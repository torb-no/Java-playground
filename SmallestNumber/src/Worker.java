public class Worker implements Runnable {

    // Static because shared across workers
    static int[] table;
    static Monitor monitor;

    private int startIndex;
    private int endIndex;

    public Worker(int startIndex, int endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    public void run() {
        // Find smallest number in array

        int smallestSoFar = table[startIndex];

        for (int i = startIndex; i<=endIndex; i++) {
            if (table[i] < smallestSoFar) {
                smallestSoFar = table[i];
            }
        }

//        System.out.println(Thread.currentThread().getName() + " found " + smallestSoFar);

        monitor.threadFinished(smallestSoFar);
    }

}
