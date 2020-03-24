package com.PlaygroundLibrary;

import java.util.ArrayList;
import java.util.List;

public class KidManager
{
    private static int totalVisitors = 0;
    public static List<Kid> totalKidsInPlayground = new ArrayList<Kid>();

    public static String askKid(int whichKid)
    {
        return totalKidsInPlayground.get(whichKid).tellTimeSpent();
    }

    public static int getTotalVisitors() {
        totalVisitors = totalKidsInPlayground.size();
        return totalVisitors;
    }
}
