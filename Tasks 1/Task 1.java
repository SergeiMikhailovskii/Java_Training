/*
*Разработайте программу, которая проверяет, что числа a, b и c различны(одинаковы).
*/

package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    int a, b, c;
        a = enterTheValue();
        b = enterTheValue();
        c = enterTheValue();
        if (a==b){
            if (b ==c){
                System.out.println("All numbers are the same");
            }
            else {
                System.out.println("2 numbers are the same");
            }
        }
        else{
            if (b == c){
                System.out.println("2 numbers are the same");
            }
            else if (a ==c){
                System.out.println("2 numbers are the same");
            }
            else {
                System.out.println("All numbers are different");
            }
        }
    }

    private static int enterTheValue(){
        int value;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter the value of the number");
            if (scanner.hasNextInt()){
                value = scanner.nextInt();
                return value;
            }
            else {
                System.out.println("Wrong input");
                scanner.nextLine();
            }
        }
    }
}
