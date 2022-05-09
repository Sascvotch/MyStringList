package ru.skypro;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class MyStringList implements StringList {

    private String[] myArrayList;
    private int countElements = 0;

    public MyStringList() {
        myArrayList = new String[0];

    }

    @Override
    public String add(String item) throws MyException {
        int index = countElements;
        add(index, item);
        return item;
    }

    @Override
    public String add(int index, String item) throws MyException {
        if (item == null) {
            throw new MyException("Введите значение");
        } else if (index > countElements) {
            throw new MyException("Индекс превышает массив");
        } else {
            String[] tempArray = Arrays.copyOf(myArrayList, index);
            String[] tempArrayAfterIndex = Arrays.copyOfRange(myArrayList, index, countElements);
            myArrayList = new String[countElements + 1];
            myArrayList = Arrays.copyOf(tempArray, countElements + 1);
            myArrayList[index] = item;
            System.arraycopy(tempArrayAfterIndex, 0, myArrayList, index + 1, tempArrayAfterIndex.length);
            countElements++;
            System.out.println("Элемент " + item + " добавлен на позицию " + index + " Теперь массив:" + Arrays.toString(myArrayList));
            return item;
        }
    }

    @Override
    public String set(int index, String item) throws MyException {
        if (item == null) {
            throw new MyException("Введите значение");
        } else if (index > countElements) {
            throw new MyException("Индекс превышает массив");
        } else {
            myArrayList[index] = item;
            System.out.println("Элемент " + item + " добавлен на позицию " + index + " Массив теперь:" + Arrays.toString(myArrayList));
            return item;
        }
    }

    @Override
    public String remove(String item) throws MyException {
        if (item == null) {
            throw new MyException("Введите значение");
        } else {
            int index = indexOf(item);
            if (index == -1) {
                throw new MyException("Такого элемента нет");
            }
            remove(index);
            return item;
        }
    }

    @Override
    public String remove(int index) throws MyException {
        if (index < 0 || index > countElements) {
            throw new MyException("Введите корректное значение в диапозоне от 0 до " + myArrayList.length);
        } else {
            String[] tempArray = Arrays.copyOf(myArrayList, countElements);
            myArrayList = new String[countElements - 1];
            System.arraycopy(tempArray, 0, myArrayList, 0, index);
            System.arraycopy(tempArray, index + 1, myArrayList, index, tempArray.length - index - 1);
            countElements--;
            System.out.println("Элемент с индексом " + index + " удален. Теперь массив: " + Arrays.toString(myArrayList));
            return tempArray[index];
        }
    }

    @Override
    public boolean contains(String item) throws MyException {
        if (item == null) {
            throw new MyException("Введите значение");
        } else {
            boolean contain = false;
            for (int i = 0; i < countElements && contain != true; i++) {
                if (myArrayList[i].equals(item)) {
                    contain = true;
                }
            }
            System.out.println("Элемент " + item + " содержится в массиве " + Arrays.toString(myArrayList) + contain);
            return contain;
        }
    }

    @Override
    public int indexOf(String item) throws MyException {
        if (item == null) {
            throw new MyException("Введите значение");
        } else {
            int index = -1;
            for (int i = 0; i < countElements && index == -1; i++) {
                if (myArrayList[i].equals(item)) {
                    index = i;
                }
            }
            if (index == -1) {
                System.out.println("Элемент " + item + "  не найден в массиве " + Arrays.toString(myArrayList));
            } else {
                System.out.println("Первое вхождение элемента " + item + " на позиции " + index + " в массиве " + Arrays.toString(myArrayList));
            }
            return index;
        }
    }

    @Override
    public int lastIndexOf(String item) throws MyException {
        if (item == null) {
            throw new MyException("Введите значение");
        } else {
            int index = -1;
            for (int i = countElements - 1; i >= 0 && index == -1; i--) {
                if (myArrayList[i].equals(item)) {
                    index = i;
                }
            }
            if (index == -1) {
                System.out.println("Элемент " + item + "  не найден в массиве " + Arrays.toString(myArrayList));
            } else {
                System.out.println("Последнее вхождение элемента " + item + " на позиции " + index + " в массиве " + Arrays.toString(myArrayList));
            }
            return index;
        }
    }

    @Override
    public String get(int index) throws MyException {
        if (index < 0 || index > countElements) {
            throw new MyException("Введите корректное значение в диапозоне от 0 до " + myArrayList.length);
        } else {
            System.out.println("Элемент " + myArrayList[index] + " на позиции " + index + " В массиве " + Arrays.toString(myArrayList));
            return myArrayList[index];
        }
    }

    @Override
    public boolean equals(StringList[] otherList) throws MyException {
        if (otherList == null) {
            throw new MyException("Введите значение");
        } else {
            boolean equal = true;
            for (int i = 0; i < myArrayList.length && equal == true; i++) {
                if (!Objects.equals(otherList[i], myArrayList[i])) {
                    equal = false;
                }
            }
            System.out.println("equal" + equal);
            return equal;
        }
    }

    @Override
    public int size() {
        System.out.println("Размер маасива " + Arrays.toString(myArrayList) + " -- " + countElements + " элементов");
        return countElements;
    }

    @Override
    public boolean isEmpty() {
        if (countElements == 0) {
            System.out.println("Массив" + Arrays.toString(myArrayList) + "Пуст");
            return true;
        } else {
            System.out.println("Массив" + Arrays.toString(myArrayList) + "Полон");
            return false;
        }
    }

    @Override
    public void clear() {
        myArrayList = new String[0];
        countElements = 0;
        System.out.println(Arrays.toString(myArrayList));
    }

    @Override
    public String[] toArray() {
        List<String> listFromString = Arrays.asList("0", "1", "2", "3", "4");
        String[] arrayFromList = new String[listFromString.size()];
        for (int i = 0; i < listFromString.size(); i++) {
            arrayFromList[i] = listFromString.get(i);
        }
        System.out.println(Arrays.toString(arrayFromList));
        return arrayFromList;
    }

    public String[] toArray(List<String> listFromString) {
        String[] arrayFromList = new String[listFromString.size()];
        for (int i = 0; i < listFromString.size(); i++) {
            arrayFromList[i] = listFromString.get(i);
        }
        System.out.println(Arrays.toString(arrayFromList));
        return arrayFromList;
    }

    static class MyException extends Exception {
        public MyException(String message) {
            super(message);
        }
    }
}
