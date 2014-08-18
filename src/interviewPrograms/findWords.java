/*
 * given 2 arrays wrds[] , chars[] as an input to a function such that
 * wrds[] = [ "abc" , "baa" , "caan" , "an" , "banc" ]
 * chars[] = [ "a" , "a" , "n" , "c" , "b"]
 * Function should return the longest word from words[] which can be constructed from the chars in chars[] array. 
 */
package interviewPrograms;

import java.util.HashMap;

public class findWords {

	public static String longestWord(String [] words, char [] chars) {
		
		HashMap<Character, Integer> charHMap = new HashMap<>();
		String longWord=null;
		int value, maxLength=0;
		int numChar = chars.length;
		for (char ch: chars) {
			if (charHMap.containsKey(ch))
				value = charHMap.get(ch)+1;
			else 
				value = 0;
			charHMap.put(ch, value);	
		}
		
		for (String word:words) {
			//If length of word is greater than the number of characters we have, it can be discarded
			if (word.length() > numChar)
				continue;

			HashMap<Character, Integer> wordHMap = new HashMap<>();
			char [] wordChars = word.toCharArray();
			
			for (char ch: wordChars) {
				if (wordHMap.containsKey(ch))
					value = wordHMap.get(ch)+1;
				else 
					value = 0;
				wordHMap.put(ch, value);	
			}
			
			boolean  charMatch = true;
			
			for (Character i:wordHMap.keySet()) {
				if (charHMap.get(i)<wordHMap.get(i)){
					charMatch = false;
					break;
				}
			}
			if (charMatch && word.length()>maxLength) {
				maxLength=word.length();
				longWord=word;
			}
		}
		return longWord;
	}
	public static void main(String[] args) {
		String [] words = {"abc" , "baa" , "caaan" , "an" , "banc"};
		char [] chars = {'a' , 'a' , 'n' , 'c' , 'b'};
		System.out.println("Longest Word: " + longestWord(words, chars));
		
	}

}
