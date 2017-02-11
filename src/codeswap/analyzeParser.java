/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codeswap;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;

/**
 *
 * @author dbm3
 */
public class analyzeParser {
    //private File file;
    private JFormattedTextField window;
    private char derp;// list
    BufferedReader br;
    public analyzeParser(JFormattedTextField window, char derp){
        this.window = window;
        this.derp = derp;
        //this.file = file;
        
    }
    
    public void analyze(){
        Scanner docParser = new Scanner(window.getText());
        Scanner lineParser = new Scanner("");
        lineParser.useDelimiter(" \n\r.()[]{}");
        while(docParser.hasNext()){
            lineParser = new Scanner(docParser.nextLine());
            while(lineParser.hasNext()){
                if(shouldNextBeFlagged(lineParser.next())){
                    
                }
            }
        }
        
    }
    
    private boolean shouldNextBeFlagged(String word){
        switch(word){
            case "int":
            case "String":
            case "char":
                return true;
            default:
                return false;
        }
    }

    public JFormattedTextField getFormattedOutput() {
        return window;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
