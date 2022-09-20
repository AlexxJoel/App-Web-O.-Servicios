package server;

import utils.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DaoHistory {

    //Aqui haremos la conexxio´n de la base de datos

    //Esta variable es el puente (Conexión) entre la base y la app
    Connection conexion = new MySQLConnection().getConnection(); //Aqui llamamos a la funcion


    //Esta variable es para preparar la consulta (la query que deseeas en la bd)
    PreparedStatement preparedStatement;

    //En esta guardaremos todos los resultados
    ResultSet result ;

    //Listo , Ahora prepararemos las QUERY (consultas)  en dado caso lo mas comun es el CRUD
    private final  String CREATE_OPERATION = "INSERT INTO `calculator`.`operations`(`type`,`first_number`,`second_number`,`result`,`created_at`)VALUES(?,?,?,?,CURRENT_TIME)";

    private final  String LIST_OPERATIONS =  "SELECT `type`,first_number,second_number,result from operations order by created_at desc";

    public void saveOperation(double num1, double num2, double result, String type){

        try {
            preparedStatement = conexion.prepareStatement(CREATE_OPERATION);
            preparedStatement.setString(1,type);
            preparedStatement.setDouble(2,num1);
            preparedStatement.setDouble(3,num2);
            preparedStatement.setDouble(4,result);
            preparedStatement.execute();

        }catch (SQLException e){
            System.out.println(e);
        }
    }

    public  List<String> listOperations (){
        List<String> Mylist = new LinkedList<>();
        String text = "";
        try{

            preparedStatement = conexion.prepareStatement(LIST_OPERATIONS);
            result = preparedStatement.executeQuery();
            while (result.next()) {

                text = ""+result.getString("type") + " : " + result.getDouble("first_number") + ", " + result.getDouble("second_number") + " -> " + result.getDouble("result");
                Mylist.add(text);
            }

        }catch (SQLException e){
            System.out.println(e);
        }

        for (String s: Mylist) {
            System.out.println(s);
        }

        return Mylist;
    }


}
