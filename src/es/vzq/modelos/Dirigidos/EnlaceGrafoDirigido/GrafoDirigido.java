package es.vzq.modelos.Dirigidos.EnlaceGrafoDirigido;

import java.util.*;



public class GrafoDirigido {

	List<EnlaceDirigido> enlaces;
	Set<Integer> nodos;
	int nNodos;
	int nEnlaces;
	Map<Integer, List<EnlaceDirigido>> hijos;
	
	
	public GrafoDirigido(List<EnlaceDirigido> enlaces) {
		
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
		this(new ArrayList<EnlaceDirigido>());
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
	
	public List<EnlaceDirigido> getEnlaces() {
		return new ArrayList<EnlaceDirigido>(this.enlaces);
	}
	
	public List<Integer> getNodos() {
		return new ArrayList<Integer>(this.nodos);
	}

	public List<EnlaceDirigido> getHijos(int i) {
		return hijos.get(i);
	}
	
	public List<EnlaceDirigido> getSalidasDesde(int i) {
		
		List<EnlaceDirigido> salidas = new ArrayList<EnlaceDirigido>();
		for (EnlaceDirigido e : getHijos(i)) {
			if (e.Origen() == i) {
				salidas.add(e);
			}
		}
		return salidas;
	}
	
	public List<EnlaceDirigido> getEntradasA(int i) {
		List<EnlaceDirigido> llegadas = new ArrayList<EnlaceDirigido>();
		for (EnlaceDirigido e: getHijos(i)) {
			if (e.Destino() == i)
				llegadas.add(e);
		}
		return llegadas;
		
	}
	
	public void añadirEnlace(EnlaceDirigido e) {
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
		EnlaceDirigido e1 = new EnlaceDirigido(0,1);
		EnlaceDirigido e2 = new EnlaceDirigido(1,2);
		G.añadirEnlace(e1);
		G.añadirEnlace(e2);
		System.out.println(G.nodos);
		System.out.println(G.getHijos(1));
		System.out.println(G.getEntradasA(1));
		System.out.println(G.getSalidasDesde(1));
		
	}
	
	
}
