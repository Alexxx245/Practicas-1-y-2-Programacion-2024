package dades;

import java.util.Arrays;

public class LlistaNivellsAigua {
    
    private NivellAigua[] llista;
    private int nElems;


    /**Constructor parametritzat
     * @param mida quantitat d'elements que tindrá la llista
     */
    public LlistaNivellsAigua (int mida){

        llista = new NivellAigua[mida];
        nElems = 0;
    }

    /**Mètode per consultar una mesura en una certa posició de la llista
     * pasada per paràmetre
     * @param pos posició a la llista
     * @return la mesura en aquella posició o null si s'intenta accedir a una posició invàlida
     */
    public NivellAigua getNivellAigua(int pos){

        if (pos<nElems){

            return (llista[pos].copia());
        }
        return null;
    }

    /**Mètode que afegeix les dades d'una nova mesura al final de la llista
     * @param niv instància de NivellAigua
     */
    public void afegir(NivellAigua niv){

        if (nElems<llista.length){
            
            llista[nElems] = niv.copia();
            nElems++;
        }
    }

    /**Mètode que retorna la primera mesura que es troba a la llista
     * d'un cert embassament, si no hi ha dades de l'embassament
     * es retorna null
     * @param embassament nom de l'embassament
     * @return el nivell d'aigua si es troba i null si no 
     */
    public NivellAigua retornaPrimeraMesura(String embassament){

        boolean trobat = false;
        int i = 0;
        while (i >= 0 && !trobat && i<llista.length){
              
                if (llista[i].esAquestEmbassament(embassament)){

                    trobat = true;
                }
                else
                    i++;
                
        }
        if (trobat) return (llista[i].copia());

        return null;
        
    }

    /**Mètode per consultar la mesura que té el percentatge de volum més alt. 
     * @return el nivell d'aigua amb més percentatge de volum 
     */
    public NivellAigua getMesPercentatgeVolum(){

        //diem que el nivell d'aigua amb més percentatge de volum és el primer de la llista
        NivellAigua maxPercVolum = llista[0];

        if (nElems<=llista.length){

            //partim de la segona posició, ja que la primera ja està asignada
            for (int i=1;i<nElems;i++){

                if (llista[i].getPercentatgeVolum() > maxPercVolum.getPercentatgeVolum()){

                    maxPercVolum = llista[i];
                }
            }
        }
        
        return maxPercVolum.copia();
    }

    //hem intentat fer un mètode a banda per el case 4
    /* 
    public LlistaNivellsAigua trobarNumeroMesGran (String provincia {
        if (lista == null || lista == 0) {
            throw new IllegalArgumentException("La lista no puede ser nula o vacía");
        }

        int maximPercentage = llista.get(0);

        for (int i = 1; i < llista.length; i++) {
            int numeroPercentageActual = llista.get(i);
            if (numeroPercentageActual > maximPercentage) {
                maximPercentage = numeroPercentageActual;
            }
        }

        return maximPercentage;
        }
    */

    /**Mètode per consultar la mesura que té el percentatge de volum més baix
     * @return el nivell d'aigua amb menys volum
     */
    public NivellAigua getMenysPercentatgeVolum(){

        NivellAigua minPercVolum = llista[0];

        if (nElems<=llista.length){

            //partim de la segona posició, ja que la primera ja està asignada
            for (int i=1;i<nElems;i++){

                if (llista[i].getPercentatgeVolum() < minPercVolum.getPercentatgeVolum()){

                    minPercVolum = llista[i];
                }
            }
        }
        
        return minPercVolum.copia();
    }

    /**Mètode per consultar els embassaments guardats a la llista
     * @return els embassaments o null si no hi ha cap
     */
    public String[] getEmbassaments(){

        String[] embassaments = new String[nElems];

        if (nElems<llista.length){

            for (int i=0;i<nElems;i++){

                embassaments[i] = llista[i].getNomEmbassament();
            }
        }
        return null;
    }

    /**Mètode per consultar la mesura amb el volum d'aigua més alt
     * @return el nivell d'aigua amb més volum
     */
    public NivellAigua getMesVolumAigua(){

        NivellAigua maxVolum = llista[0];

        if (nElems<llista.length){

            //partim de la segona posició, ja que la primera ja està asignada
            for (int i=1;i<nElems;i++){

                if (llista[i].getPercentatgeVolum() > maxVolum.getPercentatgeVolum()){

                    maxVolum = llista[i];
                }
            } 
        }
        
        return maxVolum.copia();
        
    }

    /**Mètode per consultar les mesures d'una provincia en concret 
     * @param provincia provincia on es troba l'embassament
     * @return una llista amb les mesures de la provincia indicada
     */
    public LlistaNivellsAigua consultaDadesProvincia(String provincia){

        LlistaNivellsAigua ll = new LlistaNivellsAigua(nElems);

        for(int i=0;i<nElems;i++){

            if (llista[i].esTrobaEnAquestaProvincia(provincia)){

                ll.afegir(llista[i]);
            }
        }
        return ll;
    }

    /**Mètode per consultar les mesures en un periode de temps
     * @param d1 primera data
     * @param d2 segona data
     * @return una llista amb les mesures del període de temps indicat
     */
    public LlistaNivellsAigua consultaDadesTemps(Data d1, Data d2){

        LlistaNivellsAigua ll = new LlistaNivellsAigua(nElems);

        for (int i=0;i<nElems;i++){

            if (llista[i].esTrobaEnAquestPeriode(d1,d2)){

                ll.afegir(llista[i]);
            }
                         
        }
        return ll;
    }

    /**Mètode per eliminar les mesures d'un cert embassament
     * @param embassament embassament del nivell d'aigua
     */
    public void eliminaMesures(String embassament){

        int i = 0;
        while(nElems > 0 && i<nElems){

            if (llista[i].esAquestEmbassament(embassament)){

                //desplacem les posicions posteriors cap endavant
                for (int j=i;j<nElems-1;j++){
                    llista[j] = llista[j+1];
                }
                nElems--;
            }
            else i++;
        }
    }

    /**Getter
     * @return
     */
    public NivellAigua[] getLlista() {
        return llista;
    }

    /**Getter
     * @return
     */
    public int getnElems() {
        return nElems;
    }

    /**Setter
     * @param llista
     */
    public void setLlista(NivellAigua[] llista) {
        this.llista = llista;
    }

    /**Setter
     * @param nElems
     */
    public void setnElems(int nElems) {
        this.nElems = nElems;
    }
    
    /*Mètode toString
     */
    public String toString() {
        
        return "LlistaNivellsAigua [llista=" +Arrays.toString(llista) + ", nElems=" + nElems + "]";
    }

    /**Mètode copia
     * @return un duplicat de la llista
     */
    public LlistaNivellsAigua copia(){

        LlistaNivellsAigua aux = new LlistaNivellsAigua(nElems);

        for (int i=0;i<nElems;i++){
            aux.afegir(llista[i]);
        }
        return aux;
    }
}
