package co.com.sofka.util;

public enum UserRole {
    ALL("All"),
    ADMIN("Admin"),
    ESS("Ess");

    private final String value;

    public String getValue() {
        return value;
    }

    UserRole(String value) {
        this.value = value;
    }
}
