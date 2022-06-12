package core.parser.positions;

public class Position {
    private String location;
    private String position;
    private String info;

    public Position(String location, String position, String info) {
        setLocation(location);
        setPosition(position);
        setInfo(info);
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
