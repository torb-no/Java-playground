public class TestThread extends Thread {

    static int idCounter = 0;
    int id;

    public TestThread() {
        id = idCounter++;
    }

    public void run() {
        System.out.println(id + " - before");
        if ( id == 2 ) {
            try { sleep(1000); }
            catch (InterruptedException e) { e.printStackTrace(); }
        }
        System.out.println(id + " - after");
    }
}
