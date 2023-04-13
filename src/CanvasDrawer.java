public class CanvasDrawer {

    private Canvas canvas;

    public CanvasDrawer() {

    }

    public boolean isCanvasCreated() {
        return canvas != null;
    }

    public StatusCode processCommand(String command) {
        if (command == null || command.length() == 0) {
            return StatusCode.NO_COMMAND_ENTERED;
        }

        if (!isCommandValid(command)) {
            return StatusCode.INVALID_VALUES;
        }

        int[] params = parseParamValues(command);
        String option = command.split(" ")[0];

        if ("C".equals(option) && params.length == 2) {
            return createCanvas(params);
        } else if ("Q".equals(option) && params.length == 0) {
            return StatusCode.EXIT;
        } else if ("L".equals(option) && params.length == 4) {
            return drawLine(params);
        } else if ("R".equals(option) && params.length == 4) {
            return drawRectangle(params);
        }

        return StatusCode.UNRECOGNISED_COMMAND;
    }

    private boolean isCommandValid(String command) {
        String[] split = command.split(" ");

        for (int i = 1; i < split.length; i++) {
            try {
                int parsed = Integer.parseInt(split[i]);
                if (parsed < 1) {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }

    private int[] parseParamValues(String command) {
        String[] split = command.split(" ");
        int[] args = new int[split.length - 1];
        for (int i = 1; i < split.length; i++) {
            args[i - 1] = Integer.parseInt(split[i]);
        }
        return args;
    }

    private StatusCode drawRectangle(int... params) {
        int x1 = params[0];
        int y1 = params[1];
        int x2 = params[2];
        int y2 = params[3];

        if (canvas == null) {
            return StatusCode.CANVAS_NOT_CREATED;
        }

        if (isDiagonal(x1, y1, x2, y1) || isDiagonal(x1, y1, x1, y2) || isDiagonal(x1, y2, x2, y2) || isDiagonal(x2, y1, x2, y2)) {
            return StatusCode.DIAGONAL_FOUND;
        }

        if (isOutOfBound(x1, y1) || isOutOfBound(x2, y2) || isOutOfBound(x1, y2) || isOutOfBound(x2, y1)) {
            return StatusCode.OUT_OF_BOUND;
        }

        canvas.drawRectangle(x1, y1, x2, y2);
        canvas.showCanvas();
        return StatusCode.SUCCESS;
    }

    private StatusCode drawLine(int... params) {
        int x1 = params[0];
        int y1 = params[1];
        int x2 = params[2];
        int y2 = params[3];

        if (canvas == null) {
            return StatusCode.CANVAS_NOT_CREATED;
        }

        if (isDiagonal(x1, y1, x2, y2)) {
            return StatusCode.DIAGONAL_FOUND;
        }

        if (isOutOfBound(x1, y1) || isOutOfBound(x2, y2)) {
            return StatusCode.OUT_OF_BOUND;
        }

        canvas.drawLine(x1, y1, x2, y2);
        canvas.showCanvas();
        return StatusCode.SUCCESS;
    }

    private StatusCode createCanvas(int... params) {
        int width = params[0];
        int height = params[1];

        canvas = new Canvas(width, height);
        canvas.showCanvas();
        return StatusCode.SUCCESS;
    }

    private boolean isOutOfBound(int x, int y) {
        return x > canvas.getWidth() || y > canvas.getHeight();
    }

    private boolean isDiagonal(int x1, int y1, int x2, int y2) {
        return x1 != x2 && y1 != y2;
    }
}
