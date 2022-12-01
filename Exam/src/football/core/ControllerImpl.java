package football.core;


import football.common.ConstantMessages;
import football.common.ExceptionMessages;
import football.entities.field.ArtificialTurf;
import football.entities.field.Field;
import football.entities.field.NaturalGrass;
import football.entities.player.Men;
import football.entities.player.Player;
import football.entities.player.Women;
import football.entities.supplement.Liquid;
import football.entities.supplement.Powdered;
import football.entities.supplement.Supplement;
import football.repositories.SupplementRepository;
import football.repositories.SupplementRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {

    private SupplementRepository supplement;
    private Collection<Field> fields;


    public ControllerImpl() {
        this.supplement = new SupplementRepositoryImpl();
        this.fields = new ArrayList<>();
    }

    @Override
    public String addField(String fieldType, String fieldName) {
        Field field;

        switch (fieldType) {
            case "ArtificialTurf":
                field = new ArtificialTurf(fieldName);
                break;

            case "NaturalGrass":
                field = new NaturalGrass(fieldName);
                break;

            default:
                throw new NullPointerException(ExceptionMessages.INVALID_FIELD_TYPE);
        }
        this.fields.add(field);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FIELD_TYPE, fieldType);
    }

    @Override
    public String deliverySupplement(String type) {
        Supplement supplement;

        switch (type) {
            case "Powdered":
                supplement = new Powdered();
                break;

            case "Liquid":
                supplement = new Liquid();
                break;

            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_SUPPLEMENT_TYPE);
        }
        this.supplement.add(supplement);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, type);
    }

    @Override
    public String supplementForField(String fieldName, String supplementType) {
        Field field = fields.stream().filter(f -> f.getName().equals(fieldName)).findFirst().orElse(null);
        Supplement supplement = this.supplement.findByType(supplementType);

        if (supplement == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_SUPPLEMENT_FOUND, supplementType));
        }

        if (field != null) {
            field.addSupplement(supplement);
            this.supplement.remove(supplement);
        }
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SUPPLEMENT_IN_FIELD, supplementType , fieldName);
    }

    @Override
    public String addPlayer(String fieldName, String playerType, String playerName, String nationality, int strength) {
        Player player;

        switch (playerType){
            case "Men":
                player = new Men(playerName, nationality, strength);
                break;

            case "Women":
                player = new Women(playerName,nationality,strength);
                break;

            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_PLAYER_TYPE);
        }
        Field field = this.fields.stream().filter(f -> f.getName().equals(fieldName)).findFirst().orElse(null);

        if ((player instanceof Men && field instanceof  NaturalGrass) || (player instanceof Women && field instanceof  ArtificialTurf)){
            field.addPlayer(player);
        }else {
            return ConstantMessages.FIELD_NOT_SUITABLE;
        }
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_PLAYER_IN_FIELD , playerType, fieldName);
    }

    @Override
    public String dragPlayer(String fieldName) {
        int counter = 0;
        for (Field field : this.fields) {
            field.drag();
            counter ++;
        }
        return String.format(ConstantMessages.PLAYER_DRAG , counter);
    }

    @Override
    public String calculateStrength(String areaName) {
        Field field =  this.fields.stream().filter(f -> f.getName().equals(areaName)).findFirst().orElse(null);
        int value = field.getPlayers().stream().mapToInt(Player::getStrength).sum();
        return String.format(ConstantMessages.STRENGTH_FIELD , areaName, value);
    }

    @Override
    public String getStatistics() {
        return this.fields.stream().map(Field::getInfo).collect(Collectors.joining(System.lineSeparator()));
    }
}
