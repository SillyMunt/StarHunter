package com.mygdx.starhunter;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.starhunter.theInputProcessor;
import com.mygdx.starhunter.theInputAdapter;

public class Main extends ApplicationAdapter {

    SpriteBatch batch;
    Texture img;
    Player player;
    float xPosition;
    OrthographicCamera camera;
    
    
    @Override
    public void create() {
        camera = new OrthographicCamera(); 
        //Yes, we need the camera. It adds functionality.
        //No, I can't tell you what that functionality is.
        //http://youtu.be/FfM_wS7qYfY?t=2m23s
        camera.setToOrtho(false, 800, 480);
        batch = new SpriteBatch();
        //img = new Texture("badlogic.jpg");
        player = new Player(32, 64, 100, 100, false);
        Gdx.input.setInputProcessor(new theInputProcessor());
        
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        
        
        
              
        ////////////////////////////////////////////////////////////////////////////////////
        /////////////////////// WORKING MOVEMENT CODE!//////////////////////////////////////
        /// Really need to put this somewhere else, but i'm not quite sure how yet without breaking it.
        /// 100 movement speed seems SLOOOOOOOOOOOOOW
        /// arrow key input needed
        /*if (Gdx.input.isKeyPressed(Input.Keys.A)) {

            player.setxPosition(player.getXPosition() - 100 * Gdx.graphics.getDeltaTime());

        } else if (Gdx.input.isKeyPressed(Input.Keys.D)) {

            player.setxPosition(player.getXPosition() + 100 * Gdx.graphics.getDeltaTime());

        }

        if (Gdx.input.isKeyPressed(Input.Keys.S)) {

            player.setyPosition(player.getYPosition() - 100 * Gdx.graphics.getDeltaTime());

        } else if (Gdx.input.isKeyPressed(Input.Keys.W)) {

            player.setyPosition(player.getYPosition() + 100 * Gdx.graphics.getDeltaTime());

        }*/
        ////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////

        camera.update();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(player.getPlayerTexture(), player.getXPosition(), player.getYPosition());
        //batch.draw(img, 0, 0);
        batch.end();
        
    }
}
