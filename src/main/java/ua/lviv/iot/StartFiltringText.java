package ua.lviv.iot;

import java.io.IOException;

public class StartFiltringText {

    public static void main(String[] args) throws IOException {
        FilteringText  filteringText = new  FilteringText();
        filteringText.setText(filteringText.readText());
        filteringText.sortingText();
        filteringText.printText();
    }

}
