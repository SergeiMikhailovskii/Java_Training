package com.company;


import com.company.Candies.Candies;
import com.company.Candies.Chocolate;
import com.company.Candies.Lollipop;
import com.company.Candies.Sweet;
import com.company.Comparators.ManufacturerComparator;
import com.company.Comparators.WeightComparator;
import com.company.Gift.Gift;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Logger logger = Logger.getLogger(Main.class);


    public static void main(String[] args) {
        Gift gift = new Gift();
        BufferedReader bufferedReader;
        boolean isWorkFinished = false;

        Scanner scanner = new Scanner(System.in);

        try {
            bufferedReader = new BufferedReader(new FileReader("data.txt"));

            String buffer;
            String[] bufArray;
            int i = 0;
            while ((buffer = bufferedReader.readLine()) != null){
                bufArray = buffer.split(" ");
                if (isFileDataCorrect(bufArray[0], bufArray.length)) {
                    createCandy(bufArray, gift);
                    logger.info("Candy created from line "+i);
                }
                else {
                    logger.info("Candy can't be created from line "+i);
                }
                i++;
            }

            do {
                switch (menu()){
                    case 1:
                        gift.getGiftInformation();
                        break;
                    case 2:
                        System.out.println("\nWeight = "+gift.getGiftWeight());
                        break;
                    case 3:
                        gift.getGiftBox().sort(new ManufacturerComparator());
                        gift.getGiftInformation();
                        break;
                    case 4:
                        gift.getGiftBox().sort(new WeightComparator());
                        gift.getGiftInformation();
                        break;
                    case 5:
                        System.out.println("\nEnter the weight");
                        int weight = scanner.nextInt();
                        findCandiesByWeight(gift.getGiftBox(), weight);
                        break;
                    case 0:
                        isWorkFinished = true;
                        break;
                }
            }while (!isWorkFinished);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static boolean isFileDataCorrect(String sweetName, int size){
        return (sweetName.equals("Chocolate") && size == 7)
                || (sweetName.equals("Sweet") && size == 6)
                || (sweetName.equals("Lollipop") && size == 6);
    }


    private static void createCandy(String[] bufArray, Gift gift){
        int weight = Integer.parseInt(bufArray[1]);
        double price = Double.parseDouble(bufArray[2]);
        String name = bufArray[3];
        String manufacturer = bufArray[4];
        switch (bufArray[0]) {
            case "Chocolate": {
                double cacaoPercent = Double.parseDouble(bufArray[5]);
                String kind = bufArray[6];
                Candies chocolate = new Chocolate(weight, price, name, manufacturer, cacaoPercent, kind);
                gift.addCandy(chocolate);
                break;
            }
            case "Sweet": {
                String kind = bufArray[5];
                Candies sweet = new Sweet(weight, price, name, manufacturer, kind);
                gift.addCandy(sweet);
                break;
            }
            case "Lollipop":
                String type = bufArray[5];
                Candies lollipop = new Lollipop(weight, price, name, manufacturer, type);
                gift.addCandy(lollipop);
                break;
        }
    }

    private static void findCandiesByWeight(List<Candies> giftBox, int weight){
        boolean isCandyFound = false;
        for (Candies a:giftBox){
            if (a.getWeight() == weight){
                System.out.println("\nFound candies with such weight:");
                System.out.println(a.getDescription());
                isCandyFound = true;
            }
        }
        if (!isCandyFound){
            System.out.println("\nThere are no candies with such weight!");
        }
    }

    private static int menu(){
        int choice = 0;
        boolean isInputCorrect = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n1 - show gift box");
        System.out.println("2 - count gift box weight");
        System.out.println("3 - sort gift by manufacturer");
        System.out.println("4 - sort gift by weight");
        System.out.println("5 - find candies by weight");
        System.out.println("0 - exit");
        do{
            if (scanner.hasNextInt()){
                choice = scanner.nextInt();
                isInputCorrect = true;
                logger.info("User entered value: "+choice);
            }
            else {
                scanner.nextLine();
                logger.info("User entered wrong value");
            }
        }while (!isInputCorrect);
        return choice;

    }

}
