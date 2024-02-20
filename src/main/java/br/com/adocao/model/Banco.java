package br.com.adocao.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {

	private static List<Pet> lista = new ArrayList<Pet>();
	private static Integer seqId = 100;

	public void adiciona(Pet pet) {
		pet.setId(seqId);
		Banco.lista.add(pet);
		Banco.seqId++;
	}

	public List<Pet> getLista() {
		return Banco.lista;
	}

	public void removePet(Integer id) {
		Iterator<Pet> iterator = lista.iterator();
		while (iterator.hasNext()) {
			Pet pet = iterator.next();
			if (pet.getId() == id) {
				iterator.remove();
				return;
			}
		}

	}

	public Pet buscarPet(Integer id) {
		Iterator<Pet> iterator = lista.iterator();
		while (iterator.hasNext()) {
			Pet pet = iterator.next();
			if (pet.getId() == id) {
				return pet;
			}
		}
		return null;
	}

}
