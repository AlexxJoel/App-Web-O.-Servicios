const mysql = require('mysql')
require('dotenv').config();

const client = mysql.createPool({
    connecctionLimit:5,
    host:process.env.DB_HOST,
    user:process.env.DB_USER,
    password:process.env.DB_PASSWORD,
    database: process.env.DB_DATABASE,
    port:process.env.DB_PORT
}); 
/* Crea una alberca de conecciones y 
en este caso solo permite un maximo de 5 al mismo tiempo
*/
// Se recibe la sentencia sql y los parametros
const query = (sql,params)=>{ // 1.Stament 2. Valores
    return new Promise((resolve, reject)=>{
        client.getConnection((err,conn)=>{
            // getConnection -> function -> void
            if (err) reject(err);
            conn.query(sql,params,(err,rows)=>{
                if (err) reject(err); 
                conn.release();
                resolve(rows);
            });
        });
    });
};

module.exports = {
    query
}