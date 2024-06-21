package aplicacio;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import dades.*;

public class UsaLlistaNivellsAigua {
	static Scanner teclat = new Scanner(System.in);

	public static void main(String[] args) throws FileNotFoundException {
		
		System.out.println("Indica el número de línies a llegir del fitxer (màxim 78282)");
		int numLinies = Integer.parseInt(teclat.nextLine());
		
		String[] dataset = llegirLiniesFitxer(numLinies);
		String[] linia = null;		//inicialitzem la taula linia per després modificarl-li el valor
		String[] data = null;		//inicialitzem la taula data per després modificarl-li el valor
		//String[] poblacio = null;
		

		LlistaNivellsAigua ll = new LlistaNivellsAigua(numLinies);


		for(int i = 0;i<numLinies;i++){

			linia = dataset[i].split(",");
			data = linia[0].split("/");
			//poblacio = linia[1].split("[()]"); //el caràcter ( i el caràcter ) són especials, i per tant, s'ha d'indicar amb [] 
			
			//he sapigut separar la poblacio però no com posar-la a la 3 posicio del constructor NivellAigua
			Data d = new Data(Integer.parseInt(data[0]),Integer.parseInt(data[1]),Integer.parseInt(data[2]));
		
			NivellAigua niv = new NivellAigua(d, linia[1], linia[1], linia[2],
			Double.parseDouble(linia[3]), Double.parseDouble(linia[4]), Double.parseDouble(linia[5]));

			ll.afegir(niv);
			
		}

		Data altraData = new Data(Integer.parseInt(data[0]),Integer.parseInt(data[1]),Integer.parseInt(data[2]));
		
		NivellAigua nivell = new NivellAigua(altraData, linia[1], linia[1], linia[2],
		Double.parseDouble(linia[3]), Double.parseDouble(linia[4]), Double.parseDouble(linia[5]));


		
		int opcio = 0;
		
		do{

			System.out.println("\n---------MENU OPCIONS---------");
			System.out.println("\n1. Mostrar el conjunt de nivells d'aigua de la llista.");
			System.out.println("2. Mostrar el nivell d'aigua d'una provincia entre dues dates.");
			System.out.println("3. Consultar les dades del primer nivell d'aigua d'un embassament concret.");
			System.out.println("4. Consultar les dades del nivell d'aigua amb més percentatge de volum dels embassaments de cada provincia.");
			System.out.println("5. Consultar les dades del nivell d'aigua amb menys percentatge de volum de la llista.");
			System.out.println("6. Consultar els embassaments d'una certa provincia.");
			System.out.println("7. Consultar entre dos provincies quina ha tingut més volum d'aigua en un any.");
			System.out.println("8. Consultar les dades de nivells d'aigua en un periode de temps.");
			System.out.println("9. Eliminar els nivells d'aigua d'una provincia");
			System.out.println("10. Sortir del programa.");

			System.out.println("Indica una opcio:");
			opcio = Integer.parseInt(teclat.nextLine());	//quan llegeix un enter y després vol llegir un String (al case 3) no funciona bé, per tant
															//he optat per parsear la opcio que es un enter com si fos un String

			switch(opcio){

				case 1: 
						System.out.println(ll.toString());
						
						break;
				case 2:
						
						System.out.println(ll.consultaDadesTemps(new Data(1, 1, 2022),
															new Data(31,12,2022))
															.consultaDadesProvincia("Tarragona"));
						break;
				case 3: 
						
						System.out.println("Indica el nom del embassament: ");
						linia[1] = teclat.nextLine();
						
						System.out.println(ll.retornaPrimeraMesura(linia[1]).getDataMesura());
						
						break;
				case 4: 

					/* 
					if (nivell.getProvincia() == "Barcelona"){
						int NumeroMesGran = trobarNumeroMesGran(consultaDadesProvincia);
							System.out.println(ll.getMesPercentatgeVolum(trobarNumeroMesGran));
						}
						if (nivell.getProvincia() == "Tarragona"){
							int NumeroMesGran = trobarNumeroMesGran(consultaDadesProvincia);
							System.out.println(ll.getMesPercentatgeVolum(trobarNumeroMesGran));
							

						}
						if (nivell.getProvincia() == "Lleida"){
							int NumeroMesGran = trobarNumeroMesGran(consultaDadesProvincia);
							System.out.println(ll.getMesPercentatgeVolum(trobarNumeroMesGran));
							
						}
						if (nivell.getProvincia() == "Girona"){
							int NumeroMesGran = trobarNumeroMesGran(consultaDadesProvincia);
							System.out.println(ll.getMesPercentatgeVolum(trobarNumeroMesGran));
							
						}
					*/
						//no hem aconseguit implementar-ho
						/* 
						if (nivell.getProvincia() == "Barcelona"){

							System.out.println(ll.getMesPercentatgeVolum());
						}
						if (nivell.getProvincia() == "Tarragona"){
							System.out.println(ll.getMesPercentatgeVolum());

						}
						if (nivell.getProvincia() == "Lleida"){
							System.out.println(ll.getMesPercentatgeVolum());
							
						}
						if (nivell.getProvincia() == "Girona"){
							System.out.println(ll.getMesPercentatgeVolum());
							
						}
						*/

						System.out.println(ll.consultaDadesProvincia("Girona").getMesPercentatgeVolum().getNomEmbassament());
						
				break;
				case 5: 
						System.out.println(ll.getMenysPercentatgeVolum());
						
				break;
				case 6: 
						System.out.println(ll.consultaDadesProvincia("Lleida"));
						
						break;
				case 7: 
						//no funciona bé del tot
						System.out.println("Indica l'any: ");
						data[2] = Integer.toString(teclat.nextInt());
						teclat.nextLine(); 
						
						System.out.println("Indica la primera provincia: ");
						linia[2] = teclat.nextLine();
						System.out.println();
						
						System.out.println("Indica la segona provincia: ");
						linia[2] = teclat.nextLine();
						
						

						
						
						break;
				case 8: 
						System.out.println(ll.consultaDadesTemps(new Data(1,1,2022), new Data(31, 12, 2022)));
						
						break;
				case 9: 
						//no funciona bé del tot
						
						//System.out.println("Indica la provincia: ");
						//linia[2] = teclat.nextLine();
						
						System.out.println(ll.consultaDadesProvincia("Barcelona"));
						
						ll.eliminaMesures(nivell.getNomEmbassament());

						System.out.println(ll.consultaDadesProvincia("Barcelona"));
						
				break;
				case 10:
						break;
			}

		}while(opcio!=10);

		teclat.close();
		
	}

	private static String[] llegirLiniesFitxer(int nLinies) throws FileNotFoundException {
		String[] result;
		if (nLinies < 0)
			nLinies = 0;
		if (nLinies > 78282)
			nLinies = 78282;
		result = new String[nLinies];
		Scanner f = new Scanner(new File("Quantitat_aigua_embassaments_20231025.csv"));

		String capcalera = f.nextLine();
		System.out.println("El format de les dades en cada línia és el següent\n" + capcalera);
		for (int i = 0; i < nLinies; i++) {
			result[i] = f.nextLine();
		}
		f.close();
		return result;
	}

}