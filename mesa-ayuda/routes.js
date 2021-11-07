const express = require("express")
const routes = express.Router()

var http = require('http');

/**
 *  @swagger
 *  /user:
 *     post:
 *      description: Crea un nuevo usuario.
 *      parameters:
 *        - in: body
 *          description: Se requieren los datos del usuario
 *          schema:
 *            type: object
 *            required:
 *              - usuario
 *              - contrasenia
 *            properties:
 *              usuario:
 *                type: string
 *              contrasenia:
 *                type: string
 *      responses:
 *          '200':
 *             description: Successfull response
 */
routes.post("/user", (req, res)=>{
    req.getConnection((err, conn)=>{
        if(err) return res.send(err)

        conn.query("INSERT INTO usuario SET ?", [req.body], (err, rows)=>{
            if(err) return res.send(err)

            res.json(rows)
        })
    })
})

/**
 *  @swagger
 *  /login:
 *     get:
 *      description: Realiza el login.
 *      parameters:
 *        - in: body
 *          description: Se requieren los datos del usuario
 *          schema:
 *            type: object
 *            required:
 *              - usuario
 *              - contrasenia
 *            properties:
 *              usuario:
 *                type: string
 *              contrasenia:
 *                type: string
 *      responses:
 *          '200':
 *             description: Successfull response
 */
routes.get("/login", (req, res)=>{
    req.getConnection((err, conn)=>{
        if(err) return res.send(err)

        conn.query("SELECT * FROM usuario WHERE usuario = '"+req.query.usuario+"' AND contrasenia = '"+req.query.contrasenia+"'", (err, rows)=>{
            if(err) return res.send(err)

            if(rows.length == 0) res.send(false)
            else res.send(true)
        })
    })
})

////////////////// Reclamos //////////////////

/**
 *  @swagger
 *  /reclamos:
 *     get:
 *      description: Se carga un nuevo reclamo.
 *      responses:
 *          '200':
 *             description: Successfull response
 */
routes.get("/reclamos", (req, res)=>{
    req.getConnection((err, conn)=>{
        if(err) return res.send(err)

        conn.query("SELECT * FROM reclamo", (err, rows)=>{
            if(err) return res.send(err)

            res.send(rows)
        })
    })
})

/**
 *  @swagger
 *  /reclamos/filtrar:
 *     get:
 *      description: Se filtran reclamos.
 *      parameters:
 *        - in: body
 *          description: Se requiere el estado como filtro
 *          schema:
 *            type: object
 *            required:
 *              - estado
 *            properties:
 *              estado:
 *                type: string
 *      responses:
 *          '200':
 *             description: Successfull response
 */
routes.get("/reclamos/filtrar", (req, res)=>{
    req.getConnection((err, conn)=>{
        if(err) return res.send(err)

        conn.query("SELECT * FROM reclamo WHERE estado = '"+req.query.estado+"'", (err, rows)=>{
            if(err) return res.send(err)

            res.send(rows)
        })
    })
})

/**
 *  @swagger
 *  /reclamos/atender:
 *     put:
 *      description: Se atiende un reclamo.
 *      parameters:
 *        - in: body
 *          description: Se requiere el comentario de resolucion y el id del reclamo
 *          schema:
 *            type: object
 *            required:
 *              - comentarioResolucion
 *              - idReclamo
 *            properties:
 *              comentarioResolucion:
 *                type: string
 *              idReclamo:
 *                type: integer
 *      responses:
 *          '200':
 *             description: Successfull response
 */
