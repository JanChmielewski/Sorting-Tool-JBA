package sorting;

import java.util.ArrayList;
import java.util.Arrays;


public class WordSorter extends SorterAndReader {
    private final String sortingType;
    private ArrayList<String> words;
    private int longestWordLength;
    private int occurrences;
    private String longestWord;

    public WordSorter(String sortingType) {
        words = new ArrayList<>();
        longestWordLength = 0;
        occurrences = 0;
        longestWord = "";
        this.sortingType = sortingType;
    }

    @Override
    public void read() {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            String[] wordsInLine = line.split("\\s+");
            words.addAll(Arrays.asList(wordsInLine));
        }
    }

    @Override
    public void sort() {
        for (String word : words) {
            int length = word.length();
            if (length > longestWordLength) {
                longestWordLength = length;
                longestWord = word;
                occurrences = 1;
            } else if (length == longestWordLength && words.equals(longestWord)) {
                occurrences++;
            }
        }
    }

    @Override
    public String print() {
        return "Total words: " + words.size() + "\nThe longest words: " + longestWord +
                " (" + occurrences + " time(s), " + (occurrences * 100 / words.size()) + "%).";
    }
}
