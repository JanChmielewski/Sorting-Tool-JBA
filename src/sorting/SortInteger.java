package sorting;

import java.util.ArrayList;
import java.util.Collections;

public class SortInteger extends SorterAndReader {
    private ArrayList<Integer> numbers;
    private String sortingType;

    public SortInteger(String sortingType) {
        numbers = new ArrayList<>();
        this.sortingType = sortingType;
    }

    @Override
    public void read() {
        while(scanner.hasNextInt()) {
            int number = scanner.nextInt();
            numbers.add(number);
        }
    }

    @Override
    public void sort() {
        Collections.sort(numbers);
    }

    @Override
    public String print() {
        StringBuilder output = new StringBuilder("Total numbers: " + numbers.size() + "." + "\nSorted data: ");
        for(int i : numbers) {
            output.append(i).append(" ");
        }
        return output.toString();
    }
}
