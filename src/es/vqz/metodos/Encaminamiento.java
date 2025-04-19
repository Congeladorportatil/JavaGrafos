package es.vqz.metodos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


import es.vqz.modelo.*;

public class Encaminamiento {
	Map<Integer, Integer> predecesores; // nodo y lista de predecesores
	Set<Integer> visitados;
	Set<Enlace> pendientes;
	Set<Integer> nodos;
	GrafoDirigido Grafo;
	Map<Integer, Integer> distancias;
	int origen;
	
	public Encaminamiento(GrafoDirigido G, int nodo) {
		origen = nodo;
		predecesores = new HashMap<>();
		visitados = new HashSet<>();
		this.Grafo = G;
		nodos = new HashSet<>(Grafo.getNodos());
		distancias = new HashMap<>();
		distancias.put(nodo, 0);
		visitados.add(nodo);
		recorrer(nodo,0,distancias);
	}
	
	private void recorrer(int nodo, int distancia, Map<Integer, Integer> distancias) {
		List<Enlace> hijos = Grafo.getHijos(nodo);
		for (Enlace e : hijos) {
			int destino = e.Destino();
			int nuevaDistancia = distancia + e.Peso();
			
			if (!visitados.contains(destino)) {
				if (!distancias.containsKey(destino)) {
					distancias.put(destino, distancia+e.Peso());
					this.predecesores.put(destino, nodo);
				}
				if (nuevaDistancia < distancias.get(destino)) {
					distancias.put(destino, nuevaDistancia);
					this.predecesores.put( destino, nodo);
				}
				visitados.add(destino);
				recorrer(e.Destino(), nuevaDistancia, distancias);
			} 
		}
	}
	
	public int distanciaA(int destino) throws Exception {
		if (!Grafo.validar(destino))
			throw new Exception("El nodo destino no se encuentra en grafo");
		return distancias.get(destino);
	}
	
	public List<Integer> caminoHacia(int destino) throws Exception {
		if (!Grafo.validar(destino))
			throw new Exception("El nodo destino no se encuentra en grafo");
		List<Integer> lista = new ArrayList<>();
		construirCamino(predecesores, lista, destino, this.origen);
		lista.add(predecesores.get(destino));
		return (lista);
	}
	
	private void construirCamino(Map<Integer, Integer> predecesores, List<Integer> lista, int nodo, int origen) {
		lista.add(nodo);
		if (nodo != this.origen) {
			int anterior = predecesores.get(nodo);
			lista.add(anterior);
			construirCamino(predecesores, lista, anterior, origen);
		} else {
			lista.add(origen);
		}
		
	}
	
	public static void main (String args[]) throws Exception {
		GrafoDirigido G = new GrafoDirigido();
		Enlace e1 = new Enlace(0,1);
		Enlace e2 = new Enlace(1,2);
		Enlace e3 = new Enlace(0,3);
		Enlace e4 = new Enlace(3,4);
		G.añadirEnlace(e1);
		G.añadirEnlace(e2);
		G.añadirEnlace(e3);
		G.añadirEnlace(e4);
		
		Encaminamiento d = new Encaminamiento(G, 0);
		System.out.println(G);
		System.out.println(d.distanciaA(4));
		System.out.println(d.caminoHacia(4));
	}}
