/*
*Íàïèñàòü ïðîãðàììó, êîòîðàÿ ïåðåâîðà÷èâàåò (ðåâåðñèðóåò) ñåìèçíà÷íîå
÷èñëî N (ê ïðèìåðó, ÷èñëî 1234567 ðåâåðñèðóåòñÿ â ÷èñëî 7654321).
*/

package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int number = enterTheNumber();
        int[] numArray = convertNumberToIntArray(number);
        number = 0;
        for (int aNumArray : numArray) {
            number = number * 10 + aNumArray;
        }
        System.out.println("Transformed number: "+number);
    }

    private static int enterTheNumber(){
        int number = 0;
        int minRange = 1000000;
        int maxRange = 9999999;
        boolean isInputCorrect = false;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Enter 7 digit number");
            if (scanner.hasNextInt()){
                number = scanner.nextInt();
                if (number>=minRange&&number<=maxRange){
                    isInputCorrect = true;
                }
                else {
                    System.out.println("Number should be 7 digit");
                }
            }
            else {
                System.out.println("Wrong input!");
                scanner.nextLine();
            }
        }while (!isInputCorrect);
        return number;
    }

    private static int[] convertNumberToIntArray(int number){
        int[] array = new int[7];
        int position = 0;
        while (number>0){
            array[position] = number%10;
            number/=10;
            position++;
        }
        return array;
    }

}
