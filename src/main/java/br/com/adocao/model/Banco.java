package br.com.adocao.model;

import java.util.ArrayList;
import java.util.List;

public class Banco {

	private static List<Pet> lista = new ArrayList();

	public void adiciona(Pet pet) {
		Banco.lista.add(pet);
	}

	public static List<Pet> getLista() {
		return Banco.lista;
	}

}
