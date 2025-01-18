package assignment02;

import java.util.HashSet;
import java.util.Set;

public abstract class Decorator extends Component {
	private Component delegate;
	
	public Decorator(Component delegateIn) {
		delegate = delegateIn;
	}

	public abstract Set<Character> getConsonantsInWord();
	public abstract Set<Character> getVowelsInWord();	
	
	@Override
public Set<Character> getConsonants() {
    Set<Character> consonants = new HashSet<>();
    Set<Character> delegateConsonants = delegate.getConsonants();
    for (Character c : delegateConsonants) {
        consonants.add(c);
    }
    for (Character c : getConsonantsInWord()) {
        consonants.add(c);
    }
    return consonants;
}

@Override
public Set<Set<Character>> getVowels() {
    Set<Set<Character>> vowels = new HashSet<>();
    Set<Set<Character>> delegateVowels = delegate.getVowels();
    for (Set<Character> set : delegateVowels) {
        vowels.add(new HashSet<>(set));
    }
    vowels.add(getVowelsInWord());
    return vowels;
}


	@Override
	public void print() {
		delegate.print();
	}}
