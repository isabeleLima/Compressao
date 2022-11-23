package app;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		boolean iniciar = true;
		Scanner teclado = new Scanner(System.in);
		ArvoreHuffman huf = new ArvoreHuffman();

		while (iniciar) {
			System.out.println(" ");
			System.out.println("MENU");
			System.out.println("1- Comprimir Texto");
			System.out.println("0- Sair");

			int response = teclado.nextInt();

			switch (response) {
				case 1: {
					huf.raiz = null;
					System.out.println("Digite o texto");
					String string = teclado.next();
					char[] ch = huf.ReturnChar(string);
					int[] f = huf.ReturnFreq(string);
					
					huf.charToAscii(ch);
					huf.bytesTotal(string);
					huf.freq(ch, f);
					
					huf.ContruirArvore(ch.length, ch, f);
					huf.ListarCod(" ");
					
					System.out.println(" ");
					System.out.println("====================================");
					System.out.println("String coodificada");
					huf.coodificar(string);
					System.out.println(" ");
					System.out.println("====================================");
					System.out.print(" ");
					
					break;
				}
				default: {
					iniciar = false;
				}
			}
		}
	}

}
