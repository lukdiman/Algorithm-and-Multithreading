package ru.lukdiman.algorithm.ch3;

/**
 * User: Diman
 * Date: 27.04.13 23:53
 */
public class BubbleSortApp {
    public static void main(String[] args) {
        int maxSize = 100;
        ArrayBub arr = new ArrayBub(maxSize);

        arr.insert(9);
        arr.insert(8);
        arr.insert(7);
        arr.insert(6);
        arr.insert(5);
        arr.insert(4);
        arr.insert(3);
        arr.insert(2);
        arr.insert(1);
        arr.insert(0);

        arr.display();

        arr.bubbleSort();
        arr.display();
    }
}

class ArrayBub {
    private long[] a;
    private int nElems;

    public ArrayBub(int max) {
        a = new long[max];
        nElems = 0;
    }

    public void insert(long value) {
        a[nElems] = value;
        nElems++;
    }

    public void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public void bubbleSort() {
        for (int i = nElems-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j+1]) {
                    long temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }
}
