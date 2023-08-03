package sorting;

import java.util.ArrayList;

public class LineSorter extends SorterAndReader {

    private ArrayList<String> lines;
    private int longestLineLength;
    private int indexOfLongestLine;
    private int occurrences;

    public LineSorter() {
        lines = new ArrayList<>();
        longestLineLength = 0;
        indexOfLongestLine = 0;
        occurrences = 0;
    }

    @Override
    public void read() {
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lines.add(line);
            }
    }

    @Override
    public void sort() {
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            int length = line.length();

            if(length > longestLineLength) {
                longestLineLength = length;
                indexOfLongestLine = i;
                occurrences = 1;
            } else if (length == longestLineLength && line.equals(lines.get(indexOfLongestLine))) {
                occurrences++;
            }
        }
    }

    @Override
    public String print() {
        return "Total lines: " + lines.size() + "\nThe longest line: " + "\n" + lines.get(indexOfLongestLine) +
                "\n(" + occurrences +" time(s), " + (occurrences * 100) / lines.size() + "%).";
    }

}
