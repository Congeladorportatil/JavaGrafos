package es.vzq.modelos.Dirigidos.EnlaceNodoDirigido;

import java.util.*;


public class Nodo {

	int valor;
	Set<EnlaceDirigido> enlaces;
	
	public Nodo(int valor) {
		this.valor = valor;
		enlaces = new HashSet<EnlaceDirigido>();
	}
	
	public void addEnlace(EnlaceDirigido e)  {
		enlaces.add(e);
	}
	
	public void addEnlace(Nodo destino) {
		EnlaceDirigido e = new EnlaceDirigido(this, destino);
		enlaces.add(e);
	}

	@Override
	public int hashCode() {
		return Objects.hash(valor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nodo other = (Nodo) obj;
		return valor == other.valor;
	}

	@Override
	public String toString() {
		return "Nodo [valor=" + valor + "]";
	}
	
	public static void main(String args[]) {
		
	}
}
