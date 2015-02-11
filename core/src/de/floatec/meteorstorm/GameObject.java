package de.floatec.meteorstorm;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class GameObject {
    private Vector2 position;
    private Vector2 direction;
    private Texture texture;
    private Sprite sprite;
    //private int directionY, directionX;
    private GameScreen screen;
    private float scale;

    public GameObject(Vector2 position, Vector2 direction, Texture texture, Sprite sprite, GameScreen screen, float scale){
        this.position = position;
        this.direction = direction;
        this.texture = texture;
        this.sprite = sprite;
        this.screen = screen;
        this.scale = scale;



    }
}
