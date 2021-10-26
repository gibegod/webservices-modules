const express = require("express")
const routes = express.Router()
const swaggerJsDoc = require('swagger-jsdoc');
const swaggerUi = require('swagger-ui-express');

////////// TARJETAS //////////////
/**
 *  @swagger
 *  /validarPropietario:
 *     get:
 *      description: Valida que el usuario sea realmente propietario de la tarjeta que esta queriendo agregar.
 *      parameters:
 *        - in: body
 *          description: Se requiere el id del usuario y el id de la tarjeta
 *          schema:
 *            type: object
 *            required:
 *              - idComprador
 *              - idTarjeta
 *            properties:
 *              idComprador:
 *                type: integer
 *              idTarjeta:
 *                type: integer
 *      responses:
 *          '200':
 *             description: Successfull response
 */
routes.get("/validarPropietario", (req, res)=>{
    req.getConnection((err, conn)=>{
        if(err) return res.send(err)

        conn.query("SELECT * FROM tarjeta WHERE idComprador = '"+req.query.idComprador+"' AND idTarjeta = '"+req.query.idTarjeta+"'", (err, rows)=>{
            if(err) return res.send(err)

            if(rows.length == 0) res.send(false)
            else res.send(true)
        })
    })
})

/**
 *  @swagger
 *  /consultaLimite:
 *     get:
 *      description: Consulta si la tarjeta de credito tiene limite o si la de debito tiene saldo.
 *      parameters:
 *        - in: body
 *          description: Se requiere el numero de la tarjeta y el limite mensual, o saldo.
 *          schema:
 *            type: object
 *            required:
 *              - limiteMensual
 *              - numero
 *            properties:
 *              limiteMensual:
 *                type: float
 *              numero:
 *                type: string
 *      responses:
 *          '200':
 *             description: Successfull response
 */
routes.get("/consultaLimite", (req, res)=>{
    req.getConnection((err, conn)=>{
        if(err) return res.send(err)

        conn.query("SELECT * FROM tarjeta WHERE numero = '"+req.query.numero+"' AND limiteMensual >= '"+req.query.limiteMensual+"'", (err, rows)=>{
            if(err) return res.send(err)

            if(rows.length == 0) res.send(false)
            else res.send(true)
        })
    })
})

/**
 *  @swagger
 *  /registrarTarjeta:
 *     post:
 *      description: Registra una tarjeta de credito o debito
 *      parameters:
 *        - in: body
 *          description: Se requieren los datos de la tarjeta.
 *          schema:
 *            type: object
 *            required:
 *              - idComprador
 *              - limiteMensual
 *              - saldo
 *              - numero
 *              - cvc
 *              - tipo
 *              - nombre
 *              - vencimiento
 *            properties:
 *              idComprador:
 *                type: integer
 *              limiteMensual:
 *                type: integer
 *              saldo:
 *                type: integer
 *              numero:
 *                type: string
 *              cvc:
 *                type: string
 *              tipo:
 *                type: string
 *              nombre:
 *                type: string
 *              vencimiento:
 *                type: date
 *      responses:
 *          '200':
 *             description: Successfull response
 */
routes.post("/registrarTarjeta", (req, res)=>{
    req.getConnection((err, conn)=>{
        if(err) return res.send(err)

        conn.query("INSERT INTO tarjeta SET ?", [req.body], (err, rows)=>{
            if(err) return res.send(err)

            res.json(rows)
        })
    })
})

/**
 *  @swagger
 *  /getTarjetas:
 *     get:
 *      description: Se obtienen todas las tarjetas del usuario
 *      parameters:
 *        - in: body
 *          description: Se requiere el id del usuario.
 *          schema:
 *            type: object
 *            required:
 *               - idComprador
 *            properties:
 *              idComprador:
 *                type: integer
 *      responses:
 *          '200':
 *             description: Successfull response
 */
routes.get("/getTarjetas", (req, res)=>{
    req.getConnection((err, conn)=>{
        if(err) return res.send(err)

        conn.query("SELECT * FROM tarjeta WHERE idComprador = '"+req.query.idComprador+"'", (err, rows)=>{
            if(err) return res.send(err)

            if(rows.length == 0) res.send(false)
            else res.send(rows)
        })
    })
})

///////// CUENTAS /////////////

/**
 *  @swagger
 *  /registrarCuentaBancaria:
 *     post:
 *      description: Se registra una cuenta bancaria
 *      parameters:
 *        - in: body
 *          description: Se requieren los datos de la cuenta.
 *          schema:
 *            type: object
 *            required:
 *              - banco
 *              - idVendedor
 *              - alias
 *              - cbu
 *              - dni
 *            properties:
 *              banco:
 *                type: string
 *              idVendedor:
 *                type: integer
 *              alias:
 *                type: string
 *              cbu:
 *                type: string
 *              dni:
 *                type: string
 *      responses:
 *          '200':
 *             description: Successfull response
 */
routes.post("/registrarCuentaBancaria", (req, res)=>{
    req.getConnection((err, conn)=>{
        if(err) return res.send(err)

        conn.query("INSERT INTO cuentabancaria SET ?", [req.body], (err, rows)=>{
            if(err) return res.send(err)

            res.json(rows)
        })
    })
})

/**
 *  @swagger
 *  /validarCuentaBancaria:
 *     get:
 *      description: Se valida si la cuenta bancaria le pertenece al usuario
 *      parameters:
 *        - in: body
 *          description: Se requiere el id del usuario.
 *          schema:
 *            type: object
 *            required:
 *              - idVendedor
 *            properties:
 *              idVendedor:
 *                type: integer
 *      responses:
 *          '200':
 *             description: Successfull response
 */
routes.get("/validarCuentaBancaria", (req, res)=>{
    req.getConnection((err, conn)=>{
        if(err) return res.send(err)

        conn.query("SELECT * FROM cuentabancaria WHERE idVendedor = '"+req.query.idVendedor+"' AND cbu = '"+req.query.cbu+"'", (err, rows)=>{
            if(err) return res.send(err)

            if(rows.length == 0) res.send(false)
            else res.send(true)
        })
    })
})

/**
 *  @swagger
 *  /getCuentasBancarias:
 *     get:
 *      description: Se obtienen las cuentas bancarias del usuario
 *      parameters:
 *        - in: body
 *          description: Se requiere el id del usuario.
 *          schema:
 *            type: object
 *            required:
 *               - idVendedor
 *            properties:
 *              idVendedor:
 *                type: integer
 *      responses:
 *          '200':
 *             description: Successfull response
 */
routes.get("/getCuentasBancarias", (req, res)=>{
    req.getConnection((err, conn)=>{
        if(err) return res.send(err)

        conn.query("SELECT * FROM cuentabancaria WHERE idVendedor = '"+req.query.idVendedor+"'", (err, rows)=>{
            if(err) return res.send(err)

            if(rows.length == 0) res.send(false)
            else res.send(rows)
        })
    })
})

module.exports = routes