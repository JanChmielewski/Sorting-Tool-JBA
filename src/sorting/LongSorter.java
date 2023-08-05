package sorting;

import java.util.*;

public class LongSorter extends SorterAndReader {

    private final ArrayList<Long> numbers;
    private final String sortingType;
    private Map<Long, Integer> numbersAsMap;

    public LongSorter(String sortingType) {
        numbers = new ArrayList<>();
        this.sortingType = sortingType;
        this.numbersAsMap = new HashMap<>();
    }

    @Override
    public void read() {
        while (scanner.hasNextLong()) {
            numbers.add(scanner.nextLong());
        }
        for (long key : numbers) {
            if (numbersAsMap.containsKey(key)) {
                int occurrence = numbersAsMap.get(key);
                occurrence++;
                numbersAsMap.put(key, occurrence);
            } else {
                numbersAsMap.put(key, 1);
            }
        }
    }

    @Override
    public void sort() { Collections.sort(numbers); }

    @Override
    public String print() {
        StringBuilder output = new StringBuilder();
        if(sortingType.equals("natural")) {
            output.append("Total Numbers: ").append(numbers.size()).append(".").append("\nSorted data:");
            for (long natural : numbers) {
                output.append(" ").append(natural);
            }
        }
        if (sortingType.equals("byCount")) {
            output.append("Total numbers: ").append(numbers.size()).append(".");
            List<Map.Entry<Long, Integer>> sortedByOccurrences = new ArrayList<>(numbersAsMap.entrySet());
            sortedByOccurrences.sort(Map.Entry.<Long,Integer>comparingByValue().reversed());
            for (Map.Entry<Long, Integer> entry : sortedByOccurrences) {
                long number = entry.getKey();
                int occurrences = entry.getValue();
                int percentage = occurrences / (numbers.size() * 100);

                output.append("\n").append(number).append(": ").
                        append(occurrences).append(" time(s), ").append(percentage).append("%");
            }
        }
        return output.toString();
    }
}
