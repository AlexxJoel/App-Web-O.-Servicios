c1100onst express = require("express");
require("dotenv").config(); //imports
const cors = require("cors");
const {personalRouter} = require('../modules/controller/routes');

const app = express(); //instanciar server
app.set("port", process.env.PORT || 3000);


//middleware
app.use(cors({origins: "*"})); //Permite recibir cualquier peticion con x origen
app.use(express.json({limit: "50mb"})); //Permite peticiones de hasta 50mb


//Routes
app.get("/", (request, response) => {
    response.send("Bienvenido a la AppRest Personal-UTEZ");
}); //Endpoints 
//http://localhost:3000/ -> primer Endpoint
app.use(`/api/personal`, personalRouter)
//app.use(`/api/position`, positionRouter)
//app.use(`/api/user`, userRouter)
module.exports = {
    app
}; //{app = app}

