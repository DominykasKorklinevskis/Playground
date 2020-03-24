package com.PlaygroundApplication;

import com.PlaygroundLibrary.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ButtonManager
{
    ObjectManager objectManager;
    private List<JButton> buttons = new ArrayList<JButton>();
    private List<JLabel> rightLabels = new ArrayList<JLabel>();

    ButtonManager(ObjectManager objectManager, List<JLabel> rightLabels, List<JButton> buttons)
    {
        this.objectManager = objectManager;
        this.rightLabels = rightLabels;
        this.buttons = buttons;
    }

    public JButton createPlaySiteButton(int whichButton, int whichLabel, String buttonTitle, String playSite, String setLabelText) {
        JButton jbutton = new JButton(buttonTitle);
        jbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                objectManager.setPlaySite(playSite);
                buttons.get(whichButton).setEnabled(false);
                rightLabels.get(whichLabel).setText(setLabelText);
            }
        });

        return jbutton;
    }

    public JButton createAddKidsButton(int whichLabel, String buttonTitle, String playSite) {
        JButton jbutton = new JButton(buttonTitle);
        jbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                rightLabels.get(whichLabel).setText(objectManager.assignKidToPlaysite(playSite));
            }
        });
        return jbutton;
    }

    public JButton createUtilizationButton(int whichLabel, String buttonTitle, String playSite, String setLabelText) {
        JButton jbutton = new JButton(buttonTitle);
        jbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                float percent = 0;
                percent = objectManager.getPlaysite(playSite).getUtilizationPercentage();
                rightLabels.get(whichLabel).setText(setLabelText + String.valueOf(percent) + "%");
            }
        });

        return jbutton;
    }

    public JButton createCurrentKidsFromPlaySiteButton(int whichLabel, String buttonTitle, String playSite, String setLabelText)
    {
        JButton jbutton = new JButton(buttonTitle);
        jbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int kids = 0;
                kids = objectManager.getPlaysite(playSite).getCurrentAmountOfKids();
                rightLabels.get(whichLabel).setText(setLabelText + String.valueOf(kids));
            }
        });
        return jbutton;
    }
    public JButton createTotalVisitorsButton(int whichLabel, String buttonTitle, String setLabelText)
    {
        JButton jbutton = new JButton(buttonTitle);
        jbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                rightLabels.get(whichLabel).setText(setLabelText + String.valueOf(KidManager.getTotalVisitors()));
            }
        });
        return jbutton;
    }
    public JButton createShowQueuedKidsButton(int whichLabel, String buttonTitle, String playSite, String setLabelText)
    {
        JButton jbutton = new JButton(buttonTitle);
        jbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String queuedKids = objectManager.getPlaysite(playSite).showQueuedKids();
                rightLabels.get(whichLabel).setText(queuedKids);
            }
        });
        return jbutton;
    }
}
