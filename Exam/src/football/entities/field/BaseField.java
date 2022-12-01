package football.entities.field;

import football.common.ConstantMessages;
import football.common.ExceptionMessages;
import football.entities.player.Player;
import football.entities.supplement.Supplement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public abstract class BaseField implements Field {

    private String name;
    private int capacity;
    private Collection<Supplement> supplements;
    private Collection<Player> players;

    public BaseField(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        supplements = new ArrayList<>();
        players = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.FIELD_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }


    @Override
    public int sumEnergy() {
        return this.supplements.stream().mapToInt(Supplement::getEnergy).sum();
    }

    @Override
    public void addPlayer(Player player) {
        if (this.capacity <= this.players.size()) {
            throw new IllegalStateException(ConstantMessages.NOT_ENOUGH_CAPACITY);
        }
        this.players.add(player);
    }

    @Override
    public void removePlayer(Player player) {
        this.players.remove(player);
    }

    @Override
    public void addSupplement(Supplement supplement) {
        this.supplements.add(supplement);
    }

    @Override
    public void drag() {
        for (Player player : this.players) {
            player.stimulation();
        }
    }

    @Override
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s (%s):" , getName(), getClass().getSimpleName()));
        sb.append(System.lineSeparator());
        if (this.players.isEmpty()){
            sb.append("Player: none");
        }else {
            sb.append("Player: ").append(this.players.stream().map(Player::getName).collect(Collectors.joining(" ")));
            sb.append(System.lineSeparator());
            sb.append("Supplement: ").append(this.supplements.size());
            sb.append(System.lineSeparator());
            sb.append("Energy: ").append(sumEnergy());
        }
        return sb.toString().trim();
    }

    @Override
    public Collection<Player> getPlayers() {
        return Collections.unmodifiableCollection(players);
    }

    @Override
    public Collection<Supplement> getSupplement() {
        return Collections.unmodifiableCollection(supplements);
    }

    @Override
    public String getName() {
        return this.name;
    }
}
