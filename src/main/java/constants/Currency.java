package constants;

import lombok.Getter;

public enum Currency {
    USD("USD"), EUR("EUR"), BYN("BYN");

    @Getter
    private final String name;

    Currency(String name) {
        this.name = name;
    }
}
