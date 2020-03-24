package com.PlaygroundApplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class AppManager implements ActionListener {
    private JFrame frame;
    private JPanel leftPanel;
    private JPanel middlePanel;
    private JPanel rightPanel;
    private JPanel fullPanel;
    private ObjectManager objectManager;
    private List<JButton> buttons = new ArrayList<JButton>();
    private List<JLabel> rightLabels = new ArrayList<JLabel>();
    private List<JLabel> middleLabels = new ArrayList<JLabel>();
    private List<JTextField> fields = new ArrayList<JTextField>();

    public AppManager() {
        objectManager = new ObjectManager();
        frameAndPanelInitialization();
        buttonInitialization();
        labelAndTextFieldInitialization();

        //add all buttons on the left side
        for (JButton button : buttons) {
            leftPanel.add(button);
        }
        //add labels on the right side
        for (JLabel label : rightLabels) {
            rightPanel.add(label);
        }
        //Can do either label and field
        for (JTextField f : fields) {
            JLabel label = new JLabel();
            middleLabels.add(label);
            middlePanel.add(label);
            middlePanel.add(f);
        }
        middleLabels.get(0).setText("Ask kid for how long they have been in the play site");
        middleLabels.get(1).setText("Remove Kid from Double Swings");
        middleLabels.get(2).setText("Remove Kid from Carousel");
        middleLabels.get(3).setText("Remove Kid from Slide");
        middleLabels.get(4).setText("Remove Kid from Ball Pit");
        middleLabels.get(5).setText("Remove Kid from Double Swings queue");
        middleLabels.get(6).setText("Remove Kid from Carousel queue");
        middleLabels.get(7).setText("Remove Kid from Slide queue");
        middleLabels.get(8).setText("Remove Kid from Ball Pit queue");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
    }

    public void RunApp() {
        //Add panels into one singular one and set up frame window
        fullPanel.add(leftPanel);
        fullPanel.add(middlePanel);
        fullPanel.add(rightPanel);
        fullPanel.setFocusable(true);

        frame.getContentPane().add(fullPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(1500, 500);
        frame.setVisible(true);
    }

    private void frameAndPanelInitialization() {
        frame = new JFrame("SomeTM system little example");
        leftPanel = new JPanel(new GridLayout(12, 4, 10, 10));
        middlePanel = new JPanel();
        middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.PAGE_AXIS));
        rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.PAGE_AXIS));
        fullPanel = new JPanel((new FlowLayout()));
    }

    private void buttonInitialization() {
        ButtonManager buttonManager = new ButtonManager(objectManager, rightLabels, buttons);

        buttons.add(buttonManager.createPlaySiteButton(0, 0, "Create Double Swings", "DoubleSwings", "Double Swing created!"));
        buttons.add(buttonManager.createPlaySiteButton(1, 1, "Create Carousel", "Carousel", "Carousel created!"));
        buttons.add(buttonManager.createPlaySiteButton(2, 2, "Create Slide", "Slide", "Slide created!"));
        buttons.add(buttonManager.createPlaySiteButton(3, 3, "Create Ball Pit", "BallPit", "Ball Pit created!"));

        buttons.add(buttonManager.createAddKidsButton(4,"Add a kid for Double Swings", "DoubleSwings"));
        buttons.add(buttonManager.createAddKidsButton(5,"Add a kid for Carousel", "Carousel"));
        buttons.add(buttonManager.createAddKidsButton(6,"Add a kid for Slide", "Slide"));
        buttons.add(buttonManager.createAddKidsButton(7,"Add a kid for Ball Pit", "BallPit"));

        buttons.add(buttonManager.createUtilizationButton(8, "Get Double Swings Utilization", "DoubleSwings","Double Swings utilization: "));
        buttons.add(buttonManager.createUtilizationButton(9, "Get Carousel Utilization", "Carousel","Carousel utilization: "));
        buttons.add(buttonManager.createUtilizationButton(10, "Get Slide Utilization", "Slide","Slide utilization: "));
        buttons.add(buttonManager.createUtilizationButton(11, "Get Ball Pit Utilization", "BallPit","Ball Pit utilization: "));

        buttons.add(buttonManager.createCurrentKidsFromPlaySiteButton(12, "Get Double Swings current kids", "DoubleSwings","Double Swings current kids: "));
        buttons.add(buttonManager.createCurrentKidsFromPlaySiteButton(13, "Get Carousel current kids", "Carousel", "Carousel current kids: "));
        buttons.add(buttonManager.createCurrentKidsFromPlaySiteButton(14, "Get Slide current kids", "Slide", "Slide current kids: "));
        buttons.add(buttonManager.createCurrentKidsFromPlaySiteButton(15, "Get Ball Pit current kids", "BallPit", "Ball Pit current kids: "));

        buttons.add(buttonManager.createShowQueuedKidsButton(16, "Show Double Swings queued kids", "DoubleSwings","Double Swings queued kids: "));
        buttons.add(buttonManager.createShowQueuedKidsButton(17, "Show Carousel queued kids", "Carousel","Carousel queued kids: "));
        buttons.add(buttonManager.createShowQueuedKidsButton(18, "Show Slide queued kids", "Slide","Slide queued kids: "));
        buttons.add(buttonManager.createShowQueuedKidsButton(19, "Show Ball Pit queued kids", "BallPit","Ball Pit queued kids: "));

        buttons.add(buttonManager.createTotalVisitorsButton(20, "Get total visitors", "Total Visitors: "));
    }

    private void labelAndTextFieldInitialization()
    {
        TextFieldManager textFieldManager = new TextFieldManager(objectManager, middleLabels, rightLabels, fields);

        for (int i = 0; i < 9; i++) {
            JTextField field = new JTextField(30);
            field.setMaximumSize(field.getPreferredSize());
            fields.add(field);
        }
        //create labels for right side
        for (int i = 0; i < 24; i++) {
            rightLabels.add(new JLabel());
        }

        textFieldManager.manageAskKidTextField();
        textFieldManager.manageRemovingKidsFromPlaySiteTextFields();
        textFieldManager.manageRemovingKidsFromPlaySiteQueuesTextFields();
    }
}
