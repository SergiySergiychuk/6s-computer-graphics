package sample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.GeneralPath;

public class ShipAnimation extends JPanel implements ActionListener {
    Timer timer;
    // Для анімації повороту
    private double angle = 0;
    // Для анімації масштабування
    private double scale = 1;
    private double delta = 0.01;

    private static int maxWidth;
    private static int maxHeight;

    public static void main(String[] args) {
        JFrame frame = new JFrame("lab2");
        frame.add(new ShipAnimation());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        Dimension size = frame.getSize();
        Insets insets = frame.getInsets();
        maxWidth = size.width - insets.left - insets.right;
        maxHeight = size.height - insets.top - insets.bottom;
    }

    public ShipAnimation() {
        timer = new Timer(10, this);
        timer.start();
    }

    public void actionPerformed(ActionEvent e) {
        if (scale < 0.01) {
            delta = -delta;
        } else if (scale > 0.99) {
            delta = -delta;
        }
        scale += delta;
        angle += 0.01;
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHints(rh);
        g2d.setBackground(Color.yellow);
        g2d.clearRect(0, 0, maxWidth, maxHeight);
        //static frame
        g2d.translate(maxWidth / 2, maxHeight / 2);
        BasicStroke bs2 = new BasicStroke(16, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);
        g2d.setStroke(bs2);
        g2d.drawRect(-maxWidth / 2 + 20, -maxHeight / 2 + 20, maxWidth - 40, maxHeight - 40);
        //animated element
        //ship
        double c = 300;
        double shipPoints[][] = {
                {150 - c, 170 - c + 150}, {250 - c, 200 - c + 150}, {350 - c, 200 - c + 150}, {430 - c, 170 - c + 150},
                {370 - c, 250 - c + 150}, {230 - c, 250 - c + 150}
        };
        GeneralPath ship = new GeneralPath();
        ship.moveTo(shipPoints[0][0], shipPoints[0][1]);
        for (int k = 1; k < shipPoints.length; k++)
            ship.lineTo(shipPoints[k][0], shipPoints[k][1]);
        ship.closePath();
        //mast
        double mastPoints[][] = {
                {290 - c, 130 - c + 150}, {300 - c, 130 - c + 150},
                {300 - c, 200 - c + 150}, {290 - c, 200 - c + 150}
        };
        GeneralPath mast = new GeneralPath();
        mast.moveTo(mastPoints[0][0], mastPoints[0][1]);
        for (int k = 1; k < mastPoints.length; k++)
            mast.lineTo(mastPoints[k][0], mastPoints[k][1]);
        mast.closePath();
        //flag
        double flagPoints[][] = {
                {220 - c, 100 - c + 150}, {250 - c, 50 - c + 150}, {350 - c, 50 - c + 150}, {320 - c, 110 - c + 150},
                {350 - c, 150 - c + 150}, {240 - c, 140 - c + 150}
        };
        GeneralPath flag = new GeneralPath();
        flag.moveTo(flagPoints[0][0], flagPoints[0][1]);
        for (int k = 1; k < flagPoints.length; k++)
            flag.lineTo(flagPoints[k][0], flagPoints[k][1]);
        flag.closePath();
// Перетворення для анімації повороту.
        g2d.rotate(angle, mast.getBounds2D().getCenterX(),
                mast.getBounds2D().getCenterY());

        // Перетворення для анімації зміни прозорості
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
                (float) scale));

        GradientPaint gp = new GradientPaint(5, 5,
                new Color(153, 102, 51), 5, 10, new Color(102, 51, 0), true);
        g2d.setPaint(gp);
        g2d.fill(ship);
        g2d.setColor(new Color(51, 26, 0));
        g2d.fill(mast);
        g2d.setColor(Color.gray);
        g2d.fill(flag);

    }
}
