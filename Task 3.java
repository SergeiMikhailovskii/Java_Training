/*
 На плоскости даны два круга с общим центром и радиусами R1 и R2 (R1 >
R2). Разработайте программу нахождения площади кольца, внешний радиус
которого равен R1, а внутренний радиус равен R2.
*/

package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int rVneshn, rVnutr;
        double squareOfRing;
        final double pi = 3.14;
        while (true) {
            rVneshn = enterRadius("external");
            rVnutr = enterRadius("internal");
            if (rVneshn>rVnutr){
                break;
            }
            else {
                System.out.println("R vnesh should be more than R vnutr");
            }
        }
        squareOfRing = pi*(rVneshn*rVneshn-rVnutr*rVnutr);
        System.out.println("Square of the ring: "+squareOfRing);
    }

    private static int enterRadius(String parameter){
        Scanner scanner = new Scanner(System.in);
        int r;
        while (true){
            System.out.println("Enter radius of "+parameter+" circle");
            if (scanner.hasNextInt()){
                r = scanner.nextInt();
                if (r>0){
                    return r;
                }
                else{
                    System.out.println("Radius should be more than 0");
                }
            }
            else{
                System.out.println("Wrong input");
                scanner.nextLine();
            }
        }
    }

}