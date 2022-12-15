package pendu;

import java.util.Arrays;
import java.util.Scanner;

public class pendu {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		// difficulty
		int maxtry = 7, tries = 0;
		// get word to find and put in array
		System.out.println("Please insert a word :");
		String mot = scan.nextLine().toUpperCase();
		char array[] = mot.toCharArray();
		// show word
		System.out.println(Arrays.toString(array)); 
		//get letter
		char array_letters[] = new char[maxtry];
		char discover[] = new char[mot.length()];
		
		do {
			System.out.println("Please insert a letter :");
			char input = scan.next().charAt(0);
			char letter = java.lang.Character.toUpperCase(input);
			
			// si la lettre n'est pas dans le mot
			if(new String(mot).indexOf(letter) == -1) {
				// si la lettre n'est pas dans le mot ni dans les lettres déjà utilisées
				if(new String(array_letters).indexOf(letter) == -1) {
					array_letters[tries] = letter;
					System.out.println("letters used : "+Arrays.toString(array_letters)+". "+ (maxtry-(tries+1)) +"tries left.");
					
					tries++;
				}else {
					// si la lettre est dans les lettres déja utilisées
					System.out.println("Already picked "+letter);
				}
			}else{
				//si la lettre est dans le mot et pas déjà trouvée
				if(new String(discover).indexOf(letter) == -1) {
					System.out.println("You found");
					
					for (int position = mot.indexOf(letter); position >= 0; position = mot.indexOf(letter, position + 1)){
						    discover[position] = letter;
						}

					System.out.println("LETTER '"+letter+"' IS IN THE WORD  : "+Arrays.toString(discover));
					
					if (Arrays.equals(discover, array)) {
						System.out.println("\n --- CONGRATULATION !!! YOU LIVE (YOU WILLL DIE NEXT TIME FOOL AHAHAH) ---");
						System.exit(0);
					}	
				}else {
					// si la lettre est dans le mot et déjà trouvée
					System.out.println("ALREADY USED THE LETTER '"+letter+"'");
				}
			}
		}while(tries<maxtry);
		scan.close();
		System.out.println("\n --- Perdu >> Pendu ---");
	}
}
