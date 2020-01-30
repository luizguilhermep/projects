
import java.lang.System.Logger;
import java.text.ParseException;
import java.util.Scanner;

import javax.swing.text.MaskFormatter;





public class Exercice1 {

	public static void main(String[] args) {
		//class to read from user
		Scanner ler = new Scanner(System.in);
		String cnpj;

		System.out.println("Informe um CNPJ:");
		cnpj = ler.next();


		try {
			MaskFormatter mask = null;

			if(cnpj.length() == 18){
				mask = new MaskFormatter("##.###.###/###1-##");
			} else if(cnpj.length() == 14){
				mask = new MaskFormatter("###########1##");	
			}
			else {
				System.out.println("CNPJ invalido");
				return;
			}
			System.out.println("CNPJ : " + mask.valueToString(cnpj));

		} catch (ParseException ex) {
			System.out.println("CNPJ invalido");
		}
	} 

} 




