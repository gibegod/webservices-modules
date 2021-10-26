const express = require("express")
const routes = express.Router()

////////// TARJETAS //////////////
routes.get("/validarPropietario", (req, res)=>{
    req.getConnection((err, conn)=>{
        if(err) return res.send(err)

        conn.query("SELECT * FROM tarjeta WHERE idComprador = '"+req.query.idComprador+"' AND numero = '"+req.query.numero+"'", (err, rows)=>{
            if(err) return res.send(err)

            if(rows.length == 0) res.send(false)
            else res.send(true)
        })
    })
})

routes.get("/consultaLimite", (req, res)=>{
    req.getConnection((err, conn)=>{
        if(err) return res.send(err)

        conn.query("SELECT * FROM tarjeta WHERE numero = '"+req.query.numero+"' AND limiteMensual >= '"+req.query.contrasenia+"'", (err, rows)=>{
            if(err) return res.send(err)

            if(rows.length == 0) res.send(false)
            else res.send(true)
        })
    })
})

routes.post("/registrarTarjeta", (req, res)=>{
    req.getConnection((err, conn)=>{
        if(err) return res.send(err)

        conn.query("INSERT INTO tarjeta SET ?", [req.body], (err, rows)=>{
            if(err) return res.send(err)

            res.json(rows)
        })
    })
})

routes.get("/getTarjetas", (req, res)=>{
    req.getConnection((err, conn)=>{
        if(err) return res.send(err)

        conn.query("SELECT * FROM tarjeta WHERE idComprador = '"+req.query.idComprador+"' AND tipo = '"+req.query.tipo+"'", (err, rows)=>{
            if(err) return res.send(err)

            if(rows.length == 0) res.send(false)
            else res.send(rows)
        })
    })
})

///////// CUENTAS /////////////
routes.post("/registrarCuentaBancaria", (req, res)=>{
    req.getConnection((err, conn)=>{
        if(err) return res.send(err)

        conn.query("INSERT INTO cuentabancaria SET ?", [req.body], (err, rows)=>{
            if(err) return res.send(err)

            res.json(rows)
        })
    })
})

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