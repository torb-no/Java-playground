
public class Main {

    final int tableSize = 100000000;
    int[] table = new int[tableSize];
    int threadCount = 1;

    public static void main(String[] args) {
        new Main();
    }

    Main() {
        Monitor m = new Monitor(threadCount);
        Worker.table = table;
        Worker.monitor = m;

        System.out.println("Filling table with random numbers...");
        // Fill array with random numbers
        for (int i=0; i<tableSize; i++) {
            table[i] = (int) (Math.random() * Integer.MAX_VALUE);
        }

        System.out.println("Looking for smallest number in array using " + threadCount + " threads");
        long beforeNano = System.nanoTime();

        int intervalSize = tableSize / threadCount;
        int rest = tableSize % threadCount;



        int startIndex = 0;
        for (int i=0; i<threadCount; i++) {
            int endIndex = startIndex + intervalSize - 1;

            if (rest > 0) {
                endIndex++;
                rest--;
            }

            // Make a  thread
            new Thread(new Worker(startIndex, endIndex)).start();

            startIndex = endIndex + 1;
        }

        // Waiting for threads to finnish
        m.waitForAll();

        long afterNano = System.nanoTime();
        long nanoDelta = afterNano - beforeNano;
        System.out.println("It took " + (nanoDelta / 1000000.0) + " milliseconds");

    }

}
