package assignment02;

import java.util.HashSet;
import java.util.Set;

public class Word extends Decorator {
	private String thisWord;
	public Word(Component delegate, String str) {
		super(delegate);
		thisWord = str;
	}
	
	@Override
public Set<Character> getConsonantsInWord() {
    Set<Character> consonants = new HashSet<>();
    String consonantChars = "bcdfghjklmnpqrstvwxyz";
    for (char c : thisWord.toCharArray()) {
        if (consonantChars.contains(String.valueOf(c))) {
            consonants.add(c);
        }
    }
    if (Ywords.hasYconsonant.contains(thisWord.toLowerCase())) {
        consonants.add('y');
    }
    return consonants;
}

@Override
public Set<Character> getVowelsInWord() {
    Set<Character> vowels = new HashSet<>();
    String vowelChars = "aeiou";
    for (char c : thisWord.toCharArray()) {
        if (vowelChars.contains(String.valueOf(c))) {
            vowels.add(c);
            break; // Only one vowel allowed per word
        }
    }
    if (Ywords.hasYvowel.contains(thisWord.toLowerCase())) {
        vowels.add('y');
    }
    return vowels;
}


	@Override
	public String toString() {
		return thisWord;
	}
	
	@Override
	public void print() {
		super.print();
		System.out.print("->" + this);
	}
}
