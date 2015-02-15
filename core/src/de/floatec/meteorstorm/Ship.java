package de.floatec.meteorstorm;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Ship extends GameObject{
	//private Texture texture;
	private Sprite sprite;
	//private float x, y;//position
	//private int directionY;
	//private int directionX;
	//private GameScreen screen;
    //private Vector2 direction;

	public Ship(GameScreen screen) {
        super(screen, "spaceship.png", new Vector2(100f,100f));
		//this.screen = screen;
		//texture = new Texture(Gdx.files.internal("spaceship.png"));
		//texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		//x = 100;
		//y = 100;
		TextureRegion region = new TextureRegion(super.getTexture(), 0, 0,
				super.getTexture().getWidth(), super.getTexture().getHeight());
		sprite = new Sprite(region);
	}

	public void draw(SpriteBatch batch) {

        batch.draw(super.getTexture(),super.getPosition().x, super.getPosition().y,super.getTexture().getWidth(),super.getTexture().getHeight());

	}

	public void update(float dt) {
		float move = super.getDirection().y * 80 * dt;
		if (super.getPosition().y + move > 0 && super.getPosition().y + move < super.getScreen().getH() - super.getTexture().getHeight()) {
            super.getPosition().y = (super.getPosition().y + move);
		}
		move = super.getDirection().x * 80 * dt;
		if (super.getPosition().x + move > 0 && super.getPosition().x + move < super.getScreen().getW() - super.getTexture().getWidth()) {
			//x = (x + move);
            super.setPosition(new Vector2(super.getPosition().x + move, 0f));
		}
	}

	/*public void setDirectionY(int y) {
		this.directionY = y;
	}

	public void setDirectionX(int x) {
		this.directionX = x;
	}*/
/*
	public float getX() {
		return x;
	}*/

/*	public float getY() {
		return y;
	}*/
    /*
	public float getWidth() {
		return texture.getWidth();
	}

	public float getHeight() {
		return texture.getHeight();
	}*/

	
}
