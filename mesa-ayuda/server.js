const express = require("express")
const mysql = require("mysql")
const myconn = require("express-myconnection")
const swaggerJsDoc = require('swagger-jsdoc');
const swaggerUi = require('swagger-ui-express');
const routes = require("./routes") 

const app = express()
app.set("port", 9000)
const dbOptions = {
    host : "localhost",
    port : 3306,
    user : "root",
    password : "root",
    database : "bd-webservice"
}

const swaggerOptions = {
    swaggerDefinition: {
        info: {
            title: 'Mesa de ayuda',
            description: 'Documentacion del modulo Mesa de Ayuda',
            servers: ["http://localhost:9000"]
        }
    },
    apis: ["./routes.js"]
};

const swaggerDocs = swaggerJsDoc(swaggerOptions);
app.use('/api-docs', swaggerUi.serve, swaggerUi.setup(swaggerDocs));

app.use(myconn(mysql, dbOptions, "single"))
app.use(express.json())

app.use("/api/v1.0", routes)

app.listen(app.get("port"), ()=>{
    console.log("Server running on port", app.get("port"))
})