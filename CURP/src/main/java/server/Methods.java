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



    public String searchPerson(String curp){
        System.out.println(curp);
        return curp = daoPerson.personCurp(curp);
    }


    public String history(){
        String text="";
        List<String> list = daoPerson.listCurp();
        for (String s:list) {
            text += s + "\n";
        }
        return text;
    }


}
