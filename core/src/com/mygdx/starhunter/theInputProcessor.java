/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.starhunter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

/**
 *
 * @author User
 */
public class theInputProcessor extends Main implements InputProcessor {
    @Override
   public boolean keyDown (int keycode) {
      if (Gdx.input.isKeyPressed(Input.Keys.A)) {

            player.setxPosition(player.getXPosition() - 100 * Gdx.graphics.getDeltaTime());

        } else if (Gdx.input.isKeyPressed(Input.Keys.D)) {

            player.setxPosition(player.getXPosition() + 100 * Gdx.graphics.getDeltaTime());

        }

        if (Gdx.input.isKeyPressed(Input.Keys.S)) {

            player.setyPosition(player.getYPosition() - 100 * Gdx.graphics.getDeltaTime());

        } else if (Gdx.input.isKeyPressed(Input.Keys.W)) {

            player.setyPosition(player.getYPosition() + 100 * Gdx.graphics.getDeltaTime());

        }
      return false;
   }

   @Override
   public boolean keyUp (int keycode) {
      return false;
   }

   @Override
   public boolean keyTyped (char character) {
      return false;
   }

   @Override
   public boolean touchDown (int x, int y, int pointer, int button) {
      return false;
   }

   @Override
   public boolean touchUp (int x, int y, int pointer, int button) {
      return false;
   }

   @Override
   public boolean touchDragged (int x, int y, int pointer) {
      return false;
   }

   @Override
   public boolean mouseMoved (int x, int y) {
      return false;
   }

   @Override
   public boolean scrolled (int amount) {
      return false;
   }
    
}
