package com.PlaygroundApplication;

import com.PlaygroundLibrary.*;

import java.util.Random;

public class ObjectManager
{
    private DoubleSwings doubleSwings;
    private Carousel carousel;
    private Slide slide;
    private BallPit ballPit;
    Random random;
    private KidManager kidManager;
    public ObjectManager()
    {
        random = new Random();
        kidManager = new KidManager();
    }

    private Kid createRandomKid()
    {
        Kid kid1 = new Kid("Robert", 12, 1558, false);
        Kid kid = new Kid
                (
                        "name" + 1 + random.nextInt(100),
                        1+random.nextInt(18),
                        random.nextInt(10000),
                        random.nextBoolean()
                );
        return kid;
    }

    public void assignKidToDoubleSwings()
    {
        doubleSwings.addKid(createRandomKid());
    }
    public void assignKidToCarousel()
    {
        carousel.addKid(createRandomKid());
    }
    public void assignKidToSlide()
    {
        slide.addKid(createRandomKid());
    }
    public void assignKidToBallPit()
    {
        ballPit.addKid(createRandomKid());
    }

    public String assignKidToPlaysite(String which)
    {
        String message = "";
        switch (which)
        {
            case "DoubleSwings":
                message = doubleSwings.addKid(createRandomKid());
                break;
            case "Carousel":
                message = carousel.addKid(createRandomKid());
                break;
            case "Slide":
                message = slide.addKid(createRandomKid());
                break;
            case "BallPit":
                message = ballPit.addKid(createRandomKid());
                break;
        }
        return message;
    }

    public void setDoubleSwings(DoubleSwings doubleSwings) {
        this.doubleSwings = doubleSwings;
    }

    public void setCarousel(Carousel carousel) {
        this.carousel = carousel;
    }

    public void setSlide(Slide slide) {
        this.slide = slide;
    }

    public void setBallPit(BallPit ballPit) {
        this.ballPit = ballPit;
    }

    public void setPlaySite(String which)
    {
        switch (which)
        {
            case "DoubleSwings":
                setDoubleSwings(new DoubleSwings(2));
                break;
            case "Carousel":
                setCarousel(new Carousel(20));
                break;
            case "Slide":
                setSlide(new Slide(8));
                break;
            case "BallPit":
                setBallPit(new BallPit(10));
                break;
        }
    }

    public PlaySite getPlaysite(String which)
    {
        switch (which)
        {
            case "DoubleSwings":
                return doubleSwings;
            case "Carousel":
                return carousel;
            case "Slide":
                return slide;
            case "BallPit":
                return ballPit;
        }
        return null;
    }

    public DoubleSwings getDoubleSwings() {
        return doubleSwings;
    }

    public Carousel getCarousel() {
        return carousel;
    }

    public Slide getSlide() {
        return slide;
    }

    public BallPit getBallPit() {
        return ballPit;
    }

    public KidManager getKidManager() {
        return kidManager;
    }
}
