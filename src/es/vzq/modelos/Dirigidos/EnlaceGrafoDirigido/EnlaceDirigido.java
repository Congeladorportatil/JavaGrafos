package es.vzq.modelos.Dirigidos.EnlaceGrafoDirigido;

import java.util.Objects;

/*
 * 
 * @author Víctor Vázquez González
 */


public class EnlaceDirigido {
	
	int codOrigen;
	int codDestino;
	int peso;
	
	
	public EnlaceDirigido (int codOrigen, int codDestino, int peso) {
		this.codOrigen = codOrigen;
		this.codDestino = codDestino;
		this.peso = peso;
	}
	
	public EnlaceDirigido (int codOrigen, int codDestino) {
		this(codOrigen, codDestino, 1);
	}
	
	public int Origen() {
		return codOrigen;
	}
	
	public int Destino() {
		return codDestino;
	}
	
	public int Peso() {
		return peso;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codDestino, codOrigen, peso);
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
		return codDestino == other.codDestino && codOrigen == other.codOrigen && peso == other.peso;
	}

	@Override
	public String toString() {
		return "Enlace [codOrigen=" + codOrigen + ", codDestino=" + codDestino + ", peso=" + peso + "]";
	}
	
	
}
