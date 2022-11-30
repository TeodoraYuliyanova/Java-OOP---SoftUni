package rpg_lab;

public interface Target {

    void takeAttack(int points);
    int giveExperience();
    int getHealth();
    boolean isDead();
}
