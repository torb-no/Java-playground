public class SmallestNumberWorker implements Runnable {

    private int[] table;
    private Monitor monitor;

    private int startIndex;
    private int endIndex;

    public SmallestNumberWorker(int[] table, Monitor monitor, int startIndex, int endIndex) {
        this.table = table;
        this.monitor = monitor;
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
