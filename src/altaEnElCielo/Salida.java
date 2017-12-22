package altaEnElCielo;

public class Salida {
	
	private int nroEscuelaDeMayorBandera; // Primer argumento de la primera linea de salida //
	private long longitudEscuelaDeMayorBandera; // Segundo argumento de la primera linea de salida //
	private long cantCosturasDeEscuelaDeMayorCantidadDeRetazos; // Argumento de segunda linea de salida //
	private int longitudDeRetazoSobranteEnElCarretel; // Argumento de tercera linea de salida //
	private long mayorLargoDeSubsecuenciaEnComun; // Primer argumento de cuarta linea de salida //
	private Integer[] parDeEscuela; // Segundo argumento de cuarta linea de salida //
	
	public Salida()
	{
		nroEscuelaDeMayorBandera=0;
		longitudEscuelaDeMayorBandera=0;
		cantCosturasDeEscuelaDeMayorCantidadDeRetazos=0;
		longitudDeRetazoSobranteEnElCarretel=0;
		mayorLargoDeSubsecuenciaEnComun=0;
		parDeEscuela[0]=0;
		parDeEscuela[1]=0;
	}

	public int getNroEscuelaDeMayorBandera() {
		return nroEscuelaDeMayorBandera;
	}

	public void setNroEscuelaDeMayorBandera(int nroEscuelaDeMayorBandera) {
		this.nroEscuelaDeMayorBandera = nroEscuelaDeMayorBandera;
	}

	public long getLongitudEscuelaDeMayorBandera() {
		return longitudEscuelaDeMayorBandera;
	}

	public void setLongitudEscuelaDeMayorBandera(long longitudEscuelaDeMayorBandera) {
		this.longitudEscuelaDeMayorBandera = longitudEscuelaDeMayorBandera;
	}

	public long getCantCosturasDeEscuelaDeMayorCantidadDeRetazos() {
		return cantCosturasDeEscuelaDeMayorCantidadDeRetazos;
	}

	public void setCantCosturasDeEscuelaDeMayorCantidadDeRetazos(long cantCosturasDeEscuelaDeMayorCantidadDeRetazos) {
		this.cantCosturasDeEscuelaDeMayorCantidadDeRetazos = cantCosturasDeEscuelaDeMayorCantidadDeRetazos;
	}

	public int getLongitudDeRetazoSobranteEnElCarretel() {
		return longitudDeRetazoSobranteEnElCarretel;
	}

	public void setLongitudDeRetazoSobranteEnElCarretel(int longitudDeRetazoSobranteEnElCarretel) {
		this.longitudDeRetazoSobranteEnElCarretel = longitudDeRetazoSobranteEnElCarretel;
	}

	public long getMayorLargoDeSubsecuenciaEnComun() {
		return mayorLargoDeSubsecuenciaEnComun;
	}

	public void setMayorLargoDeSubsecuenciaEnComun(long mayorLargoDeSubsecuenciaEnComun) {
		this.mayorLargoDeSubsecuenciaEnComun = mayorLargoDeSubsecuenciaEnComun;
	}

	public Integer[] getParDeEscuela() {
		return parDeEscuela;
	}

	public void setParDeEscuela(Integer[] parDeEscuela) {
		this.parDeEscuela = parDeEscuela;
	}
}
