package module1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class maximot 
{
	public static void main (String[] args) 
	{
	char[] t = tirerMotAleatoirement();
	t = melanger(t);
	char[] uWord = afficher(t);
	if (bonnesLettres(t, uWord) == false)
		System.out.println("Mot incorrect");
	dansleDico(uWord);
	}
	
	private static void dansleDico(char [] t) 
	{
		int i = 0;
		String DicoWord;
		String uWord = Arrays.toString(t).replaceAll("\\[|\\]|,|\\s", "");
		try (FileInputStream fichier = new FileInputStream("./dictionnaire.txt");
				Scanner s = new Scanner(fichier))
		{
			while (s.hasNextLine())
			{
				System.out.println(s.nextLine());
				DicoWord = s.nextLine();
				boolean compareWithDico = DicoWord.equals(uWord);
				if (compareWithDico == true)
				{
					i++;
					return;
				}
			}
		System.out.println(i);
		} 
		catch (IOException e) 
		{
			System.out.println("Lecture impossible");
		}
		return;
	}
	
	private static boolean bonnesLettres (char[] t, char[] uWord)
	{
		boolean word;
		word = true;
		int size_t = t.length;
		int size_uWord = uWord.length;
		if (size_t < size_uWord)
			return (word = false);
		for (int i = 0; i < (uWord.length); i++)
		{
			for(int j = 0; j < (t.length); j++)
			{
				if (uWord[i] == t[j])
				{	
					word = true;
					t[j] = 0;
					break;
				}
				word = false;
			}
		}
		return word;
	}
	
	public static char [] afficher (char [] t)
	{
		char [] uWord;
		Scanner sc = new Scanner(System.in);
		System.out.println(t);
		System.out.println("Inserez votre mot");
		uWord = sc.nextLine().toUpperCase().toCharArray();
		return uWord;
	}
	
	
	private static char [] melanger(char[] t)
	{
		    Random random = new Random();
		    int size = t.length;
		    for (int i = size; i > 1; i--) 
		    {
		        swap(t, i - 1, random.nextInt(i));
		    }
		    return t;   
	}	 
	private static void swap(char[] t, int i, int j) 
	{
		char tmp = t[i];
		t[i] = t[j];
		t[j] = tmp;
	}
	
	private static char[] tirerMotAleatoirement()
	{
		char [] tab = null;
		//Ouverture du fichier
		try  (FileInputStream fichier = new FileInputStream("./dictionnaire.txt");
				Scanner s = new Scanner(fichier)) 
			{
				//Selection d'un mot aleatoire
				int i = 0;
				Random ran = new Random();
				int nbr = ran.nextInt(22506);
				//char[] t = s.nextLine().toUpperCase().toCharArray();
				while (i < nbr - 1)
				{
					s.nextLine();
					i++;
				}
				char[] t = s.nextLine().toUpperCase().toCharArray();
				System.out.println(t);
				System.out.println("Fichier lu intégralement avec succès");
				tab = t;
			} 
		catch (IOException e)
		{
			System.out.println("Lecture impossible");
		}
		return tab;
	}
}