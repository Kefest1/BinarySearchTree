public class KeyIsAlreadyTaken extends Exception {

    public KeyIsAlreadyTaken() {
        System.out.println("Error. Keys have to be unique");
    }

    public KeyIsAlreadyTaken(String message) {
        super(message);
    }
}
