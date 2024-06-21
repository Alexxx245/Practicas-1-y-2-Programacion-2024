import java.util.Arrays;

public class Poligon{

private Punt[] vertexs;


/**Constructor parametritzat
 * @param vertexs numero de punts que formen el poligon
 */
public Poligon(int vertexs){

    this.vertexs = new Punt[vertexs];
}

/**Constructor per defecte, sense paràmetres
 */
public Poligon (){

    this.vertexs = new Punt[3];
}

/**Setter
 * @param vertexs numero de punts que formen el poligon
 */
public void setVertexs(Punt[] vertexs){

    this.vertexs = vertexs;
}

/**Getter
 * @return el nombre de vertexs del Poligon
 */
public Punt[] getVertexs(){

    return vertexs;
}

/**Mètode per afegir un vertex al Poligon
 * @param index posició de la llista de vertexs
 * @param p és la referencia de l'objecte amb el que es vol afegir
 * a la llista de vertexs
 */
public void afegirVertex(int index, Punt p){

    if (index >= 0 && index < vertexs.length){

        vertexs[index] = p;
    }
    else{
        
        System.out.println("No s'ha pogut afegir el vertex, intentes accedir a un index fora de rang");
    }
    
}

/**Mètode per consultar el vèrtex i-èssim del polígon
 * @param index posició de la llista de vertexs
 * @return l'index del vertex si existeix i null si no existeix
 */
public Punt consultarVertex(int index){

    if (index >= 0 && index < vertexs.length){
        
        return vertexs[index];
    }
    else{

        return null;
    }
    
}

/**Mètode per modificar el vèrtex i-èssim del polígon
 * @param index posició de la llista de vertexs
 * @param p és la referencia de l'objecte amb el que es vol afegir
 * a la llista de vertexs
 */
public void modificarVertex(int index, Punt p){

    if (index >= 0 && index < vertexs.length){
        
        afegirVertex(index, p);
    }
    else{

        System.out.println("No s'ha pogut modificar el vertex, intentes accedir a un index fora de rang");
    }
    
}

/**Mètode per calcular i retornar el perímetre del polígon
 * @return el perímetre
 */
public double perimetre(){

    double perimetre = 0.0;

    for (int i= 0; i < vertexs.length -1; i++){
        
        Punt p = vertexs[i];
        Punt p2 = vertexs[i+1];
        perimetre += p.calculaDistancia(p2);
    }

    Punt primerVertex = vertexs[0];
    Punt ultimVertex = vertexs[vertexs.length-1];

    perimetre += ultimVertex.calculaDistancia(primerVertex);

    return perimetre;
}

/**Mètode per calcular la reflexió del poígon sobre l'eix x
 * @return el poligon després de la reflexió
 */
public Poligon calculaReflexioV2(){

    Poligon reflexio = new Poligon(vertexs.length);

    for (int i = 0;i < vertexs.length;i++){

        int x = vertexs[i].getX();
        int y = vertexs[i].getY();  
        
        reflexio.afegirVertex(i, new Punt(x,-y));
    }

    return reflexio;
}

/**Mètode que calcula la capsa en forma de rectangle que conté el poligon
 * @param p la referencia de l'objecte Poligon
 * @return la capsa que conté el poligon
 */
public Poligon capsaContenidora(Poligon p){

    //NO HE SAPIGUT IMPLEMENTAR AQUEST MÈTODE
    
    return p;
}

/*
 * Mètode toString que transforma els atributs en una cadena de text
 */
public String toString(){

    return Arrays.toString(vertexs);
}

/**Mètode que crea un duplicat del polígon
 * @return una nova instància del polígon amb el mateix contingut que l'objecte actual
 */

public Poligon copia(){

    Poligon duplicat = new Poligon(vertexs.length);

    for (int i=0;i < vertexs.length;i++){
        duplicat.afegirVertex(i, vertexs[i]);
    }
    return duplicat;
}

}