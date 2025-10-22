package util;

import java.util.Scanner;

public class InputHandler {
    static Scanner scanner = new Scanner(System.in);

    public static String readLine(){
        System.out.println("Enter text");
        return scanner.nextLine();
    }
    public static String readLine(String text){
        System.out.println("Enter "+text+": ");
        return scanner.nextLine();
    }

    public static int readInt(){
        while(true){
            System.out.println("Enter number: ");
            String input = scanner.nextLine();
            try{
                return Integer.parseInt(input);
            }catch(NumberFormatException e){
                System.out.println("Wrong input, u were supposed to enter number");
            }
        }
    }

    public static int readInt(String text){
        while(true){
            System.out.println("Enter "+text+": ");
            String input = scanner.nextLine();
            try{
                return Integer.parseInt(input);
            }catch(NumberFormatException e){
                System.out.println("Wrong input, u were supposed to enter number");
            }
        }
    }
}
