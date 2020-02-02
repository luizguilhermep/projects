package br.com.rectangles;

import java.util.Scanner;
/**
 * 
 * @author luizg
 * 3) Test if two rectangles intersect 
 * Fonte: https://www.baeldung.com/java-check-if-two-rectangles-overlap
 */
public class IntersectRectangle {
	public static void main(String[] args) {
		try {
			
			Scanner ler = new Scanner(System.in);
			
			System.out.println("Informe o valor de x do ponto 1 do retangulo A:");
			int x1 = ler.nextInt();
			
			System.out.println("Informe o valor de y do ponto 1 do retangulo A:");
			int y1 = ler.nextInt();
			
			Point point1 = new Point(x1, y1);
			
			System.out.println("Informe o valor de x do ponto 2 do retangulo A:");
			int x2 = ler.nextInt();
			
			System.out.println("Informe o valor de y do ponto 2 do retangulo A:");
			int y2 = ler.nextInt();
			
			Point point2 = new Point(x2, y2);
			
			Rectangle r1 = new Rectangle(point1, point2);
			
			System.out.println("Informe o valor de x do ponto 1 do retangulo B:");
			int x3 = ler.nextInt();
			
			System.out.println("Informe o valor de y do ponto 1 do retangulo B:");
			int y3 = ler.nextInt();
			
			Point point3 = new Point(x3, y3);
			
			System.out.println("Informe o valor de x do ponto 2 do retangulo B:");
			int x4 = ler.nextInt();
			
			System.out.println("Informe o valor de y do ponto 2 do retangulo B:");
			int y4 = ler.nextInt();
			Point point4 = new Point(x4, y4);
			
			Rectangle r2 = new Rectangle(point3, point4);
			
			boolean isOverlaping = r1.isOverlapping(r2);
			System.out.println("A e B:" + isOverlaping);
			
			
			
		} catch (Exception e) {
			System.out.println("Valor Inválido");
		}
		
	}


}