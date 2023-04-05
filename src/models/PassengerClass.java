package models;

public enum PassengerClass {
    FIRST_CLASS("1st"),
    SECOND_CLASS("2nd"),
    THIRD_CLASS("3rd");

    private String className;

    PassengerClass(String name){
        this.className = name;
    }

    public static PassengerClass getPassengerClassByValue(String name) {
        PassengerClass type;
        switch (name) {
            case "1st":
                type = PassengerClass.FIRST_CLASS;
                break;
            case "2nd":
                type = PassengerClass.SECOND_CLASS;
                break;
            case "3rd":
                type = PassengerClass.THIRD_CLASS;
                break;
            default:
                throw new IllegalArgumentException("Invalid passenger class: " + name);
        }

        return type;
    }
}
