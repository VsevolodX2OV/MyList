package com.jetbrains;

public class Main {

    public static void main(String[] args) {
        MyList myList = new MyList();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);
        myList.add(6);
        myList.indexAt(4);
        System.out.println(myList);
        myList.swap(2, 4);
        System.out.println(myList);
        myList.swap(0, 3);
        System.out.println(myList);
    }
}
