/**
 * Created by baoyu on 2019/8/30.
 */

import java.util.Objects;

/**
 * items array will be like:a,b,c, ,d,e; when nextFirst==nextLast,will call "resize"function.
 */
public class ArrayDeque<T> {
    T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = items.length - 1;
        nextLast = 0;
    }

    public ArrayDeque(ArrayDeque other) {
    }

    public void addFirst(T x) {
        if (nextFirst == nextLast) {
            addSize();
        }
        items[nextFirst] = x;
        if (nextFirst == 0) {
            nextFirst += items.length;
        }
        nextFirst -= 1;
        size += 1;
    }

    public void addLast(T x) {
        if (nextFirst == nextLast) {
            addSize();
        }
        items[nextLast] = x;
        if (nextLast == items.length - 1) {
            nextLast -= items.length;
        }
        nextLast += 1;
        size += 1;
    }

    private void addSize() {
        T[] reitems = (T[]) new Object[items.length * 2];
        System.arraycopy(items, 0, reitems, 0, nextLast);
        if (nextFirst != items.length - 1) {
            System.arraycopy(items, nextFirst + 1, reitems, items.length + nextFirst + 1, items.length - nextFirst - 1);
        }
        nextFirst = items.length + nextFirst;
        items = reitems;
    }

    public boolean isEmpty() {
        if (size == 0)
            return true;
        return false;
    }

    public int size() {
        return size;
    }


    public void printDeque() {
        if(isEmpty())
            return;
        int i = nextFirst + 1;
        for (; i < items.length; i++) {
            if (i == nextLast) {
                System.out.println();
                return;
            }
            System.out.print(items[i] + " ");
        }
        for (i = 0; i < nextLast; i++) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }



    public T removeFirst() {
        if(isEmpty())
            return null;
        double rate = (double) (size - 1) / items.length;
        if (rate <= 0.25 && items.length > 8) {
            reduceSize();
        }
        if (nextFirst == items.length - 1) {
            nextFirst -= items.length;
        }
        nextFirst += 1;
        T x = items[nextFirst];
        items[nextFirst] = null;
        size -= 1;
        return x;
    }

    public T removeLast() {
        if(isEmpty())
            return null;
        double rate = (double) (size - 1) / items.length;
        if (rate <= 0.25 && items.length > 8) {
            reduceSize();
        }
        if (nextLast == 0) {
            nextLast += items.length;
        }
        nextLast -= 1;
        T x = items[nextLast];
        items[nextLast] = null;
        size -= 1;
        return x;
    }

    private void reduceSize() {
        /**
         *  , ,nF,a,b,c,nL, , ,
         */


        if (nextFirst < nextLast) {
            T[] reitems = (T[]) new Object[items.length / 2];
            System.arraycopy(items, nextFirst + 1, reitems, 0, size);
            nextLast = size;
            nextFirst = reitems.length - 1;
            items = reitems;
        }
        /**
         * a,b,c,nL, , ,nF
         * a,b,nL, , , nF,c
         * nL, , , nF,a,b,c
         */
        else {
            T[] reitems = (T[]) new Object[items.length / 2];
            System.arraycopy(items, 0, reitems, 0, nextLast);
            System.arraycopy(items, nextFirst + 1, reitems, reitems.length - (items.length - nextFirst + 1), items.length - nextFirst + 1);
            nextFirst = reitems.length - (items.length - nextFirst + 1) - 1;
            items = reitems;
        }

    }

    public T get(int index) {
        return null;
    }

    public static void main(String args[]) {
        ArrayDeque a = new ArrayDeque();
        for(int i=0;i<20;i++)
        {
            a.addFirst(i);
            a.printDeque();
        }
        for(int i=0;i<21;i++)
        {
            if(i%2==0)
            {
                a.removeFirst();
            }
            else
                a.removeLast();
            a.printDeque();
        }
    }

}
