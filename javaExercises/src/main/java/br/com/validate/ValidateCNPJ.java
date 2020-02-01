package br.com.validate;


import java.text.ParseException;
import java.util.Scanner;
import javax.swing.text.MaskFormatter;

import br.com.caelum.stella.validation.CNPJValidator;
import br.com.caelum.stella.validation.InvalidStateException;

/**
 * 
 * @author Luizg
 * 1) Validate CNPJ Format (Mask)  
 *  
 * 2) Validate CNPJ Digits 
 * 
 */

public class ValidateCNPJ {
	
	
	public static int CNPJ_FORMATTED = 18;
	
	public static int CNPJ_ONLY_NUMBERS = 14;

	public static void main(String[] args) {
		
		Scanner ler = new Scanner(System.in);
		String cnpj;
        
		System.out.println("Informe um CNPJ:");
		//Taking value from the user
		cnpj = ler.next();
		CNPJValidator cnpjValidator = new CNPJValidator();

		try {
			MaskFormatter mask = null;

			if(cnpj.length() == CNPJ_FORMATTED){
				mask = new MaskFormatter("##.###.###/###1-##");
			} else if(cnpj.length() == CNPJ_ONLY_NUMBERS){
				mask = new MaskFormatter("###########1##");	
			}
			else {
				System.out.println("CNPJ Inválido");
				return;
			}
			//library for cnpj validation
			cnpjValidator.assertValid(cnpj);
			System.out.println("CNPJ Válido: " + mask.valueToString(cnpj));

		} catch (ParseException ex) {
			System.out.println("CNPJ Inválido");
		} catch (InvalidStateException ex) {
			System.out.println("CNPJ Inválido");
		}
	} 

}




