/*
*В молодом возрасте дракон каждый год отращивает по три головы, но после
того, как ему исполнится 200 лет – только по две, а после 300 лет – лишь по
одной. Предполагается, что дракон появляется на свет сразу с тремя головами.
Разработайте программу, которая высчитывала бы, сколько голов и глаз у
дракона, которому N лет?
* */
package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int age = enterAge();
        int heads = 3;
        if (age<200){
            heads = heads+age*3;
        }
        else if (age<300){
            heads = heads+200*3+(age-200)*2;
        }
        else {
            heads = heads+200*3+100*2 +(age-300);
        }
        System.out.println("Heads: "+heads);
        System.out.println("Eyes: "+heads*2);

    }

    private static int enterAge(){
        Scanner scanner = new Scanner(System.in);
        int age;
        while (true){
            System.out.println("Enter the age:");
            if (scanner.hasNextInt()){
                age = scanner.nextInt();
                if (age>=0){
                    return age;
                }
                else {
                    System.out.println("Age should be more than zero");
                }
            }
            else {
                System.out.println("Wrong input");
                scanner.nextLine();
            }
        }

    }


}
