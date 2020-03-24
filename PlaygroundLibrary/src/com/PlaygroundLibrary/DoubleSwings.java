package com.PlaygroundLibrary;

public class DoubleSwings extends PlaySite
{
    public DoubleSwings(int limit)
    {
        super(limit);
    }

    @Override
    public float getUtilizationPercentage()
    {
        //simple code to return not precise percentage wit 2 decimal points
        int kidAmount = getCurrentAmountOfKids();
        float result = 0;
        if(kidAmount < getLimit())
        {
            result = 0;
        }
        else
        {
            result = 100;
        }

        return result;
    }

    @Override
    public String typeOfPlaysite() {
        return "DoubleSwing";
    }
}
