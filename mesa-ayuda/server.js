const express = require("express")
const mysql = require("mysql")
const myconn = require("express-myconnection")

const routes = require("./routes") 

const app = express()
app.set("port", 9000)
const dbOptions = {
    host : "localhost",
    port : 3306,
    user : "root",
    password : "",
    database : "mesa_ayuda"
}

app.use(myconn(mysql, dbOptions, "single"))
app.use(express.json())

app.use("/api/v1.0", routes)

app.listen(app.get("port"), ()=>{
    console.log("Server running on port", app.get("port"))
})