package calculator;


import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        String[] input = getString();

    }
    public static String[] getString(){
        String s = scanner.nextLine();
        return s.split(" ");
    }

}