package rpg_lab;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class HeroTest {

    private final static int TARGET_XP = 10;

    @Test
    public void testAttackGainsXpIfTargetIsDead() {

        Weapon weapon = Mockito.mock(Weapon.class);
        Target target = Mockito.mock(Target.class);

        Mockito.when(target.isDead()).thenReturn(true);
        Mockito.when(target.giveExperience()).thenReturn(TARGET_XP);

        Hero hero = new Hero("Pesho", weapon);
        hero.attack(target);
        Assert.assertEquals(TARGET_XP,hero.getExperience());
    }

}