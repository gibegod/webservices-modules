const express = require("express")

const app = express()
app.set("port", 9000)

app.get("/", (req, res)=>{
    res.send("Welcome")
})

app.listen(app.get("port"), ()=>{
    console.log("Server running on port", app.get("port"))
})