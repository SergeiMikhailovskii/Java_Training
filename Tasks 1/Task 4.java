/*
*Разработайте программу, которая проверяет, что цифры четырёхзначного
числа N образуют возрастающую (убывающую) последовательность (к примеру,
число 1357 удовлетворяет условию, т.к. его цифры соответствуют следующему
неравенству: 1 < 3 < 5 < 7, т.е. идут в порядке возрастания).
*/

package com.company;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int number = enterFourDigitNumber();
        int[] numArray = convertNumberToIntArray(number);
        boolean areDigitsIncreaseOrDecrease = true;
        int choice = 0;
        do {
            choice = menu();

            switch (choice) {
                case 1:
                    for (int i = 0; i < numArray.length - 1; i++) {
                        if (numArray[i + 1] <= numArray[i]) {
                            areDigitsIncreaseOrDecrease = false;
                            break;
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < numArray.length - 1; i++) {
                        if (numArray[i + 1] >= numArray[i]) {
                            areDigitsIncreaseOrDecrease = false;
                            break;
                        }
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Choose 1 or 2");
                    break;

            }
            if (choice != 0) {
                if (areDigitsIncreaseOrDecrease) {
                    System.out.println("Number is increasing/decreasing");
                }
                else  {
                    System.out.println("Number is increasing/decreasing");
                }
            }
        } while (choice != 0);

    }

    private static int enterFourDigitNumber() {
        int number;
        final int minRange = 1000;
        final int maxRange = 9999;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter number");
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                if (number >= minRange && number <= maxRange) {
                    return number;
                }
                else {
                    System.out.println("Number should be four digits");
                }
            }
            else {
                System.out.println("Wrong input, please, try again");
                scanner.nextLine();
            }
        }
    }

    private static int[] convertNumberToIntArray(int number) {
        int[] numArray = new int[4];
        int position = 3;  // С этого индекса начинаем заполнять массив
        while (number > 0) {
            numArray[position] = number % 10;
            number /= 10;
            position--;
        }
        return numArray;
    }

    private static int menu() {
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        boolean isInputCorrect = false;
        do {
            System.out.println("1 - check if increase");
            System.out.println("2 - check if decrease");
            System.out.println("0 - exit");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                isInputCorrect = true;
            }
            else {
                System.out.println("Wrong input");
                scanner.nextLine();
            }
        } while (!isInputCorrect);
        return choice;
    }

}
