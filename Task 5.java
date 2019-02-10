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
        int number;
        final int minRange = 100000;
        final int maxRange = 999999;
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Enter 6 digit number");
            if (scanner.hasNextInt()){
                number = scanner.nextInt();
                if (number>minRange&& number<maxRange){
                    return number;
                }
                else {
                    System.out.println("Number should be 6 digit");
                }
            }
            else {
                System.out.println("Wrong input!");
                scanner.nextLine();
            }
        }
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
        double avArifm, avGeom;
        int sum = 0, mult = 1;
        for (int aNumArray : numArray) {
            sum += aNumArray;
            mult *= aNumArray;
        }
        avArifm = (double) sum/numArray.length;
        avGeom = (double) Math.pow(mult, 1.0/numArray.length);
        System.out.println("Average arifm: "+avArifm);
        System.out.println("Average geom: "+avGeom);
    }

}