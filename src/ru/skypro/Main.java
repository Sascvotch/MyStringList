package ru.skypro;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws MyStringList.MyException {
        MyStringList otherList = new MyStringList();
        List<String> listFromString = Arrays.asList("0", "1", "2", "3", "4");
        otherList.toArray(listFromString);

        MyStringList myStringList = new MyStringList();
        myStringList.add("0");
        myStringList.add("1");
        myStringList.add("2");
        myStringList.add("8");
        myStringList.remove(1);
        myStringList.add(1, "3");
        myStringList.set(2, "4");
        myStringList.equals(otherList);
        myStringList.equals("6, 3, 4");
        myStringList.equals("6, 3");
        myStringList.size();
        myStringList.remove("3");
        myStringList.remove(1);
        myStringList.contains("6");
        myStringList.contains("8");
        myStringList.indexOf("0");
        myStringList.indexOf("8");
        myStringList.lastIndexOf("3");
        myStringList.get(0);
        myStringList.clear();
        myStringList.isEmpty();
        myStringList.toArray();

    }
}
