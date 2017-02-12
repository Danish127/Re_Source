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
    private char cValue;
    private String sValue;
    private enum type {character, string};
    private type ofValue;
    private boolean flagged = false;
    private enum flaggedFor {deletion, swap};
    private flaggedFor flag;
    private Color formattedColor;
    
    public Word(String sValue){
        this.sValue = sValue;
        //type.string;
        ofValue = type.string;
    }
    
    public Word(char cValue){
        this.cValue = cValue;
        ofValue = type.character;
    }
    
    //add get/sets
    
    public void setValue(String value){
        this.sValue = value;
    }
    
    public String getValue(){
        if(ofValue == type.string){
            return sValue;
        }else{
            return cValue + "";
        }
    }
    
    /*public char getValue(){
        return cValue;
    }*/
    
    public void setFlagged(boolean flagged){
        this.flagged = flagged;
    }
    
    public boolean getFlagged(){
        return flagged;
    }
}
