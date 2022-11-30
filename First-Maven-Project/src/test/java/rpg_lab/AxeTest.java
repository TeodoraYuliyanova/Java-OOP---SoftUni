package rpg_lab;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AxeTest {

    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 1;
    private static final int DUMMY_HEALTH = 20;
    private static final int DUMMY_XP = 10;
    private static final int EXPECTED_DURABILITY = AXE_DURABILITY - 1;

    private Axe axe;
    private Dummy dummy;

    @Before
    public void setup() {

        this.axe = new Axe(AXE_ATTACK,AXE_DURABILITY);
        this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_XP);

    }

    @Test
    public void testIfLosesDurabilityPointsAfterAttack() {

        //Act
        this.axe.attack(this.dummy);

        //Assert
        Assert.assertEquals("Wrong Durability," , EXPECTED_DURABILITY , this.axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void testAttackingWithBrokenAxe() {

        //Act
        this.axe.attack(this.dummy);
        this.axe.attack(this.dummy);

    }
}