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

/**
 *
 * @author dbm3
 */
public class analyzeParser {
    private File file;
    BufferedReader br;
    public analyzeParser(File file){
        this.file = file;
    }
    
    public void analyze(){
        try {
            Scanner docParser = new Scanner(file);
            Scanner lineParser = new Scanner("");
            lineParser.useDelimiter(" \n\r.()[]{}");
            while(docParser.hasNext()){
                lineParser = new Scanner(docParser.nextLine());
                while(lineParser.hasNext()){
                    if(shouldNextBeFlagged(lineParser.next())){
                        
                    }
                }
            }
            
            
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(analyzeParser.class.getName()).log(Level.SEVERE, null, ex);
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
}
