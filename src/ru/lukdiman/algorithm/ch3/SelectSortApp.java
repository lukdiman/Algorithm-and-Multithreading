package ru.lukdiman.algorithm.ch3;

/**
 * User: Diman
 * Date: 28.04.13 8:44
 */
public class SelectSortApp {
    public static void main(String[] args) {
        int maxSize = 100;
        ArraySel arr = new ArraySel(maxSize);

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

        arr.selectionSort();
        arr.display();
    }
}

class ArraySel {
    private long[] a;
    private int nElems;

    public ArraySel(int max) {
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

    public void selectionSort() {
        int min;
        for (int i = 0; i < nElems-1; i++) {
            min = i;
            for (int j = i+1; j < nElems; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }

            long temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
    }
}
