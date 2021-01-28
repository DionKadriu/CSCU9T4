// GUI and main program for the Training Record
package Practical1;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.Number;

public class TrainingRecordGUI extends JFrame implements ActionListener {

    private JTextField name = new JTextField(30);
    private JTextField day = new JTextField(2);
    private JTextField month = new JTextField(2);
    private JTextField year = new JTextField(4);
    private JTextField hours = new JTextField(2);
    private JTextField mins = new JTextField(2);
    private JTextField secs = new JTextField(2);
    private JTextField repetition = new JTextField(2);
    private JTextField recovery = new JTextField(2);
    private JTextField dist = new JTextField(4);
    private JTextField where = new JTextField(2);
    private JTextField terrain = new JTextField(2);
    private JTextField tempo = new JTextField(2);
    private JLabel labn = new JLabel(" Name:");
    private JLabel labd = new JLabel(" Day:");
    private JLabel labm = new JLabel(" Month:");
    private JLabel laby = new JLabel(" Year:");
    private JLabel labh = new JLabel(" Hours:");
    private JLabel labmm = new JLabel(" Mins:");
    private JLabel labs = new JLabel(" Secs:");
    private JLabel labrepetition = new JLabel(" Reps:");
    private JLabel labrecovery = new JLabel(" Recovery:");
    private JLabel labwhere = new JLabel(" Where:");
    private JLabel labtempo = new JLabel(" Tempo:");
    private JLabel labterrain = new JLabel(" Terrain:");
    private JLabel labdist = new JLabel(" Distance (km):");
    private JButton add_sprint = new JButton("Add Sprint");
    private JButton add_swim = new JButton("Add swim");
    private JButton add_cycle = new JButton("Add cycle");
    private JButton lookUpByDate = new JButton("Look Up");
    private JButton findAllByDate = new JButton("Find By Date");//added the button
    private JButton remove = new JButton("Remove element");
    private JButton findAllByName = new JButton("Find By Name");

    private TrainingRecord myAthletes = new TrainingRecord();

    private JTextArea outputArea = new JTextArea(5, 50);

    public static void main(String[] args) {
        TrainingRecordGUI applic = new TrainingRecordGUI();
    } // main

    // set up the GUI 
    public TrainingRecordGUI() {
        super("Training Record");
        setLayout(new FlowLayout());
        add(labn);
        add(name);
        name.setEditable(true);
        add(labd);
        add(day);
        day.setEditable(true);
        add(labm);
        add(month);
        where.setEditable(true);//where
        add(labwhere);
        add(where);
        month.setEditable(true);
        add(laby);
        add(year);
        year.setEditable(true);
        add(labh);
        add(hours);
        hours.setEditable(true);
        add(labmm);
        add(mins);
        mins.setEditable(true);
        add(labs);
        add(secs);
        secs.setEditable(true);
        add(labdist);
        add(dist);
        dist.setEditable(true);
        add(recovery);//
        add(labrecovery);//
        recovery.setEditable(true);///recovery box
        add(terrain);//
        add(labterrain);//
        terrain.setEditable(true);///terrain box
        add(tempo);//
        add(labtempo);//
        tempo.setEditable(true);///recovery box
        add(repetition);
        add(labrepetition);
        repetition.setEditable(true);//repetition
        add(add_sprint);
        add_sprint.addActionListener(this);
        add(add_swim);
        add_swim.addActionListener(this);
        add(add_cycle);
        add_cycle.addActionListener(this);
        add(remove);
        remove.addActionListener(this);

        add(lookUpByDate);
        lookUpByDate.addActionListener(this);
        add(outputArea);
        add(findAllByDate);
        findAllByDate.addActionListener(this);
        add(findAllByName);
        findAllByName.addActionListener(this);
        outputArea.setEditable(false);
        setSize(720, 200);
        setVisible(true);
        blankDisplay();


//        findAllByDate.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e)// To save typing in new entries while testing, uncomment
//            {// the following lines (or add your own test cases)
//                int m = Integer.parseInt(month.getText());
//                int d = Integer.parseInt(day.getText());
//                int y = Integer.parseInt(year.getText());
//                outputArea.setText("looking up record ...");
//
//                String message = myAthletes.findAllByDate(d, m, y);
//
//
//                JOptionPane.showMessageDialog(null, message);
//            } // } constructor
//        });

        // listen for and respond to GUI events
    }

    public void actionPerformed(ActionEvent event) {
        String message = "";
        if (event.getSource() == add_sprint) {
            message = addEntrySprint("sprint");
        }
        if (event.getSource() == add_swim) {
            message = addEntrySwim("swimming");
        }
        if (event.getSource() == add_cycle) {
            message = addEntryCycle("cycling");
        }
        if (event.getSource() == lookUpByDate) {
            message = lookupEntry();
        }
        if (event.getSource() == findAllByDate) {
            message = findAllByDate();
        }
        if (event.getSource() == remove) {
            message = remove();
        }
        if (event.getSource() == findAllByName) {
            message = findAllByName();
        }
        outputArea.setText(message);
        blankDisplay();
    } // actionPerformed

