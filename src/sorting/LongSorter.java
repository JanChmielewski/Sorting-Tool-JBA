package sorting;

import java.util.ArrayList;
import java.util.Collections;

import static java.util.Collections.max;

public class LongSorter extends SorterAndReader {

    private final ArrayList<Long> numbers;
    private int times;

    public LongSorter() {
        numbers = new ArrayList<>();
        times = 0;
    }

    @Override
    public void read() {
        while (scanner.hasNextLong()) {
            numbers.add(scanner.nextLong());
        }
    }

    @Override
    public void sort() {
        Collections.sort(numbers);
        times = Collections.frequency(numbers, max(numbers));
    }

    @Override
    public String print() {
        return "Total Numbers: " + numbers.size() + "." +
                "\nThe greatest number: " + max(numbers) + "(" + times + "time(s), " +
                (times * 100)/numbers.size() + "%).";
    }
}
