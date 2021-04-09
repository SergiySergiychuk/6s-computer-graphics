package sample;

import com.sun.j3d.utils.geometry.*;
import com.sun.j3d.utils.image.TextureLoader;
import org.w3c.dom.Text;

import javax.media.j3d.*;
import javax.vecmath.Color3f;
import javax.vecmath.Color4f;
import javax.vecmath.Vector3f;
import java.awt.*;

public class Phone {
    public static int primFlags = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;
    private static double pi = 3.14;

    public static TransformGroup getPhone() {
        TransformGroup phone = new TransformGroup();
        phone.addChild(getCorps());
        phone.addChild(getScreen());
        phone.addChild(getMainButton());
        phone.addChild(getVolumeButton());
        phone.addChild(getChargingHole());
        return phone;
    }

    private static TransformGroup getCorps() {
        TransformGroup transformGroup = new TransformGroup();
        Transform3D transform3D = new Transform3D();
        Box corps = new Box(0.2f, 0.4f, 0.05f, primFlags, getCorpsAppearance());
        transformGroup.setTransform(transform3D);
        transformGroup.addChild(corps);
        return transformGroup;
    }

    private static TransformGroup getScreen() {
        TransformGroup transformGroup = new TransformGroup();
        Transform3D transform3D = new Transform3D();
        Box corps = new Box(0.18f, 0.36f, 0.05f, primFlags, getScreenAppearance());
        Vector3f vectorTop = new Vector3f(0.0f, 0.0f, 0.001f);
        transform3D.setTranslation(vectorTop);
        transformGroup.setTransform(transform3D);
        transformGroup.addChild(corps);
        return transformGroup;
    }

    private static TransformGroup getMainButton() {
        TransformGroup transformGroup = new TransformGroup();
        Transform3D transform3D = new Transform3D();
        Cylinder button = new Cylinder(0.05f, 0.1f, getMainButtonAppearance());
        Vector3f vectorTop = new Vector3f(0.0f, -0.19f, 0.011f);
        transform3D.rotX(pi / 2);
        transform3D.setTranslation(vectorTop);
        transformGroup.setTransform(transform3D);
        transformGroup.addChild(button);
        return transformGroup;
    }

    private static TransformGroup getVolumeButton() {
        TransformGroup transformGroup = new TransformGroup();
        Transform3D transform3D = new Transform3D();
        Box button = new Box(0.2f, 0.05f, 0.01f, primFlags, getVolumeButtonAppearance());
        Vector3f vectorTop = new Vector3f(0.01f, 0.25f, 0.0f);
        transform3D.setTranslation(vectorTop);
        transformGroup.setTransform(transform3D);
        transformGroup.addChild(button);
        return transformGroup;
    }

    private static TransformGroup getChargingHole() {
        TransformGroup transformGroup = new TransformGroup();
        Transform3D transform3D = new Transform3D();
        Box button = new Box(0.03f, 0.4f, 0.01f, primFlags, getChargingHoleAppearance());
        Vector3f vectorTop = new Vector3f(0.0f, -0.001f, 0.0f);
        transform3D.setTranslation(vectorTop);
        transformGroup.setTransform(transform3D);
        transformGroup.addChild(button);
        return transformGroup;
    }

    private static Appearance getCorpsAppearance() {
        Appearance appearance = new Appearance();
        TextureLoader loader = new TextureLoader("source_folder/texture2.jpg", new Container());
        Texture texture = loader.getTexture();
        texture.setBoundaryModeS(Texture.WRAP);
        texture.setBoundaryModeT(Texture.WRAP);
        texture.setBoundaryColor(new Color4f(0.0F, 1.0F, 1.0F, 0.0F));
        TextureAttributes texAttr = new TextureAttributes();
        texAttr.setTextureMode(2);
        appearance.setTexture(texture);
        appearance.setTextureAttributes(texAttr);
        return appearance;
    }

    private static Appearance getScreenAppearance() {
        Appearance appearance = new Appearance();
        Color3f emissive = new Color3f(Color.BLACK);
        Color3f ambient = new Color3f(Color.BLACK);
        Color3f diffuse = new Color3f(Color.BLACK);
        Color3f specular = new Color3f(Color.BLACK);
        appearance.setMaterial(new Material(ambient, emissive, diffuse, specular, 1.0f));
        return appearance;
    }

    private static Appearance getMainButtonAppearance() {
        Appearance appearance = new Appearance();
        TextureLoader loader = new TextureLoader("source_folder/texture2.jpg", new Container());
        Texture texture = loader.getTexture();
        texture.setBoundaryModeS(Texture.WRAP);
        texture.setBoundaryModeT(Texture.WRAP);
        texture.setBoundaryColor(new Color4f(0.0F, 1.0F, 1.0F, 0.0F));
        TextureAttributes texAttr = new TextureAttributes();
        texAttr.setTextureMode(TextureAttributes.MODULATE);
        appearance.setTexture(texture);
        appearance.setTextureAttributes(texAttr);
        return appearance;
    }

    private static Appearance getVolumeButtonAppearance() {
        Appearance appearance = new Appearance();
        TextureLoader loader = new TextureLoader("source_folder/texture.jpg", new Container());
        Texture texture = loader.getTexture();
        texture.setBoundaryModeS(Texture.WRAP);
        texture.setBoundaryModeT(Texture.WRAP);
        texture.setBoundaryColor(new Color4f(0.0F, 1.0F, 1.0F, 0.0F));
        TextureAttributes texAttr = new TextureAttributes();
        texAttr.setTextureMode(TextureAttributes.MODULATE);
        appearance.setTexture(texture);
        appearance.setTextureAttributes(texAttr);
        return appearance;
    }

    private static Appearance getChargingHoleAppearance() {
        Appearance appearance = new Appearance();
        Color3f emissive = new Color3f(Color.BLACK);
        Color3f ambient = new Color3f(Color.BLACK);
        Color3f diffuse = new Color3f(Color.BLACK);
        Color3f specular = new Color3f(Color.BLACK);
        appearance.setMaterial(new Material(ambient, emissive, diffuse, specular, 1.0f));

        return appearance;
    }

}
