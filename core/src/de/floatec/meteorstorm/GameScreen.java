package de.floatec.meteorstorm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class GameScreen implements Screen {
    private Game parent;
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Texture texture;
	private Sprite sprite;
	private BitmapFont font;
	private Ship ship;
	private float w;
	private float h;
	private List<Meteor> meteors = new ArrayList<Meteor>();
	private List<MeteorAnimation> anim = new ArrayList<MeteorAnimation>();
	private Random randGenerator = new java.util.Random(System.currentTimeMillis());
	private Sound music;
	private Sound crash;
	
	public float getH() {
		return h;
	}

	public float getW() {
		return w;
	}

	public GameScreen(Game parent) {
        this.parent=parent;
		font = new BitmapFont();
		w = Gdx.graphics.getWidth();
		h = Gdx.graphics.getHeight();

		camera = new OrthographicCamera(1, 1);
		batch = new SpriteBatch();
		ship = new Ship(this);
		
		music = Gdx.audio.newSound(Gdx.files.internal("music.mp3"));
		crash = Gdx.audio.newSound(Gdx.files.internal("crash.ogg"));
		music.loop();
	}

	@Override
	public void render(float dt) {
		update(dt);
		draw();
	}

	private void update(float dt) {

		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			ship.setDirectionX(1);
		} else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			ship.setDirectionX(-1);
		} else {
			ship.setDirectionX(0);
		}

        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            ship.setDirectionY(1);
        } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            ship.setDirectionY(-1);
        } else {
            ship.setDirectionY(0);
        }
/*
        if(escape){
            parent.switchToMaenu();
        }
*/
        int rnd = (int)(randGenerator.nextDouble()*100);
        if(rnd<3){
			meteors.add(new Meteor(this));
		}
        System.out.println(meteors.size());
		for (Meteor meteor : meteors) {
			meteor.update(dt);
		}
		for (int i = meteors.size()-1; i >= 0; i--) {
			if(meteors.get(i).position.x<0){
				meteors.remove(i);
			}
		}
		ship.update(dt);
		for (int i = meteors.size()-1; i >= 0; i--) {
			if(meteors.get(i).isColliding(ship.position.x, ship.position.y, ship.getWidth(), ship.getHeight())){
				anim.add(new MeteorAnimation(meteors.get(i).position.x, meteors.get(i).position.y, meteors.get(i).getScale()));
				meteors.remove(i);
				crash.play();
				
			}
		}
		for (MeteorAnimation meteorAnimation : anim) {
			meteorAnimation.update(dt);
		}
		for (int i = anim.size()-1; i >= 0; i--) {
			if(!anim.get(i).isRunnung()){
				anim.remove(i);
				
			}
		}

	}

	private void draw() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		ship.draw(batch);
		for (Meteor meteor : meteors) {
			meteor.draw(batch);
		}
		for (MeteorAnimation meteorAnimation : anim) {
			meteorAnimation.draw(batch);
		}
		
		font.draw(batch, "Meteorstorm", 10, 20);
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		batch.dispose();
		texture.dispose();
        this.dispose();

	}

}
