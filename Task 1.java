/*
Необходимо написать программу «Heads or Tails?» («Орёл или решка?»),
которая бы «подбрасывала» условно монету, к примеру, 1000 раз и сообщала,
сколько раз выпал орёл, а сколько – решка.
*/

package com.company;


import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int amount, heads = 0, tails = 0;
        final Random random = new Random();
        System.out.println("Enter the amount: ");
        amount = enterAmount();
        for (int i = 0;i<amount;i++){
            if (random.nextInt(2)==0){
                tails++;
            }
            else {
                heads++;
            }
        }
        System.out.println("Heads: "+heads+". Tails: "+tails);
    }

    private static int enterAmount(){
        int amount = 0;
        Scanner scanner = new Scanner(System.in);
        boolean isInputCorrect = false;
        do {
            if (scanner.hasNextInt()){
                amount = scanner.nextInt();
                if (amount>0){
                    isInputCorrect = true;
                }
                else {
                    System.out.println("Amount should be more than 0!");
                }
            }
            else {
                System.out.println("Wrong input");
                scanner.nextLine();
            }
        }while (!isInputCorrect);
        return amount;
    }

}