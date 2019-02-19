/*
*Дру́жественные чи́сла — два различных натуральных числа , для которых
сумма всех собственных делителей первого числа равна второму числу и
наоборот, сумма всех собственных делителей второго числа равна первому
числу. Дружественные числа были открыты последователями Пифагора ,
которые, однако, знали только одну пару дружественных чисел – 220 и 284.
Найдите все дружественные числа в заданном диапазоне.
* */
package com.company;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int a = 0, b =0;
        boolean isInputCorrect = false;
        do {
            a = enterNumber();
            b = enterNumber();
            if (a <= b){
                isInputCorrect = true;
            }
            else {
                System.out.println("B should be larger than A");
            }
        }while (!isInputCorrect);
        for (int i = a; i<=b;i++){
            if (i == sumOfDividers(sumOfDividers(i)) && i<sumOfDividers(i)){
                System.out.println(i+" "+sumOfDividers(i));
            }
        }
    }

    private static int sumOfDividers(int number){
        int sum = 1;
        for (int i = 2; i<=number/2;i++){
            if (number%i == 0){
                sum+=i;
            }
        }
        return sum;
    }

    private static int enterNumber(){
        int number = 0;
        boolean isInputCorrect = false;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Enter the number");
            if (scanner.hasNextInt()){
                number = scanner.nextInt();
                isInputCorrect = true;
            }
            else {
                System.out.println("Wrong input!");
                scanner.nextLine();
            }
        }while (!isInputCorrect);
        return number;
    }

}
