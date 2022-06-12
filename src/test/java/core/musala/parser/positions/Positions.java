package core.musala.parser.positions;

import java.util.LinkedList;
import java.util.List;

public class Positions {
    private static final List<Position> positions = new LinkedList<>();

    public static void addPosition(String location, String position, String info) {
        getPositions().add(new Position(location, position, info));
    }

    public static List<Position> getPositions() {
        return positions;
    }
}
