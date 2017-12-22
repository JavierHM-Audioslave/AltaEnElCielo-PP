package altaEnElCielo;

import java.util.ArrayList;

public class SecuenciaEscuela {

	private ArrayList<Integer> escuela;
	
	public SecuenciaEscuela(int metros)
	{
		escuela=new ArrayList<Integer>(1);
		escuela.add(metros);
	}

	public ArrayList<Integer> getEscuela() {
		return escuela;
	}

	public void setEscuela(ArrayList<Integer> escuela) {
		this.escuela = escuela;
	}
	
	public long sumaDeSecuencia() // Metodo a usar para obtener la info de la salida del punto A. //
	{
		long suma=0;
		
		for(int i=0; i<escuela.size(); i++)
		{
			suma+=(long)escuela.get(i);
		}
		return suma; 
	}
	
	public int[] trocearNumero()
	{
		int nroATrocear=escuela.get(escuela.size()-1);
		int dividendo1, dividendo2, resto1, resto2;
		int[] devolucion=new int[3]; // Aca adentro voy a poner los numeros parseados de la ultima secuencia del objeto. //
		dividendo1=nroATrocear/100;
		resto1=nroATrocear%100;
		if(resto1!=0)
		{
			dividendo2=resto1/10;
			resto2=resto1%10;
			devolucion[0]=dividendo1;
			devolucion[1]=dividendo2;
			devolucion[2]=resto2;
			return devolucion;
		}
		else
		{
			devolucion[0]=dividendo1;
			devolucion[1]=0;
			devolucion[2]=0;
			return devolucion;
		}
	}
	
}
