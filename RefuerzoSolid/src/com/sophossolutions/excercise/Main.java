package com.sophossolutions.excercise;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) throws CloneNotSupportedException {
		menu();
	}

	public static void menu()throws CloneNotSupportedException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Bienvenido a la maquina de cafe de manuel");
		IMaquina maquinaCafe = new Maquina();

		ArrayList<Cafe> cafesCliente = new ArrayList<>();
		 Map<String,Integer> cafesClienteMap = new TreeMap<>();
		int opcion = 0;
		do {
			System.out.println("Que cafe desea?");
			int indice = 1;
			for (Cafe cafe : maquinaCafe.ObtenerCafes()) {
				System.out.println(indice + ". " + cafe.toString2());
				indice++;
			}
			System.out.println("-1. Salir");
			opcion = sc.nextInt();
			if (opcion == -1)
				break;
			Cafe cafeActual = (Cafe) maquinaCafe.ObtenerCafes().get(opcion - 1).clone();
			maquinaCafe.prepararCafe();
			System.out.println("Que adicion le gustaria agregar?");
			indice = 1;
			System.out.println("0. Ninguno");
			for (Adicion adicion : maquinaCafe.obtenerAdicionales()) {
				System.out.println(indice + ". " + adicion.getStrNombre());
				indice++;
			}

			opcion = sc.nextInt();
			maquinaCafe.agregarAdicionalAlCafe(cafeActual, opcion - 1);
			System.out.println("Desea consumirlo en el momento?");
			System.out.println("1. Si");
			System.out.println("2. No");
			opcion = sc.nextInt();
			if(opcion==1) {cafeActual.consumir();}
			cafesCliente.add(cafeActual);
			if(cafesClienteMap.containsKey(cafeActual.toString())) {

				cafesClienteMap.put(cafeActual.toString(),(cafesClienteMap.get(cafeActual.toString())+1));
			}else {cafesClienteMap.put(cafeActual.toString(),1);}

		} while (true);
		System.out.println("----LISTADO TOTAL DE CAFE PREPARADOS----");
		int indice =1;
		for (Map.Entry<String, Integer> entry : cafesClienteMap.entrySet()) {
			String key = entry.getKey();
			Integer val = entry.getValue();
			System.out.println(key+" "+cafesClienteMap.get(key));
			
		}

	}
}