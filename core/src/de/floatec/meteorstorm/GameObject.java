package de.floatec.meteorstorm;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.graphics.Texture.TextureFilter;

public class GameObject {
    private Vector2 position;
    private Vector2 direction = new Vector2(0f,0f);
    private Texture texture;
    //private Sprite sprite;
    //private int directionY, directionX;
    private GameScreen screen;
    private float scale;

    /*
    public GameObject(Vector2 position, Vector2 direction, Texture texture, Sprite sprite, GameScreen screen, float scale){
        this.position = position;
        this.direction = direction;
        this.texture = texture;
        this.sprite = sprite;
        this.screen = screen;
        this.scale = scale;
    }
    */
    public GameObject(GameScreen screen, String textur, Vector2 position){
        this.screen = screen;
        this.texture = new Texture(Gdx.files.internal(textur));
        this.texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
        this.position = position;
    }
    /* getter/setter */
    public void setTexture(Texture textur){
        this.texture = textur;
    }

    public Texture getTexture(){
        return this.texture;
    }
    public void setPosition(Vector2 position){
        this.position = position;
    }
    public Vector2 getPosition(){
        return this.position;
    }
    public void setDirection(Vector2 direction){
        this.direction = direction;
    }
    public void setDirectionX(float x){
        this.direction.x = x;
    }
    public void setDirectionY(float y){
        this.direction.x = y;
    }
    public Vector2 getDirection(){
        return this.direction;
    }
    public void setScale(float scale){
        this.scale = scale;
    }
    public float getScale(){
        return this.scale;
    }
    public void setScreen(GameScreen screen){
        this.screen = screen;
    }
    public GameScreen getScreen(){
        return this.screen;
    }

    public float getX() {
        return this.direction.x;
    }
    public float getY() {
        return this.direction.y;
    }

    public float getWidth() {
        return this.texture.getWidth();
    }

    public float getHeight() {
        return this.texture.getHeight();
    }
}