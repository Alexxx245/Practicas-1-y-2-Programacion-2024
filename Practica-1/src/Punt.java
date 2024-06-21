public class Punt {
    
    private int x,y;


/**
 * Constructor per defecte, sense paràmetres
 */
public Punt(){

    x = 1;
    y = 1;
}

/**
 * Constructor parametritzat
 * @param x coordenada x del punt
 * @param y coordenada y del punt
 */
public Punt(int x, int y){

    this.x = x;
    this.y = y;

}

/**Getter
 * @return coordenada x del punt
 */
public int getX(){

    return x;
}

/**Getter
 * @return coordenada y del punt
 */
public int getY(){

    return y;
}

/**Setter
 * @param x coordenada x del punt
 * @param y coordenada y del punt
 */
public void setX(int x){

    this.x = x;
     
}

/**Setter
 * @param x coordenada x del punt
 * @param y coordenada y del punt
 */
public void setY(int y){

    this.y = y;
     
}

/*
 * Mètode toString, transforma els atributs en una cadena de text
 */
public String toString(){

    return ("Punt: [x] = "+x+", [y] = "+y);
}


/**
 * @param p és la referencia de l'objecte per comparar el contingut de
 * l'objecte actual
 * @return cert si els punts tenen les mateixes coordenades i fals si no les tenen
 */
public boolean esIgual(Punt p){
    
    return ((p.x == x) && (p.y == y));
}

/**Mètode que crea una copia de l'objecte actual
 * @return una nova instància del punt amb el mateix contingut que l'objecte actual
 */
public Punt copia(){

    return (new Punt(x,y));
}

/**Mètode que calcula la distància entre dos punts
 * @param p és la referencia de l'objecte amb el que es vol calcular
 * la distància respecte a l'objecte actual
 * @return la distaància enter entre dos punts
 */
public double calculaDistancia(Punt p){

    double dist;
 
    dist = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));

    return ((int)dist);
}

/**Mètode que calcula el punt resultant de la reflexió sobre l'eix x
 * @return el punt després de la reflexió
 */
public Punt calculaReflexio(){

    Punt p = new Punt(x,-y);
    
    return p;
}
}


