public enum Unit {
    Inch(1),
    Foot(0.83333);

    double unitValue;

    Unit(double unitValue) {
         this.unitValue = unitValue;
    }

    double returnInch(double value) {
       return this.unitValue * value;
    }
 }
