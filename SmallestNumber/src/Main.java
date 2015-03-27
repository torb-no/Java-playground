
public class Main {

    final int tableSize = 100000000;
    int[] table = new int[tableSize];
    int threadCount = 4;

    public static void main(String[] args) {
        new Main();
    }


    Main() {
        Monitor m = new Monitor(threadCount);
        Worker.table = table;
        Worker.monitor = m;

        // Fill array with random numbers
        for (int i=0; i<tableSize; i++) {
            table[i] = (int) (Math.random() * Integer.MAX_VALUE);
        }

        int intervalSize = tableSize / threadCount;

        // Calculate rest
        int rest = tableSize % threadCount;

        int startIndex = 0;
        for (int i=0; i<threadCount; i++) {
            int endIndex = startIndex + intervalSize - 1;

            if (rest > 0) {
                endIndex++;
                rest--;
            }

            System.out.println(startIndex + " - " + endIndex);

            // Make a  thread
            new Thread(new Worker(startIndex, endIndex)).start();

            startIndex = endIndex + 1;


        }

        // Waiting for threads to finnish
        m.waitForAll();

    }

}
