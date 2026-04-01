import java.util.LinkedList;
import java.util.List;

class Pile {
    private final static int MAX = 10;
    private List myList = new LinkedList();
    private boolean isEmpty() {
        return myList.isEmpty();
    }
    private boolean isFull() {
        return (myList.size() >= MAX);
    }
    synchronized void push(String assiette) throws InterruptedException {
// Attendre que la pile ne soit pas pleine
        while (isFull())
            wait(); // Peut lever InterruptedException
// Ajouter à la fin de la liste
        myList.add(assiette);
        System.out.println("La pile contient " + myList.size() + " assiettes");
        notifyAll(); // Notifier que la pile n'est plus vide
    }
    synchronized String pop()  throws InterruptedException {
// Attendre que la pile ne soit pas vide
        while (isEmpty())
            wait(); // Peut lever InterruptedException
// Dépiler
        assert !isEmpty(); // On est sur que la pile n'est pas vide
        String result = (String)myList.remove(myList.size()-1);
        System.out.println("La pile contient " + myList.size() + " assiettes");
        notifyAll(); // Notifier que la pile n'est plus pleine
        return result;
    }
}