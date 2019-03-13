package com.company.Candies;

public class Chocolate extends Candies {
    private double cacaoPercent;
    private String kind;

    public double getCacaoPercent() {
        return cacaoPercent;
    }

    public void setCacaoPercent(double cacaoPercent) {
        this.cacaoPercent = cacaoPercent;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Chocolate(){
        super();
        cacaoPercent = 0;
        kind = "Milk";
    }

    @Override
    public String getDescription() {
        return super.getDescription()+", Cacao Percent = "+cacaoPercent+", Kind = "+kind;
    }

    public Chocolate(int weight, double price, String name, String manufacturer, double cacaoPercent, String kind){
        super(weight, price, name, manufacturer);
        this.cacaoPercent = cacaoPercent;
        this.kind = kind;
    }
}