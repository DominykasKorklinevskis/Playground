package com.PlaygroundLibrary;

public class Carousel extends PlaySite
{
    public Carousel(int limit)
    {
        super(limit);
    }

    @Override
    public float getUtilizationPercentage()
    {
        //simple code to return not precise percentage wit 2 decimal points
        int kidAmount = getCurrentAmountOfKids();
        float result = kidAmount * 100 / getLimit();
        result *= 100;
        int intResult = (int)result;
        return intResult / 100;
    }

    @Override
    public String typeOfPlaysite() {
        return "Carousel";
    }
}
