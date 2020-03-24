package com.PlaygroundLibrary;

import java.util.Timer;

public interface Watch
{
    public int doubleSwingTime = 0;
    public int carouselTime = 0;
    public int slideTime = 0;
    public int ballPitTime = 0;
    public Timer timer = new Timer();
    public String tellTimeSpent();
}
