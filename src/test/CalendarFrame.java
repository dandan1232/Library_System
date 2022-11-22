package test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author: ����
 * @date: 2022/11/22 14:44
 * @description:
 */
public class CalendarFrame extends Frame implements ActionListener {
    Label labelDay[] = new Label[42];
    Button titleName[] = new Button[7];
    String name[] = {"��", "һ", "��", "��", "��", "��", "��"};
    Button nextMonth, previousMonth;
    int year = 2020, month = 5;
    CalendarBean calendar;
    Label showMessage = new Label("", Label.CENTER);

    public CalendarFrame() {
        Panel pCenter = new Panel();
        pCenter.setLayout(new GridLayout(7, 7)); //��pCenter�Ĳ�������Ϊ7��7�е�GridLayout ���֡�
        for (int i = 0; i < 7; i++) {
            titleName[i] = new Button(name[i]);
            pCenter.add(titleName[i]);//pCenter������titleName[i]��
        }
        for (int i = 0; i < 42; i++) {
            labelDay[i] = new Label("", Label.CENTER);
            pCenter.add(labelDay[i]);//pCenter������labelDay[i]��
        }
        calendar = new CalendarBean();
        calendar.setYear(year);
        calendar.setMonth(month);
        String day[] = calendar.getCalendar();
        for (int i = 0; i < 42; i++) {
            labelDay[i].setText(day[i]);
        }
        nextMonth = new Button("����");
        previousMonth = new Button("����");
        nextMonth.addActionListener(this);
        previousMonth.addActionListener(this);
        Panel pNorth = new Panel(),
                pSouth = new Panel();
        pNorth.add(previousMonth);
        pNorth.add(nextMonth);
        pSouth.add(showMessage);
        showMessage.setText("������" + calendar.getYear() + "��" + calendar.getMonth() + "��");
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.add(pCenter);
        add(scrollPane, BorderLayout.CENTER);// �������scrollPane����������
        add(pNorth, BorderLayout.NORTH);//  �������pNorth �ڱ�������
        add(pSouth, BorderLayout.SOUTH);// �������pSouth ��������
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nextMonth) {
            month = month + 1;
            if (month > 12) {
                month = 1;
                year++;
            }
            calendar.setYear(year);
            calendar.setMonth(month);
            String day[] = calendar.getCalendar();
            for (int i = 0; i < 42; i++) {
                labelDay[i].setText(day[i]);
            }
        } else if (e.getSource() == previousMonth) {
            month = month - 1;
            if (month < 1) {
                month = 12;
                year--;
            }
            calendar.setYear(year);
            calendar.setMonth(month);
            String day[] = calendar.getCalendar();
            for (int i = 0; i < 42; i++) {
                labelDay[i].setText(day[i]);
            }
        }
        showMessage.setText("������" + calendar.getYear() + "��" + calendar.getMonth() + "��");

    }
}