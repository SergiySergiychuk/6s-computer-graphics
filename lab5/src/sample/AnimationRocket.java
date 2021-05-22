package sample;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.media.j3d.*;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.vecmath.*;

public class AnimationRocket implements ActionListener, KeyListener {
    private TransformGroup wholerocket;
    private Transform3D translateTransform;
    private Transform3D rotateTransformX;
    private Transform3D rotateTransformZ;

    private JFrame mainFrame;

    private float zoom = 0.2f;
    private float xloc = -1.5499996f;
    private float yloc = -1.6999996f;
    private float zloc = 0.0f;
    private Timer timer;

    private double angle = 0, step = 0;

    public AnimationRocket(TransformGroup wholerocket, Transform3D trans, JFrame frame) {
        this.wholerocket = wholerocket;
        this.translateTransform = trans;
        this.mainFrame = frame;

        rotateTransformX = new Transform3D();
        rotateTransformZ = new Transform3D();
        rotateTransformX.rotX(3 * Math.PI / 2);
        translateTransform.mul(rotateTransformX);


        Main.canvas.addKeyListener(this);
        timer = new Timer(100, this);

        Panel p = new Panel();
        mainFrame.add("North", p);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        step += 0.01;
        xloc += ImproveNoise.noise(angle, 0, 0) / 10;
        yloc += ImproveNoise.noise(0, angle, 0) / 10;
        zloc += ImproveNoise.noise(0, angle, 0) / 10;
        Transform3D main = new Transform3D();
        main.setTranslation(new Vector3f(xloc, yloc, zloc));

        angle += 0.02;
        Transform3D rotX = new Transform3D();
        rotX.rotX(angle);
        Transform3D rotY = new Transform3D();
        rotY.rotY(angle);
        Transform3D rotZ = new Transform3D();
        rotZ.rotZ(angle);

        main.mul(rotX);
        main.mul(rotY);
        main.mul(rotZ);
        wholerocket.setTransform(main);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //Invoked when a key has been typed.
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Invoked when a key has been released.
    }

}
