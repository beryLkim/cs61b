package Test;
/**
 * Created by baoyu on 2019/9/4.
 */
public class Sort {
    public static void sort(String[] input,int startIndex) {
        if(startIndex==input.length-1)
            return;
        else {
            int smallestIndex = findSmallestIndex(input, startIndex);
            swap(input, startIndex, smallestIndex);
            sort(input,startIndex+1);
        }

    }
    public static int findSmallestIndex(String[] x,int startIndex)
    {
        int smallestIndex=startIndex;
        for(int i=startIndex;i<x.length;i++)
        {
            if(x[i].compareTo(x[smallestIndex])<0)
            {
                smallestIndex=i;
            }
        }
        return smallestIndex;
    }

    public static void swap(String x[],int a,int b)
    {
        String mark=x[a];
        x[a]=x[b];
        x[b]=mark;
    }
}
