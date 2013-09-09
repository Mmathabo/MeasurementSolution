public final class Measurement {
    private final double value;
    private final Unit unit;

    public Measurement(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object obj) {
         Measurement other = (Measurement)obj;

        return this.unit.returnInch(this.value) == other.unit.returnInch(other.value);

    }
}
