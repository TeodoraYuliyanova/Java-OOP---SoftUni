package RandomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList extends ArrayList {

    public Object getRandomElement() {
        int index = new Random().nextInt();
        return super.remove(index);
    }

}
