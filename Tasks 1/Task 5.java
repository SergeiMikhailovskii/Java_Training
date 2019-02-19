/*
* Написать программу, которая находит арифметическое и геометрическое
среднее цифр шестизначного числа N.
* */
package com.company;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int number = enterNumber();
        int[] numArray = numberToIntArray(number);
        countAverages(numArray);
    }

    private static int enterNumber(){
        int number = 0;
        final int MIN_RANGE = 100000;
        final int MAX_RANGE = 999999;
        boolean isInputCorrect = false;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Enter 6 digit number");
            if (scanner.hasNextInt()){
                number = scanner.nextInt();
                if (number> MIN_RANGE && number<MAX_RANGE){
                    isInputCorrect = true;
                }
                else {
                    System.out.println("Number should be 6 digit");
                }
            }
            else {
                System.out.println("Wrong input!");
                scanner.nextLine();
            }
        }while (!isInputCorrect);
        return number;
    }

    private static int[] numberToIntArray(int number){
        int[] numArray = new int[6];
        int position = 0;
        while (number>0){
            numArray[position]=number%10;
            number/=10;
            position++;
        }
        return numArray;
    }

    private static void countAverages(int[] numArray){
        double avArithm, avGeom;
        int sum = 0, mult = 1;
        for (int aNumArray : numArray) {
            sum += aNumArray;
            mult *= aNumArray;
        }
        avArithm = (double) sum/numArray.length;
        avGeom = (double) Math.pow(mult, 1.0/numArray.length);
        System.out.println("Average arithmetic: "+avArithm);
        System.out.println("Average geometric: "+avGeom);
    }

}
