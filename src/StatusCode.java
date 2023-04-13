public enum StatusCode {

    SUCCESS("Success"),
    NO_COMMAND_ENTERED("No command entered!"),
    INVALID_VALUES("Please supply only positive integers as arguments!"),
    UNRECOGNISED_COMMAND("Unrecognised command. Please check your option and format!"),
    DIAGONAL_FOUND("Diagonal lines are currently not supported!"),
    OUT_OF_BOUND("The given coordinates are out of bound of the canvas!"),
    CANVAS_NOT_CREATED("Canvas is not created. Please create canvas first!"),
    EXIT("Exiting programme");

    private final String statusMessage;

    StatusCode(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public String getStatusMessage() {
        return statusMessage;
    }
}
