// conex to mysqwl }

const mysql = require('mysql'); 
require('dotenv').config();



const client = mysql.createPool({
    connectionLimit:5, // just 5 conection at the same time 
    //configuration 
    host: process.env.DB_HOST ,
    user: process.env.DB_USER , 
    password:  process.env.DB_PASSWORD , 
    database: process.env.DB_SATABASE , 
    port: process.env.DB_PORT 

}) //conection pool

//check database , consult and values
const query = (sql,params)=>{
    return new Promise((resolve, reject) => {
        client.getConnection((error,conex)=>{
            //getConnection -> function ->  void
            if (error) reject(error); 

             conex.query(sql,params, (err, row)=>{
                if (err) reject(err); 
                conex.release(); 
                resolve(row)
             })
        });
    })

    /* function query (consult, values to insert  )
        whit a promise check coonection 
    */
};



//import 
module.exports = {
    app
}