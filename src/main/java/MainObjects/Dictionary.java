package MainObjects;

import Tools.Util;
import java.util.Set;

public class Dictionary {

    private Set<String> dictionary;

    public Dictionary(Set<String> dictionary){
        this.dictionary = dictionary;
    }

    public boolean isEnglishWord(String someWord){
        return dictionary.contains(Util.capitalize(someWord));
    }
}