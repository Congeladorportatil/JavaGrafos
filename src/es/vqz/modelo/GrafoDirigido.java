package es.vqz.modelo;

import java.util.*;



public class GrafoDirigido {

	List<Enlace> enlaces;
	Set<Integer> nodos;
	int nNodos;
	int nEnlaces;
	Map<Integer, List<Enlace>> hijos;
	
	
	public GrafoDirigido(List<Enlace> enlaces) {
		
		hijos = new HashMap<>();
		nodos = new HashSet<>();
		if (enlaces == null)
			enlaces = new ArrayList<>();
		this.enlaces = enlaces;
		if (enlaces.size()>0) {
			for (int i = 0; i < enlaces.size(); i++) {
				añadirEnlace(enlaces.get(i));
			}
		}
		nNodos = nodos.size();
		nEnlaces = enlaces.size();
	}
	
	public GrafoDirigido() {
		this(new ArrayList<Enlace>());
	}
	
	public boolean validar(int nodo) {
		if (nodo < 0 || !nodos.contains(nodo))
			return false;
		return true;
	}
	
	public int nNodos() {
		return nNodos;
	}
	
	public int nEnlaces() {
		return nEnlaces;
	}
	
	public List<Enlace> getEnlaces() {
		return new ArrayList<Enlace>(this.enlaces);
	}
	
	public List<Integer> getNodos() {
		return new ArrayList<Integer>(this.nodos);
	}
	public List<Enlace> getHijos(int i) {
		return hijos.get(i);
	}
	
	public List<Enlace> getSalidasDesde(int i) {
		
		List<Enlace> salidas = new ArrayList<Enlace>();
		for (Enlace e : getHijos(i)) {
			if (e.Origen() == i) {
				salidas.add(e);
			}
		}
		return salidas;
	}
	
	public List<Enlace> getEntradasA(int i) {
		List<Enlace> llegadas = new ArrayList<Enlace>();
		for (Enlace e: getHijos(i)) {
			if (e.Destino() == i)
				llegadas.add(e);
		}
		return llegadas;
		
	}
	
	public void añadirEnlace(Enlace e) {
		int origen = e.Origen();
		int dest = e.Destino();
		
		
		nodos.add(origen);
		nodos.add(dest);
		
		if (!hijos.containsKey(origen))
			hijos.put(origen, new ArrayList<>());
		if (!hijos.containsKey(dest))
			hijos.put(dest, new ArrayList<>());
		
		hijos.get(origen).add(e);
		hijos.get(dest).add(e);
		
	}
	
	
	
	public static void main(String args[]) {
		GrafoDirigido G = new GrafoDirigido();
		Enlace e1 = new Enlace(0,1);
		Enlace e2 = new Enlace(1,2);
		G.añadirEnlace(e1);
		G.añadirEnlace(e2);
		System.out.println(G.nodos);
		System.out.println(G.getHijos(1));
		System.out.println(G.getEntradasA(1));
		System.out.println(G.getSalidasDesde(1));
		
	}
	
	
}
