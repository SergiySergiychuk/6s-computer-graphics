package sample;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import javax.swing.*;

@SuppressWarnings("serial")
public class Skeleton extends JPanel {

    private static int maxWidth;
    private static int maxHeight;

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHints(rh);
        g2d.setBackground(Color.yellow);
        g2d.clearRect(0, 0, maxWidth, maxHeight / 2);
        //ship
        GradientPaint gp = new GradientPaint(5, 5,
                new Color(153, 102, 51), 5, 10, new Color(102, 51, 0), true);
        g2d.setPaint(gp);
        double shipPoints[][] = {
                {150, 170}, {250, 200}, {350, 200}, {430, 170},
                {370, 250}, {230, 250}
        };
        GeneralPath ship = new GeneralPath();
        ship.moveTo(shipPoints[0][0], shipPoints[0][1]);
        for (int k = 1; k < shipPoints.length; k++)
            ship.lineTo(shipPoints[k][0], shipPoints[k][1]);
        ship.closePath();
        g2d.fill(ship);
        //mast
        g2d.setColor(new Color(51, 26, 0));
        double mastPoints[][] = {
                {290, 130}, {300, 130},
                {300, 200}, {290, 200}
        };
        GeneralPath mast = new GeneralPath();
        mast.moveTo(mastPoints[0][0], mastPoints[0][1]);
        for (int k = 1; k < mastPoints.length; k++)
            mast.lineTo(mastPoints[k][0], mastPoints[k][1]);
        mast.closePath();
        g2d.fill(mast);
        //flag
        g2d.setColor(Color.gray);
        double flagPoints[][] = {
                {220, 100}, {250, 50}, {350, 50}, {320, 110},
                {350, 150}, {240, 140}
        };
        GeneralPath flag = new GeneralPath();
        flag.moveTo(flagPoints[0][0], flagPoints[0][1]);
        for (int k = 1; k < flagPoints.length; k++)
            flag.lineTo(flagPoints[k][0], flagPoints[k][1]);
        flag.closePath();
        g2d.fill(flag);
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Привіт, Java 2D!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.add(new Skeleton());
        frame.setVisible(true);
        Dimension size = frame.getSize();
        Insets insets = frame.getInsets();
        maxWidth = size.width - insets.left - insets.right;
        maxHeight = size.height - insets.top - insets.bottom;
    }


}
