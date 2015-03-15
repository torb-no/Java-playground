import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

/**
 * Annotation interface used to annotate commands
 */
@Retention(RetentionPolicy.RUNTIME)
@interface Command {
    public String caption();
    public String key();
}

/**
 * Superclass for all menus
 *
 * A menu class represents a "location" in a menu system and
 * data associated with that.
 */
public abstract class Menu {

    // Menu system

    private boolean continueCommandLoop = true;

    public final void start() {
        onStart();

        while (continueCommandLoop) {
            beforeCommandList();

            displayCommands();
            readAndExecuteCommand();

            afterCommandList();
        }

        onExit();
    }

    private final void displayCommands() {
        String s = "";

        Method[] methods = this.getClass().getMethods();

        for (int i=methods.length-1; i>=0; i--) {

            Annotation[] annotations = methods[i].getDeclaredAnnotations();
            if (annotations.length != 0 && annotations[0] instanceof Command) {

                Command c = (Command)methods[i].getDeclaredAnnotations()[0];
                s += c.caption();
                if (i != methods.length-1) s += ", ";
            }
        }

        println(s);

    }

    private final void readAndExecuteCommand() {

        String nextCommand = nextLine();
        nextCommand = nextCommand.substring(0,1);

        for (Method m : this.getClass().getMethods()) {
            Annotation[] annotations = m.getDeclaredAnnotations();
            if (annotations.length != 0 && annotations[0] instanceof Command) {
                Command c = (Command)m.getDeclaredAnnotations()[0];
                if (c.key().equalsIgnoreCase(nextCommand)) {
                    try {
                        m.invoke(this);
                        return;
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                        System.exit(1);
                    }
                }
            }
        }

        // Found no matching command
        println("Unknown command: " + nextCommand);
    }

    protected final void exitCommandLoop() {
        continueCommandLoop = false;
    }

    // Events that subclasses can override

    protected void onStart() {};
    protected void beforeCommandList() {};
    protected void afterCommandList() {};
    protected void onExit() {};

    // Terminal helpers

    static Scanner consoleScanner = new Scanner(System.in);

    protected static void println(Object o) {
        System.out.println(o);
    }

    protected static void println() {
        System.out.println();
    }

    protected static String nextLine() {
        return consoleScanner.nextLine();
    }

}