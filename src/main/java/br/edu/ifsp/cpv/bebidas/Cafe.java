package br.edu.ifsp.cpv.bebidas;

import javax.persistence.Entity;

@Entity
public class Cafe extends Bebida {
	
	private boolean leite;
	
	private boolean gelado;
	
	public Cafe() {
		super();
	}

	public Cafe(String nome, double preco, boolean leite, boolean gelado) {
		super(nome, preco);
		this.leite = leite;
		this.gelado = gelado;
	}

	public boolean isLeite() {
		return leite;
	}

	public void setLeite(boolean leite) {
		this.leite = leite;
	}

	public boolean isGelado() {
		return gelado;
	}

	public void setGelado(boolean gelado) {
		this.gelado = gelado;
	}

}
