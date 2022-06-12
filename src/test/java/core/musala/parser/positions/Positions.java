package core.musala.parser.positions;

import general.AttributeType;

import java.util.List;

public class Positions {
    private Position position;
    private List<Position> positions;

    public Positions(AttributeType attribute, String position, String info) {
        this.position = new Position(attribute, position, info);
    }
}
