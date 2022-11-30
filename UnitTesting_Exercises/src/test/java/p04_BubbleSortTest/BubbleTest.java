package p04_BubbleSortTest;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class BubbleTest  {

    @Test
    public void testSort() {
        int [] numbers = {9,-5,6,3,10};
        Bubble.sort(numbers);
        int [] sorted = {-5,3,6,9,10};
        Assert.assertArrayEquals(numbers,sorted);
    }

}