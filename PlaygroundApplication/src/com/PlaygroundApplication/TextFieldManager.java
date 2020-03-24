package com.PlaygroundApplication;

import com.PlaygroundLibrary.KidManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TextFieldManager
{
    ObjectManager objectManager;
    private List<JTextField> fields = new ArrayList<JTextField>();
    private List<JLabel> middleLabels = new ArrayList<JLabel>();
    private List<JLabel> rightLabels = new ArrayList<JLabel>();

    TextFieldManager(ObjectManager objectManager, List<JLabel> middleLabels, List<JLabel> rightLabels, List<JTextField> fields)
    {
        this.objectManager = objectManager;
        this.middleLabels = middleLabels;
        this.rightLabels = rightLabels;
        this.fields = fields;
    }

    public void manageAskKidTextField()
    {
        //get action for first text field
        fields.get(0).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String input = KidManager.askKid(Integer.parseInt(fields.get(0).getText()));
                rightLabels.get(21).setText(input);
                System.out.println(input);
            }
        });
    }

    public void manageRemovingKidsFromPlaySiteTextFields()
    {
        fields.get(1).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                objectManager.getPlaysite("DoubleSwings").removeKidFromPlaySite(Integer.parseInt(fields.get(1).getText()));
                String input = "Kid Removed from " + "DoubleSwings";
                rightLabels.get(22).setText(input);
                System.out.println(input);
            }
        });

        fields.get(2).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                objectManager.getPlaysite("Carousel").removeKidFromPlaySite(Integer.parseInt(fields.get(2).getText()));
                String input = "Kid Removed from " + "Carousel";
                rightLabels.get(22).setText(input);
                System.out.println(input);
            }
        });

        fields.get(3).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                objectManager.getPlaysite("Slide").removeKidFromPlaySite(Integer.parseInt(fields.get(3).getText()));
                String input = "Kid Removed from " + "Slide";
                rightLabels.get(22).setText(input);
                System.out.println(input);
            }
        });

        fields.get(4).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                objectManager.getPlaysite("BallPit").removeKidFromPlaySite(Integer.parseInt(fields.get(4).getText()));
                String input = "Kid Removed from " + "BallPit";
                rightLabels.get(22).setText(input);
                System.out.println(input);
            }
        });
    }

    public void manageRemovingKidsFromPlaySiteQueuesTextFields()
    {
        fields.get(5).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                objectManager.getPlaysite("DoubleSwings").removeKidFromQueue(Integer.parseInt(fields.get(5).getText()));
                String input = "Kid Removed from " + "DoubleSwings" + " Queue";
                rightLabels.get(23).setText(input);
                System.out.println(input);
            }
        });

        fields.get(6).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                objectManager.getPlaysite("Carousel").removeKidFromQueue(Integer.parseInt(fields.get(6).getText()));
                String input = "Kid Removed from " + "Carousel" + " Queue";
                rightLabels.get(23).setText(input);
                System.out.println(input);
            }
        });

        fields.get(7).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                objectManager.getPlaysite("Slide").removeKidFromQueue(Integer.parseInt(fields.get(7).getText()));
                String input = "Kid Removed from " + "Slide" + " Queue";
                rightLabels.get(23).setText(input);
                System.out.println(input);
            }
        });

        fields.get(8).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                objectManager.getPlaysite("BallPit").removeKidFromQueue(Integer.parseInt(fields.get(8).getText()));
                String input = "Kid Removed from " + "BallPit" + " Queue";
                rightLabels.get(23).setText(input);
                System.out.println(input);
            }
        });
    }
}
