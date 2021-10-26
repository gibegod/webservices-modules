const express = require("express")
const routes = express.Router()

const uuid = require('uuid');

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

            res.json(rows)
        })
    })
})

/**
 *  @swagger
 *  /envio:
 *     post:
 *      description: Se carga un nuevo envio.
 *      parameters:
 *        - in: body
 *          description: Se requieren los datos del envio
 *          schema:
 *            type: object
 *            required:
 *              - id_venta
 *              - dni_destinatario
 *              - cod_seguimiento
 *              - estado
 *            properties:
 *              id_venta:
 *                type: integer
 *              dni_destinatario:
 *                type: string
 *              cod_seguimiento:
 *                type: string
 *              estado:
 *                type: string
 *      responses:
 *          '200':
 *             description: Successfull response
 */
routes.post("/envio", (req, res)=>{
    req.getConnection((err, conn)=>{
        if(err) return res.send(err)

        const uuidV1 = uuid.v1()

        conn.query("INSERT INTO envio (id_venta, dni_destinatario, cod_seguimiento, estado) VALUES ("+req.query.id_venta+", '"+req.query.dni_destinatario+"', '"+uuidV1+"', "+"'EN PREPARACIÓN'"+")", (err, rows)=>{
            if(err) return res.send(err)

            res.send(uuidV1)
        })
    })
})

/**
 *  @swagger
 *  /envio:
 *     patch:
 *      description: Se modifica el envio.
 *      parameters:
 *        - in: body
 *          description: Se requiere el estado y codigo de seguimiento del envio.
 *          schema:
 *            type: object
 *            required:
 *              - cod_seguimiento
 *              - estado
 *            properties:
 *              cod_seguimiento:
 *                type: string
 *              estado:
 *                type: string
 *      responses:
 *          '200':
 *             description: Successfull response
 */
routes.patch("/envio", (req, res)=>{
    req.getConnection((err, conn)=>{
        if(err) return res.send(err)

        conn.query("UPDATE envio SET estado = '"+req.body.params.estado+"' WHERE cod_seguimiento = '"+req.body.params.cod_seguimiento+"'", (err, rows)=>{
            if(err) return res.send(err)

            res.send(rows)
        })
    })
})

/**
 *  @swagger
 *  /envios:
 *     get:
 *      description: Se obtienen todos los envios.
 *      parameters:
 *        - in: body
 *          description: Se requiere el codigo de seguimiento, el estado y el dni del destinatario.
 *          schema:
 *            type: object
 *            required:
 *              - cod_seguimiento
 *              - estado
 *              - dni_destinatario
 *            properties:
 *              cod_seguimiento:
 *                type: string
 *              estado:
 *                type: string
 *              dni_destinatario:
 *                type: string
 *      responses:
 *          '200':
 *             description: Successfull response
 */
routes.get("/envios", (req, res)=>{
    req.getConnection((err, conn)=>{
        if(err) return res.send(err)

        var query = "SELECT * FROM envio "
        if(req.query.cod_seguimiento != undefined){
            query += "WHERE cod_seguimiento = '"+req.query.cod_seguimiento+"' AND "
        }
        else{
            query += "WHERE true AND "
        }
        if(req.query.dni_destinatario != undefined){
            query += "dni_destinatario = '"+req.query.dni_destinatario+"' AND "
        }
        else{
            query += "true AND "
        }
        if(req.query.estado != undefined){
            query += "estado = '"+req.query.estado+"'"
        }
        else{
            query += "true"
        }
        conn.query(query, (err, rows)=>{
            if(err) return res.send(err)

            res.json(rows)
        })
    })
})

module.exports = routes