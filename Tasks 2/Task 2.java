/*
Разработать наиболее эффективные алгоритмы и написать код для решения
следующих задач:
 найти наибольшую цифру натурального числа;
 проверить, является ли заданное натуральное число палиндромом;
 определить является ли заданное натуральное число простым;
 найти все простые делители заданного натурального числа;
 найти НОД и НОК двух натуральных чисел a и b.
 найти количество различных цифр у заданного натурального числа.
*/

package com.company;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int choice = menu();
        switch (choice){
            case 1:
                findMaxDigit();
                break;
            case 2:
                checkIfPalindrome();
                break;
            case 3:
                findAllSimpleDivisors();
                break;
            case 4:
                findLCMAndGCD();
                break;
            case 5:
                checkIfNumberSimple();
                break;
            case 6:
                countAmountOfDifferentNumbers();
                break;
            default:
                System.out.println("Choose 1-6");
                break;
        }
    }

    private static int menu(){
        int choice;
        System.out.println("1 - find max digit of the number");
        System.out.println("2 - check if number is palindrome");
        System.out.println("3 - find all simple divisors of the number");
        System.out.println("4 - find the least common multiple and the greatest common divisor");
        System.out.println("5 - check if number is simple");
        System.out.println("6 - count amount of all different digits in number");
        choice = enterNumber();
        return choice;
    }

    private static int enterNumber(){
        int number = 0;
        Scanner scanner = new Scanner(System.in);
        boolean isInputCorrect = false;
        do {
            if (scanner.hasNextInt()){
                number = scanner.nextInt();
                isInputCorrect = true;
            }
            else {
                System.out.println("Wrong input. Please, try again!");
                scanner.nextLine();
            }
        }while (!isInputCorrect);
        return number;
    }

    private static void findMaxDigit(){
        int number, maxDigit = 0;
        do {
            System.out.println("Enter the number");
            number = enterNumber();
        }while (!(number>0));
        do {
            if (number%10>maxDigit){
                maxDigit = number%10;
            }
            number/=10;
        }while (number>0);
        System.out.println("Max digit = "+maxDigit);
    }

    private static void checkIfPalindrome(){
        int number, mirrorNumber = 0, number1;
        do {
            System.out.println("Enter the number");
            number = enterNumber();
        }while (!(number>0));
        number1 = number;
        do {
            mirrorNumber = mirrorNumber*10+number1%10;
            number1/=10;
        }while (number1>0);
        if (mirrorNumber == number){
            System.out.println("Number is palindrome");
        }
        else {
            System.out.println("Number is not palindrome");
        }
    }

    private static void findAllSimpleDivisors(){
        int number;
        do {
            System.out.println("Enter number");
            number = enterNumber();
        }while (!(number>1));
        for (int i = 2; i<number;i++){
            if (number%i == 0){
                number/=i;
                System.out.println(i);
            }
        }
    }

    private static void checkIfNumberSimple(){
        int number;
        boolean isNumberSimple = true;
        do{
            System.out.println("Enter the number");
            number = enterNumber();
        }while (!(number>1));
        for (int i = 2; i<Math.sqrt(number)+1;i++){
            if (number%i == 0){
                isNumberSimple = false;
                break;
            }
        }
        if (isNumberSimple){
            System.out.println("Number is simple");
        }
        else {
            System.out.println("Number isn't simple");
        }
    }

    private static void findLCMAndGCD(){
        int a, b, a1, b1, LCM, GCD;
        do{
            System.out.println("Enter the number");
            a = enterNumber();
        }while (!(a>1));
        do{
            System.out.println("Enter the number");
            b = enterNumber();
        }while (!(b>1));
        a1 = a;
        b1 = b;
        while((a!=0)&&(b!=0)){
            if (a>b){
                a=a%b;
            }
            else {
                b = b%a;
            }
        }
        GCD = a+b;
        System.out.println("GCD = "+GCD);
        LCM = a1*b1/GCD;
        System.out.println("LCM = "+LCM);
    }

    private static void countAmountOfDifferentNumbers(){
        int number, amount = 0;
        boolean isContain;
        do{
            System.out.println("Enter the number");
            number = enterNumber();
        }while (number<1);
        String numberStr = String.valueOf(number);
        for (int i = 0; i<10;i++){
            isContain = false;
            for (int j = 0; j<numberStr.length();j++){
                if (i == Character.digit(numberStr.charAt(j), 10)){
                    isContain = true;
                }
            }
            if (isContain){
                amount++;
            }
        }
        System.out.println("Amount = "+amount);
    }
}
