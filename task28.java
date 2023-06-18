public class task28 {
    private double[] weights;
    private double bias;

    public task28(double[] weights, double bias) {
        this.weights = weights;
        this.bias = bias;
    }

    public double sigmoid(double x) {
        return 1 / (1 + Math.exp(-x));
    }

    public double feedForward(double[] inputs) {
        if (inputs.length != weights.length) {
            throw new IllegalArgumentException("Неправильное количество входных значений.");
        }

        double sum = bias;
        for (int i = 0; i < inputs.length; i++) {
            sum += inputs[i] * weights[i];
        }

        return sigmoid(sum);
    }

    public static void main(String[] args) {
        double[] weights = {0.5, 0.7}; // Веса нейронов
        double bias = 0.3; // Смещение (bias)

        task28 neuron = new task28(weights, bias);

        double[] inputs = {0.8, 0.2}; // Входные значения

        double output = neuron.feedForward(inputs);

        System.out.println("Выходное значение: " + output);
    }
}