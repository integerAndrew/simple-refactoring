package org.chartsmart;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IndividualDisplay extends JPanel {

    private String mode;
    private String chartTitle;
    private int chartType;

    private void initializeDrawArea() {
        this.setPreferredSize(new Dimension(600, 600));
        setTitleOfChartType();
    }

    private void setTitleOfChartType() {
        chartTitle = getChartType() + " Chart - " + getChartMode();
    }

    private String getChartMode() {
        if (mode.equals("rpfll")) {
            return "Single Mode";
        }
        return "Compare Mode";

    }

    private String getChartType() {
        if (chartType == 406) {
            return "Bar";
        }
        return "Pie";
    }

    public IndividualDisplay() {
    }

    public String getTitle() {
        return chartTitle;
    }

    /**
     * Shows the chart
     *
     * @param chartType
     * @param mode
     * @param shouldInitializeDrawArea
     * @return
     */
    public void showChart(int chartType, String mode, boolean shouldInitializeDrawArea) {
        this.chartType = chartType;
        this.mode = mode;
        if (shouldInitializeDrawArea) {
            initializeDrawArea();
        }
    }

    private String generateTimeStamp() {
        return new Date().toString();
    }

    /**
     * @param graphics
     * @author Wilbur
     * @since
     */
    public void paint(Graphics graphics) {
        String[] data;
        List<String> specialData = new ArrayList<String>();
        String[] data3point14;
        Font font;

        if (chartType == 406) {
            if (mode.equals("rpfll")) {
                graphics.setColor(Color.RED);
                graphics.fillRect(100, 90, getWidth() - 200, 420);
                data = new String[1];
                data[0] = "Bar Chart";
            } else {
                graphics.setColor(Color.BLACK);
                graphics.fillRect(95, 95, 210, 210);
                data = new String[2];
                data[0] = "Bar Chart";
                data[1] = "Small";
            }
            if (mode.equals("shareddisplay")) {
                font = new Font("Arial Black", Font.BOLD, 25);
                graphics.setColor(Color.CYAN);
                int bottomY = 300;
                graphics.fillRect(100, bottomY - 100, 40, 100);
                graphics.fillRect(140, bottomY - 200, 40, 200);
                graphics.fillRect(180, bottomY - 150, 40, 150);
                graphics.fillRect(220, bottomY - 125, 40, 125);
                graphics.fillRect(260, bottomY - 170, 40, 170);
                graphics.setColor(Color.RED);
                graphics.setFont(font);
                graphics.drawString(data[0], 130, 250);
                graphics.drawString(data[1], 130, 270);
            } else {
                int bottomY = 500;
                graphics.setColor(Color.CYAN);
                graphics.fillRect(112, bottomY - 200, 75, 200);
                graphics.fillRect(187, bottomY - 400, 75, 400);
                graphics.fillRect(262, bottomY - 300, 75, 300);
                graphics.fillRect(337, bottomY - 250, 75, 250);
                graphics.fillRect(412, bottomY - 340, 75, 340);
                font = new Font("Arial Black", Font.BOLD, 55);
                graphics.setColor(Color.BLACK);
                graphics.setFont(font);
                graphics.drawString(data[0], 130, 400);
            }
        } else {
            if (mode.equals("rpfll")) {
                graphics.setColor(Color.BLUE);
                graphics.fillOval(100, 100, 450, getHeight() - 150);
                specialData.add("Pie Chart");
                font = new Font("Bookman Old Style", Font.BOLD, 55);
                graphics.setColor(Color.WHITE);
                graphics.setFont(font);
                graphics.drawString(specialData.get(0), 200, 340);
            } else {
                graphics.setColor(Color.BLUE);
                double isq = 405;
                float padding = 90;
                int sc = (int) (isq - padding * 2);
                graphics.fillOval(100, 100, sc, sc);
                data3point14 = new String[2];
                data3point14[1] = "Small";
                data3point14[0] = "Pie" + " Chart";
                font = new Font("Bookman Old Style", Font.BOLD, 30);
                graphics.setFont(font);
                graphics.setColor(Color.WHITE);
                graphics.drawString(data3point14[0], 145, 205);
                graphics.drawString(data3point14[1], 170, 235);
            }
        }

        if (specialData.contains("Monthly") || getTitle().contains("daily")) {
            repaint(200);
        }
    }
}
