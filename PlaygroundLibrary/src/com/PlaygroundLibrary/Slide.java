package com.PlaygroundLibrary;

public class Slide extends PlaySite
{
    public Slide(int limit)
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
        return "Slide";
    }
}