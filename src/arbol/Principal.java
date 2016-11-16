/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol;

/**
 *
 * @author Maxi
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ABB arbol = BuildArbolBinarioCompleto();
        cantNodos(arbol);
    }
    private static void cantNodos(ABB arbol){
        if(arbol.isEmpty()){
            System.out.print("El arbol esta vacio");
        }else{
            ABB unArbol = new ABB();
            int cant = unArbol.cantDeNodos(arbol.getRaiz());
            System.out.print("Tiene : " + cant + " Nodos");
        }
    }
    public static ABB BuildArbolBinarioCompleto()
        {
            // raiz
            nodoABB raiz = new nodoABB(8);
            // nivel 1
            nodoABB unoIzq = new nodoABB(5);
            nodoABB unoDer = new nodoABB(15);
            raiz.setIzq(unoIzq);
            raiz.setDer(unoDer);
            // nivel 2
            nodoABB unoIzqdosIzq = new nodoABB(7);
            nodoABB unoIzqdosDer = new nodoABB(1);
            unoIzq.setIzq(unoIzqdosIzq);
            unoIzq.setDer(unoIzqdosDer);
            nodoABB unoDerdosIzq = new nodoABB(3);
            nodoABB unoDerdosDer = new nodoABB(9);
            unoDer.setIzq(unoDerdosIzq);
            unoDer.setDer(unoDerdosDer);
            // Genera el arbol
            ABB arbolB = new ABB(raiz);
            return arbolB;
        }
    
}
