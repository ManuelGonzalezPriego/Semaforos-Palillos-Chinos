package Palillos;

import java.util.Arrays;

public class Filosofo {
	private String nombre;
	private int[] palillos;
	
	public Filosofo(String nombre) {
		this.nombre = nombre;
	}
	
	public int[] getPalillos() {
		return palillos;
	}

	public String getNombre() {
		return nombre;
	}
	
	
	public void setPalillos(int[] palillos) {
		this.palillos = palillos;
	}

	@Override
	public String toString() {
		return "Filosofo=" + nombre + " con los palillos=" + Arrays.toString(palillos) + ".";
	}
}