    public String addEntrySwim(String what) {
        String message = "Record added\n";
        System.out.println("Adding " + what + " entry to the records");

        try {
            String n = name.getText();
            if (n.isEmpty()) {
                return "Name can not be empty";

            }
            int m = Integer.parseInt(month.getText());
            int d = Integer.parseInt(day.getText());
            int y = Integer.parseInt(year.getText());
            float km = java.lang.Float.parseFloat(dist.getText());
            int h = Integer.parseInt(hours.getText());
            int mm = Integer.parseInt(mins.getText());
            int s = Integer.parseInt(secs.getText());

            String where1 = where.getText();


            SwimEntry swim = new SwimEntry(n, d, m, y, h, mm, s, km, where1);

            myAthletes.addEntry(swim);


        } catch (IllegalArgumentException ex) {
            message = "One of the boxes not filled or incorrect input \n" +
                    "Record could not be added".toUpperCase();
            return message;
        }


        return message;
    }


    public String addEntrySprint(String what) {
        String message = "Record added\n";
        System.out.println("Adding " + what + " entry to the records");

        try {
            String n = name.getText();
            if (n.isEmpty()) {
                return "Name can not be empty";

            }
            int m = Integer.parseInt(month.getText());
            int d = Integer.parseInt(day.getText());
            int y = Integer.parseInt(year.getText());
            float km = java.lang.Float.parseFloat(dist.getText());
            int h = Integer.parseInt(hours.getText());
            int mm = Integer.parseInt(mins.getText());
            int s = Integer.parseInt(secs.getText());
            int rep = Integer.parseInt(repetition.getText());
            int rec = Integer.parseInt(recovery.getText());

            SprintEntry sprint = new SprintEntry(n, d, m, y, h, mm, s, km, rep, rec);
            myAthletes.addEntry(sprint);


        } catch (IllegalArgumentException ex) {
            message = "One of the boxes not filled or incorrect input \n" +
                    "Record could not be added".toUpperCase();
            return message;
        }


        return message;
    }

    public String addEntryCycle(String what) {
        String message = "Record added\n";
        System.out.println("Adding " + what + " entry to the records");

        try {
            String n = name.getText();
            if (n.isEmpty()) {
                return "Name can not be empty";

            }
            int m = Integer.parseInt(month.getText());
            int d = Integer.parseInt(day.getText());
            int y = Integer.parseInt(year.getText());
            float km = java.lang.Float.parseFloat(dist.getText());
            int h = Integer.parseInt(hours.getText());
            int mm = Integer.parseInt(mins.getText());
            int s = Integer.parseInt(secs.getText());
            String terr = terrain.getText();
            String temp = tempo.getText();

            CycleEntry cycleEntry = new CycleEntry(n, d, m, y, h, mm, s, km, terr, temp);
            myAthletes.addEntry(cycleEntry);


        } catch (IllegalArgumentException ex) {
            return "One of the boxes not filled or incorrect input \n" +
                    "Record could not be added".toUpperCase();

        }


        return message;
    }

    public String lookupEntry() {
        try {
            int m = Integer.parseInt(month.getText());
            int d = Integer.parseInt(day.getText());
            int y = Integer.parseInt(year.getText());
            String res = myAthletes.lookupEntry(d, m, y);
            return res;

        } catch (NumberFormatException ex) {
            return "No entries found for display";
        }
    }

    public String findAllByDate() {

        try {
            int m = Integer.parseInt(month.getText());
            int d = Integer.parseInt(day.getText());
            int y = Integer.parseInt(year.getText());
            String res = myAthletes.findAllByDate(d, m, y);
            return res;

        } catch (NumberFormatException ex) {
            return "No entries found for display";
        }

    }

    public String findAllByName() {
        String n = name.getText();
        outputArea.setText("looking up record ...");

        String message = myAthletes.findAllByName(n);

        return message;
    }

    public String remove() {
        try {
            String n = name.getText();
            int m = Integer.parseInt(month.getText());
            int d = Integer.parseInt(day.getText());
            int y = Integer.parseInt(year.getText());
            outputArea.setText("The entries are removed ...");
            String message = myAthletes.remove(n, d, m, y);
            return message;
        } catch (IllegalArgumentException ex) {
            return "No entries to remove";
        }


    }

    public void blankDisplay() {
        name.setText("");
        day.setText("");
        month.setText("");
        year.setText("");
        hours.setText("");
        mins.setText("");
        secs.setText("");
        dist.setText("");
        repetition.setText("");//set to blan
        where.setText("");//set to blan
        recovery.setText("");//set to blanl
        terrain.setText("");//set to blank
        tempo.setText("");//set to blank

    }// blankDisplay

    // Fills the input fields on the display for testing purposes only
    public void fillDisplay(Entry ent) {
        name.setText(ent.getName());
        day.setText(String.valueOf(ent.getDay()));
        month.setText(String.valueOf(ent.getMonth()));
        year.setText(String.valueOf(ent.getYear()));
        hours.setText(String.valueOf(ent.getHour()));
        mins.setText(String.valueOf(ent.getMin()));
        secs.setText(String.valueOf(ent.getSec()));
        dist.setText(String.valueOf(ent.getDistance()));
    }

} // TrainingRecordGUI

