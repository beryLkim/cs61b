package Test;
/**
 * Created by baoyu on 2019/9/4.
 */
public class TestSort {
    public static void testSort()
    {
        String[] input={"i","have","an","eg"};
        String[] expected={"an","eg","have","i"};
        Sort.sort(input,0);
        /*using junit to replace the loop*/
        org.junit.Assert.assertArrayEquals(expected,input);
        /**
         for (int i = 0; i < input.length; i += 1) {
         if (!input[i].equals(expected[i])) {
         System.out.println("Mismatch in position " + i + ", expected: " + expected + ", but got: " + input[i] + ".");
         break;
         }
         */
    }

    public static void testFindSmallest()
    {
        String[] input={"i","have","an","eg"};
        int expected=2;
        int actual=Sort.findSmallestIndex(input,0);
        /*using junit to replace the loop*/
        org.junit.Assert.assertEquals(expected,actual);
    }
    public static void testSwap()
    {
        String[] input={"i","have","an","eg"};
        String[] expected={"i","have","an","eg"};
        Sort.swap(input,1,2);
        /*using junit to replace the loop*/
        org.junit.Assert.assertArrayEquals(expected,input);
    }
    public static void main(String args[])
    {
        testSort();
    }
}
