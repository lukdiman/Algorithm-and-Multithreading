package ru.lukdiman.algorithm.ch2;

public class OrderedApp {
    public static void main(String[] args) {
        int maxSize = 100;
        OrdArray arr = new OrdArray(maxSize);

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

        int searchKey = 56;
        if (arr.find(searchKey) != arr.size()) {
            System.out.println("Found " + searchKey);
        } else {
            System.out.println("Can't find " + searchKey);
        }

        arr.display();

        arr.delete(00);
        arr.delete(55);
        arr.delete(99);

        arr.display();

        OrdArray newArr = new OrdArray(maxSize);
        newArr.insert(10);
        newArr.insert(20);
        newArr.insert(30);
        newArr.insert(40);
        newArr.merge(arr);
        newArr.display();
    }
}

class OrdArray {
    private long[] a;
    private int nElems;
    private int upperBound;
    private int lowerBound;

    public OrdArray(int size) {
        a = new long[size];
        nElems = 0;
    }

    public int size() {
        return nElems;
    }

    public int find(long searchKey) {
        int curIn;
        lowerBound = 0;
        upperBound = nElems-1;
        while (true) {
            curIn = (lowerBound + upperBound) / 2;
            if (a[curIn] == searchKey) {
                return curIn;
            } else if (lowerBound > upperBound) {
                return nElems;
            } else {
                if (a[curIn] > searchKey) {
                    upperBound = curIn - 1;
                } else {
                    lowerBound = curIn + 1;
                }
            }
        }
    }

    public void insert(long value) {
        int foundIndex = find(value);
        if (foundIndex != nElems) { return; }

        for (int i = nElems; i > lowerBound; i--) {
            a[i] = a[i-1];
        }
        a[lowerBound] = value;
        nElems++;
    }

    public boolean delete(long value) {
        int j = find(value);
        if (j == nElems) {
            return false;
        }

        for (int k = j; k < nElems-1; k++) {
            a[k] = a[k+1];
        }
        nElems--;

        return true;
    }

    public void merge(OrdArray arr) {
        for (int i = 0; i < arr.nElems; i++) {
            int foundIndex = find(arr.a[i]);
            if (foundIndex != nElems) { continue; }

            for (int j = nElems; j > lowerBound; j--) {
                a[j] = a[j-1];
            }
            a[lowerBound] = arr.a[i];
            nElems++;
        }
    }

    public void display() {
        for (int j = 0; j < nElems; j++) {
            System.out.print(a[j] + " ");
        }
        System.out.println();
    }
}
