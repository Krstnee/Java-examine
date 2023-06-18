class zad5 {
    int value;
    zad5 left;
    zad5 right;

    public zad5(int value) {
        this.value = value;
        left = null;
        right = null;
    }
}

public class task5 {
    zad5 root;

    public task5() {
        root = null;
    }

    // Вставка значения в бинарное дерево поиска
    public void insert(int value) {
        if (root == null) {
            // Если дерево пустое, создаем корневой узел
            root = new zad5(value);
            return;
        }

        zad5 current = root;
        while (true) {
            if (value < current.value) {
                // Если значение меньше текущего, переходим к левому поддереву
                if (current.left == null) {
                    // Если левое поддерево пустое, вставляем новый узел
                    current.left = new zad5(value);
                    return;
                }
                current = current.left;
            } else {
                // Если значение больше или равно текущему, переходим к правому поддереву
                if (current.right == null) {
                    // Если правое поддерево пустое, вставляем новый узел
                    current.right = new zad5(value);
                    return;
                }
                current = current.right;
            }
        }
    }

    // Поиск значения в бинарном дереве поиска
    public boolean search(int value) {
        zad5 current = root;
        while (current != null) {
            if (value == current.value) {
                // Значение найдено
                return true;
            } else if (value < current.value) {
                // Если значение меньше текущего, переходим к левому поддереву
                current = current.left;
            } else {
                // Если значение больше текущего, переходим к правому поддереву
                current = current.right;
            }
        }
        // Значение не найдено
        return false;
    }

    public static void main(String[] args) {
        task5 bst = new task5();
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        boolean searchResult = bst.search(100);
        System.out.println("Search for value 40: " + searchResult);
    }
}
