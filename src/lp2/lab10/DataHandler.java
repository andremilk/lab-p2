package lp2.lab10;

import java.util.Scanner;

public class DataHandler {
    
    private static Scanner entrada = new Scanner(System.in);

    public static double entradaNota(String message) {
        System.out.println(message);
        return entrada.nextDouble(); 
    }
    
}











