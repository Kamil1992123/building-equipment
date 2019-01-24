package pl.app.building.equipment.app;

public class InvalidOptionException extends RuntimeException {

    InvalidOptionException() {
        super("Nie poprawy nr opcji");
    }
}
