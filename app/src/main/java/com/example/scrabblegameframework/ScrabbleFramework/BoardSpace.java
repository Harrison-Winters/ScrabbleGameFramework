/*
 * @author Cory Marleau, Harrison Winters, Kamalii Silva, Jason Katayama
 *
 * */
package com.example.scrabblegameframework.ScrabbleFramework;

import android.graphics.Canvas;
import android.graphics.Paint;

public class BoardSpace {
    //define variables
    private float cx, cy;
    private float height, width;
    private Tile tile;
    private int multiplier;
    private int border;
    private Paint tileColor;
    private Paint letterColor;

    public boolean isEmpty;
    public Tile initValue;
    /**
     * BoardSpace - constructor for the BoardSpace object
     * @param x left edge location for space
     * @param y top edge location for space
     * @param h height of space
     * @param w width of space
     * @param mult multiplier value of space
     */
    public BoardSpace(float x, float y, float h, float w, int mult){
        cx = x;
        cy = y;
        height = h;
        width = w;
        tile = null;
        multiplier = mult;
        border = 1;
        initValue = null;

        //set up the paint color
        tileColor= new Paint();
        tileColor.setARGB(255,105,7,0);
        letterColor = new Paint();
        letterColor.setARGB(255,130,130,130);
        letterColor.setTextSize(20);
    }

    /**
     * BoardSpace - copy constructor
     * @param other BoardSpace object to be copied
     */
    public BoardSpace (BoardSpace other){
        cx = other.cx;
        cy = other.cy;
        height = other.height;
        width = other.width;
        if(other.tile == null){
            tile = null;
        }
        else {
            tile = new Tile(other.tile);
        }
        multiplier = other.multiplier;
        border = other.border;

        tileColor = new Paint(other.tileColor);
        letterColor = new Paint(other.letterColor);
    }

    /**
     * draw - draws each space onto the board
     * @param canvas canvas to draw
     */
    public void draw(Canvas canvas){
        canvas.drawRect((cx - width/2), (cy - height/2), (cx + width/2), (cy + height/2), letterColor);
        canvas.drawRect((cx - width/2) + border, (cy - height/2) + border, (cx + width/2) - border, (cy + height/2) - border, tileColor);
        if(tile != null) {
            canvas.drawText("" + tile.getLetter(), (cx - width / 2) + border, (cy + height / 2) - border, letterColor);
        }
    }
    /**
     * Manually sets the position of the Tile
     * */
    public void setPos(float x, float y){
        cx = x;
        cy = y;
    }
    /**
     * Sets the height of the tile
     * */
    public void setHeight(float h){
        height = h;
    };
    /**
     * Sets the width of the tile
     * */
    public void setWidth(float w){
        width = w;
    };
    /**
     * getTile - gets the tile in the space
     * @return tile
     */
    public Tile getTile(){
        return tile;
    }
    /**
     * setTile - sets the tile of the space
     * @param tile to set to
     */
    public void setTile(Tile tile) {
        this.tile = tile;
    }
    public void select(){
        if (!isEmpty) {
            tileColor.setARGB(255, 214, 168, 51);
        }
    }
    /**
     * equals - overwrites equals method
     * @param object
     * @return
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof BoardSpace)) {
            return false;
        }
        BoardSpace space = (BoardSpace) object;
        if(!(space.tile.equals(tile))){
            return false;
        }
        if(space.multiplier != multiplier){
            return false;
        }
        return true;
    }
}