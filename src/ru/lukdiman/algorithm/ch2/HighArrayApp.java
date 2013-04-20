package ru.lukdiman.algorithm.ch2;

public class HighArrayApp {
    public static void main(String[] args) {
        int maxSize = 100;
        HighArray arr = new HighArray(maxSize);

        arr.insert(77);
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);

        arr.display();

        long searchKey = 35;
        if (arr.find(searchKey)) {
            System.out.println("Found " + searchKey);
        } else {
            System.out.println("Can't find " + searchKey);
        }

        long maxValue = arr.removeMax();
        System.out.println("Максимальное значение массива до удаления элементов: " + maxValue);

        arr.delete(00);
        arr.delete(55);
        arr.delete(99);

        arr.display();

        maxValue = arr.removeMax();
        System.out.println("Максимальное значение массива после удаления элементов: " + maxValue);

        arr.display();

        HighArray sortedArray = new HighArray(maxSize);
        long elem;
        while((elem = arr.removeMax()) != -1) {
            sortedArray.insert(elem);
        }
        sortedArray.display();
    }
}

class HighArray {
    private long[] a;
    private int nElems;

    public HighArray(int size) {
        a = new long[size];
        nElems = 0; // Пока нет ниодного элемента
    }

    public void insert(long value) {
        a[nElems] = value;
        nElems++;
    }

    public boolean find(long searchKey) {
        int j;
        for (j = 0; j < nElems; j++) {
            if (a[j] == searchKey) {
                break;
            }
        }

        if (j == nElems) {
            return false;
        } else {
            return true;
        }
    }

    public long removeMax() {
        if (nElems == 0) { return -1; }

        int indexForRemove = 0;
        long maxValue = a[indexForRemove];
        for (int i = 1; i < nElems; i++) {
            if (a[i] > maxValue) {
                maxValue = a[i];
                indexForRemove = i;
            }
        }

        for (int i = indexForRemove; i < nElems-1; i++) {
            a[i] = a[i+1];
        }
        nElems--;

        return maxValue;
    }

    public boolean delete(long value) {
        int j;
        for (j = 0; j < nElems; j++) {
            if (a[j] == value) {
                break;
            }
        }

        if (j == nElems) {
            return false;
        } else {
            for (int k = j; k < nElems - 1; k++) {
                a[k] = a[k+1];
            }
            nElems--;

            return true;
        }
    }

    public void display() {
        for (int j = 0; j < nElems; j++) {
            System.out.print(a[j] + " ");
        }
        System.out.println();
    }
}
