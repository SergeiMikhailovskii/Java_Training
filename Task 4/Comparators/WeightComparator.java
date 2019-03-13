package com.company.Comparators;

import com.company.Candies.Candies;

import java.util.Comparator;

public class WeightComparator implements Comparator<Candies> {

    @Override
    public int compare(Candies o1, Candies o2) {
        return Integer.compare(o1.getWeight(), o2.getWeight());
    }
}