routes.put("/reclamos/atender", (req, res)=>{
    req.getConnection((err, conn)=>{
        if(err) return res.send(err)

		var aceptado = req.query.aceptado;
		var comentarioResolucion = req.query.comentarioResolucion;
		var idReclamo = req.query.idReclamo;
		
		if(aceptado == "true"){
			conn.query("SELECT id_venta FROM reclamo WHERE id = "+idReclamo, (err, rows)=>{
				if(err) return res.send(err)
	
				var idVenta = rows[0].id_venta;
				conn.query("UPDATE venta SET estado = 'RECLAMO ACEPTADO' WHERE id = "+idVenta, (err, rows)=>{
					if(err) return res.send(err)
				})
				conn.query("SELECT * FROM venta WHERE id = "+idVenta, (err, rows)=>{
					if(err) return res.send(err)

					var precioTotal = rows[0].precio_total;
					var idTarjetaTienda = rows[0].id_tarjeta;
					
					conn.query("SELECT id_tarjeta FROM tarjeta WHERE id = "+idTarjetaTienda, (err, rows)=>{
						if(err) return res.send(err)
							
						var idTarjetaExterna = rows[0].id_tarjeta;
						
						var options = {
							host: 'localhost',
							port: 9002,
							path: '/api/v1.0/devolucion-compra?idTarjeta='+idTarjetaExterna+'&monto='+precioTotal,
							method: 'POST'
						}

						var req = http.request(options);
						req.end();
					})
				})
			})
		} else {
			conn.query("SELECT id_venta FROM reclamo WHERE id = "+idReclamo, (err, rows)=>{
				if(err) return res.send(err)
	
				var idVenta = rows[0].id_venta;
				conn.query("UPDATE venta SET estado = 'RECLAMO RECHAZADO' WHERE id = "+idVenta, (err, rows)=>{
					if(err) return res.send(err)
				})
			})
		}		
		
        conn.query("UPDATE reclamo SET comentario_resolucion = '"+comentarioResolucion+"', estado = 'RESUELTO', aceptado = "+aceptado+" WHERE id = "+idReclamo, (err, rows)=>{
            if(err) return res.send(err)

            res.send(rows)
        })
    })
})

////////////////// Denuncias //////////////////

/**
 *  @swagger
 *  /denuncias:
 *     get:
 *      description: Se obtienen todas las denuncias.
 *      responses:
 *          '200':
 *             description: Successfull response
 */
routes.get("/denuncias", (req, res)=>{
    req.getConnection((err, conn)=>{
        if(err) return res.send(err)

        conn.query("SELECT * FROM denuncia", (err, rows)=>{
            if(err) return res.send(err)

            res.send(rows)
        })
    })
})

/**
 *  @swagger
 *  /denuncias/filtrar:
 *     get:
 *      description: Se filtran denuncias.
 *      parameters:
 *        - in: body
 *          description: Se requiere el estado como filtro
 *          schema:
 *            type: object
 *            required:
 *              - estado
 *            properties:
 *              estado:
 *                type: string
 *      responses:
 *          '200':
 *             description: Successfull response
 */
routes.get("/denuncias/filtrar", (req, res)=>{
    req.getConnection((err, conn)=>{
        if(err) return res.send(err)

        conn.query("SELECT * FROM denuncia WHERE estado = '"+req.query.estado+"'", (err, rows)=>{
            if(err) return res.send(err)

            res.send(rows)
        })
    })
})

/**
 *  @swagger
 *  /denuncias/atender:
 *     put:
 *      description: Se atiende una denuncia.
 *      parameters:
 *        - in: body
 *          description: Se requiere el comentario de resolucion y el id de la denuncia
 *          schema:
 *            type: object
 *            required:
 *              - comentarioResolucion
 *              - idDenuncia
 *            properties:
 *              comentarioResolucion:
 *                type: string
 *              idDenuncia:
 *                type: integer
 *      responses:
 *          '200':
 *             description: Successfull response
 */
routes.put("/denuncias/atender", (req, res)=>{
    req.getConnection((err, conn)=>{
        if(err) return res.send(err)
			
		var aceptado = req.query.aceptado;
		var comentarioResolucion = req.query.comentarioResolucion;
		var idDenuncia = req.query.idDenuncia;
		
		if(aceptado == "true"){
			conn.query("SELECT id_producto FROM denuncia WHERE id = '"+idDenuncia+"'", (err, rows)=>{
				if(err) return res.send(err)

				var idProducto = rows[0].id_producto;
				var q = "UPDATE producto SET activo = "+false+" WHERE id = "+idProducto;
				conn.query(q, (err, rows)=>{
					if(err) return res.send(err)
				})
			})			
		}

        conn.query("UPDATE denuncia SET comentario_resolucion = '"+comentarioResolucion+"', estado = 'RESUELTO', aceptado = "+aceptado+" WHERE id = "+idDenuncia, (err, rows)=>{
            if(err) return res.send(err)

            res.send(rows)
        })
    })
})

module.exports = routes