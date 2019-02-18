/*
Натуральное число называют совершенным, если оно равно сумме всех своих
делителей, не считая только его самого (например, 28=1+2+3+7+14 –
совершенное число). Напишите программу, которая проверяет, является ли
введённое натуральное число совершенным. Для проверки работоспособности
программы приводится список некоторых совершенных чисел: 6, 28, 496, 8128.
*/

package com.company;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int number = enterNumber();
        int sum = 0;
        for (int i = 1;i<=number/2;i++){
            if (number%i == 0){
                sum+=i;
            }
        }
        if (sum == number){
            System.out.println("Number is perfect");
        }
        else {
            System.out.println("Number is not perfect");
        }
    }

    private static int enterNumber(){
        int number = 0;
        boolean isInputCorrect = false;
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.println("Enter the number");
            if (scanner.hasNextInt()){
                number = scanner.nextInt();
                if (number>1){
                    isInputCorrect = true;
                }
                else {
                    System.out.println("Number should be natural");
                }
            }
            else {
                System.out.println("Wrong input!");
            }
        }while (!isInputCorrect);
        return  number;
    }


}