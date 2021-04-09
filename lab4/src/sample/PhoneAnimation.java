package sample;

import com.sun.j3d.utils.geometry.Cone;
import com.sun.j3d.utils.geometry.Sphere;
import com.sun.j3d.utils.image.TextureLoader;
import com.sun.j3d.utils.universe.SimpleUniverse;

import javax.media.j3d.*;
import javax.swing.*;
import javax.vecmath.Color3f;
import javax.vecmath.Point3d;
import javax.vecmath.Vector3f;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PhoneAnimation extends Applet implements ActionListener {

    private TransformGroup transformGroup = new TransformGroup();
    private Transform3D transform3D = new Transform3D();
    private double dAlpha = 0.01D;
    private double alpha = 0.0D;
    private final Timer timer = new Timer(10, this);

    public static void main(String[] args) {
        new PhoneAnimation();
    }

    public PhoneAnimation() {
        SimpleUniverse simpleUniverse = new SimpleUniverse();
        BranchGroup branchGroup = new BranchGroup();
        simpleUniverse.getViewingPlatform().setNominalViewingTransform();
        this.transformGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        this.transformGroup.addChild(Phone.getPhone());
        branchGroup.addChild(getLight());
        branchGroup.addChild(getBackground_());
        branchGroup.addChild(this.transformGroup);
        simpleUniverse.addBranchGraph(branchGroup);
        this.timer.start();
    }

    public Node getLight() {
        Color3f light1Color = new Color3f(0.0f, 0.0f, 0.0f);
        BoundingSphere boundingSphere = new BoundingSphere(new Point3d(0, 0, 0), 100);
        Vector3f light1Direction = new Vector3f(4.0f, -7.0f, -12.0f);
        DirectionalLight light1 = new DirectionalLight(light1Color, light1Direction);
        light1.setInfluencingBounds(boundingSphere);
        return light1;
    }

    public Node getBackground_() {
        ImageComponent2D texture = (new TextureLoader("source_folder/bird.png", new Container())).getImage();
        Background background = new Background(texture);
        background.setImageScaleMode(Background.SCALE_REPEAT);
        BoundingSphere sphere = new BoundingSphere(new Point3d(0.0D, 0.0D, 0.0D), 100000.0D);
        background.setApplicationBounds(sphere);
        return background;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (((int) (alpha / 6.28) % 2) == 0) {
            this.transform3D.rotX(alpha);
        } else {
            this.transform3D.rotY(alpha);
        }
        this.transformGroup.setTransform(this.transform3D);
        this.alpha += this.dAlpha;
    }
}
