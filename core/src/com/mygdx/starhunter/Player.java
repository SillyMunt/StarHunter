/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.starhunter;

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
   
   
public Player (int x, int y) {
   this.x = x;
   this.y = y;
   
   
   
   
    }

public void drawPlayer (){
    
    playerHitBox = new Pixmap(this.x,this.y,Pixmap.Format.RGBA8888);
    playerHitBox.setColor(Color.WHITE);
    playerHitBox.fill();
    playerTexture = new Texture(playerHitBox); 
    
    
}
   
   
   

    
}
