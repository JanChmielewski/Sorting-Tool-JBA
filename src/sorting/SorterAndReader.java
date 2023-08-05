package sorting;

import java.util.Scanner;

public abstract  class SorterAndReader {
    int occurrences;
    Scanner scanner;

    public SorterAndReader() {
        this.occurrences = 0;
        scanner = new Scanner(System.in);
    }

    public abstract void read();
    public abstract void sort();
    public abstract String print();
}
