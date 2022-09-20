package server;

import utils.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DAO {

    Connection conexion = new MySQLConnection().getConnection();


    PreparedStatement preparedStatement;


    ResultSet result ;

    private final  String CREATE = "INSERT INTO `calculator`.`operations`(`type`,`first_number`,`second_number`,`result`,`created_at`)VALUES(?,?,?,?,CURRENT_TIME)";

    private final  String LIST =  "SELECT `type`,first_number,second_number,result from operations order by created_at desc";

    public void saveOperation(double num1, double num2, double result, String type){

        try {
            preparedStatement = conexion.prepareStatement(CREATE);
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

            preparedStatement = conexion.prepareStatement(LIST);
            result = preparedStatement.executeQuery();
            while (result.next()) {

                text = ""+result.getString("type") + " : " + result.getDouble("first_number") + ", " + result.getDouble("second_number") + " Resultado: " + result.getDouble("result");
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
