package p01_Database;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {

    @Test
    public void testCreateDataBase() throws OperationNotSupportedException {
        //Happy path
        Integer[] numbers = {1, 2, 3, 4, 5, 6};
        Database database = new Database(numbers);
        Integer[] dbElements = database.getElements();
        Assert.assertEquals(numbers.length, dbElements.length);

        for (int i = 0; i < numbers.length; i++) {
            Assert.assertEquals(numbers[i], dbElements[i]);
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorWithLessThanOneArgument() throws OperationNotSupportedException {
        //Failed validation - too few arguments
        Database database = new Database();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorWithMoreThan16Arguments() throws OperationNotSupportedException {
        //Failed validation - too many arguments
        Database database = new Database(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17);

    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddWithNullArgumentShouldThrow() throws OperationNotSupportedException {
        Database database = new Database(1, 2, 3, 4, 5);
        database.add(null);

    }

    @Test
    public void testAddSuccessful() throws OperationNotSupportedException {
        Database database = new Database(1, 2, 3, 4, 5, 6);
        int initialSize = database.getElements().length;
        database.add(7);
        Integer[] dbElements = database.getElements();
        int lastElementFromDb = dbElements[dbElements.length - 1];

        Assert.assertEquals(7, lastElementFromDb);
        Assert.assertEquals(initialSize + 1, dbElements.length);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveFromEmptyDbShouldThrow() throws OperationNotSupportedException {
        Database database = new Database();
        database.remove();
    }

    @Test
    public void testRemoveSuccessful() throws OperationNotSupportedException {
        Database database = new Database(1, 2, 3, 4, 5, 6);

        int initialSize = database.getElements().length;
        Integer[] dbElements = database.getElements();
        int lastElementFromDb = dbElements[dbElements.length - 1];
        database.remove();
        Integer [] currentElements = database.getElements();

        Assert.assertEquals(6, lastElementFromDb);
        Assert.assertEquals(initialSize - 1, currentElements.length);

    }

}