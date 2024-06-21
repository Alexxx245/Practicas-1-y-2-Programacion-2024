package dades;

public class NivellAigua {
	private Data dataMesura;
	private String nomEmbassament;
	private String poblacio;
	private String provincia;
	private double nivell;
	private double percentatgeVolum;
	private double volum;
	
	/**Mètode constructor parametritzat
	 * @param dataMesura
	 * @param nomEmbassament
	 * @param poblacio
	 * @param provincia
	 * @param nivell
	 * @param percent
	 * @param volum
	 */
	public NivellAigua(Data dataMesura, String nomEmbassament, String poblacio, String provincia, double nivell, double percent, double volum) {
		
		this.dataMesura=dataMesura.copia();
		this.nomEmbassament=nomEmbassament;
		this.poblacio=poblacio;
		this.provincia=provincia;
		this.nivell=nivell;
		this.percentatgeVolum=percent;
		this.volum=volum;
	}

	/**Mètode que comprova si la població és la mateixa
	 * @param poblacio nom de la poblacio
	 * @return true si són iguals i false si no
	 */
	public boolean esTrobaEnAquestaPoblacio(String poblacio) {
		return (poblacio.equalsIgnoreCase(this.poblacio));
	}
	
	/**Mètode que comprova si la provincia és la mateixa
	 * @param provincia nom de la provincia
	 * @return true si són iguals i false si no
	 */
	public boolean esTrobaEnAquestaProvincia(String provincia) {
		return (provincia.equalsIgnoreCase(this.provincia));
	}

	/**Mètode que comprova si es troba en el periode establert
	 * per dues dates passades per paràmetre
	 * @param d1 data 1 per comprovar si es inferior a la data de la mesura
	 * @param d2 data 2 per comprovar si es inferior a la data de la mesura
	 * @return true si les dues dates son inferiors a la data de la mesura
	 * i fals si una de les dues o les dues són dates posteriors
	 */
	public boolean esTrobaEnAquestPeriode(Data d1, Data d2) {
		return (d1.esDataInferiorOigual(dataMesura) && dataMesura.esDataInferiorOigual(d2));
	}
	
	/**Mètode que comprova si el embassament passat per paràmetre
	 * es el mateix embassament que el fitxer
	 * @param nomEmbassament nom de l'embassament
	 * @return true si són iguals i false si són diferents
	 */
	public boolean esAquestEmbassament(String nomEmbassament) {
        return this.nomEmbassament.equalsIgnoreCase(nomEmbassament);
    }

	/**Getter
	 * @return el nom de l'embassament
	 */
	public String getNomEmbassament() {
		return nomEmbassament;
	}

	/**Getter
	 * @return el percentatge del volum del nivell d'aigua
	 */
	public double getPercentVolum() {
		return percentatgeVolum;
	}

	 /**Getter
	 * @return el volum del nivell d'aigua
	 */
	public double getVolum() {
        return volum;
    }

	public Data getDataMesura() {
		return dataMesura;
	}

	public String getPoblacio() {
		return poblacio;
	}

	public String getProvincia() {
		return provincia;
	}

	public double getNivell() {
		return nivell;
	}

	public double getPercentatgeVolum() {
		return percentatgeVolum;
	}

	/*Mètode toString
	 */
	public String toString() {
		String aux="NivellAigua =>";
		aux=aux+"\n\tData mesura= " + dataMesura + ", nom embassament= "+nomEmbassament;
		aux=aux+"\n\tpoblacio= " + poblacio + ", provincia= "+provincia;
		aux=aux+"\n\tnivell= " + nivell + ", percentatgeVolum= "+percentatgeVolum+ ", volum= "+volum;
		return aux;
	}

	/**Mètode que crea un duplicat del nivell d'aigua
	 * @return una nova instància de l'objecte nivell d'aigua
	 */
	public NivellAigua copia() {
		return (new NivellAigua(dataMesura, nomEmbassament, poblacio, provincia, nivell, percentatgeVolum, volum));
		
	}

	
}
