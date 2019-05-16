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
    void test() {
        filteringText.setText("data_da false data_time false_false www_www wwwwww alfa_al");
        filteringText.setNumberLine(8);
        textList.add("data_da, www_www, alfa_al");
        textListTest = filteringText.searchText();
        assertEquals(textList, textListTest);
    }
 
    @Test
    void testSort() {
        textList.add("data_da, www_www, alfa_al");
        filteringText.setTextList(textList);
        textListTest = filteringText.sortByText();
        assertEquals(textList, textListTest);
    }
   
    @Test
    void processTextTest(){
        String text = "data_da false data_time false_false www_www wwwwww alfa_al";
        textListTest = filteringText.processText(text, 8);
        textList.add("alfa_al, data_da, www_www");
        assertEquals(textList, textListTest);
    }

}
