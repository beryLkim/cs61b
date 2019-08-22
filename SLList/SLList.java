package SLList;

/**
 * Created by baoyu on 2019/8/14.
 */
public class SLList {
    /**
     * static means the "IntNode" can never use the stuff of SLList
     */
    private static class IntNode {
        int item;
        IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }

    }

    private IntNode first;
    private int size;

    public SLList()
    {
        first=null;
        size=0;
    }

    public SLList(int x) {
        first = new IntNode(x, null);
        size=1;
    }

    /**
     * Adds x to the front of the list
     */
    public void addFirst(int x) {
        first = new IntNode(x, first);
        size+=1;
    }

    /**
     * Return the first item in the list
     */
    public int getFirst() {
        return first.item;
    }

    /**
    *Adds an item to the end of the list.
     */
    public void addLast(int x) {
        size += 1;
        if(first==null)
        {
            first=new IntNode(x,null);
        }
        else {
            IntNode p = first;
            while (p.next != null)
                p = p.next;
            p.next = new IntNode(x, null);
        }

    }

    /**
     *Return the size of the list 递归
     */
   /* private static int size(IntNode p)
    {
        if (p.next!=null)
            return 1+size(p.next);
        else return 1;
    }
    */
    public int size()
    {
        return size;
    }


    public static void main(String args[]) {
       SLList L1 = new SLList();
       // L1.addFirst(10);
       // L1.addFirst(5);
        L1.addLast(20);
        System.out.println(L1.first.item);
    }
}
