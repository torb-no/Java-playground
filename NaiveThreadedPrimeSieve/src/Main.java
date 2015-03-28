import java.util.Random;

public class Main {

    static final int tableSize = 500;
    static final int bound = Integer.MAX_VALUE;
    static final int threadCount = 4;
    static final long seed = 23131;

    public static void main(String[] args) {
        Monitor monitor = new Monitor(threadCount);
        int[] table = new int[tableSize];

        System.out.println("Filling table with random numbers...");
        Random random = new Random(seed);
        // Fill array with random numbers
        for (int i=0; i<tableSize; i++) {
            table[i] = random.nextInt(bound);
        }

        System.out.println("Looking for primes using " + threadCount + " threads");

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
            threads[i] = new Thread(new Worker(table, monitor, startIndex, endIndex));

            startIndex = endIndex + 1;
        }


        long beforeNano = System.nanoTime();
        for (Thread t : threads) t.start();

        // Waiting for threads to finnish
        int result = monitor.getResultsWhenFinished();
        long afterNano = System.nanoTime();
        double deltaInSeconds = ( (afterNano - beforeNano) / 1000000.0 ) / 1000;

        System.out.println("Found " + result + " primes in randomly generated numbers");
        System.out.println("It took " + deltaInSeconds + " seconds");
    }

}
