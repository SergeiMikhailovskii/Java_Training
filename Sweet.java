package com.company.Candies;

public class Sweet extends Candies{

    private String kind;

    public Sweet(){
        kind = "Roast";
    }

    @Override
    public String getDescription() {
        return super.getDescription()+", Sweet kind = " + kind;
    }

    public Sweet(int weight, double price, String name, String manufacturer, String kind){
        super(weight, price, name, manufacturer);
        this.kind = kind;
    }

}
