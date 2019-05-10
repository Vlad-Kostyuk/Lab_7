package ua.lviv.iot;

import java.io.IOException;

public class StartFiltringText {

    public static void main(String[] args) throws IOException {
        FilteringText  filteringText = new  FilteringText();
        filteringText.readText();;
        filteringText.searchText();
        filteringText.sortByText();
        filteringText.printText();
    }

}
