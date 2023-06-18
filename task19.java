//19. Создать класс Matrix для работы с двумерными матрицами. Создать методы для  генерации нулевой матрицы,
// а также для генерации матрицы со случайными величинами – применить Math.random(). Реализовать метод сложения матриц.
public class task19 {
    private int rows;
    private int cols;
    private double[][] data;

    public task19(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.data = new double[rows][cols];
    }

    public task19(double[][] data) {
        this.rows = data.length;
        this.cols = data[0].length;
        this.data = data;
    }

    public static task19 zeros(int rows, int cols) {
        return new task19(rows, cols);
    }

    public static task19 random(int rows, int cols) {
        task19 task19 = new task19(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                task19.data[i][j] = Math.random();
            }
        }
        return task19;
    }

    public task19 add(task19 other) {
        if (this.rows != other.rows || this.cols != other.cols) {
            throw new IllegalArgumentException("Matrices must have the same dimensions");
        }

        task19 result = new task19(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.data[i][j] = this.data[i][j] + other.data[i][j];
            }
        }

        return result;
    }

    public void print() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        task19 a = task19.random(3, 3);
        task19 b = task19.zeros(3, 3);
        task19 c = a.add(b);

        System.out.println("Матрица a:");
        a.print();
        System.out.println("Матрица b:");
        b.print();
        System.out.println("Матрица c:");
        c.print();


    }
}