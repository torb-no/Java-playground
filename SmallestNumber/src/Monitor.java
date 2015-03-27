public class Monitor {

    private int smallestSoFar = Integer.MAX_VALUE;
    private int runningThreads;

    public Monitor(int runningThreads) {
        this.runningThreads = runningThreads;
    }

    // Needs to be synchronized becuase of wait()
    synchronized void waitForAll() {
        while (runningThreads > 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }

        System.out.println("MONITOR(MAIN): All workers finished. " +
                            "smallest number is " + smallestSoFar);
    }

    // Synchronized
    synchronized void threadFinished(int smallest) {
        runningThreads--;

        if (smallest < smallestSoFar) smallestSoFar = smallest;

        // To get this (main thread) to get wait() to re-evaluate
        notify();
    }

}
