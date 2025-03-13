package javaProject.amusementPark.main;

import javaProject.amusementPark.member.MemDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public abstract class GuiMaker extends JPanel implements ActionListener {

    public GuiMaker() {

    }

    public static JPanel makeGenderPanel(int a) {
        JPanel panel = new JPanel(new GridLayout(1, 2));
        JRadioButton radioMan = new JRadioButton("남자");
        JRadioButton radioWoman = new JRadioButton("여자");
        panel.add(radioMan);
        panel.add(radioWoman);
        if (a == 0) {
            radioMan.setSelected(true);
        } else if (a == 1) {
            radioWoman.setSelected(true);
        }
        radioMan.addActionListener(actionEvent -> {
            if (radioMan.isSelected()) {
                radioWoman.setSelected(false);
            } else {
                radioMan.setSelected(true);
            }
        });
        radioWoman.addActionListener(actionEvent -> {
            if (radioWoman.isSelected()) {
                radioMan.setSelected(false);
            } else {
                radioWoman.setSelected(true);
            }
        });
        return panel;
    }

    public static JPanel makerBirthPanel(MemDTO memDTO) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        String[] year = new String[46];
        String[] month = new String[12];
        String[] day = new String[31];
        for (int i = 0; i < year.length; i++) {
            year[i] = String.valueOf(i+1980);
        }
        for (int i = 0; i < month.length; i++) {
            month[i] = String.valueOf(i+1);
        }
        for (int i = 0; i < day.length; i++) {
            day[i] = String.valueOf(i+1);
        }
        JComboBox yearCom = new JComboBox(year);
        yearCom.setBackground(Color.WHITE);
        JComboBox monthCom = new JComboBox(month);
        monthCom.setBackground(Color.WHITE);
        JComboBox dayCom = new JComboBox(day);
        dayCom.setBackground(Color.WHITE);
        panel.add(yearCom);
        panel.add(new JLabel("년"));
        panel.add(monthCom);
        panel.add(new JLabel("월"));
        panel.add(dayCom);
        panel.add(new JLabel("일"));

        int mBYear = Integer.parseInt(memDTO.getYear());
        int mBMonth = Integer.parseInt(memDTO.getMonth());
        int mBDay = Integer.parseInt(memDTO.getDay());

        yearCom.setSelectedIndex(mBYear-1980);
        monthCom.setSelectedIndex(mBMonth-1);
        dayCom.setSelectedIndex(mBDay-1);

        return panel;
    }
}
