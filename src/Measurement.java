public final class Measurement {
    private final double value;
    private final Unit unit;

    public Measurement(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object obj) {
        Measurement other = (Measurement) obj;

        return this.representAsInch() == other.representAsInch();

    }

    private double representAsInch() {
        return this.unit.representAsInch(this.value);
    }
}
