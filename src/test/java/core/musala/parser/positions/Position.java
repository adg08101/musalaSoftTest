package core.musala.parser.positions;

import general.AttributeType;

public class Position {
    private AttributeType attributeType;
    private String position;
    private String info;

    public Position(AttributeType attribute, String position, String info) {
        setAttributeType(attribute);
        setPosition(position);
        setInfo(info);
    }

    public AttributeType getAttributeType() {
        return attributeType;
    }

    public void setAttributeType(AttributeType attributeType) {
        this.attributeType = attributeType;
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
}
