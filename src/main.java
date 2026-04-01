import java.io.IOException;

public static void main(String[] args) {
    Pile pileAssiettes = new Pile();
    Laveur l = new Laveur(pileAssiettes);
    Laveur l2 = new Laveur(pileAssiettes);
    Essuyeur e = new Essuyeur(pileAssiettes);
//Essuyeur e2 = new Essuyeur(pileAssiettes);
    l.start(); e.start(); l2.start();
// attendre la frappe d’une touche dans la console
    try {
        System.in.read();
    }
    catch (IOException ex) { }
    l.interrupt();
    e.interrupt();
    l2.interrupt();
}