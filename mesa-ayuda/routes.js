const express = require("express")
const routes = express.Router()

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

            if(rows.length == 0) res.send(false)
            else res.send(true)
        })
    })
})

////////////////// Reclamos //////////////////

routes.get("/reclamos", (req, res)=>{
    req.getConnection((err, conn)=>{
        if(err) return res.send(err)

        conn.query("SELECT * FROM reclamo", (err, rows)=>{
            if(err) return res.send(err)

            res.send(rows)
        })
    })
})

routes.get("/reclamos/filtrar", (req, res)=>{
    req.getConnection((err, conn)=>{
        if(err) return res.send(err)

        conn.query("SELECT * FROM reclamo WHERE estado = '"+req.query.estado+"'", (err, rows)=>{
            if(err) return res.send(err)

            res.send(rows)
        })
    })
})

routes.put("/reclamos/atender", (req, res)=>{
    req.getConnection((err, conn)=>{
        if(err) return res.send(err)

        conn.query("UPDATE reclamo SET estado = '"+req.query.estado+"' WHERE idReclamo = "+req.query.idReclamo, (err, rows)=>{
            if(err) return res.send(err)

            res.send(rows)
        })
    })
})

////////////////// Denuncias //////////////////
routes.get("/denuncias", (req, res)=>{
    req.getConnection((err, conn)=>{
        if(err) return res.send(err)

        conn.query("SELECT * FROM denuncia", (err, rows)=>{
            if(err) return res.send(err)

            res.send(rows)
        })
    })
})

routes.get("/denuncias/filtrar", (req, res)=>{
    req.getConnection((err, conn)=>{
        if(err) return res.send(err)

        conn.query("SELECT * FROM denuncia WHERE estado = '"+req.query.estado+"'", (err, rows)=>{
            if(err) return res.send(err)

            res.send(rows)
        })
    })
})

routes.put("/denuncias/atender", (req, res)=>{
    req.getConnection((err, conn)=>{
        if(err) return res.send(err)

        conn.query("UPDATE denuncia SET estado = '"+req.query.estado+"' WHERE idDenuncia = "+req.query.idDenuncia, (err, rows)=>{
            if(err) return res.send(err)

            res.send(rows)
        })
    })
})

module.exports = routes