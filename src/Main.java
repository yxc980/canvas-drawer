import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        CanvasDrawer canvasDrawer = new CanvasDrawer();
        Scanner scanner = new Scanner(System.in);
        printManual();

        while (true) {
            StatusCode status = canvasDrawer.processCommand(scanner.nextLine());
            if (StatusCode.EXIT.equals(status)) {
                print(status.getStatusMessage());
                System.exit(0);
            } else if (!StatusCode.SUCCESS.equals(status)) {
                print(status.getStatusMessage());
                printManual();
            }
        }
    }

    private static String formatOption(String option, String manual) {
        return String.format("\"%s\" (%s)", option, manual);
    }

    private static void print(String string) {
        System.out.println(string);
    }

    private static void printManual() {
        print("Please enter one command from: \n"
                + formatOption("C w h", "Create a new canvas with width and height") + "\n"
                + formatOption("L x1 y1 x2 y2", "Draw a line starting from (x1,y1) to (x2,y2)") + "\n"
                + formatOption("R x1 y1 x2 y2", "Draw a rectangle with upper left corner (x1,y1) and lower right corner (x2,y2)") + "\n"
                + formatOption("Q", "Quit") + "\n"
                + "Note: coordinates are 1-indexed with the origin at top left corner of canvas\n");
    }
}