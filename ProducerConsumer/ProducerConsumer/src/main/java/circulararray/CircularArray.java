package circulararray;

import java.util.NoSuchElementException;

public class CircularArray<E> {
    private E[] array;
    private int first;
    private int size;
    public CircularArray(int capacity){
        array = (E[]) new Object[capacity];
        first = 0;
        size = 0;
    }
    public int capacity(){
        return array.length;
    }
    public int size(){
        return size;
    }
    public int avaiablespace(){
        return capacity() - size();
    }
    public void addfirst(E element){
        if(avaiablespace()<0){
            throw new RuntimeException("circular array is full");
        }
        if(size == 0){
            first = 0;
        } else {
            first--;
            if(first < 0){
                first = array.length-1;
            }
        }
        array[first] = element;
        size++;
    }
    public void addlast(E element){
        if(avaiablespace()<1){
            throw new RuntimeException("circular array is full");
        }
        if(size == 0){
            first = 0;
        }
        int last = first + size;
        if(last >= array.length){
            last -= array.length;
        }
        array[last] = element;
        ++size;

    }
    public E removefirst(){
        if(size < 1){
            throw new NoSuchElementException("circular array is empty");
        }
        E element = array[first];
        array[first] = null;
        ++ first;
        if(first >= array.length){
            first = 0;
        }
        --size;
        return element;
    }
    public E removelast(){
        if(size < 1){
            throw new NoSuchElementException("circular array is empty");
        }
        int last = first + size-1;
        if(last >= array.length){
            last -= array.length;
        }
        E element = array[last];
        array[last] = null;
        --size;
        return element;
    }
    public String show(){
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < array.length; ++i){
            res.append((array[i]== null) ? "0" : "X");
        }
        res.append(System.lineSeparator());
        for(int i = 0; i<first; ++i){
            res.append(" ");
        }
        res.append("^");
        res.append(System.lineSeparator());
        res.append("size = ").append(size).append(System.lineSeparator());
        return res.toString();
    }
}
