const express = require("express")
const routes = express.Router()

const uuid = require('uuid');

routes.post("/user", (req, res)=>{
    req.getConnection((err, conn)=>{
        if(err) return res.send(err)

        conn.query("INSERT INTO usuario SET ?", [req.body], (err, rows)=>{
            if(err) return res.send(err)

            res.json(rows)
        })
    })
})

routes.get("/login", (req, res)=>{
    req.getConnection((err, conn)=>{
        if(err) return res.send(err)

        conn.query("SELECT * FROM usuario WHERE usuario = '"+req.query.usuario+"' AND contrasenia = '"+req.query.contrasenia+"'", (err, rows)=>{
            if(err) return res.send(err)

            res.json(rows)
        })
    })
})

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

routes.patch("/envio", (req, res)=>{
    req.getConnection((err, conn)=>{
        if(err) return res.send(err)

        conn.query("UPDATE envio SET estado = '"+req.query.estado+"' WHERE cod_seguimiento = '"+req.query.cod_seguimiento+"'", (err, rows)=>{
            if(err) return res.send(err)

            res.send(rows)
        })
    })
})

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