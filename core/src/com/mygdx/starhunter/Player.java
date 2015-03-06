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
   private int xPosition;
   private int yPosition;
   private int moveSpeed;
   
   
public Player (int x, int y, int xPosition, int yPosition, boolean isBoss) { 
   this.y = y;
   this.x = x;
   this.xPosition = xPosition;
   this.yPosition = yPosition;
   this.playerHitBox = new Pixmap(this.x,this.y,Pixmap.Format.RGBA8888);
   this.playerHitBox.setColor(Color.WHITE);
   this.playerHitBox.fill();
   this.moveSpeed = 10;
   
}

public Texture getPlayerTexture(){  
  this.playerTexture = new Texture(playerHitBox);
  
  return this.playerTexture;
}
   
public int getXPosition(){   
   if(Gdx.input.isKeyPressed(Input.Keys.A)){
       this.xPosition -= moveSpeed;
   }else if(Gdx.input.isKeyPressed(Input.Keys.D)){
       this.xPosition += moveSpeed;
   }
   
   return xPosition;
}

public int getYPosition(){
   if(Gdx.input.isKeyPressed(Input.Keys.W)){
       this.yPosition += moveSpeed;
   }else if(Gdx.input.isKeyPressed(Input.Keys.S)){
       this.yPosition -= moveSpeed;
   }
   
   return yPosition;
}



}
