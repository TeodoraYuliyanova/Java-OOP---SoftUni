package p03_IteratorTest;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.List;

public class ListIteratorTest {

    private ListIterator listIterator;
    private String [] NAMES = {"Gosho" , "Tosho" , "Ivan"};

    @Before
    public void setup() throws OperationNotSupportedException {
        listIterator = new ListIterator(NAMES);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testCreateWithNullShouldThrow() throws OperationNotSupportedException {
        new ListIterator(null);
    }

    @Test
    public void testHasNext() {
        Assert.assertTrue(listIterator.hasNext());
        listIterator.move();
        Assert.assertTrue(listIterator.hasNext());
        listIterator.move();
        Assert.assertFalse(listIterator.hasNext());
    }

    @Test
    public void testMove() {
        Assert.assertTrue(listIterator.move());
        Assert.assertTrue(listIterator.move());
        Assert.assertFalse(listIterator.move());
    }

    @Test(expected = IllegalStateException.class)
    public void testPrintEmptyListIteratorShouldThrow() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator();
        listIterator.print();
    }

    @Test
    public void testPrintSuccessfully() {
        int index = 0;
        while (listIterator.hasNext()){
            Assert.assertEquals(NAMES[index] , listIterator.print());
            index++;
            listIterator.move();
        }
    }
}