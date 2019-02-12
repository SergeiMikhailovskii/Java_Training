/*
* Разработайте небольшую цельную программу, которая меняет местами
содержимое двух целочисленных переменных a и b, не используя для этого
дополнительных переменных.
* */
package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int x1, x2, x3;
        int y1, y2, y3;
        boolean isZeroException = false;
        boolean isTriangle = true;
        x1 = enterCoordinate("x");
        y1 = enterCoordinate("y");
        x2 = enterCoordinate("x");
        y2 = enterCoordinate("y");
        x3 = enterCoordinate("x");
        y3 = enterCoordinate("y");
        try {
            if ((x2-x1)/(y2-y1) == (x3-x2)/(y3-y2)){
                System.out.println("A line");
                isTriangle = false;
            }
        }catch (ArithmeticException e){
            isZeroException = true;
        }
        if (isZeroException) {
            try {
                if ((y2 - y1) / (x2 - x1) == (y3 - y2) / (x3 - x2)) {
                    System.out.println("A line");
                    isTriangle = false;
                }
            } catch (ArithmeticException e) {

            }
        }
        if (isTriangle){
            System.out.println("It is triangle");
            //Sides
            double a,b,c;
            a =Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
            b =Math.sqrt((x3-x2)*(x3-x2)+(y3-y2)*(y3-y2));
            c =Math.sqrt((x1-x3)*(x1-x3)+(y1-y3)*(y1-y3));
            if (a == Math.sqrt(b*b+c*c)){
                System.out.println("Rectangular triangle");
            }
            else if (b == Math.sqrt(a*a+c*c)){
                System.out.println("Rectangular triangle");
            }
            else if (c == Math.sqrt(a*a+b*b)){
                System.out.println("Rectangular triangle");
            }


        }



    }

    private static int enterCoordinate(String axis){
        Scanner scanner = new Scanner(System.in);
        int number;
        System.out.println("Enter the "+ axis+" coordinate:");
        while (true){
            if (scanner.hasNextInt()){
                number = scanner.nextInt();
                return number;
            }
            else {
                System.out.println("Wrong input");
                scanner.nextLine();
            }
        }
    }


}