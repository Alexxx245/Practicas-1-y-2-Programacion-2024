public class UsaPunt {
    public static void main(String[] args) throws Exception {
        
    Punt p = new Punt(3,8);
    Punt p2 = new Punt(5,6);

    System.out.println(p.toString());

    p2 = p.copia();

    System.out.println("\nContingut de la copia:\n ");
    System.out.println(p2);

    validacioIguals();
    validacioDistancia();
    validacioReflexio();
    
    }
    
    private static void validacioIguals(){

    Punt p, f;

    p = new Punt(2,4);
    f = new Punt(2,4);
    
    System.out.println("\n"+p+" i "+f+" son iguals ");
    System.out.println(p.esIgual(f));

    p = new Punt(4,5);
    f = new Punt(3,8);
    
    System.out.println("\n"+p+" i "+f+" son diferents ");
    System.out.println(p.esIgual(f));

    }

    private static void validacioDistancia(){

    Punt p, f;
    
    p = new Punt (4,5);
    f = new Punt (7,9);

    System.out.println("\nLa distancia entre "+p+" i "+f+" es "+p.calculaDistancia(p));

    p = new Punt (10,5);
    f = new Punt (20,7);
    
    System.out.println("\nLa distancia entre "+p+" i "+f+" es "+p.calculaDistancia(p));

    }

    public static void validacioReflexio(){
    
    Punt p,f;

        p = new Punt (5,8);

        System.out.println("\nPunt original: "+p);

        System.out.println("\nPunt reflectit: "+p.calculaReflexio());

        f = new Punt (-3,-7);

        System.out.println("\nPunt original: "+f);

        System.out.println("\nPunt reflectit: "+f.calculaReflexio());

        f = new Punt ();

        System.out.println("\nPunt original: "+f);

        System.out.println("\nPunt reflectit: "+f.calculaReflexio());
    }
}
