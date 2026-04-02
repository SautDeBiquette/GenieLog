package utils;

import java.time.LocalTime; // import the LocalDateTime class

public class Timer implements Runnable {
    private void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void run() {
        LocalTime time = LocalTime.of(1, 0);
        while (time.isAfter(LocalTime.MIDNIGHT)) {
            System.out.println(time);
            if (time.equals(LocalTime.of(6, 0))) {
                System.out.println("Dring Drong ! Il faut se lever maintenant ! TULULU TULULU");
            }
            if (time.equals(LocalTime.of(8, 0))) {
                System.out.println("Rappel : Il est important de s'hydrater");
            }
            time = time.plusMinutes(30);
            this.sleep();
        }

        System.out.println("\n========================================");
        System.out.println("           FIN DE LA DÉMO               ");
        System.out.println("========================================");
    }
}
