package server;

public class test {

    public static void main(String[] args) {
        GenerarPalabra();
    }

    public static String GenerarPalabra(){
        String palabra = "";
        int letra = (int)(Math.random()*9);
        System.out.println(letra);

        int codigoAscii = (int)Math.floor(Math.random()*(122 - 97)+97);
        palabra = palabra + (char)codigoAscii;
        palabra = letra + palabra.toUpperCase();
        System.out.println(palabra);
        return palabra;
    }
}
