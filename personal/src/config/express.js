//importacion de librearias y/o componentes
const express = require("express");
const cors = require("cors");
require("dotenv").config();


//Inicializacion de server
const app = express();

app.set('port',process.env.PORT || 3000) //Utilizar puerto     
//middle ware 
//Utilizacion de middlewares
app.use(
    cors({origins: "*"})
);//permite recibir peticiones desde cualquier aplicacion

//Limite del tamaño de datos en peticiones
app.use(express.json({limit:"50mb"}));//se limita el peso de las peticiones
//Routes
//Definicion de todas mis rutas
app.get("/", (request,response) =>{
    response.send("Bienvenido a la aplicacion utez");
});//este metodo va a recibir dos parametros la ruta y un metodo 
//end points 
//address -> localhost:3000 -> primer endpoint 
//Exportacion de nuestro modulo y/o variables
//variable global module
module.exports = {
    app
}


