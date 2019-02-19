/*
* Разработайте небольшую цельную программу, которая меняет местами
содержимое двух целочисленных переменных a и b, не используя для этого
дополнительных переменных.
* */
package com.company;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int number1 = enterNumber();
        int number2 = enterNumber();
        number1 = number1+number2;
        number2 = number1-number2;
        number1 = number1-number2;
        System.out.println(number1+" "+number2);
    }

    private static int enterNumber(){
        int number = 0;
        boolean isInputCorrect = false;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Enter the number:");
            if (scanner.hasNextInt()){
                number = scanner.nextInt();
                isInputCorrect = true;
            }
            else {
                System.out.println("Wrong input");
                scanner.nextLine();
            }
        }while (!isInputCorrect);
        return number;
    }

}
