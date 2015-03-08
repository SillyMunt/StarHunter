/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.starhunter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

/**
 *
 * @author Cliff
 */
public class Player {

    private Rectangle playerBody;
    private Sprite playerImage;
    private Pixmap playerHitBox;
    private Texture playerTexture;
    private int x;
    private int y;
    private float xPosition;
    private float yPosition;
    private float moveSpeed;
    private boolean isBoss;
    private boolean xDirection; // true is right, false is left
    private boolean yDirection; // true is up, fals is down

    public Player(int x, int y, int xPosition, int yPosition, boolean isBoss, float moveSpeed) {
        this.y = y;
        this.x = x;
        this.xPosition = (float) xPosition;
        this.yPosition = (float) yPosition;
        this.playerHitBox = new Pixmap(this.x, this.y, Pixmap.Format.RGBA8888);
        this.playerHitBox.setColor(Color.WHITE);
        this.playerHitBox.fill();
        this.moveSpeed = moveSpeed;
        if (isBoss){
        this.isBoss = isBoss;
        this.yDirection = true;
        this.xDirection = true;
        this.moveSpeed *= 10;
        }

    }

    public Texture getPlayerTexture() {
        this.playerTexture = new Texture(playerHitBox);
        return this.playerTexture;
    }

    public float getX() {
        return x;
    }

    public float getXPosition() {
        return xPosition;
    }

    public void setXPosition(float xPosition) {
        this.xPosition = xPosition;

        //If it goes past the screen limit, set it to edge.
        //Currently entering camera dimensions manually, probably better way to do it.
        if (this.xPosition > 800 - this.x) {
            this.xPosition = 800 - this.x;
            collision("x");
        }
        if (this.xPosition < 0) {
            this.xPosition = 0;
            collision("x");
        }

    }

    public float getYPosition() {
        return yPosition;
    }

    public void setYPosition(float yPosition) {
        this.yPosition = yPosition;

        //If it goes past the screen limit, set it to edge.
        //Currently entering camera dimensions manually, probably better way to do it.
        if (this.yPosition > 480 - this.y) {
            this.yPosition = 480 - this.y;
            collision("y");
        }
        if (this.yPosition < 0) {
            this.yPosition = 0;
            collision("y");
        }
    }

    public float getMoveSpeed() {
        //Works with the Player's moveSpeed parameter to let us set how fast we want Player Entities to move.
        return (this.moveSpeed * Gdx.graphics.getDeltaTime());
    }

    public boolean getIsBoss() {
        return this.isBoss;

    }

    public void collision(String axis) {
        if (axis.contentEquals("y")) {
            this.yDirection = !this.yDirection;
        }
        if (axis.contentEquals("x")) {
            this.xDirection = !this.xDirection;
        }
    }

    public boolean isxDirection() {
        return xDirection;
    }

    public void setxDirection(boolean xDirection) {
        this.xDirection = xDirection;
    }
    

    public boolean isyDirection() {
        return yDirection;
    }

    public void setyDirection(boolean yDirection) {
        this.yDirection = yDirection;
    }
    
    
    
    

    public void moveRight() {
        this.setXPosition(this.getXPosition() + this.getMoveSpeed());
    }

    public void moveLeft() {
        this.setXPosition(this.getXPosition() - this.getMoveSpeed());
    }

    public void moveUp() {
        this.setYPosition(this.getYPosition() + this.getMoveSpeed());
    }

    public void moveDown() {
        this.setYPosition(this.getYPosition() - this.getMoveSpeed());
    }

}
