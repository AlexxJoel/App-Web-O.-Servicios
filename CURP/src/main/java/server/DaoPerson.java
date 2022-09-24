package server;

import utils.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class DaoPerson {

    Connection conexion;    PreparedStatement preparedStatement;    ResultSet result ;


    private final  String CREATE_CURP= "INSERT INTO `person`.`curp`(`name`,` first_surname`,`second_surname`,`sex`,`place_born`,`date_born`,`curp`)VALUES(?,?,?,?,?,?,?)";

    private final  String LIST_PERSON_CURP =  "SELECT * FROM person.curp;";
    private final  String PERSON_CURP =  "SELECT * FROM person.curp where curp = ?";

    public boolean saveCurp(String name, String  first_surname, String second_surname, String sex, String place_born, String date_born,String curp){
        try {
            conexion = new MySQLConnection().getConnection();
            preparedStatement = conexion.prepareStatement(CREATE_CURP);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,first_surname);
            preparedStatement.setString(3,second_surname);
            preparedStatement.setString(4,sex);
            preparedStatement.setString(5,place_born);
            preparedStatement.setString(6, date_born);
            preparedStatement.setString(7,curp);


           return preparedStatement.executeUpdate()==1;

        }catch (SQLException e){
            System.out.println(e);
        }
        return false;
    }

    public List<String> listCurp (){
        List<String> Mylist = new LinkedList<>();
        String text = "";
        try{
            conexion = new MySQLConnection().getConnection();
            preparedStatement = conexion.prepareStatement(LIST_PERSON_CURP);
            result = preparedStatement.executeQuery();
            while (result.next()) {
            String sex ="";
                if(result.getString("sex").equals("H")){
                    sex = "HOMBRE";
                }else sex = "MUJER";
                text =  "->(" + result.getString("curp")+ ") " + result.getString("name") + " : " + result.getString(3) + ", " + result.getString("second_surname") + " , " + sex + " , " + result.getString("place_born")  + " , " + result.getString("date_born");
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



    public String personCurp (String curp){
        String text = "";
        try{
            conexion = new MySQLConnection().getConnection();
            preparedStatement = conexion.prepareStatement(PERSON_CURP);
            preparedStatement.setString(1, curp);
            result = preparedStatement.executeQuery();
            if (result.next()) {
                String sex ="";
                if(result.getString("sex").equals("H")){
                    sex = "HOMBRE";
                }else sex = "MUJER";

                text =  "->(" + result.getString("curp")+ ") " + result.getString("name") + " : " + result.getString(3) + ", " + result.getString("second_surname") + " , " + sex + " , " + result.getString("place_born")  + " , " + result.getString("date_born");

            }else text = "No hay niguna coincidenica!!";
        }catch (SQLException e){
            System.out.println(e);
            text = "UPSS Problemas";

        }
        System.out.println(text);
        return text;
    }


    public static void main(String[] args) {
      /*boolean f =   new DaoPerson().saveCurp("Joel","Herrera","Hernandez","H","Morelos","2003-11-09","HHJ031109HMRRE_A2");

        System.out.println(f);

       */

        new DaoPerson().personCurp("218030903MX3006R");
    }

    /*



     */


}
