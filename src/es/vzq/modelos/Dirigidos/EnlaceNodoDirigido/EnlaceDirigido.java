package es.vzq.modelos.Dirigidos.EnlaceNodoDirigido;

import java.util.Objects;

/*
 * 
 * @author Víctor Vázquez González
 */


public class EnlaceDirigido {
	
	Nodo origen;
	Nodo destino;
	int peso;
	
	
	public EnlaceDirigido (Nodo origen, Nodo destino, int peso) {
		this.origen = origen;
		this.destino = destino;
		this.peso = peso;
	}
	
	public EnlaceDirigido (Nodo origen, Nodo destino) {
		this(origen, destino, 1);
	}
	
	public Nodo Origen() {
		return origen;
	}
	
	public Nodo Destino() {
		return destino;
	}
	
	public int Peso() {
		return peso;
	}

	@Override
	public int hashCode() {
		return Objects.hash(destino, origen);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EnlaceDirigido other = (EnlaceDirigido) obj;
		return Objects.equals(destino, other.destino) && Objects.equals(origen, other.origen);
	}

	@Override
	public String toString() {
		return "EnlaceDirigido [origen=" + origen + ", destino=" + destino + ", peso=" + peso + "]";
	}

	
	
	
}
