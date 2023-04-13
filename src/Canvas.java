import java.util.Arrays;

public class Canvas {

    private final char[][] canvas;
    private final int width;
    private final int height;

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;

        int canvasHeight = height + 2;
        int canvasWidth = width + 2;
        canvas = new char[canvasHeight][canvasWidth];

        Arrays.stream(canvas).forEach(line -> Arrays.fill(line, ' '));

        for (int i = 0; i < canvasWidth; i++) {
            canvas[0][i] = '-';
            canvas[canvasHeight - 1][i] = '-';
        }

        for (int i = 1; i < canvasHeight - 1; i++) {
            canvas[i][0] = '|';
            canvas[i][canvasWidth - 1] = '|';
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void drawLine(int x1, int y1, int x2, int y2) {
        if (x1 == x2) {
            for (int i = Math.min(y1, y2); i <= Math.max(y1, y2); i++) {
                canvas[i][x1] = 'X';
            }
        } else if (y1 == y2) {
            for (int i = Math.min(x1, x2); i <= Math.max(x1, x2); i++) {
                canvas[y1][i] = 'X';
            }
        }
    }

    public void drawRectangle(int x1, int y1, int x2, int y2) {
        drawLine(x1, y1, x2, y1);
        drawLine(x1, y1, x1, y2);
        drawLine(x1, y2, x2, y2);
        drawLine(x2, y1, x2, y2);
    }

    public void showCanvas() {
        for (char[] line : canvas) {
            StringBuilder sb = new StringBuilder();
            for (char c : line) {
                sb.append(c);
            }
            System.out.println(sb.toString().trim());
        }
    }
}
