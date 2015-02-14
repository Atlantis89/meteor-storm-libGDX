package de.floatec.meteorstorm;

import java.util.Random;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Meteor {
	//private Texture texture;
	//private Sprite sprite;
	//private float x, y;//position
	//private float directionX;
	//private GameScreen screen;
	//private float scale;

	public Meteor(GameScreen screen) extends GameObject{
        super(screen, "meteor.png");
		//this.screen = screen;
		//texture = new Texture(Gdx.files.internal("meteor.png"));
		//texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		Random randGenerator = new java.util.Random(System.currentTimeMillis());
		x = screen.getW();
		y = screen.getH() * (float) randGenerator.nextDouble();
		directionX = -1;
		scale = 0.4f + (0.6f * (float) randGenerator.nextDouble());

	}

	public void draw(SpriteBatch batch) {

		batch.draw(texture, x, y, texture.getWidth() * scale,
				texture.getHeight() * scale);
	}

	public void update(float dt) {
		float move = directionX * 80 * dt;
		x = (x + move);

	}

	public float getX() {
		return x;
	}
	public float getScale() {
		return scale;
	}
	public float getY() {
		return y;
	}

	public int getWidth() {
		return texture.getWidth();
	}

	
	public boolean isColliding(float x, float y, float w, float h) {
		return x <= this.x + this.texture.getWidth() * scale 
				&& x + w >= this.x
				&& y <= this.y + this.texture.getHeight() * scale
				&& y + h >= this.y;
	}

}
