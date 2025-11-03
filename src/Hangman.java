import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Map.Entry;

public class Hangman {

		public static void main(String[] args) {
			Scanner scan = new Scanner(System.in);
			String [] wordList = {"une","arbre","chien","fleur","pluie","neige","rire","vif","jardin","soleil"};
			String randomWord = getRandomWord(wordList);
			Map<Character, Boolean> lettersMap = new LinkedHashMap<>();
			for (int i =0;i<randomWord.length();i++) {
				System.out.println(randomWord.charAt(i));
				lettersMap.put(randomWord.charAt(i), false);
			}
			System.out.println(lettersMap);
			System.out.println(randomWord);
			
			Boolean gameEnd = false;
			int nbTries = 5;
			while (nbTries>=0){
				for (Entry<Character,Boolean> letter : lettersMap.entrySet()) {
					if(letter.getValue() == false) {
						gameEnd = false;
					} else {
						gameEnd = true;
					}
				}
				if(!gameEnd) {
					System.out.print("Mot mystère : ");
					printHiddenRandomWord(lettersMap,randomWord);
					System.out.print("Proposez une lettre : ");
					char letterChoice = scan.next().charAt(0);
					if (isValidChoice(letterChoice)) {
						if(isLetterInHiddenWord(letterChoice,randomWord)) {
							lettersMap = revealLetters(letterChoice,lettersMap);
							System.out.println("Bien joué ! La lettre '" + letterChoice + "' est dans le mot");						
						} else {
							if(nbTries == 0) {
								System.out.println("Vous avez dépassé le nombre d'essais maximum, la partie est perdue. :(");
								break;
							} else {
								System.out.println("Dommage ! La lettre '" + letterChoice + "' n'est pas dans le mot. Il vous reste "+ nbTries +" essais");
							}
						}
					} else {
						System.out.println("entrée invalide, merci de rentrer une seule lettre ");
						continue;
					}
				
				} else {
					System.out.println("Félicitations ! Vous avez deviné le mot : "+ randomWord);
					break;
				}
				
				
				nbTries --;
			}
			
		}
	
		private static Map<Character, Boolean> revealLetters(char letterChoice, Map<Character, Boolean> lettersMap) {
			for (Entry<Character,Boolean> letter : lettersMap.entrySet()) {
				if(letter.getKey() == letterChoice) {
					letter.setValue(true);
				}
			}
			return lettersMap;
			
		}

		private static boolean isLetterInHiddenWord(char letterChoice,String randomWord) {
			if(randomWord.indexOf(letterChoice) != -1) return true;
			return false;
		}

		private static boolean isValidChoice(char letterChoice) {
			if(!Character.isDigit(letterChoice)) {
				return true;
			}
			return false;
		}

		private static void printHiddenRandomWord(Map<Character,Boolean> lettersMap,String randomWord) {
			StringBuilder hiddenWord = new StringBuilder();
			
			for (int i=0;i < randomWord.length();i++) {
				for (Entry<Character,Boolean> letter : lettersMap.entrySet()) {
					if(letter.getValue() == true && letter.getKey() == randomWord.charAt(i)) {
						hiddenWord.append( randomWord.charAt(i) + " ");
					} else if(letter.getKey() == randomWord.charAt(i) && letter.getValue() == false ) {
						hiddenWord.append("_ ");
					}
				}
				
			}
			
			
			
			
			
			
			System.out.println(hiddenWord);
			
		}

		private static String getRandomWord(String[] wordList) {
				Random randomInt = new Random();				
				return wordList[randomInt.nextInt(wordList.length)];	
		}

}


