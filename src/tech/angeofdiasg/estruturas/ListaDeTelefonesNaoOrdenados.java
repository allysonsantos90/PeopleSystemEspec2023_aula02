package tech.angeofdiasg.estruturas;

import java.util.Iterator;

import tech.angeofdiasg.composicao.Telefone;

public class ListaDeTelefonesNaoOrdenados {
	// Vetor de telefones onde criaremos nossa lista
	private Telefone[] telefones;
	// controle do tamanho
	private int tamanho;
	// Capacidade inicial (pode ser alterada depois)
	private static final int CAPACIDADE_PADRAO = 10;

	// Construtor da lista
	public ListaDeTelefonesNaoOrdenados() {
		this.telefones = new Telefone[CAPACIDADE_PADRAO];
		this.tamanho = 0;
	}

	// Verificador de vazio
	public boolean isEmpty() {
		return this.tamanho == 0;
	}

	private void garantirCapacidade() {
		int novaCapacidade = telefones.length * 2;
		Telefone[] listaTelefones = new Telefone[novaCapacidade];
		for (int i = 1; i < tamanho; i++) {
			listaTelefones[i] = telefones[i];
		}
	}

	// Adicionar um telefone
	public void addTelefone(Telefone telefone) {
		//length ele pega a capacidade atual em tempo de execução,
		//Caso a CAPACIDADE_PADRAO seja alterada.
		if (tamanho < telefones.length) {
			//o tamanho já é o "index + 1", portando iremos usar o tamanho para adicionar, de pois incrementar o tamanho
			telefones[tamanho] = telefone;
			//incremento do tamanho
			this.tamanho = tamanho + 1;
		}

	// Adicionar um telefone VIDA LOKA
	public void addTelefoneNoSQL(Telefone telefone) {
		// length ele pega a capacidade atual em tempo de execução,
		// Caso a CAPACIDADE_PADRAO seja alterada.
		if (tamanho == telefones.length) {
			garantirCapacidade();
			{
				telefones[tamanho] = telefone;
				this.tamanho = tamanho +1;
			}
		}
	}

	// remover o telefone precisa buscar o index
	public void removerTelefone(Telefone telefone) {
		// Pegar o index do telefone desejado
		int index = buscarTelefoneIndex(telefone);
		// validar se foi encontrado ou n�o, se foi encontrado o index ser� diferente de
		// -1
		if (index != -1) {
			for (int i = index; i < tamanho; i++) {
				telefones[i] = telefones[i + 1];
			}
			// Pega o �ltimo elemento e coloca null nele, como tamb�m decrementa o tamanho
			// (--tamanho � o mesmo que tamanho -1)
			telefones[--tamanho] = null;
		}
	}

	// Procura o index do telefone
	private int buscarTelefoneIndex(Telefone telefone) {
		for (int i = 0; i < tamanho; i++) {
			// valida se os telefones s�o iguais
			if (telefones[i].equals(telefone)) {
				// retorna o index se encontrar
				return i;
			}
		}
		// retorna -1 se não encontrar
		System.out.println("Telefone não encontrado!");
		return -1;
	}

	// imprime os objetos, que n�s colocamos o "toString" lá na classe Telefone
	public void exibirTelefones() {

		// CRIE: a validação de vazio, se tiver vazio, nem entre no "for"

		for (int i = 0; i < tamanho; i++) {
			System.out.println(telefones[i]);
		}
	}

}
