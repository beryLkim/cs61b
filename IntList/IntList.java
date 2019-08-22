package IntList;

/**
 * Created by baoyu on 2019/8/5.
 */
public class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }


    /**add the first item in the list*/
    public static IntList addFirst(int x,IntList f)
    {
        return new IntList(x,f);
    }

    /**@return the size of list using 递归*/
    public int size() {
        if (rest == null)
            return 1;
        else {
            return 1 + this.rest.size();
        }
    }
    /** @return the size of list using 迭代*/
    public int iterativeSize() {
        IntList p = this;
        int totalSize = 0;
        while (p != null) {
            totalSize++;
            p = p.rest;
        }
        return totalSize;
    }

    /**return ith item of the list using 递归*/
    public int get(int i)
    {
        if(i==0)
        {
            return this.first;
        }
        else
            return this.rest.get(i-1);
    }

    /**
     *Return an IntList identical to L, but with all values incremented by x.
     *Values in L cannot change!
     */
    public static IntList incrList(IntList L,int x)
    {
        if (L==null)
            return L;
        else
        {
            return new IntList(L.first+x,incrList(L.rest,x));
        }
    }

    /**
     * Returns an IntList identical to L, but with all values incremented by x.
     * Not allowed to use"new"(to save memory).
     */
    public static IntList dincrList(IntList L,int x) {
        IntList Q=L;
        while(Q!=null) {
            Q.first += 2;
            Q = Q.rest;
        }
        return L;
    }

    public static void main(String args[]) {
        IntList L = new IntList(15, null);
        L = new IntList(10, L);
       // L = new IntList(5, L);
        L=addFirst(5,L);
        System.out.println(L.size());
        System.out.println(L.iterativeSize());
        System.out.println(L.get(0)+";"+L.get(1)+";"+L.get(2));
        IntList Q=dincrList(L,2);
        System.out.println(Q.size());
        System.out.println(L.get(1));
        System.out.println(Q.get(2));
        System.out.println(Q.get(0));
    }
}
