/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codeswap;

import java.io.BufferedReader;
import java.util.Scanner;
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
    private ArrayList<Word> row = new ArrayList<Word>();
    private ArrayList<ArrayList<Word> > parsed = new ArrayList<ArrayList<Word> >();

    public AnalyzeParser(JFormattedTextField window, JList<String> flaggedList) {
        this.window = window;
        this.flaggedList = flaggedList;
    }

    public void analyze() {
        Scanner docParser = new Scanner(window.getText());
        Scanner lineParser = new Scanner("");
        //lineParser.useDelimiter("<([{\\^\\-=$!|]})?\\*+.>\t\r\n ");
        //lineParser.use
        String tmpStr;
        ArrayList<Word> tmpList = new ArrayList<Word>();
        while (docParser.hasNext()) {
            //lineParser = new Scanner(docParser.nextLine());
            tmpList = lineToWord(docParser.nextLine());
            for (int i = 0; i < tmpList.size(); i++) {
                System.out.println("Now evaluating: " + tmpList.get(i).getValue());
                if (tmpList.get(i).getFlagged()) {

                }
                if (shouldNextBeFlagged(tmpList.get(i).getValue())) {
                    tmpList.get(i+2).setFlagged(true);
                    //flaggedList.
                    //flaggedList.add(tmpList.get(i).getValue()));
                    System.out.println("Found something");
                }
            }
            parsed.add(tmpList);
            
            window.setText("");
            for(int i = 0; i < parsed.size(); i++){
                for(int j  = 0; j < parsed.get(i).size(); j++){
                    if(parsed.get(i).size() - j > 1){
                        if(parsed.get(i).get(j + 1).getValue().length() == 1){
                            window.setText(window.getText() + parsed.get(i).get(j).getValue());
                        }else{
                            window.setText(window.getText() + parsed.get(i).get(j).getValue());
                        }
                    }
                    //window.
                    
                }
                window.setText(window.getText() + "\r\n");
            }
            /*while(lineParser.hasNext()){
                tmp = lineParser.next();
                //row.add(new Word(tmp));
                if(shouldNextBeFlagged(tmp)){
                    System.out.println("Found something");
                }else{
                    System.out.println(tmp);
                }
            }*/
        }

    }

    private boolean shouldNextBeFlagged(String word) {
        switch (word) {
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

    public JList<String> getVariableList() {
        return flaggedList;
    }

    private ArrayList<Word> lineToWord(String line) {
        ArrayList<Word> tmpList = new ArrayList<Word>();
        String tmpStr = "";
        char tmpChar;
        for (int i = 0; i < line.length(); i++) {
            tmpChar = line.charAt(i);
            if (tmpChar == ' ' || tmpChar == '\t' || tmpChar == '\n' || tmpChar == '\r' || tmpChar == '.' || tmpChar == '+' || tmpChar == '-' || tmpChar == '*' || tmpChar == '/' || tmpChar == '=' || tmpChar == '|' || tmpChar == '(' || tmpChar == ')' || tmpChar == '[' || tmpChar == ']' || tmpChar == '{' || tmpChar == '}' || tmpChar == ';') {
                tmpList.add(new Word(tmpStr));
                System.out.println("String added:" + tmpStr);
                tmpStr = "";
                tmpList.add(new Word(tmpChar));
                System.out.println("Char added:" + tmpChar);
            } else {
                tmpStr += tmpChar;
            }
        }
        tmpList.add(new Word(tmpStr));
        tmpList.add(new Word('\n'));
        return tmpList;
    }
}
