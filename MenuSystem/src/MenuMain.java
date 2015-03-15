public class MenuMain extends Menu {

    @Command(caption = "Say [H]ello to the world", key = "h")
    public void hello() {
        System.out.println("Hello World");
    }

    @Command(caption = "[E]cho what I say", key = "e")
    public void echo() {
        String echo = nextLine();
        println(echo + " ... " + echo + " ... " + echo);
    }

    @Command(caption = "Look at a [s]tring", key = "s")
    public void lookAtString() {
        println("Please provide a string");
        String string = nextLine();
        new MenuString(string).start();
    }

    @Command(caption = "E[x]it this app", key = "x")
    public void exit() {
        exitCommandLoop();
    }

    protected void onExit() {
        println("Goodbye!");
    }
}
