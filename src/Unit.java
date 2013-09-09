public enum Unit {
    Inch(1),
    Foot(12);

    double unitValue;

    Unit(double unitValue) {
        this.unitValue = unitValue;
    }

    double representAsInch(double value) {
        return this.unitValue * value;
    }
}
