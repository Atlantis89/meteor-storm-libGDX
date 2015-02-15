package de.floatec.meteorstorm;

import java.util.Random;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Meteor extends GameObject{
	//private Texture texture;
	//private Sprite sprite;
	//private float x, y;//position
	//private float directionX;
	//private GameScreen screen;
	//private float scale;

	public Meteor(GameScreen screen) {
        super(screen, "meteor.png", new Vector2(0f,0f));
		//this.screen = screen;
		//texture = new Texture(Gdx.files.internal("meteor.png"));
		//texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		Random randGenerator = new java.util.Random(System.currentTimeMillis());
        super.setPosition(new Vector2(screen.getW(), screen.getH() * (float) randGenerator.nextDouble()));
		//x = screen.getW();
		//y = screen.getH() * (float) randGenerator.nextDouble();
		//directionX = -1;
        super.setDirection(new Vector2(-0.1f,0f));
		super.setScale(0.4f + (0.6f * (float) randGenerator.nextDouble()));
	}

	/*public void draw(SpriteBatch batch) {

		batch.draw(super.getTexture(), super.getPosition().x, super.getPosition().y, super.getTexture().getWidth() * super.getScale(),
				super.getTexture().getHeight() * super.getScale());
	}*/


/*
	public float getX() {
		return x;
	}
	*/
/*	public float getScale() {
		return scale;
	}*/
    /*
	public float getY() {
		return y;
	}
*/
	/*public int getWidth() {
		return texture.getWidth();
	}*/

	
	public boolean isColliding(float x, float y, float w, float h) {
		return x <= position.x +texture.getWidth() * scale
				&& x + w >= position.x
				&& y <= position.y + texture.getHeight() * scale
				&& y + h >= position.y;
	}

}
