public class task23 {
    private int real;
    private int imaginary;

    public task23(int real, int imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public int getReal() {
        return real;
    }

    public void setReal(int real) {
        this.real = real;
    }

    public int getImaginary() {
        return imaginary;
    }

    public void setImaginary(int imaginary) {
        this.imaginary = imaginary;
    }

    public task23 add(task23 other) {
        int realResult = this.real + other.real;
        int imaginaryResult = this.imaginary + other.imaginary;
        return new task23(realResult, imaginaryResult);
    }

    public task23 subtract(task23 other) {
        int realResult = this.real - other.real;
        int imaginaryResult = this.imaginary - other.imaginary;
        return new task23(realResult, imaginaryResult);
    }

    public task23 multiply(task23 other) {
        int realResult = (this.real * other.real) - (this.imaginary * other.imaginary);
        int imaginaryResult = (this.real * other.imaginary) + (this.imaginary * other.real);
        return new task23(realResult, imaginaryResult);
    }

    @Override
    public String toString() {
        return real + " + " + imaginary + "i";
    }
}
