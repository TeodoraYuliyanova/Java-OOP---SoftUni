package football;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class FootballTeamTest  {

    private FootballTeam footballTeam1;
    private FootballTeam footballTeam2;

    @Before
    public void setup() {
        footballTeam1 = new FootballTeam("Manchester" , 2);
        footballTeam2 = new FootballTeam("Liverpool" , 1);
    }


    @Test
    public void testGetName(){
        Assert.assertEquals("Liverpool" , footballTeam2.getName());
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldThrow() {
        FootballTeam footballTeam = new FootballTeam(null , 1);
    }

    @Test
    public void testGetVacantPositions(){
        Assert.assertEquals(2 , footballTeam1.getVacantPositions());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetVacantPositionsShouldThrow() {
        FootballTeam footballTeam = new FootballTeam("PSG" , -1);
    }

    @Test
    public void testGetCount() {
        Footballer footballer = new Footballer("Pesho");
        FootballTeam footballTeam = new FootballTeam("Bulgaria" , 2);
        footballTeam.addFootballer(footballer);
        Assert.assertEquals(1, footballTeam.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddFootballerShouldThrow() {
        Footballer footballer = new Footballer("Pesho");
        Footballer footballer2 = new Footballer("Gosho");
        Footballer footballer3 = new Footballer("Tosho");
        footballTeam2.addFootballer(footballer);
        footballTeam2.addFootballer(footballer2);
        footballTeam2.addFootballer(footballer3);
    }

    @Test
    public void testRemoveFootballerSuccessfully() {
        Footballer footballer = new Footballer("Pesho");
        Footballer footballer2 = new Footballer("Gosho");
        footballTeam1.addFootballer(footballer);
        footballTeam1.addFootballer(footballer2);
        footballTeam1.removeFootballer("Pesho");
    }

    @Test(expected =  IllegalArgumentException.class)
    public void testRemoveFootballerShouldThrow() {
        footballTeam1.removeFootballer(null);
    }

    @Test
    public void testFootballerForSaleSuccessfully() {
        Footballer footballer = new Footballer("Pesho");
        Footballer footballer2 = new Footballer("Gosho");
        footballTeam1.addFootballer(footballer);
        footballTeam1.addFootballer(footballer2);
        Assert.assertEquals(footballer , footballTeam1.footballerForSale("Pesho"));
        Assert.assertFalse(footballer.isActive());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFootballerForSaleShouldThrow() {
        footballTeam2.footballerForSale("Gosho");
    }

    @Test
    public void testGetStatistics() {
        Footballer footballer = new Footballer("Pesho");
        footballTeam1.addFootballer(footballer);
        String output = "The footballer Pesho is in the team Manchester.";
        Assert.assertEquals(output, footballTeam1.getStatistics());
    }

}