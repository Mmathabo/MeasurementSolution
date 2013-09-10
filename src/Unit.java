public class Unit {

    public static final Unit TEASPOON = new Unit(1, MeasurementUnit.VOLUME);
    public static final Unit TABLESPOON = new Unit(3, MeasurementUnit.VOLUME);
    public static final Unit INCH = new Unit(1, MeasurementUnit.DISTANCE);
    public static final Unit FOOT = new Unit(12, MeasurementUnit.DISTANCE);

    double unitValue;
    MeasurementUnit measurementUnit;

    private Unit(double unitValue, MeasurementUnit measurementUnit) {
        this.unitValue = unitValue;
        this.measurementUnit = measurementUnit;
    }

    double toBaseUnitValue(double value) {
        return this.unitValue * value;
    }

    boolean areMeasurementUnitsEqual(MeasurementUnit measurementUnit) {
        return this.measurementUnit == measurementUnit;
    }

    static Unit toBaseUnit(Unit unit) {
        if (unit.measurementUnit == MeasurementUnit.DISTANCE) {
            return INCH;
        }
        return TEASPOON;
    }

}


