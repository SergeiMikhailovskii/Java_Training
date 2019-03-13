package com.company.Comparators;

import com.company.Candies.Candies;

import java.util.Comparator;

public class ManufacturerComparator implements Comparator<Candies> {
    @Override
    public int compare(Candies o1, Candies o2) {
        return o1.getManufacturer().compareTo(o2.getManufacturer());
    }

}
