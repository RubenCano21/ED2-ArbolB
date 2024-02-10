package bo.edu.uagrm.ficct.inf310.arbolb;

import javax.swing.JTextArea;

/**
 *
 * @author Cano
 */
public class ArbolB {

    private Nodo raiz;

    public ArbolB() {
        this.raiz = null;
    }
    
    public boolean esHoja(Nodo p){
        return p.esNodoVacio();
    }
    
    public void insertar(int x){
        Nodo q = new Nodo(x);
        if (raiz == null) {
            raiz = q;
            return;
        }
        Nodo p = raiz;
        Nodo ap = null;
        while (p != null) {            
            ap = p;
            if (x < p.getElem()) {
                p = p.getHI();
            }else if (x > p.getElem()) {
                p = p.getHD();
            }else {
                return;
            }
        }
        if (x < ap.getElem()) {
            ap.setHI(q);
        }else {
            ap.setHD(q);
        }
    }
    
    public void preOrden(JTextArea ta){
        preOrden(raiz, ta);
    }
    
    private void preOrden(Nodo p, JTextArea ta){
        if (p != null) {
            ta.append(String.valueOf(p.getElem()) + " ");
            preOrden(p.getHI(), ta);
            preOrden(p.getHD(), ta);
        }
    }
    
    public void InOrden(JTextArea ta){
        InOrden(raiz, ta);
    }
    
    private void InOrden(Nodo p, JTextArea ta){
        if (p != null) {
            InOrden(p.getHI(), ta);
            ta.append(String.valueOf(p.getElem()) + " ");
            InOrden(p.getHD(), ta);
        }
    }
    
    public void postOrden(JTextArea ta){
        postOrden(raiz, ta);
    }
    
    private void postOrden(Nodo p, JTextArea ta){
        if (p != null) {
            postOrden(p.getHI(), ta);
            postOrden(p.getHD(), ta);
            ta.append(String.valueOf(p.getElem()) + " ");
        }
    }
   
    // 1. Sumar todos los elementos del arbol
    public int sumar(){
        return sumar(raiz);
    }

    private int sumar(Nodo p) {
        int ai,ad;
        if(p == null)
            return 0;
        else {
            if(esHoja(p))
                return p.getElem();
            else {
                ai = sumar(p.getHI());
                ad = sumar(p.getHD());                
            }
        }
        return ai + ad + p.getElem();
    }
    
    // 2. mostrar la cantidad de nodos que hay en el arbol
    public int cantidad(){
        return cantidad(raiz);
    }
    
    private int cantidad (Nodo p){
        if(p == null)
            return 0;
        else {
            if(esHoja(p))
                return 1;
            else{
                int ai = cantidad(p.getHI());
                int ad = cantidad(p.getHD());
                return ai + ad +1;
            }
        }
    }
    
    // 3. mostrar la altura del arbol
    public int altura(){
        return altura(raiz);
    }
    
    private int altura(Nodo p){
        if (p == null) {
            return 0;
        }else if (esHoja(p)) {
            return 1;
        }else {
            int ai = altura(p.getHI());
            int ad = altura(p.getHI());
            if(ai > ad)
                return ai + 1;
            else
                return ad + 1;
        }
    }
    
    // 4. Verificar si el elemento existe en el arbol
    public boolean existe(int x){
        return existe(raiz, x);
    }
    
    private boolean existe(Nodo p, int x){
        if (p == null) {
            return false;
        }else if (esHoja(p)) {
            if(x == p.getElem())
                return true;
        }else {
            boolean ai = existe(p.getHI(), x);
            boolean ad = existe(p.getHD(), x);
            if( ai || ad)
                return true;
            else
                return (x == p.getElem());
        }
        return false;
    }
    
    // 5. mostrar la cantidad de nodo incompletos del arbol
    public int cantIncompletos(){
        return cantIncompletos(raiz);
    }
    
    private int cantIncompletos(Nodo p){
        if (p == null) {
            return 0;
        }else if (esHoja(p)) {
            return 0;
        }else {
            int ai = cantIncompletos(p.getHI());
            int ad = cantIncompletos(p.getHD());
            if (p.getHI() != null && p.getHD() == null || 
                    p.getHI() == null && p.getHD() != null) {
                return ai + ad +1;
            }else{
                return ai + ad;
            }
        }
    }
}



















