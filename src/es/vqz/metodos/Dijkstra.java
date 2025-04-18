package es.vqz.metodos;

import java.util.*;
import es.vqz.modelo.*;

public class Dijkstra {
	
	Map<Integer, Integer> predecesores;
	Set<Integer> visitados;
	Set<Enlace> pendientes;
	Set<Integer> nodos;
	GrafoDirigido Grafo;
	
	public Dijkstra(GrafoDirigido G) {
		predecesores = new HashMap<>();
		visitados = new HashSet<>();
		this.Grafo = G;
		nodos = new HashSet<>(Grafo.getNodos());
	}
	
	public List<Integer> CaminoMasCercano(int i1, int i2) {
		Map<Integer, Integer> distancias = new HashMap<>();
		List<Integer> lista = new ArrayList<>();
		if (!nodos.contains(i1) || !nodos.contains(i2))
			return lista;
		recorrer(i1,0);
		return lista;
	}
	
	private void recorrer(int nodo, int distancia) {
		List<Enlace> hijos = Grafo.getHijos(nodo);
		
	}
	
}
