package p02_ExtendedDatabase;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseTest {

    private Database database;
    private Person person;
    private Person person1;
    private Person person2;
    private Person person3;

    @Before
    public void setup() throws OperationNotSupportedException {
        person = new Person(1, "asd");
        person1 = new Person(1, "Gosho");
        person2 = new Person(2, "Tosho");
        person3 = new Person(3, "Ivan");

    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddTwoPeopleWIthSameIdShouldThrow() throws OperationNotSupportedException {
        //trying to add to people with same id
        database = new Database();
        database.add(person);
        database.add(person1);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddNegativeIdShouldThrow() throws OperationNotSupportedException {
        database = new Database();
        Person person = new Person(-1, "Gosho");
        database.add(person);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddNullIdShouldThrow() throws OperationNotSupportedException {
        database = new Database(person1, person2);
        Person person = null;
        database.add(person);
    }

    @Test
    public void testCreateDbSuccessfully() throws OperationNotSupportedException {
        //Happy Path
        database = new Database(person1);
        database.add(person2);
        database.add(person3);

        Person[] people = database.getElements();
        String[] names = {"Gosho", "Tosho", "Ivan"};

        for (int i = 0; i < people.length; i++) {
            Assert.assertEquals(names[i], people[i].getUsername());
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveFromEmptyDbShouldThrow() throws OperationNotSupportedException {
        database = new Database();
        database.remove();
    }

    @Test
    public void testRemoveSuccessfully() throws OperationNotSupportedException {
        //Happy path
        database = new Database(person2);
        database.add(person3);

        database.remove();

        Person[] buffer = database.getElements();
        Person person = buffer[0];

        Assert.assertEquals(person2, person);

    }

    @Test(expected = OperationNotSupportedException.class)
    public void testNoUserWithThisNameIsPresentShouldThrow() throws OperationNotSupportedException {
        database = new Database(person1);
        database.findByUsername("Ivancho");

    }

    @Test(expected = OperationNotSupportedException.class)
    public void testUsernameNullShouldThrow() throws OperationNotSupportedException {
        database = new Database(person1);
        database.findByUsername(null);
    }

    @Test
    public void testSearchByUsernameSuccessful() throws OperationNotSupportedException {
        database = new Database(person2);
        database.add(person1);
        Person p = database.findByUsername("Gosho");
        Assert.assertEquals("Gosho" , p.getUsername());

    }

    @Test(expected = OperationNotSupportedException.class)
    public void testNoUserWithSuchId() throws OperationNotSupportedException {
        database = new Database(person1);
        database.findById(65);
    }

    @Test
    public void testSearchByIdSuccessfully() throws OperationNotSupportedException {
        database = new Database(person2);
        database.add(person1);
        Person p = database.findById(1);
        Assert.assertEquals(1 , p.getId());

    }
}