package com.mygdx.starhunter;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Main extends ApplicationAdapter {

    SpriteBatch batch;
    Texture img;
    Player player;
    Player boss;
    float xPosition;
    OrthographicCamera camera;
    private boolean bossMoveRight;

    @Override
    public void create() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        batch = new SpriteBatch();
        player = new Player(32, 64, 100, 100, false, 250);
        boss = new Player(64, 64, 0, 300, true, 50);
        bossMoveRight = true;
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
        if (Gdx.input.isKeyPressed(Input.Keys.A)||Gdx.input.isKeyPressed(Input.Keys.LEFT)) {

            player.moveLeft();

        } else if (Gdx.input.isKeyPressed(Input.Keys.D)||Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {

            player.moveRight();

        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)||Gdx.input.isKeyPressed(Input.Keys.DOWN)) {

            player.moveDown();

        } else if (Gdx.input.isKeyPressed(Input.Keys.W)||Gdx.input.isKeyPressed(Input.Keys.UP)) {

            player.moveUp();

        }

        ////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////BOSS MOVEMENT LOOP////////////////////////////////////
        
        if (boss.getIsBoss()) {
            if (boss.isxDirection()){
            boss.moveRight();}
            if (!boss.isxDirection()){
                boss.moveLeft();
            }
            if (boss.isyDirection()){
            boss.moveUp();}
            if (!boss.isyDirection()){
                boss.moveDown();
            }

        }

        ////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(player.getPlayerTexture(), player.getXPosition(), player.getYPosition());
        batch.draw(boss.getPlayerTexture(), boss.getXPosition(), boss.getYPosition());
        batch.end();
    }
}
