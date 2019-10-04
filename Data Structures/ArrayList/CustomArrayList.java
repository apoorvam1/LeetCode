package ArrayList;

import java.util.Arrays;

public class CustomArrayList<T> {

    // constant that holds the initial capacity of the arraylist
    private final int INIT_CAPACITY = 10;

    // array underneath the arraylist
    private Object data[] = {};

    // current size of the arraylist
    private int size = 0;

    public CustomArrayList() {
        data = new Object[INIT_CAPACITY];
    }


    /*
     * if size has reached data length then increase capacity by 2
     * insert the element into the array and increase size
     */
    public void add(T element) {

        if(size == data.length) {
            increaseCapacity();
        }

        data[size++] = element;
    }

    /*
     * increase the array size by 2 and copy the contents
     */
    private void increaseCapacity() {
        data = Arrays.copyOf(data, size * 2);
    }

    /*
     * if index is invalid throw an expection
     * else return the value at index
     */
    public T get(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (T)data[index];
    }

    /*
     * if index is invalid throw exception
     * else remove index element and move all next elements 1 step back
     */
    public T remove(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Object val = data[index];
        moveArrayAtIndex(index);
        size--;
        return (T)val;
    }

    /*
     * left shifts the array elements by 1 index
     */
    private void moveArrayAtIndex(int index) {
        for(int i = index+1; i < size; i++) {
            data[i-1] = data[i];
        }
    }

    /*
     * return the size of arraylist
     */
    public int size() {
        return size;
    }

    /*
     * return an array form of the list
     */
    public Object[] toArray() {
        return Arrays.copyOf(data, size);
    }

    /*
     * element can be of any type, hence perform a null check
     * if found in array return true else return false
     * See how we compare using equals rather than '==' operator
     */
    public boolean contains(T element) {
        if(element == null) {
            throw new IllegalArgumentException("Invalid input. Cannot be null !!");
        }

        for(Object obj : data) {
            if(obj != null && obj.equals(element)) {
                return true;
            }
        }
        return false;
    }

    /*
     * if size is 0 list is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /*
     * create the data array again and set size to 0
     */
    public void reset() {
        size = 0;
        data = new Object[INIT_CAPACITY];
    }

    /*
     * prints all elements per index
     */
    public void print() {
        for(int i = 0; i < size; i++) {
            System.out.println("Index: " + i + ", Value: " + data[i]);
        }
    }

    public static void main(String[] args) {
        CustomArrayList<Integer> testList = new CustomArrayList<>();
        for(int i = 0; i < 11; i++) {
            testList.add(i);
        }

        System.out.println("testList size: " + testList.size);
        System.out.println("value at 4th index: " + testList.get(3));
        System.out.println("remove value at 4th index: " + testList.remove(3));

        System.out.println("6th element: " + testList.get(5));


        System.out.println(Arrays.toString(testList.toArray()));
        if(testList.contains(8)) {
            System.out.println("testList has 8");
        }
        if(testList.contains(3)) {
            System.out.println("testList has 8");
        } else {
            System.out.println("testList doesn't have 3");
        }

        if(testList.isEmpty()) {
            System.out.println("testList is empty");
        } else {
            System.out.println("testList is not empty");
        }

        System.out.println("Printing list");
        testList.print();

        System.out.println("Clearing testList");
        testList.reset();
        System.out.println("testList size after reset: " + testList.size());
    }
}
