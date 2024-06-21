public class UsaPoligon {

    public static void main(String[] args) throws Exception{


    validaAfegirVertex();
    validaPerimetre();
    validaReflexioV2();
    validaModificaVertex();
    
    
   }

    private static void validaAfegirVertex(){

    Punt p = new Punt(2,2);
    Punt p2 = new Punt(4, 4);
    Punt p3 = new Punt(6,2);
    
    Poligon triangle = new Poligon(); 
    
    triangle.afegirVertex(0, p);
    triangle.afegirVertex(1, p2);
    triangle.afegirVertex(2, p3);   

    System.out.println("Triangle: "+triangle);

    Punt f = new Punt(3,3);
    Punt f2 = new Punt(8,3);
    Punt f3 = new Punt(8,8);
    Punt f4 = new Punt(3,8);

    Poligon quadrat = new Poligon(4);

    quadrat.afegirVertex(0, f);
    quadrat.afegirVertex(1, f2);
    quadrat.afegirVertex(2, f3);
    quadrat.afegirVertex(3, f4);


    System.out.println("Quadrat: "+ quadrat);

    }

    private static void validaModificaVertex(){

    Punt p = new Punt(2,2);
    Punt p2 = new Punt(4, 4);
    Punt p3 = new Punt(6,2);
    
    Poligon triangle = new Poligon(3);

    triangle.afegirVertex(0, p);
    triangle.afegirVertex(1, p2);
    triangle.afegirVertex(2, p3); 

    Punt f = new Punt(3,3);
    Punt f2 = new Punt(8,3);
    Punt f3 = new Punt(8,8);
    Punt f4 = new Punt(3,8);


    Poligon quadrat = new Poligon(4);

    quadrat.afegirVertex(0, f);
    quadrat.afegirVertex(1, f2);
    quadrat.afegirVertex(2, f3);
    quadrat.afegirVertex(3, f4);
    
    System.out.println("MODIFICACIONS POLIGONS");

    System.out.println("\nTriangle original: "+triangle);
    System.out.println("\nQuadrat original: "+quadrat);

    System.out.println("\nModificacions correctes ");

    triangle.modificarVertex(0, p2);
    triangle.modificarVertex(1, p3);
    triangle.modificarVertex(2, p);

    quadrat.modificarVertex(0, f2);
    quadrat.modificarVertex(1, f3);
    quadrat.modificarVertex(2, f4);
    quadrat.modificarVertex(3, f);

    System.out.println("\nTriangle modificat: "+triangle);

    System.out.println("\nQuadrat modificat: "+quadrat);

    System.out.println("\nModificacions fora d'index");

    triangle.modificarVertex(3, p2);
    triangle.modificarVertex(-1, p);
    triangle.modificarVertex(4, p3);

    }

    private static void validaPerimetre(){

    Punt p = new Punt(2,2);
    Punt p2 = new Punt(4, 4);
    Punt p3 = new Punt(6,2);


    System.out.println("\nCÀLCUL PERIMETRE POLIGONS");
    Poligon triangle = new Poligon(3);

    triangle.afegirVertex(0, p);
    triangle.afegirVertex(1, p2);
    triangle.afegirVertex(2, p3);

    System.out.println("\nPerimetre del triangle: "+ triangle.perimetre());

    Punt f = new Punt(3,3);
    Punt f2 = new Punt(8,3);
    Punt f3 = new Punt(8,8);
    Punt f4 = new Punt(3,8);


    Poligon quadrat = new Poligon(4);

    quadrat.afegirVertex(0, f);
    quadrat.afegirVertex(1, f2);
    quadrat.afegirVertex(2, f3);
    quadrat.afegirVertex(3, f4);

    System.out.println("\nPerimetre del triangle: "+ quadrat.perimetre());
    System.out.println();
    
    }

    private static void validaReflexioV2(){

    Punt p = new Punt(2,2);
    Punt p2 = new Punt(4, 4);
    Punt p3 = new Punt(6,2);

    System.out.println("\nCÀLCUL REFLEXIÓ POLIGONS");

    Poligon triangle = new Poligon(3);

    triangle.afegirVertex(0, p);
    triangle.afegirVertex(1, p2);
    triangle.afegirVertex(2, p3);

    System.out.println("\nReflexió del poligon triangle: "+triangle.calculaReflexioV2());
    

    Punt f = new Punt(3,3);
    Punt f2 = new Punt(8,3);
    Punt f3 = new Punt(8,8);
    Punt f4 = new Punt(3,8);


    Poligon quadrat = new Poligon(4);

    quadrat.afegirVertex(0, f);
    quadrat.afegirVertex(1, f2);
    quadrat.afegirVertex(2, f3);
    quadrat.afegirVertex(3, f4);


    System.out.println("\nReflexió del poligon quadrat: "+quadrat.calculaReflexioV2());
    System.out.println();
    
    }
    
}
