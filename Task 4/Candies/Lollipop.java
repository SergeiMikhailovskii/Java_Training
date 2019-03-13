package com.company.Candies;

public class Lollipop extends Candies{
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Lollipop(){
        type = "Gelatin";
    }

    @Override
    public String getDescription() {
        return super.getDescription()+", Lollipop type = "+type;
    }

    public Lollipop(int weight, double price, String name, String manufacturer, String type){
        super(weight, price, name, manufacturer);
        this.type = type;
    }
}
