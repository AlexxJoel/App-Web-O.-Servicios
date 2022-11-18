//Destructurar
const {app} = require("./config/express");

const main = () => {
    try{
        app.listen(app.get("port"));
        console.log(`Running in the http://localhost:${ app.get("port") }/`)
    }catch (err){
        console.log(err)
    }
};

main();