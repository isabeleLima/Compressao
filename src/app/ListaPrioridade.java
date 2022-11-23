package app;

import java.util.List;

public class ListaPrioridade {
	List<No> heap;

	public ListaPrioridade() {
	}

	public ListaPrioridade(List<No> lista) {
		this.heap = lista;
	}

	private int piso(double numero) {
		return (int) numero;
	}

	private void subir(int i, List<No> heap) {

		int pai;
		No aux;

		pai = piso((i - 1) / 2);

		if (pai >= 0 && heap.get(i).getFrequencia() < heap.get(pai).getFrequencia()) {

			aux = heap.get(i);
			heap.set(i, heap.get(pai));
			heap.set(pai, aux);

			subir(pai, heap);

		}

	}

	private void descer(int i, List<No> heap) {

		int filho;
		No aux;

		filho = 2 * i + 1;

		if (filho < size()) {

			if (filho < size() - 1) {

				if (heap.get(filho).getFrequencia() > heap.get(filho + 1).getFrequencia())
					filho++;

			}

			if (heap.get(filho).getFrequencia() < heap.get(i).getFrequencia()) {

				aux = heap.get(i);
				heap.set(i, heap.get(filho));
				heap.set(filho, aux);

				descer(filho, heap);
			}

		}

	}

	public void inserir(No novo) {

		if (size() == 0) {

			this.heap.add(novo);

		} else {

			this.heap.add(novo);

			subir(size() - 1, heap);
		}

	}

	public No remover() {

		No retirado;

		if (this.heap.size() != 0) {

			retirado = this.heap.get(0);

			this.heap.set(0, this.heap.get(size() - 1));
			this.heap.remove(size() - 1);

			descer(0, this.heap);

			return retirado;

		} else {

			return null;

		}

	}

	public int size() {
		return this.heap.size();
	}

}
