/*
The idea is based on a simple depth-first traversal. 
We start from every word of the first list as the first word of an output 
sentence, then recur for the remaining lists.
Below is the C++ implementation of the above idea. 
In the below implementation, the input list of the list is considered as a 
2D array. If we take a closer look, we can observe that the code is very 
close to the DFS of graph.
*/


class Sentences {

    public static void main(String[] args) {

        String[][] string = {{"you", "we", ""},
        {"have", "are", ""},
        {"sleep", "eat", "drink"}};

        printSentences(string);
    }

    public static void printSentences(String string[][]) {

        // Create an array to store sentence
        String sentences[] = new String[string.length];

        // Consider all words for first 
        // row as starting points and
        // print all sentences
        for (int index = 0; index < string[0].length; index++) {
            if (!"".equals(string[0][index])) {
                printSentencesUtil(string, 0, index, sentences);
            }
        }
    }

    // A recursive function to 
// print all possible sentences 
// that can be formed  
// from a list of word list
    public static void printSentencesUtil(String string[][], int row,
            int column, String sentences[]) {

        // Add current word to output array
        sentences[row] = string[row][column];

        // If this is last word of 
        // current output sentence, 
        // then print the output sentence
        if (row == string.length - 1) {
            for (String sentence : sentences) {
                System.out.print(sentence + " ");
            }
            System.out.println("");
            return;
        }

        // Recur for next row
        for (int index = 0; index < string[0].length; index++) {
            if (!"".equals(string[row + 1][index])) {
                printSentencesUtil(string, row + 1, index, sentences);
            }
        }
    }
}

// Time --> O(2^N) — Exponential Time
