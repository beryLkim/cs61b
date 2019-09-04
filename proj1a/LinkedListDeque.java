
/**
 * Created by baoyu on 2019/8/26.
 */
public class LinkedListDeque <T>{
    private class Node{
        T item;
        Node prev;
        Node next;
        Node(T value)
        {
            item=value;
        }
    }
    private Node sentinel;
    private int size;

    public LinkedListDeque()
    {
        sentinel=new Node(null);
        size=0;
        sentinel.prev=sentinel;
        sentinel.next=sentinel;
    }

    public LinkedListDeque(LinkedListDeque other)
    {
        sentinel=new Node(null);
        size=0;
        sentinel.prev=sentinel;
        sentinel.next=sentinel;

        for(int i=1;i<other.size+1;i++)
        {
            this.addLast((T)other.get(i));
        }
    }

    public void addFirst(T x)
    {
        Node first=new Node(x);
        first.next=sentinel.next;
        sentinel.next=first;
        first.prev=sentinel;
        first.next.prev=first;
        size+=1;
    }

    public void addLast(T x)
    {
        Node last=new Node(x);
        last.prev=sentinel.prev;
        sentinel.prev=last;
        last.next=sentinel;
        last.prev.next=last;
        size+=1;
    }

    public boolean isEmpty()
    {
        if(size==0)
            return true;
        return false;
    }

    public int size()
    {
        return size;
    }
    public void printDeque()
    {
        Node i=sentinel.next;
        while(i!=sentinel)
        {
            System.out.print(i.item+" ");
            i=i.next;
        }
        System.out.println();
    }

    public T removeFirst()
    {
        T x=sentinel.next.item;
        sentinel.next=sentinel.next.next;
        sentinel.next.prev=sentinel;
        return x;
    }

    public T removeLast()
    {
        T x=sentinel.prev.item;
        sentinel.prev=sentinel.prev.prev;
        sentinel.prev.next=sentinel;
        return x;
    }

    public T get(int index)
    {
        if(index>size)
        {
            return null;
        }
        Node x=sentinel;
        for(int i=0;i<index;i++)
        {
            x=x.next;
        }
        return x.item;
    }

    public T getRecursive(Node x,int index)
    {
        if(index!=0)
        {
            return getRecursive(x.next,index--);
        }
        return x.item;
    }

    public static void main(String args[])
    {

    }
}
