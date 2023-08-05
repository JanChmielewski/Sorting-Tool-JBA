package sorting;

import java.util.Arrays;

public class ArgumentSelector {

    public static SorterAndReader selectArgument(String[] args) {

        String dataType = "word";
        String sortingType = "natural";

        if (Arrays.asList(args).contains("-sortingType")) {
            sortingType = Arrays.asList(args).get(Arrays.asList(args).indexOf("-sortingType") + 1);
        }
        if (Arrays.asList(args).contains("-dataType")) {
            dataType = Arrays.asList(args).get(Arrays.asList(args).indexOf("-dataType") + 1);
        }
        switch (dataType) {
            case "long":
                return new LongSorter(sortingType);
            case "line":
                return new LineSorter(sortingType);
            case "word":
                return new WordSorter(sortingType);
        }
        return null;
    }
}