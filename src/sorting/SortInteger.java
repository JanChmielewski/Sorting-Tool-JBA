package sorting;

import java.util.ArrayList;
import java.util.Collections;

public class SortInteger extends SorterAndReader {
    private ArrayList<Integer> numbers;

    public SortInteger() {
        numbers = new ArrayList<>();
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
            output.append(i);
        }
        return output.toString();
    }
}
