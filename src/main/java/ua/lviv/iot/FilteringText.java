package ua.lviv.iot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import org.omg.CORBA.PRIVATE_MEMBER;


public class FilteringText {
    private int numberLine;
    private String inputText;
    private List<String> textList = new LinkedList<String>();

    public FilteringText() {

    }

    public FilteringText(String text, List<String> textList, int numberLine) {
        this.inputText = text;
        this.textList = textList;
        this.numberLine = numberLine;
    }

    public int getNumberLine() {
        return numberLine;
    }

    public void setNumberLine(int numberLine) {
        this.numberLine = numberLine;
    }

    public String getText() {
        return inputText;
    }

    public void setText(String inputText) {
        this.inputText = inputText;
    }

    public List<String> getTextList() {
        return textList;
    }

    public void setTextList(List<String> textList) {
        this.textList = textList;
    }

    public void readText() throws IOException {
        BufferedReader buffered_reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ведіть текст");
        this.inputText = buffered_reader.readLine();
        System.out.println("Ведіть розмір слова");
        this.numberLine = Integer.parseInt(buffered_reader.readLine());
    }

    public void readTextScanner() {
          Scanner scan = new Scanner(System.in);
          System.out.println("Ведіть текст");
          this.inputText = scan.toString();
    }
    
    public List<String> searchText() {
        String REGEX = ",";
        Pattern pattern = Pattern.compile(REGEX);
        String[] textArray = pattern.split(inputText);
        
        for (String word : textArray) {
            if (word.contains("_") && word.length() < this.numberLine) {
                this.textList.add(word);
            }
        }
        return this.textList;
    }

    public List<String> sortByText() {
        Collections.sort(textList);
        return textList;
    }

    public void printText() {
        if (textList.isEmpty()) {
            System.out.println("Список пустий");
        } else {
            System.out.println("Результат:");
            System.out.println(textList);
        }
    }
    
    public List<String> processText(String input, int textLenth ) {
        this.numberLine = textLenth;
        this.setText(input);
        this.searchText();
        this.sortByText();
        return this.textList;
    }
    
    public void startSortText() {
        try {
            this.readText();
            this.processText(this.inputText, this.numberLine);
            this.printText();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
