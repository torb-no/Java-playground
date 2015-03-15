public class MenuString extends Menu {

    private String string;

    public MenuString(String string) {
        this.string = string;
    }

    protected void onStart() {
        println("We are looking at string \"" + string + "\"");
    }

    @Command(caption = "Show in all all-[c]aps", key = "c")
    public void allCaps() {
        println(string.toUpperCase());
    }

    @Command(caption = "[B]ack", key ="b")
    public void back() {
        exitCommandLoop();
    }
}
