package ru.lukdiman.algorithm.ch2;

public class ClassDataApp {
    public static void main(String[] args) {
        int maxSize = 10;
        ClassDataArray arr = new ClassDataArray(maxSize);

        arr.insert("Patty", "Evans", 24);
        arr.insert("Lorraine", "Smith", 37);
        arr.insert("Tom", "Yee", 43);
        arr.insert("Henry", "Adams", 63);
        arr.insert("Sato", "Hashimoto", 21);
        arr.insert("Henry", "Stimson", 29);
        arr.insert("Jose", "Velasquez", 72);
        arr.insert("Henry", "Lamarque", 54);
        arr.insert("Minh", "Vang", 22);
        arr.insert("Lucinda", "Creswell", 18);

        arr.display();

        String searchKey = "Stimson";
        Person found = arr.find(searchKey);
        if (found == null) {
            System.out.println("Can't find " + searchKey);
        } else {
            System.out.print("Found ");
            found.display();
        }

        System.out.println("Deleting Smith, Yee and Creswell");
        arr.delete("Smith");
        arr.delete("Yee");
        arr.delete("Creswell");

        arr.display();
    }
}

class ClassDataArray {
    private Person[] a;
    private int nElems;

    public ClassDataArray(int size) {
        a = new Person[size];
        nElems = 0;
    }

    public Person find(String searchName) {
        int j;
        for (j = 0; j < nElems; j++) {
            if (a[j].getLastName().equals(searchName)) {
                break;
            }
        }

        if (j == nElems) {
            return null;
        } else {
            return a[j];
        }
    }

    public void insert(String firstName, String lastName, int age) {
        a[nElems] = new Person(firstName, lastName, age);
        nElems++;
    }

    public boolean delete(String searchName) {
        int j;
        for (j = 0; j < nElems; j++) {
            if (a[j].getLastName().equals(searchName)) {
                break;
            }
        }

        if (j == nElems) {
            return false;
        } else {
            for (int k = j; k < nElems-1; k++) {
                a[k] = a[k+1];
            }
            nElems--;
            return true;
        }
    }

    public void display() {
        for (int j = 0; j < nElems; j++) {
            a[j].display();
        }
    }
}

class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public void display() {
        System.out.print("Last name: " + lastName);
        System.out.print(", First name: " + firstName);
        System.out.println(", Age: " + age);
    }

    public String getLastName() {
        return lastName;
    }
}
