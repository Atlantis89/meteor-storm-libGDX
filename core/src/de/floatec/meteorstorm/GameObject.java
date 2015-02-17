package de.floatec.meteorstorm;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.graphics.Texture.TextureFilter;

public class GameObject {
    protected Vector2 position;
    protected Texture texture;
    protected GameScreen screen;
    protected float scale=1;
    protected Sprite sprite;


    public GameObject(GameScreen screen, String textur, Vector2 position){
        this.screen = screen;
        this.texture = new Texture(Gdx.files.internal(textur));
        this.texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
        this.position = position;

        TextureRegion region = new TextureRegion(texture, 0, 0,
                texture.getWidth(), texture.getHeight());
        sprite = new Sprite(region);
    }

    public float getWidth() {
        return this.texture.getWidth();
    }

    public float getHeight() {
        return this.texture.getHeight();
    }

    public void draw(SpriteBatch batch) {

        batch.draw(texture,position.x, position.y,texture.getWidth()*scale,texture.getHeight()*scale);

    }
    public void update(float dt) {

    }

}
