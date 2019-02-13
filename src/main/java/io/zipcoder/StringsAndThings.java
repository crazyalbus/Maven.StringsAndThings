package io.zipcoder;


import com.sun.xml.internal.fastinfoset.util.StringArray;

/**
 * @author tariq
 */
public class StringsAndThings {

    /**
     * Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count,
     * but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if there is not an alphabetic
     * letter immediately following it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
     * example : countYZ("fez day"); // Should return 2
     * countYZ("day fez"); // Should return 2
     * countYZ("day fyyyz"); // Should return 2
     */
    public Integer countYZ(String input) {
        String lowerCaseInput = input.toLowerCase();
        String[] splitString = lowerCaseInput.split(" ");
        Integer wordCount = 0;
        for (String word : splitString
        ) {
            if (word.endsWith("y") || word.endsWith("z")) {
                wordCount++;
            }
            ;
        }
        return wordCount;
    }

    /**
     * Given two strings, base and remove, return a version of the base string where all instances of the remove string have
     * been removed (not case sensitive). You may assume that the remove string is length 1 or more.
     * Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
     * <p>
     * example : removeString("Hello there", "llo") // Should return "He there"
     * removeString("Hello there", "e") //  Should return "Hllo thr"
     * removeString("Hello there", "x") // Should return "Hello there"
     */
    public String removeString(String base, String remove) {
        return base.replaceAll(remove, "");
    }

    /**
     * Given a string, return true if the number of appearances of "is" anywhere in the string is equal
     * to the number of appearances of "not" anywhere in the string (case sensitive)
     * <p>
     * example : containsEqualNumberOfIsAndNot("This is not")  // Should return false
     * containsEqualNumberOfIsAndNot("This is notnot") // Should return true
     * containsEqualNumberOfIsAndNot("noisxxnotyynotxisi") // Should return true
     */
    public Boolean containsEqualNumberOfIsAndNot(String input) {
        String lowercaseInput = input.toLowerCase();

        return wordCount(lowercaseInput, "is") == wordCount(lowercaseInput, "not");
    }

    private int wordCount(String phraseToSearch, String wordToCount) {
        int wordsCounted = 0;
        int indexCounter = 0;

        while (indexCounter != -1) {
            indexCounter = phraseToSearch.indexOf(wordToCount, indexCounter);
            if (indexCounter != -1) {
                wordsCounted++;
                indexCounter++;
            }
        }
        return wordsCounted;
    }


    /**
     * We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right.
     * Return true if all the g's in the given string are happy.
     * example : gHappy("xxggxx") // Should return  true
     * gHappy("xxgxx") // Should return  false
     * gHappy("xxggyygxx") // Should return  false
     */
    public Boolean gIsHappy(String input) {
        char[] inputAsCharArray = input.toCharArray();

        return countAllLetters(inputAsCharArray, 'g') == countHappyLetters(inputAsCharArray, 'g');
    }

    private int countAllLetters(char[] charArrayToCheck, char letterToCount) { //this method works
        int numberOfLetters = 0;
        for (char letter : charArrayToCheck
        ) {
            if (letter == letterToCount) {
                numberOfLetters ++;
            }
        }
        return numberOfLetters;
    }

    private int countHappyLetters(char[] arrayToSearch, char letterToTest) {
        int happyLetterCount = 0;

        if (arrayToSearch[0] == letterToTest) {
            if (duplicateLetterAfter(arrayToSearch, 0)) {
                happyLetterCount++;
            }
        }

        for (int i = 1; i < arrayToSearch.length - 1; i++) {
            if (arrayToSearch[i] == letterToTest) {
                if(duplicateLetterBefore(arrayToSearch, i) || duplicateLetterAfter(arrayToSearch,i)) {
                    happyLetterCount++;
                }
            }
        }

        if (arrayToSearch[arrayToSearch.length - 1] == letterToTest) {
            if (duplicateLetterAfter(arrayToSearch, arrayToSearch.length - 1)) {
                happyLetterCount++;
            }
        }
        return happyLetterCount;
    }

    private boolean duplicateLetterBefore(char[] arrayToSearch, int position) {
        return arrayToSearch[position] == arrayToSearch[position - 1];
    }

    private boolean duplicateLetterAfter(char[] arrayToSearch, int position) {
        return arrayToSearch[position] == arrayToSearch[position + 1];
    }

    //      ------- NOTES -------
    //      search string for instances of g using indexOf
    //      input.indexOf('g');

    //      counter for happy g's
    //      Int happyGCounter = 0;

    //      test if g is happy
    //      if (input.charAt(letter - 1) || input.charAt(letter +1)) {

    //
    //      loop
    //      for (int[] gIndex : input) {}






     //




    /**
     * We'll say that a "triple" in a string is a char appearing three times in a row.
     * Return the number of triples in the given string. The triples may overlap.
     * example :  countTriple("abcXXXabc") // Should return 1
     *            countTriple("xxxabyyyycd") // Should return 3
     *            countTriple("a") // Should return 0
     */
    public Integer countTriple(String input){
        return null;
    }
}
