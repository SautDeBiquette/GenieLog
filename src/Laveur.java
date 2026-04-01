class Laveur extends Thread {
    private final Pile myStack;
    Laveur(Pile s) {
        myStack = s;
    }
    public void run() {
        int i = 1;
        while (true) {
            try {
// Laver une assiette
                String assiette = "Assiette: " + i;
                i++;
                sleep(500);
// La mettre sur la pile
                System.out.println("J'empile l'assiette: " + assiette);
                myStack.push(assiette);
            }
            catch (InterruptedException ex) {
                break; // Sort du while, termine le Thread;
            }
        }
        System.out.println("Laveur terminé");
    }
}
