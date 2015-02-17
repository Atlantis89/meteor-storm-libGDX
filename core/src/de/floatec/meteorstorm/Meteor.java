package de.floatec.meteorstorm;

import java.util.Random;
import com.badlogic.gdx.math.Vector2;

public class Meteor extends GameObject{

	public Meteor(GameScreen screen) {
        super(screen, "meteor.png", new Vector2(0f,0f));
		Random randGenerator = new java.util.Random(System.currentTimeMillis());
        position = (new Vector2(screen.getW(), screen.getH() * (float) randGenerator.nextDouble()));
        direction=(new Vector2(-0.1f,0f));
		scale=(0.4f + (0.6f * (float) randGenerator.nextDouble()));
	}
}
