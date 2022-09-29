<?php

    include_once('lib/nusoap.php');
    $servicio = new soap_server();

    $servicio->configureWSDL( "MIServicio" );

    $servicio->register( "devolverMensaje", array('mensaje' => 'xsd:string'), array('return' => 'xsd:string'));

    function devolverMensaje ($mensaje){

        $resultado = "El mensaje recibido fue ".Smensaje;

        return $resultado;

    }

    $servicio->service(file_get_contents("php://input"));


?>