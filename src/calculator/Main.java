package calculator;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите два числа и операцию которую хотит совершить, разделите их пробелом.");
        System.out.println("Числа могут быть только арабскими или только римскими.");
        String inputLine = scanner.nextLine();
        System.out.println(parsing(inputLine));
    }

    public static String parsing(String inputLine) throws Exception {
        int num1;
        int num2;
        String operation;
        String result;
        boolean isRoman;
        String[] operands = inputLine.split(" ");
        if (operands.length != 3)
            throw new Exception("Строка не является математической операцией или формат математической операции не удовлетворяет заданию.");
        operation = detectOperation(inputLine);
        if (operation == null) throw new Exception("Не найдена математическая операция");
        if (RomanToArabian.isRoman(operands[0]) && RomanToArabian.isRoman(operands[2])) {
            num1 = RomanToArabian.romanToInt(operands[0]);
            num2 = RomanToArabian.romanToInt(operands[2]);
            isRoman = true;
        } else if (!RomanToArabian.isRoman(operands[0]) && !RomanToArabian.isRoman(operands[2])) {
            num1 = Integer.parseInt(operands[0]);
            num2 = Integer.parseInt(operands[2]);
            isRoman = false;
        } else throw new Exception("Используются одновременно разные системы счисления");
        if (num1 > 10 || num2 > 10) {
            throw new Exception("Числа должны быть от 1 до 10");
        }
        int arabian = calculation(num1, num2, operation);
        if (isRoman) {
            if (arabian <= 0) {
                throw new Exception("Римское число должно быть больше нуля");
            }

            result = RomanToArabian.intToRoman(arabian);
        } else {
            result = String.valueOf(arabian);
        }

        return result;
    }

    static String detectOperation(String inputLine) {
        if (inputLine.contains("+")) return "+";
        else if (inputLine.contains("-")) return "-";
        else if (inputLine.contains("*")) return "*";
        else if (inputLine.contains("/")) return "/";
        else return null;
    }

    static int calculation(int a, int b, String oper) {
        return switch (oper) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            default -> a / b;
        };
    }
}