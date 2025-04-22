package es.vzq.modelos.Dirigidos.EnlaceGrafoDirigido;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import es.vzq.modelos.Dirigidos.*;

public class Metodos {
	Map<Integer, List<Integer>> predecesores; // nodo y lista de predecesores
	Set<Integer> visitados;
	Set<EnlaceDirigido> pendientes;
	Set<Integer> nodos;
	GrafoDirigido Grafo;
	Map<Integer, Integer> distancias;
	int origen;

	public Metodos(GrafoDirigido G, int nodo) {
		origen = nodo;
		predecesores = new HashMap<>();
		visitados = new HashSet<>();
		this.Grafo = G;
		nodos = new HashSet<>(Grafo.getNodos());
		distancias = new HashMap<>();
		distancias.put(nodo, 0);
		visitados.add(nodo);
		recorrer(nodo, 0, distancias);
	}

	private void recorrer(int nodo, int distancia, Map<Integer, Integer> distancias) {
		List<EnlaceDirigido> hijos = Grafo.getHijos(nodo);
		for (EnlaceDirigido e : hijos) {
			int destino = e.Destino();
			int nuevaDistancia = distancia + e.Peso();

			if (!visitados.contains(destino)) {
				if (!distancias.containsKey(destino) || nuevaDistancia < distancias.get(destino)) {
					distancias.put(destino, nuevaDistancia);
					List<Integer> lista = new ArrayList<>();
					lista.add(0);
					predecesores.put(0, lista);
					actualizarPredecesores(predecesores, destino, nodo);
				}
				/*
				 * if (nuevaDistancia < distancias.get(destino)) { distancias.put(destino,
				 * nuevaDistancia); actualizarPredecesores(predecesores, destino, nodo); }
				 */
				visitados.add(destino);
				recorrer(e.Destino(), nuevaDistancia, distancias);
			}
		}
	}

	private void actualizarPredecesores(Map<Integer, List<Integer>> predecesores, int destino, int nodo) {
		List<Integer> lista;
		if (predecesores.containsKey(nodo)) {
			lista = new ArrayList<>(predecesores.get(nodo));
		} else 
			lista = new ArrayList<>();
		List<Integer> ret = new ArrayList<>();
		ret.add(destino);
		ret.addAll(lista);
		if (predecesores.containsKey(destino)) {
			
			for (Integer i : predecesores.get(destino)) {
				lista.add(i);
				if (i == nodo) {
					break;
				}
			}
			ret.add(nodo);
		}
		predecesores.put(destino, ret);
	}

	public int distanciaA(int destino) throws Exception {
		if (!Grafo.validar(destino))
			throw new Exception("El nodo destino no se encuentra en grafo");
		return distancias.get(destino);
	}

	public List<Integer> caminoHacia(int destino) throws Exception {
		if (!Grafo.validar(destino))
			throw new Exception("El nodo destino no se encuentra en grafo");
		//List<Integer> lista = new ArrayList<>();
		//construirCamino(predecesores, lista, destino, this.origen);
		List<Integer> lista = new ArrayList<>(predecesores.get(destino));
		Collections.reverse(lista);
		return lista;
		//lista.add(predecesores.get(destino));
		//return (lista);
	}

	/*
	 * private void construirCamino(Map<Integer, Integer> predecesores,
	 * List<Integer> lista, int nodo, int origen) {
	 * 
	 * lista.add(nodo); if (nodo != this.origen) { int anterior =
	 * predecesores.get(nodo); lista.add(anterior); construirCamino(predecesores,
	 * lista, anterior, origen); } else { lista.add(origen); }
	 * 
	 * 
	 * return predecesore }
	 */

	public static void main(String args[]) throws Exception {
		GrafoDirigido G = new GrafoDirigido();
		EnlaceDirigido e1 = new EnlaceDirigido(0, 1);
		EnlaceDirigido e2 = new EnlaceDirigido(1, 2);
		EnlaceDirigido e3 = new EnlaceDirigido(2, 3);
		EnlaceDirigido e4 = new EnlaceDirigido(0, 4);
		G.añadirEnlace(e1);
		G.añadirEnlace(e2);
		G.añadirEnlace(e3);
		G.añadirEnlace(e4);

		Metodos mg = new Metodos(G, 0);
		System.out.println(G);
		System.out.println(mg.distanciaA(4));
		System.out.println(mg.caminoHacia(4));
	}

}
