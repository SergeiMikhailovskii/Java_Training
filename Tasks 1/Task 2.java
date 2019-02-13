/*
    *Масса динозавра задаётся в килограммах. Разработайте программу, которая вычисляет, сколько это миллиграмм, грамм и тонн.
*/

package com.company;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int weight = enterWeight();
        double convertedWeight = -1;
        String measure="";
        switch (menu()){
            case 1:
                convertedWeight = weight*1000000;
                measure = "mg";
                break;
            case 2:
                convertedWeight=weight*1000;
                measure = "g";
                break;
            case 3:
                convertedWeight=(double) weight/1000;
                measure = "t";
                break;
            default:
                System.out.println("Wrong input");
                break;
        }
        if (convertedWeight!=-1) {
            System.out.println(weight+" kg is " +convertedWeight+" "+measure);
        }
    }

    private static int enterWeight(){
        Scanner scanner = new Scanner(System.in);
        int weight;
        while (true){
            System.out.println("Enter the weight");
            if (scanner.hasNextInt()){
                weight = scanner.nextInt();
                if (weight>0) {
                    return weight;
                }
                else {
                    System.out.println("Weight should be more than 0");
                }
            }
            else{
                System.out.println("Wrong input, Please try again");
                scanner.nextLine();
            }
        }
    }

    private static int menu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the variant you need to convert:");
        System.out.println("1 - milligrams");
        System.out.println("2 - grams");
        System.out.println("3 - tones");
        while (true){
            if (scanner.hasNextInt()){
                return scanner.nextInt();
            }
            else {
                System.out.println("Wrong input, Please try again");
                scanner.nextInt();
            }
        }
    }


}
