const {app} = require('./config/express');

const main = () => {
    try {
        app.listen(app.get('port'));
        console.log( 'Runnig in the http://loacalhost'+ app.get('port'))
    } catch (error) {
        console.log(error);
    }
}

main()