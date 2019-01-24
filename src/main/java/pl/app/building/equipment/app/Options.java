package pl.app.building.equipment.app;


public enum Options {


    ADD_DEVICE(1, "Dodaj urządzenie"),
    ADD_CATEGORY(2, "Dodaj kategorię"),
    ADD_CUSTOMER(3, "Dodaj klienta"),
    RENT(4, "Wypożycz urządzenie"),
    REMOVE_DEVICE(5, "Usuń urządzenie"),
    REMOVE_CATEGORY(6, "Usuń categorię"),
    REMOVE_CUSTOMER(7, "Usuń klienta"),
    EXIT(8, "Wyjście");

    private int number;
    private String desc;

    Options(int number, String desc) {
        this.number = number;
        this.desc = desc;
    }


    @Override
    public String toString() {
        return number + " " + desc;
    }

    static Options numberToCategory(int number) {

        if (number < 1 || number > values().length)
            throw new InvalidOptionException();
            return values()[number - 1];
        }
    }

