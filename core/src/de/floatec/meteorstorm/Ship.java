package de.floatec.meteorstorm;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Ship extends GameObject{
	//private Texture texture;
	//private Sprite sprite;
	//private float x, y;//position
	//private int directionY;
	//private int directionX;
	//private GameScreen screen;
    //private Vector2 direction;

	public Ship(GameScreen screen) {
        super(screen, "spaceship.png");
		//this.screen = screen;
		//texture = new Texture(Gdx.files.internal("spaceship.png"));
		//texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		//x = 100;
		//y = 100;
		TextureRegion region = new TextureRegion(texture, 0, 0,
				texture.getWidth(), texture.getHeight());
		sprite = new Sprite(region);
	}

	public void draw(SpriteBatch batch) {

        batch.draw(texture,x, y,texture.getWidth(),texture.getHeight());

	}

	public void update(float dt) {
		float move = directionY * 80 * dt;
		if (y + move > 0 && y + move < screen.getH() - texture.getHeight()) {
			y = (y + move);
		}
		move = directionX * 80 * dt;
		if (x + move > 0 && x + move < screen.getW() - texture.getWidth()) {
			x = (x + move);
		}
	}

	public void setDirectionY(int y) {
		this.directionY = y;
	}

	public void setDirectionX(int x) {
		this.directionX = x;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}
	public float getWidth() {
		return texture.getWidth();
	}

	public float getHeight() {
		return texture.getHeight();
	}

	
}
