package altaEnElCielo;

import java.io.*;
import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		
		File archEnt;
		FileReader fr;
		BufferedReader br;
		File archSal;
		FileWriter fw;
		PrintWriter pw;
		SecuenciaEscuela[] arrayDeEscuelas;
		long largoCarretel; // Es T //
		int cantEscuelas; // Es E //
		int noCambios=0;
		 
		try
		{
			archEnt=new File(JOptionPane.showInputDialog("Ingrese el path completo del archivo de entrada"));
			fr=new FileReader(archEnt);
			br=new BufferedReader(fr);
			String[] primerLinea=new String[2];
			primerLinea=br.readLine().split(" ");
			largoCarretel=Long.parseLong(primerLinea[0]);
			cantEscuelas=Integer.parseInt(primerLinea[1]);
			arrayDeEscuelas=new SecuenciaEscuela[cantEscuelas];
			for(int i=0; i<cantEscuelas; i++)
			{
				arrayDeEscuelas[i]=new SecuenciaEscuela(Integer.parseInt(br.readLine()));
				largoCarretel-=(long)arrayDeEscuelas[i].getEscuela().get(0);
				if(largoCarretel<0)
				{
					System.out.println("El largo del carretel es menor a la suma de retazos iniciales pedidos por las escuelas.'\nSe cancela la ejecucion del programa.");
					fr.close();
					br.close();
					System.exit(1);
				}
			}
			
			fr.close();
			br.close();
			
			int tamDeUltimoNumeroDeSecuencia, j=0, largoDeNuevoRetazo;
			int[] troceado=new int[3];
			
			while(largoCarretel>0 && noCambios<arrayDeEscuelas.length)
			{
				tamDeUltimoNumeroDeSecuencia=arrayDeEscuelas[j].getEscuela().get(arrayDeEscuelas[j].getEscuela().size()-1);
				troceado=arrayDeEscuelas[j].trocearNumero();
				largoDeNuevoRetazo=tamDeUltimoNumeroDeSecuencia+troceado[0]+troceado[1]+troceado[2];
				if(largoDeNuevoRetazo<=largoCarretel)
				{
					largoCarretel-=largoDeNuevoRetazo;
					arrayDeEscuelas[j].getEscuela().add(largoDeNuevoRetazo);
					noCambios=0;
				}
				else
				{
					noCambios++;
				}
				j++;
				if(j==cantEscuelas)
				{
					j=0;
				}
			}
			
			// Hasta aca, lo que hice fue llenar el array de objetos SecuenciaEscuela para cada secuencia de escuela. //
			// Lo que resta (que es por donde tengo que continuar) es generar el archivo de salida con la informacion contenida en lo aclarado en el renglon de arriba. //
			// RESUMEN: Quedan hacer los metodos para resolver la segunda, tercera y cuarta linea del archivo de salida. //
			
			long banderaMasExtensa=0, sumaAux;
			int numeroEscuelaDeBanderaMasExtensa=0; //GRABAR EN ARCHIVO, primera linea: numeroEscuelaDeBanderaMasExtensa y banderaMasExtensa. //
			
			for(int z=0; z<arrayDeEscuelas.length; z++)
			{
				sumaAux=0;
				for(int retazo : arrayDeEscuelas[z].getEscuela())
				{
					sumaAux+=retazo;
				}
				if(sumaAux>banderaMasExtensa)
				{
					banderaMasExtensa=sumaAux;
					numeroEscuelaDeBanderaMasExtensa=z+1;
				}					
			}
			
			long mayorCantDeCosturas=0;	// GRABAR EN ARCHIVO, segunda linea: mayorCantDeCosturas. //
			
			for(int z=0; z<arrayDeEscuelas.length; z++)
			{
				sumaAux=0;
				sumaAux=arrayDeEscuelas[z].getEscuela().size()-1;
				if(sumaAux>mayorCantDeCosturas)
				{
					mayorCantDeCosturas=sumaAux;
				}
			}
			
			// GRABAR EN ARCHIVO, tercera linea: largoCarretel. //
			
			int y,z,numeroAux1, numeroAux2, nroEscuela1=0, nroEscuela2=0, cotaInf, cotaSup, aux, i; // GRABAR EN ARCHIVO, cuarta linea: Mayor largo de subsecuencia en comun. //
			long pivotePosta, pivoteAuxiliar, maxSubsecuencia=0, auxMaxSubsecuencia, posPivotePosta, posPivoteAuxiliar, auxaux, auxauxaux;
			
			for(z=0; z<arrayDeEscuelas.length; z++)
			{
				i=0;
				auxaux=0;
				for(int o:arrayDeEscuelas[z].getEscuela())
				{
					posPivotePosta=auxaux;
					if(z!=i)
					{
						auxauxaux=0;
						for(int oo:arrayDeEscuelas[i].getEscuela())
						{
							posPivoteAuxiliar=auxauxaux;
							auxMaxSubsecuencia=0;
							auxMaxSubsecuencia++;
							posPivotePosta++;
							while(posPivotePosta<arrayDeEscuelas[z].getEscuela().size() && posPivoteAuxiliar<arrayDeEscuelas[i].getEscuela().size() && (arrayDeEscuelas[z].getEscuela().get((int) posPivotePosta)==arrayDeEscuelas[i].getEscuela().get((int) posPivoteAuxiliar)))
							{
								auxMaxSubsecuencia++;
								posPivotePosta++;
								posPivoteAuxiliar++;
							}
							if(auxMaxSubsecuencia>maxSubsecuencia)
							{
								maxSubsecuencia=auxMaxSubsecuencia;
								nroEscuela1=z;
								nroEscuela2=i;
							}
						auxauxaux++;
					}
					i++;
				}
				auxaux++;
				}				
			}	
			
			archSal=new File(JOptionPane.showInputDialog("Ingrese la ruta de salida del archivo."));
			fw=new FileWriter(archSal);
			pw=new PrintWriter(fw);
			pw.println(numeroEscuelaDeBanderaMasExtensa+" "+banderaMasExtensa);
			pw.println(mayorCantDeCosturas);
			pw.println(largoCarretel);
			pw.println(maxSubsecuencia+" "+nroEscuela1+" "+nroEscuela2);
			fr.close();
			br.close();
			fw.close();
			pw.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.exit(1);
		}
	}
}