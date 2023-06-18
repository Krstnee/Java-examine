public class task26 {
    public static void main(String[] args) {
        // Пример использования
        RGBConverter rgbConverter = new RGBConverter();
        CMYKConverter cmykConverter = new CMYKConverter();

        // RGB в CMYK
        int red = 125;
        int green = 200;
        int blue = 50;
        CMYKColor cmykColor = rgbConverter.convertToCMYK(red, green, blue);
        System.out.println("RGB to CMYK:");
        System.out.println("RGB(" + red + ", " + green + ", " + blue + ") -> CMYK(" +
                cmykColor.getCyan() + ", " + cmykColor.getMagenta() + ", " +
                cmykColor.getYellow() + ", " + cmykColor.getBlack() + ")");

        // CMYK в RGB
        double cyan = 0.3;
        double magenta = 0.6;
        double yellow = 0.1;
        double black = 0.2;
        RGBColor rgbColor = cmykConverter.convertToRGB(cyan, magenta, yellow, black);
        System.out.println("\nCMYK to RGB:");
        System.out.println("CMYK(" + cyan + ", " + magenta + ", " + yellow + ", " + black + ") -> RGB(" +
                rgbColor.getRed() + ", " + rgbColor.getGreen() + ", " + rgbColor.getBlue() + ")");
    }
}

class RGBConverter {
    public CMYKColor convertToCMYK(int red, int green, int blue) {
        double r = red / 255.0;
        double g = green / 255.0;
        double b = blue / 255.0;

        double k = 1 - Math.max(Math.max(r, g), b);
        double c = (1 - r - k) / (1 - k);
        double m = (1 - g - k) / (1 - k);
        double y = (1 - b - k) / (1 - k);

        return new CMYKColor(c, m, y, k);
    }
}

class CMYKConverter {
    public RGBColor convertToRGB(double cyan, double magenta, double yellow, double black) {
        int red = (int) Math.round(255 * (1 - cyan) * (1 - black));
        int green = (int) Math.round(255 * (1 - magenta) * (1 - black));
        int blue = (int) Math.round(255 * (1 - yellow) * (1 - black));

        return new RGBColor(red, green, blue);
    }
}

class CMYKColor {
    private double cyan;
    private double magenta;
    private double yellow;
    private double black;

    public CMYKColor(double cyan, double magenta, double yellow, double black) {
        this.cyan = cyan;
        this.magenta = magenta;
        this.yellow = yellow;
        this.black = black;
    }

    public double getCyan() {
        return cyan;
    }

    public double getMagenta() {
        return magenta;
    }

    public double getYellow() {
        return yellow;
    }

    public double getBlack() {
        return black;
    }
}

class RGBColor {
    private int red;
    private int green;
    private int blue;

    public RGBColor(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }
}
//Данный код решает задачу преобразования цветовых моделей RGB (Red Green Blue) и CMYK (Cyan Magenta Yellow Black) друг в друга.
//
//Классы RGBConverter и CMYKConverter представляют конвертеры для преобразования цветов из RGB в CMYK и обратно соответственно.
// Они содержат методы convertToCMYK и convertToRGB, которые принимают значения цветовых компонент (красный, зеленый,
// синий для RGB и циан, маджента, желтый, черный для CMYK) и выполняют соответствующие математические операции для
// преобразования цветов.
//
//Классы CMYKColor и RGBColor представляют объекты, содержащие значения цветовых компонент для CMYK и RGB соответственно.
//
//В методе main класса task26 создаются экземпляры конвертеров rgbConverter и cmykConverter. Затем демонстрируется пример
// использования конвертеров, где производятся преобразования цветов из RGB в CMYK и обратно. Результаты преобразований
// выводятся на экран.
//
//Таким образом, данная программа реализует функциональность конвертации цветовых моделей RGB и CMYK, позволяя получить
// значения цветовых компонент в каждой из моделей на основе исходных значений.