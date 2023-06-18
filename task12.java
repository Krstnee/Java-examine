public class task12 {
    private double value;

    public task12(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public static task12 add(task12 a, task12 b) {
        double result = a.getValue() + b.getValue();
        return new task12(result);
    }

    public static task12 divide(task12 a, task12 b) {
        double result = a.getValue() / b.getValue();
        return new task12(result);
    }

    public static task12 power(task12 base, task12 exponent) {
        double result = Math.pow(base.getValue(), exponent.getValue());
        return new task12(result);
    }
}
