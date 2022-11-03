const express = require('express');

require('dotenv').config(); //Imports

const cors = require('cors');
const {personalRouter} = require('../modules/controler/routes');

const app = express(); //Instanciar servers
app.set('port', process.env.PORT || 3000)


//middlewares
app.use(cors({origin: '*'})); //Permite recibir cualquierpeticion con x orignes
app.use(express.json({limit: '50mb'})); // Permite peticiones de hasta 50mb

//Routes
app.get('/',( request, response) => {
    response.send('bienvenido a la AppRest Personal-UTEZ')
}); //Endpoints

// http://localhost:3000/ => Primer Endpoint
app.use(`/api/personal`, personalRouter);
//app.use(`/api/position`,positionRouter);
//app.use(`/api/user`, useRouter);
module.exports = {
    app
}; // es el equivalente a {app:app}
