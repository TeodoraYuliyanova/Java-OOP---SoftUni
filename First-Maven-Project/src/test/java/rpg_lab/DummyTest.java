package rpg_lab;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DummyTest {

    private static final int AXE_ATTACK = 5;
    private static final int AXE_DURABILITY = 5;
    private static final int DUMMY_HEALTH = 20;
    private static final int DUMMY_XP = 10;
    private static final int ATTACK_POINTS = 2;
    private static final int EXPECTED = DUMMY_HEALTH - ATTACK_POINTS;

    private Dummy dummy;
    private Axe axe;

    @Before
    public void setup() {
        this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_XP);
        this.axe = new Axe(AXE_ATTACK,AXE_DURABILITY);
    }

    @Test
    public void testIfLosesHealthWhenAttacked() {

        //Act
        this.dummy.takeAttack(ATTACK_POINTS);

        //Assert
        Assert.assertEquals(EXPECTED,dummy.getHealth());
    }

    @Test (expected = IllegalStateException.class)
    public void testIfDeadDummyThrowsEx() {

        //Act
        this.dummy.takeAttack(ATTACK_POINTS);
        this.dummy.takeAttack(ATTACK_POINTS);
        this.dummy.takeAttack(ATTACK_POINTS);
        this.dummy.takeAttack(ATTACK_POINTS);
        this.dummy.takeAttack(ATTACK_POINTS);
        this.dummy.takeAttack(ATTACK_POINTS);
        this.dummy.takeAttack(ATTACK_POINTS);
        this.dummy.takeAttack(ATTACK_POINTS);
        this.dummy.takeAttack(ATTACK_POINTS);
        this.dummy.takeAttack(ATTACK_POINTS);
        this.dummy.takeAttack(ATTACK_POINTS);
    }

    @Test
    public void testDeadDummyGivesXp() {

        this.dummy.takeAttack(ATTACK_POINTS);
        this.dummy.takeAttack(ATTACK_POINTS);
        this.dummy.takeAttack(ATTACK_POINTS);
        this.dummy.takeAttack(ATTACK_POINTS);
        this.dummy.takeAttack(ATTACK_POINTS);
        this.dummy.takeAttack(ATTACK_POINTS);
        this.dummy.takeAttack(ATTACK_POINTS);
        this.dummy.takeAttack(ATTACK_POINTS);
        this.dummy.takeAttack(ATTACK_POINTS);
        this.dummy.takeAttack(ATTACK_POINTS);
        //Assert
        Assert.assertEquals(DUMMY_XP,dummy.giveExperience());
    }

    @Test(expected = IllegalStateException.class)
    public void testAliveDummyCantGiveXp() {

        this.axe.attack(this.dummy);
        this.dummy.giveExperience();
    }

}