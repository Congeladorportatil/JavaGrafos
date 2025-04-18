package es.vqz.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Encaminamiento {
	Map<Integer, Integer> predecesores;
	Set<Integer> visitados;
	Set<Enlace> pendientes;
	Set<Integer> nodos;
	GrafoDirigido Grafo;
	Map<Integer, Integer> distancias = new HashMap<>();
	
	public Encaminamiento(GrafoDirigido G) {
	predecesores = new HashMap<>();
	visitados = new HashSet<>();
	this.Grafo = G;
	nodos = new HashSet<>(Grafo.getNodos());
	}

public List<Integer> CaminoMasCercano(int i1, int i2) {
	List<Integer> lista = new ArrayList<>();
	if (!nodos.contains(i1) || !nodos.contains(i2))
		return lista;
	recorrer(i1,0);
	return lista;
}

private void recorrer(int nodo, int distancia) {
	List<Enlace> hijos = Grafo.getHijos(nodo);
	
	for (Enlace e : hijos) {
		recorrer(e.Destino(), distancia + e.peso);
	}
	
}

}
