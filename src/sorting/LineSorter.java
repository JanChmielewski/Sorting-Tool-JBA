package sorting;

import java.util.*;

public class LineSorter extends SorterAndReader {

    private final ArrayList<String> lines;
    private final String sortingType;
    private final Map<String, Integer> linesAsMap;

    public LineSorter(String sortingType) {
        lines = new ArrayList<>();
        this.sortingType = sortingType;
        this.linesAsMap = new HashMap<>();
    }

    @Override
    public void read() {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            lines.add(line);
        }
        for (String key : lines) {
            if (linesAsMap.containsKey(key)) {
                int occurrence = linesAsMap.get(key);
                occurrence++;
                linesAsMap.put(key, occurrence);
            } else {
                linesAsMap.put(key, 1);
            }
        }
    }

    @Override
    public void sort() {
        Collections.sort(lines);
    }

    @Override
    public String print() {
        StringBuilder output = new StringBuilder();

        if (sortingType.equals("natural")) {
            output.append("Total lines: ").append(lines.size()).append("\nSorted data: ");
            for (String natural : lines) {
                output.append("\n").append(natural);
            }
        }
        if (sortingType.equals("byCount")) {
            output.append("Total lines: ").append(lines.size()).append(".");
            List<Map.Entry<String, Integer>> sortedByOccurrences = new ArrayList<>(linesAsMap.entrySet());
            sortedByOccurrences.sort(Map.Entry.<String,Integer>comparingByValue().reversed());
            for (Map.Entry<String, Integer> entry : sortedByOccurrences) {
                String line = entry.getKey();
                int occurrences = entry.getValue();
                int percentage = occurrences / (lines.size() * 100);

                output.append("\n").append(line).append(": ").
                        append(occurrences).append(" time(s), ").append(percentage).append("%");
            }
        }
        return output.toString();
    }

}
