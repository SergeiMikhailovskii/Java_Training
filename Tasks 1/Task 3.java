/*
 На плоскости даны два круга с общим центром и радиусами R1 и R2 (R1 >
R2). Разработайте программу нахождения площади кольца, внешний радиус
которого равен R1, а внутренний радиус равен R2.
*/

package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int rExternal, rInternal;
        double squareOfRing;
        final double PI = 3.14;
        while (true) {
            rExternal = enterRadius("external");
            rInternal = enterRadius("internal");
            if (rExternal>rInternal){
                break;
            }
            else {
                System.out.println("R external should be more than R internal");
            }
        }
        squareOfRing = PI*(rExternal*rExternal-rInternal*rInternal);
        System.out.println("Square of the ring: "+squareOfRing);
    }

    private static int enterRadius(String parameter){
        Scanner scanner = new Scanner(System.in);
        int r = 0;
        boolean isInputCorrect = false;
        do{
            System.out.println("Enter radius of "+parameter+" circle");
            if (scanner.hasNextInt()){
                r = scanner.nextInt();
                if (r>0){
                    isInputCorrect = true;
                }
                else{
                    System.out.println("Radius should be more than 0");
                }
            }
            else{
                System.out.println("Wrong input");
                scanner.nextLine();
            }
        }while (!isInputCorrect);
        return r;
    }

}
