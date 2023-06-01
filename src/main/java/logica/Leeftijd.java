package logica;

public enum Leeftijd {
    LEEFTIJD_9_10("9-10"),
    LEEFTIJD_11_12("11-12"),
    LEEFTIJD_13_14("13-14"),
    LEEFTIJD_15_16("15-16"),
    LEEFTIJD_17_18("17-18"),
    LEEFTIJD_11_PLUS("11+");

    private final String label;

    private Leeftijd(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
    public static Leeftijd valueOfLabel(String label) {
        for (Leeftijd leeftijd : values()) {
            if (leeftijd.getLabel().equals(label)) {
                return leeftijd;
            }
        }
        throw new IllegalArgumentException("Geen leeftijd gevonden voor label: " + label);
    }

    public String getLabel() {
        return label;
    }
}


