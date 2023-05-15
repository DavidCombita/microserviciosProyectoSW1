package com.proyectosw1.inventario.utils;

public class CalculatorTattoHelper {

	  public static double getCalculatorTatto(String size, String style) {
	    // Definir los precios iniciales para cada tamaño
	    double size2x2 = 50;
	    double size3x3 = 80;
	    double size4x4 = 110;
	    double size5x5 = 140;
	    double size6x6 = 170;
	    double antebrazo = 200;
	    double pectoral = 250;
	    double mediaManga = 300;
	    double manga = 400;
	    double pierna = 450;
	    double pantorrilla = 500;
	    double espalda = 550;
	    // Definir los precios adicionales para cada estilo
	    double blackWork = 50;
	    double lettering = 75;
	    double triba = 100;
	    double minimalista = 125;
	    double tradicional = 150;
	    double neoTradicional = 175;
	    double color = 200;
	    double ignorant = 225;
	    // Definir la variable para el precio final
	    double finalPrice = 0;
	    // Calcular el precio inicial según el tamaño
	    if (size.equals("2x2")) {
	      finalPrice = size2x2;
	    } else if (size.equals("3x3")) {
	      finalPrice = size3x3;
	    } else if (size.equals("4x4")) {
	      finalPrice = size4x4;
	    } else if (size.equals("5x5")) {
	      finalPrice = size5x5;
	    } else if (size.equals("6x6")) {
	      finalPrice = size6x6;
	    } else if (size.equals("antebrazo")) {
	      finalPrice = antebrazo;
	    } else if (size.equals("pectoral")) {
	      finalPrice = pectoral;
	    } else if (size.equals("media manga")) {
	      finalPrice = mediaManga;
	    } else if (size.equals("manga")) {
	      finalPrice = manga;
	    } else if (size.equals("pierna")) {
	      finalPrice = pierna;
	    } else if (size.equals("pantorrilla")) {
	      finalPrice = pantorrilla;
	    } else if (size.equals("espalda")) {
	      finalPrice = espalda;
	    }
	    // Calcular el precio adicional según el estilo
	    if (style.equals("negro y gris")) {
	      finalPrice += blackWork;
	    } else if (style.equals("blackWork")) {
	      finalPrice += lettering;
	    } else if (style.equals("Lettering")) {
	      finalPrice += triba;
	    } else if (style.equals("triba")) {
	      finalPrice += minimalista;
	    } else if (style.equals("minimalista")) {
	      finalPrice += tradicional;
	    } else if (style.equals("tradicional")) {
	      finalPrice += neoTradicional;
	    } else if (style.equals("neoTradicional")) {
	      finalPrice += color;
	    } else if (style.equals("color")) {
	      finalPrice += ignorant;
	    }
	    // Imprimir el precio final
	    System.out.println("El precio de su tatuaje es: " + finalPrice);
        return finalPrice;
	  }
}
