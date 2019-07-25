package br.com.biscleta.ditado;

public class Principal {
	
	public static void main(String[] args) {
		String original = "This news is about a dog.\n" + 
				"He has two noses.\n" + 
				"His name is Toby.\n" + 
				"People find him in the streets of Fresno, California, USA.\n" + 
				"People take the dog to a shelter.\n" + 
				"The shelter tries to find Toby a new home.\n" + 
				"However, it is not easy.\n" + 
				"People do not want a two-nosed dog.\n" + 
				"Toby is in danger.\n" + 
				"If nobody takes him, the shelter has to put him down.\n" + 
				"Toby is lucky.\n" + 
				"A man adopts him.\n" + 
				"The man is a music producer.\n" + 
				"He also has many special animals.\n" + 
				"He has many two-headed animals.\n" + 
				"He also has a five-legged dog, and a two-legged dog.";
		
		String transcrito = "This news is about a dog.\n" + 
				"He has two noses.\n" + 
				"His name is Toby.\n" + 
				"People find him in the streets of Fresno, California, USA.\n" + 
				"People take the dog to a shelter.\n" + 
				"The shelter tries to find Toby a new home.\n" + 
				"However, it is not easy.\n" + 
				"People do not want a two-nosed dog.\n" +
				"Toby is in danger.\n" + 
				"If nobody takes him, the shelter has to put him down.\n" +
				"Toby is lucky.\n" +
				"A man adopts him.\n" +
				"The man is a music producer.\n" +
				"He also has many special animals.\n" +
				"He has many two-headed animals.\n" +
				"He also has a five-legged dog, and a two-legged dog.";
		
		System.out.println(original.equals(transcrito));
		
		String[] originalArray = original.split(" ");
		
		String[] transcritoArray = transcrito.split(" ");
		
		for (int i = 0; i < originalArray.length; i++) {
			if (!originalArray[i].equals(transcritoArray[i])) {
				System.out.println(originalArray[i]);
				System.out.println(transcritoArray[i]);
				System.out.println();
			}
		}
	}

}
