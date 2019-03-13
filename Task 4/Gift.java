package com.company.Gift;

import com.company.Candies.Candies;

import java.util.ArrayList;
import java.util.List;

public class Gift {

    private List<Candies> giftBox;

    public Gift(){
        giftBox = new ArrayList<>();
    }

    public List<Candies> getGiftBox() {
        return giftBox;
    }

    public void addCandy(Candies candy){
        giftBox.add(candy);
    }

    public void removeCandy(Candies candy){
        giftBox.remove(candy);
    }

    public double getGiftWeight(){
        double weight = 0;
        for (Candies aGiftBox : giftBox) {
            weight += aGiftBox.getWeight();
        }
        return weight;
    }

    public void getGiftInformation(){
        for (Candies aGiftBox : giftBox) {
            System.out.println(aGiftBox.getDescription());
        }
    }

}