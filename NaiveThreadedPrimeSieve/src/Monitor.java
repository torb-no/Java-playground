public class Monitor {

    private int totalPrimeCount = 0;
    private int runningThreads;

    public Monitor(int runningThreads) {
        this.runningThreads = runningThreads;
    }

    public synchronized int getResultsWhenFinished() {
        while (runningThreads > 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }

        return totalPrimeCount;
    }

    public synchronized void workerFinished(int primeCount) {
        runningThreads--;
        totalPrimeCount += primeCount;

        notify();
    }

}
