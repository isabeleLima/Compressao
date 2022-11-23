package app;

import java.util.ArrayList;
import java.util.List;

public class ArvoreHuffman {
	No raiz;

	

	public char[] ReturnChar(String string) {
		int t = 0;
		boolean add = true;
		int[] frequencia = new int[string.length()];
		String def = "";

		for (int i = 0; i < string.length(); i++) {
			for (int j = 0; j < def.length(); j++) {

				if (string.charAt(i) == def.charAt(j)) {
					frequencia[j]++;
					add = false;
				}
			}
			if (add) {
				def = def + string.charAt(i);
				frequencia[t]++;
				t++;
			}
			add = true;
		}

		return def.toCharArray();
	}

	public int[] ReturnFreq(String string) {
		int t = 0;
		boolean add = true;
		int[] frequencia = new int[string.length()];
		String def = "";

		for (int i = 0; i < string.length(); i++) {
			for (int j = 0; j < def.length(); j++) {

				if (string.charAt(i) == def.charAt(j)) {
					frequencia[j]++;
					add = false;
				}
			}
			if (add) {
				def = def + string.charAt(i);
				frequencia[t]++;
				t++;
			}
			add = true;
		}

		return frequencia;
	}

	public void ContruirArvore(int n, char[] vetorDecaracteres, int[] vetorDeFrequencia) {
		List<No> lista = new ArrayList<>();
		ListaPrioridade heap = new ListaPrioridade(lista);
		No no;
		for (int i = 0; i < n; i++) {
			no = new No();

			no.setCarectere(vetorDecaracteres[i]);
			no.setFrequencia(vetorDeFrequencia[i]);
			no.setEsq(null);
			no.setDir(null);
			heap.inserir(no);
		}

		raiz = null;

		while (heap.size() > 1) {
			No x = heap.remover();
			No y = heap.remover();
			No z = new No();
			z.setFrequencia(x.getFrequencia() + y.getFrequencia());
			z.setCarectere('-');
			z.setEsq(x);
			z.setDir(y);
			raiz = z;
			heap.inserir(z);
		}

	}

	public void imprimirCodigo(No no, String s, char a) {
		if (no.getEsq() == null && no.getDir() == null) {
			if (no.getCarectere() == a) {
				System.out.print(s);

			}
			return;
		}
		imprimirCodigo(no.getEsq(), s + "0", a);
		imprimirCodigo(no.getDir(), s + "1", a);
	}

	public void coodificar(String s) {
		for (int i = 0; i < s.length(); i++) {
			imprimirCodigo(raiz, "", s.charAt(i));
		}
	}

	public void imprimirTabela(No no, String s) {
		if (no.getEsq() == null && no.getDir() == null) {
			System.out.println(no.getCarectere() + ":" + s);
			return;
		}
		imprimirTabela(no.getEsq(), s + "0");
		imprimirTabela(no.getDir(), s + "1");
	}

	public void charToAscii(char[] a) {
		System.out.println(" ");
		System.out.println("====================================");
		System.out.println("Exibindo os bits de cada caractere");
		for (int i = 0; i < a.length; i++) {
			int ascii = (int) a[i];
			System.out.println(a[i] + ":" + Integer.toBinaryString(ascii));
		}
		System.out.println("====================================");
		System.out.print(" ");
	}
	
	public void freq(char[] a, int[] f) {
		System.out.println(" ");
		System.out.println("====================================");
		System.out.println("Exibindo a frequencia de cada caracatere");
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i] + ":" + f[i]);
		}
		System.out.println("====================================");
		System.out.print(" ");
	}
	
	public void bytesTotal(String s) {
		System.out.println(" ");
		System.out.println("====================================");
		System.out.println("Numero de Bytes no total");
		System.out.println(s.getBytes().length * 8);
		System.out.println("====================================");
		System.out.print(" ");
	}
	
	public void ListarCod(String s) {
		System.out.println(" ");
		System.out.println("====================================");
		System.out.println("Coodificação de cada caractere");
		imprimirTabela(raiz, " ");
		System.out.println("====================================");
		System.out.print(" ");
	}
}
