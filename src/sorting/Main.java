package sorting;

public class Main {
    public static void main(final String[] args) {
        SorterAndReader readAndSort = ArgumentSelector.selectArgument(args);
        readAndSort.read();
        readAndSort.sort();
        System.out.println(readAndSort.print());
    }
}

