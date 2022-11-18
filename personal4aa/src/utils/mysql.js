const mysql = require("mysql");
require("dotenv").config();

const client = mysql.createPool({
    connectionLimit: 5,
    host: process.env.DB_HOST,
    user: process.env.DB_USER,
    password: process.env.DB_PASSWORD,
    databse: process.env.DB_DATABASE,
    port: process.env.DB_PORT
}); //Crea una alberca de conexiones -> Maximo 5 al mismo tiempo

//la lib de mysql es sincrona, aqui hacemos un wrapper para hacerla asincrona
const query = (sql, params) => {//1. Statemen, 2. Valores
    return new Promise((resolve, reject) => { //Se termina de ejecutar hasta que alguno de los dos metodos retorne algo
        client.getConnection((err, conn) => {
            //getConnection -> function -> void
            if (err) reject(err);
            conn.query(sql, params, (err, row) => { //opcional param campos
                //Tambien es void y se obliga a que retorne algo con su reject o resolve
                if (err) reject(err);
                conn.release();
                resolve(row);
            })
        });
    });
}

module.exports = {
    query
};
//Importa el orden de los parametros
//resolve y reject son los metodos importantes de una función asincrona
