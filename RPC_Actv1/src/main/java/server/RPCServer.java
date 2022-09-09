package server;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.webserver.WebServer;

import java.io.IOException;

public class RPCServer {

    public static void main(String[] args) throws XmlRpcException, IOException {

        System.out.println("Initialize server....");
        //KEY WORD TO APUNATR A LOS MEOTDOS
        //Request en servlets
        PropertyHandlerMapping mapping = new PropertyHandlerMapping();

        mapping.addHandler("Methods", Methods.class); // Asiganos una variable a la clase

        //El class hace referencia a la clase compilada

        WebServer server = new WebServer(1200); //Abrimos el puerto donde abrira ek server

        server.getXmlRpcServer().setHandlerMapping(mapping); // seteamos la clase

        server.start(); //empezar el servidor

        System.out.println("Server running in http://localhost:1200");

        System.out.println("Waiting requests...");


    }

}
