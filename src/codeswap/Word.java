/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codeswap;

import java.awt.Color;

/**
 *
 * @author dbm3
 */
public class Word {
    private String value;
    private boolean flagged = false;
    private enum flaggedFor {deletion, swap;}
    private Color formattedColor;
    public Word(String value){
        this.value = value;
    }
    
    //add get/sets
    
    public void setValue(String value){
        this.value = value;
    }
    
    public String getValue(){
        return value;
    }
    
    public void setFlagged(boolean flagged){
        this.flagged = flagged;
    }
    
    public boolean getFlagged(){
        return flagged;
    }
}
