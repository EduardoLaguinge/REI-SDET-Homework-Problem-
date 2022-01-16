package Tools;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;

public class Util {

    /**
     * This method helps me to modify the word and convert it to minus.
     * @param thisWord --> String
     * @return thisWord --> String
     */
    public static String capitalize(String thisWord){
        if (thisWord == null || thisWord.isEmpty()) {
            return thisWord;
        }
        thisWord = thisWord.toLowerCase(Locale.ROOT);
        return thisWord;
    }

    /**
     * This method searches on words.properties the variables that has as a value some word.
     * and then returns the word that we need.
     * @param param --> String
     * @return word --> String
     */
    public static String getWordToSearchOnDictionary(String param){
        Properties prop = new Properties();
        String word = null;
        try{
            InputStream input = new FileInputStream(GlobalConfig.WORDS_PROPIERTIES_ABSOLUTE_PATH);
            prop.load(input);
            word = prop.getProperty(param);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return word;
    }

    /**
     * This method executes generateWords(String word) to get a String's Collection of possibles english words.
     * But the word that will use as a parameter won't be reversed, to get some combinations.
     * @param word --> String
     * @return a String's collection --> Collection<String>
     */
    public static Collection<String> generateWordsWithoutReverseWord(String word) {
        return generateWords(word);
    }

    /**
     * This method executes generateWords(String word) to get a String's Collection of possibles english words.
     * But the word that will use as a parameter will be reversed, to get other combinations.
     * @param word --> String
     * @return a String's collection --> Collection<Sring>
     */
    public static Collection<String> generateWordsFromReverseWord(String word) {
        return generateWords(getReverseWord(word));
    }

    /**
     * This method returns a reverse word
     * @param word --> String
     * @return reverse word --> String
     */
    private static String getReverseWord(String word){
        StringBuilder str = new StringBuilder(word);
        return str.reverse().toString();
    }

    /**
     * This method makes all the possible combinations of words from a simple word
     * @param word -->String
     * @return String's array --> Set<String>
     */
    private static Set<String> generateWords(String word){
        Set<String> words = new TreeSet<>();
        char[] letters = word.toCharArray();

        //From left to right
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < letters.length; i++) {
            sb.append(letters[i]);
            words.add(capitalize(sb.toString()));
        }
        /*
           StringBuilder sb = new StringBuilder(); ---> sb.toString() => ""
            i = 0
                letters[0] => 'h'
                sb.append(letters[0]) ---> sb.toString() => "h"
                words.add("H") ----> ["H"]

            i = 1
                letters[1] => 'o'
                sb.append(letters[1]) ---> sb.toString() => "ho"
                words.add("Ho") ----> ["H"; "Ho"]

            i = 2
                letters[2] => 'l'
                sb.append(letters[2]) ---> sb.toString() => "hol"
                words.add("Hol") ----> ["H"; "Ho"; "Hol"]

            i = 3
                letters[3] => 'a'
                sb.append(letters[3]) ---> sb.toString() => "hola"
                words.add("Hola") ----> ["H"; "Ho"; "Hol"; "Hola"]
         */

        // letters => ['h'; 'o'; 'l'; 'a']
        // position     0;   1;   2;   3
        for (int i = 0; i < letters.length; i++) {
            StringBuilder xb = new StringBuilder();
            xb.append(letters[i]);
            for (int j = i+1; j < letters.length; j++) {
                xb.append(letters[j]);
                words.add(capitalize(xb.toString()));
            }
        }
        /*
        StringBuilder xb = new StringBuilder();  ---> xb.toString() => ""
            i = 1
                letters[1] => 'o'
                xb.append(letters[1]) ---> xb.toString() => "o"
                j = i+1 = 1+1 = 2
                    letters[2] => 'l'
                    xb.append(letters[2]) ---> xb.toString() => "ol"
                    words.add("Ol") ----> ["H"; "Ho"; "Hol"; "Hola";    "Ol"]

                j = i+2 = 1+2 = 3
                    letters[3] => 'a'
                    xb.append(letters[3]) ---> xb.toString() => "ola"
                    words.add("Ola") ----> ["H"; "Ho"; "Hol"; "Hola";    "Ol"; "Ola"]

                j = i+3 = 1+3 = 4 ---> CORTA EL CICLO DEL MEDIO
                xb = new StringBuilder();  ---> xb.toString() => ""

            i = 2
                letters[2] => 'l'
                xb.append(letters[2]) ---> xb.toString() => "l"
                j = i+1 = 2+1 = 3
                    letters[3] => 'a'
                    xb.append(letters[3]) ---> xb.toString() => "la"
                    words.add("La") ----> ["H"; "Ho"; "Hol"; "Hola";    "Ol"; "Ola"; "La"]

                j = i+2 = 2+2 = 4 ---> CORTA EL CICLO DEL MEDIO
                xb = new StringBuilder();  ---> xb.toString() => ""

            i = 3
                letters[3] => 'a'
                j = i+1 = 3+1 = 4 ---> CORTA EL CICLO DEL MEDIO
                xb = new StringBuilder();  ---> xb.toString() => ""

            i = 4 ---> CORTA EL CICLO COMPLETO
         */
        return words;
    }
}