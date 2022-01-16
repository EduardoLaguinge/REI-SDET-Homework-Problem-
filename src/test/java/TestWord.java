import MainObjects.Dictionary;
import Tools.DataBaseReader;
import Tools.Util;
import org.junit.jupiter.api.*;
import java.util.Set;
import java.util.TreeSet;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestWord {

    private Dictionary myDictionary;
    private String word = Util.getWordToSearchOnDictionary("word4");

    /**
     * BeforeAll is a tag that will execute in first place before run the other ones like @Test.
     * This tag will create an Object MainObjects.Dictionary, and this when call setup method, executes a
     * MainObjects.Dictionary's Constructor method to get a MainObjects.Dictionary's instance.
     */
    @BeforeAll
    public void setup(){
        myDictionary = new Dictionary(DataBaseReader.getMyMock());
    }

    /**
     * My first test case
     */
    @Test
    @DisplayName("This scenario tests if some word exists on our dictionary.")
    @Tag("test")
    void first_test(){
        System.out.println("I used the word '"+ word + "' and I got as a result: " + myDictionary.isEnglishWord(word));
    }

    @Test
    @DisplayName("This automated test case searches others words from a reverse word, and serches each one in the dictionary, returning true if it's a english word or false if it's not.")
    @Tag("test")
    void second_test(){
        Set<String> words = new TreeSet<>(); // words.toString() ---> [""]
        words.addAll(Util.generateWordsWithoutReverseWord(word));
        System.out.println("Words created: " + words);
        for (String element : words) {
            System.out.println("The word or letter taken was: '" + element +"' and I got as a result: " + myDictionary.isEnglishWord(element));
        }
    }

    @Test
    @DisplayName("This automated test case searches others words from a reverse word, and serches each one in the dictionary, returning true if it's a english word or false if it's not.")
    @Tag("test")
    void third_test(){
        Set<String> words = new TreeSet<>(); // words.toString() ---> [""]
        words.addAll(Util.generateWordsFromReverseWord(word));
        System.out.println("Words created: " + words);
        for (String element : words) {
            System.out.println("The word or letter taken was: '"+ element +"' and I got as a result: " + myDictionary.isEnglishWord(element));
        }
    }
}