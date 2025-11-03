import java.util.Random;
import java.util.Scanner;

public class Hangman {

		public static void main(String[] args) {
			Scanner scan = new Scanner(System.in);
			String [] wordList = {"une","arbre","chien","fleur","pluie","neige","rire","vif","jardin","soleil"};
			String randomWord = getRandomWord(wordList);				
			printHiddenRandomWord(randomWord);
			
			int nbTries = 0;
			while (nbTries<10){
				System.out.print("proposer une lettre : ");
				String letterChoice = scan.next();
				if (isValidChoice(letterChoice)) {
					
				} else {
					System.out.println("entrée invalide, merci de rentrer une seule lettre ");
					continue;
				}
				
				
				nbTries ++;
			}
			
		}
	
		private static boolean isValidChoice(String letterChoice) {
			if(letterChoice.length() == 1 && !Character.isDigit(letterChoice.charAt(0))) {
				return true;
			}
			return false;
		}

		private static void printHiddenRandomWord(String randomWord) {
			StringBuilder hiddenWord = new StringBuilder();
			for (int i=0;i<randomWord.length();i++) {
				hiddenWord.append('-');
			}
			System.out.println(hiddenWord);
			
		}

		private static String getRandomWord(String[] wordList) {
				Random randomInt = new Random();				
				return wordList[randomInt.nextInt(wordList.length)];	
		}

}


