public class Worker implements Runnable {

    private int[] table;
    private Monitor monitor;

    private int startIndex;
    private int endIndex;

    public Worker(int[] table, Monitor monitor, int startIndex, int endIndex) {
        this.table = table;
        this.monitor = monitor;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    public void run() {
        // Find Amount of primes

        int primeCount = 0;

        outerLoop:
        for (int i = startIndex; i<=endIndex; i++) {

            if (table[i] == 0 || table[i] == 1) continue outerLoop;

            for (int d=2; d<table[i]; d++) {
                if (table[i] % d == 0) continue outerLoop;
            }

            // No numbers divide evenly, must be a prime
            primeCount++;
        }

        monitor.workerFinished(primeCount);
    }

}
