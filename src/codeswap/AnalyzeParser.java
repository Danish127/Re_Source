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
import javax.swing.JList;
import java.util.ArrayList;

/**
 *
 * @author dbm3
 */
public class AnalyzeParser {
    //private File file;
    private JFormattedTextField window;
    private JList<String> flaggedList;// list
    private BufferedReader br;
    private ArrayList<Word> row;
    private ArrayList<ArrayList> parsed;
    
    public AnalyzeParser(JFormattedTextField window, JList<String> flaggedList){
        this.window = window;
        //this.derp = derp;
        //this.file = file;
        this.flaggedList = flaggedList;
    }
    
    public void analyze(){
        Scanner docParser = new Scanner(window.getText());
        Scanner lineParser = new Scanner("");
        lineParser.useDelimiter("[ \t\n\r.(){}]");
        while(docParser.hasNext()){
            lineParser = new Scanner(docParser.nextLine());
            while(lineParser.hasNext()){
                row.add(new Word(lineParser.next()));
                if(shouldNextBeFlagged(lineParser.next())){
                    System.out.println("Found something");
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

    public JFormattedTextField getFormattedOutputWindow() {
        return window;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public JList<String> getVariableList(){
        return flaggedList;
    }
    
    
}
