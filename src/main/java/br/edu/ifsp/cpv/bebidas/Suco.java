package br.edu.ifsp.cpv.bebidas;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;

@Entity
public class Suco extends Bebida {
	
	@ElementCollection
	private List<String> frutas;
	
	private boolean leite;
	
	public Suco() {
		super();
	}

	public Suco(String nome, double preco, boolean leite, List<String> frutas) {
		super(nome, preco);
		this.leite = leite;
		this.frutas = new ArrayList<>();
		this.frutas.addAll(frutas);
	}

	public List<String> getFrutas() {
		return frutas;
	}

	public void setFrutas(List<String> frutas) {
		this.frutas = frutas;
	}

	public boolean isLeite() {
		return leite;
	}

	public void setLeite(boolean leite) {
		this.leite = leite;
	}

}
