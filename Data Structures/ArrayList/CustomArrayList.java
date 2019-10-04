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


    public static void main(String[] args) {
        CustomArrayList<Integer> testList = new CustomArrayList<>();
        for(int i = 0; i < 11; i++) {
            testList.add(i);
        }

        System.out.println("testList size: " + testList.size);
    }
}
