public final class Measurement {
    private final double value;
    private final Unit unit;

    public Measurement(double value, Unit unit) throws IllegalArgumentException {
        if (value < 0) throw new IllegalArgumentException();
        this.value = value;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Measurement) {
            Measurement other = (Measurement) obj;

            return this.unit.toBaseUnitValue(value) == other.unit.toBaseUnitValue(other.value)
                    && this.unit.areMeasurementUnitsEqual(other.unit.measurementUnit);
        }

        return false;
    }

    public Measurement plus(Measurement other) {
        if (!this.unit.areMeasurementUnitsEqual(other.unit.measurementUnit))
            throw new IllegalArgumentException();

        return new Measurement(sumOfValues(other), Unit.toBaseUnit(unit));
    }

    private double sumOfValues(Measurement other) {
        return unit.toBaseUnitValue(value) + other.unit.toBaseUnitValue(other.value);
    }
}
