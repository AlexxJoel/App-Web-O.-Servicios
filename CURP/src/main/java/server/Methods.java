package server;

import java.util.List;

public class Methods {

    DaoPerson daoPerson = new DaoPerson();


    public boolean savePerson(String name,String firtSurname, String secondSurname, String sex, String  placeBorn, String dateBorn,  String curp){
        if (daoPerson.saveCurp(name, firtSurname, secondSurname, sex, placeBorn, dateBorn, curp)){
            return true;
        }
        return false;
    }



    /*
    public String history(double num1 ){
        String text="";
        List<String> list = daoHistory.listOperations();
        for (String s:list) {
            text += s + "\n";
        }
        return text;
    }

     */
}
