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
