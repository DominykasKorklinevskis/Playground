package com.PlaygroundLibrary;

import java.util.TimerTask;

public class Kid implements Watch
{
    private String name;
    private int age;
    private int ticketNumber;
    private boolean ticketTypeVIP;
    private String currentPlaySite;
    public int doubleSwingTime;
    public int carouselTime;
    public int slideTime;
    public int ballPitTime;

    public Kid(String name, int age, int ticketNumber, boolean ticketTypeVip)
    {
        this.name = name;
        this.age = age;
        this.ticketNumber = ticketNumber;
        this.ticketTypeVIP = ticketTypeVip;
        currentPlaySite = "Nowhere";
        this.doubleSwingTime = Watch.doubleSwingTime;
        this.carouselTime = Watch.carouselTime;
        this.slideTime = Watch.slideTime;
        this.ballPitTime = Watch.ballPitTime;
    }

    @Override
    public String tellTimeSpent()
    {
        long startTime;
        long elapsedTime;
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                switch(currentPlaySite) {
                    case "Nowhere":
                        break;
                    case "DoubleSwing":
                        doubleSwingTime++;
                        break;
                    case "Carousel":
                        carouselTime++;
                        break;
                    case "Slide":
                        slideTime++;
                        break;
                    case "BallPit":
                        ballPitTime++;
                        break;

                }
            }
        };
        timer.scheduleAtFixedRate(timerTask, 0, 1000);

        return "Double Swing: " + doubleSwingTime + "s, Carousel: " + carouselTime + "s, Slide: " + slideTime + "s, Ball Pit: " + ballPitTime + "s";
    }

    public String history()
    {
        return currentPlaySite;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public boolean isTicketTypeVIP() {
        return ticketTypeVIP;
    }

    public String getCurrentPlaySite() {
        return currentPlaySite;
    }

    public void setCurrentPlaySite(String currentPlaySite) {
        this.currentPlaySite = currentPlaySite;
    }

}
