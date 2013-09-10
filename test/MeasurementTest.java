import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class MeasurementTest {

    @Test
    public void shouldVerifyThatOneInchIsEqualsToOneInch() {
        assertThat(new Measurement(1, Unit.INCH), is(new Measurement(1, Unit.INCH)));
    }

    @Test
    public void shouldVerifyThatOneInchIsNotEqualToOneFoot() {
        assertThat(new Measurement(1, Unit.INCH), is(not(new Measurement(1, Unit.FOOT))));
    }

    @Test
    public void shouldVerifyThatOneFootIsEqualToTwelveInches() {
        assertThat(new Measurement(1, Unit.FOOT), is(new Measurement(12, Unit.INCH)));
    }

    @Test
    public void shouldVerifyThatOneInchIsNotEqualToTwoInches() throws Exception {
        assertThat(new Measurement(1, Unit.INCH), is(not(new Measurement(2, Unit.INCH))));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfUnitValueIsNegative() throws Exception {
        new Measurement(-1, Unit.INCH);
    }

    @Test
    public void shouldVerifyThatOneInchIsNotNull() {
        assertNotNull(new Measurement(1, Unit.INCH));
    }

    @Test
    public void shouldVerifyThatOneTableSpoonIsEqualToThreeTeaSpoons() {
        assertThat(new Measurement(1, Unit.TABLESPOON), is(new Measurement(3, Unit.TEASPOON)));
    }

    @Test
    public void shouldVerifyThatOneTeaSpoonIsNotEqualToOneInch() throws Exception {
        assertFalse(new Measurement(1, Unit.TEASPOON).equals(new Measurement(1, Unit.INCH)));
    }

    @Test
    public void shouldReturnSumOfOneInchAndTwoInchesAsThreeInches() {
        Measurement firstMeasurement = new Measurement(1, Unit.INCH);
        Measurement secondMeasurement = new Measurement(2, Unit.INCH);

        assertThat(firstMeasurement.plus(secondMeasurement), is(new Measurement(3, Unit.INCH)));
    }

    @Test
    public void shouldReturnSumOfOneInchAndOneFootAsThirteenInches() {
        Measurement firstMeasurement = new Measurement(1, Unit.INCH);
        Measurement secondMeasurement = new Measurement(1, Unit.FOOT);

        assertThat(firstMeasurement.plus(secondMeasurement), is(new Measurement(13, Unit.INCH)));
    }

    @Test
    public void shouldReturnSumOfOneTeaspoonAndOneTableSpoonAsFourTeaspoons() throws Exception {

        Measurement firstMeasurement = new Measurement(1, Unit.TEASPOON);
        Measurement secondMeasurement = new Measurement(1, Unit.TABLESPOON);

        assertThat(firstMeasurement.plus(secondMeasurement), is(new Measurement(4, Unit.TEASPOON)));

    }

    @Test
    public void shouldReturnSumOfOneTeaspoonAndTwoTableSpoonsAsSevenTeaspoons() throws Exception {

        Measurement firstMeasurement = new Measurement(2, Unit.TABLESPOON);
        Measurement secondMeasurement = new Measurement(1, Unit.TEASPOON);

        assertThat(firstMeasurement.plus(secondMeasurement), is(new Measurement(7, Unit.TEASPOON)));

    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForDifferentMeasurementUnitTypes() throws Exception {

        Measurement firstMeasurement = new Measurement(2, Unit.INCH);
        Measurement secondMeasurement = new Measurement(1, Unit.TEASPOON);

        firstMeasurement.plus(secondMeasurement);

    }

}
