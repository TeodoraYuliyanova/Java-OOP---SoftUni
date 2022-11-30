package p05_CustomLinkedList;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CustomLinkedListTest {

    private CustomLinkedList<String> customLinkedList;

    @Before
    public void setup() {
        customLinkedList = new CustomLinkedList<>();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetForMissingPositiveIndexShouldThrow() {
        customLinkedList.get(100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetForMissingNegativeIndexShouldThrow() {
        customLinkedList.get(-5);
    }

    @Test
    public void testGetSuccessfully() {
        customLinkedList.add("Pesho");
        Assert.assertEquals("Pesho", customLinkedList.get(0));
    }

    @Test
    public void testAddToEmptyList() {
        customLinkedList.add("Petkan");
        customLinkedList.get(0);
    }

    @Test
    public void testAddToNonEmptyList() {
        customLinkedList.add("Petkan");
        customLinkedList.add("Ivan");
        customLinkedList.get(1);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testSetForMissingPositiveIndexShouldThrow() {
        customLinkedList.set(100, "Pesho");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetForMissingNegativeIndexShouldThrow() {
        customLinkedList.set(-5, "Ivan");
    }

    @Test
    public void testSetSuccessfully() {
        customLinkedList.add("Pesho");
        customLinkedList.add("Tosho");
        customLinkedList.add("Gosho");
        customLinkedList.add("Ivan");

        customLinkedList.set(1, "Petka");
        Assert.assertEquals("Petka", customLinkedList.get(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveAtInvalidPositiveIndexShouldThrow() {
        customLinkedList.removeAt(100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveAtInvalidNegativeIndexShouldThrow() {
        customLinkedList.removeAt(-5);
    }

    @Test
    public void testRemoveAtSuccess() {
        customLinkedList.add("Pesho");
        customLinkedList.add("Tosho");
        customLinkedList.add("Gosho");
        Assert.assertEquals("Tosho", customLinkedList.removeAt(1));
    }

    @Test
    public void testRemoveSuccess() {
        customLinkedList.add("Pesho");
        customLinkedList.add("Tosho");
        customLinkedList.add("Gosho");
        customLinkedList.remove("Tosho");
    }

    @Test
    public void testRemoveWithNonExistingElement() {
        customLinkedList.add("Pesho");
        customLinkedList.add("Gosho");
        customLinkedList.add("Tosho");
        customLinkedList.remove("Ivan");
    }

    @Test
    public void testIndexOfSuccessfully() {
        customLinkedList.add("Pesho");
        customLinkedList.add("Gosho");
        customLinkedList.add("Tosho");
        Assert.assertEquals(1, customLinkedList.indexOf("Gosho"));
    }

    @Test
    public void testIndexOfWithNonExistingElement() {
        customLinkedList.indexOf("Ivan");
    }

    @Test
    public void testContainsSuccess() {
        customLinkedList.add("Pesho");
        customLinkedList.add("Gosho");
        customLinkedList.add("Tosho");
        Assert.assertTrue(customLinkedList.contains("Pesho"));
    }

    @Test
    public void testContainsNonExistingElement() {
        customLinkedList.add("Pesho");
        customLinkedList.add("Gosho");
        customLinkedList.add("Tosho");
        Assert.assertFalse(customLinkedList.contains("Ivan"));
    }

    @Test
    public void testRemoveListNode() {

        //NOT FINISHED
        customLinkedList.add("Pesho");
        customLinkedList.add("Gosho");
        customLinkedList.add("Tosho");
        customLinkedList.add("Ivan");
        customLinkedList.add("Petkan");



    }
}