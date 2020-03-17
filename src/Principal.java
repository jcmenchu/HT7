import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Principal {
	public static void main(String[] args) throws IOException {
		String texto = "";
        /* Leer archivos */
    	System.out.println("Ingrese el nombre del archivo del diccionario.");
		Scanner input = new Scanner(System.in);
		File file = new File(input.nextLine());
		try {
			Scanner scanner = new Scanner(file);
	        if(scanner.hasNextLine()) {
	        	/* Leer diccionario */
	        	String[] palabras = scanner.nextLine().split(",");
	        	BinaryTree<String> diccionario = new BinaryTree<String>(palabras[0].trim(),palabras[1].trim());
	        	while (scanner.hasNextLine()){
		            palabras = scanner.nextLine().split(",");
		        	diccionario.put(palabras[0].trim(),palabras[1].trim());
		        }
		        scanner.close();
		        
		        /* Leer texto */
		        System.out.println("Ingrese el nombre del archivo de texto a traducir.\n");
		        file = new File(input.nextLine());
		        scanner = new Scanner(file);
		        while (scanner.hasNextLine()){
		        	texto += scanner.nextLine() + "\n";
		        }
		        texto = texto.substring(0, texto.length() - 1);
		        scanner.close();
		        
		        /* Limpiar texto, separar palabras de caracteres usuales*/
		        texto = texto.replace(".", " . ");
		        texto = texto.replace(",", " , ");
		        texto = texto.replace("(", " ( ");
		        texto = texto.replace(")", " ) ");
		        
		        /* Traducir */
		        String[] words = texto.split(" ");
		        String traduccion = "";
		        for(int i = 0; i < words.length; i++) {
		        	if(words[i] != null) {
		        		if(words[i].chars().allMatch(Character::isLetter)) {
		        			Object palabra = diccionario.get(words[i]);
				        	if(palabra != null) {
				        		traduccion += palabra + " ";
				        	}
				        	else {
				        		traduccion += "*" + words[i] + "* ";
				        	}
			        	}
		        		else {
		        			traduccion += words[i];
		        		}
		        	}
		        }
		        /* Mostrar resultado*/
		        System.out.println("Texto Original: \n" + texto);
		        System.out.println("\nTraduccion: \n" + traduccion);
		        System.out.println("\nDiccionario ordenado:");
		        diccionario.InOrder();
	        }
	        else {
	        	System.out.println("El diccionario esta vacio.");
	        	scanner.close();
	        	input.close();
	        }
		}
		catch (Exception e){
			System.out.println("Error: " + e.toString());
		}
	}
}