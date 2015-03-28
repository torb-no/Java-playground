
public class Main {

    final int tableSize = 190000000;
    int[] table = new int[tableSize];
    int threadCount = 4;

    public static void main(String[] args) {
        new Main();
    }

    Main() {
        Monitor monitor = new Monitor(threadCount);

        System.out.println("Filling table with random numbers...");
        // Fill array with random numbers
        for (int i=0; i<tableSize; i++) {
            table[i] = (int) (Math.random() * Integer.MAX_VALUE);
        }

        System.out.println("Looking for smallest number in array using " + threadCount + " threads");


        int intervalSize = tableSize / threadCount;
        int rest = tableSize % threadCount;

        Thread[] threads = new Thread[threadCount];

        int startIndex = 0;
        for (int i=0; i<threadCount; i++) {
            int endIndex = startIndex + intervalSize - 1;

            if (rest > 0) {
                endIndex++;
                rest--;
            }

            // Make a  thread
            threads[i] = new Thread(new SmallestNumberWorker(table, monitor, startIndex, endIndex));

            startIndex = endIndex + 1;
        }


        long beforeNano = System.nanoTime();
        for (Thread t : threads) t.start();

        // Waiting for threads to finnish
        monitor.waitForAll();

        long afterNano = System.nanoTime();
        long nanoDelta = afterNano - beforeNano;
        System.out.println("It took " + (nanoDelta / 1000000.0) + " milliseconds");

    }

}
