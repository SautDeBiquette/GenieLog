class Essuyeur extends Thread {
    private final Pile myStack;
    Essuyeur(Pile s) {
        myStack = s;
    }
    public void run() {
        while (true) {
            try {
// Prendre une assiette sur la pile
                String assiette = myStack.pop();
// L'essuyer
                System.out.println("J'essuie l'assiette " + assiette);
                sleep(1000);
            }
            catch (InterruptedException ex) {
                break; // Sort du while, termine le Thread;
            }
        }
        System.out.println("Essuyeur terminé");
    }
}
