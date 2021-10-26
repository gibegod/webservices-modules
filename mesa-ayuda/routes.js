const express = require("express")
const routes = express.Router()

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

        conn.query("UPDATE reclamo SET comentarioResolucion = '"+req.query.comentarioResolucion+"', estado = 'RESUELTO' WHERE idReclamo = "+req.query.idReclamo, (err, rows)=>{
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

        conn.query("UPDATE denuncia SET comentarioResolucion = '"+req.query.comentarioResolucion+"', estado = 'RESUELTO' WHERE idDenuncia = "+req.query.idDenuncia, (err, rows)=>{
            if(err) return res.send(err)

            res.send(rows)
        })
    })
})

module.exports = routes