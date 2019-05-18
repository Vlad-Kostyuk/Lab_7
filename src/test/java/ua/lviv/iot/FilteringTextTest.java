package ua.lviv.iot;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

class FilteringTextTest {
    private List<String> textListTest = new LinkedList<String>();
    private List<String> textList = new LinkedList<String>();
    FilteringText filteringText = new FilteringText();

 

    @Test
    void processTextTest(){
        String text = "data_da,false,data_time,false_false,www_www,wwwwww,alfa_al";     
        textListTest = filteringText.processText(text, 8);
        //textList.add("alfa_al, data_da, www_www");
        textList.add("alfa_al");
        textList.add("data_da");
        textList.add("www_www");
        assertEquals(textList, textListTest);
    }
    
    

}
