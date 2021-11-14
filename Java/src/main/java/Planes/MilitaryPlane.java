package Planes;

import models.MilitaryType;

import java.util.Objects;

public class MilitaryPlane extends Plane{

    private MilitaryType type;

    public MilitaryPlane(String model,
                         int maxSpeed,
                         int maxFlightDistance,
                         int maxLoadCapacity,
                         MilitaryType type) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.type = type;
    }

    public MilitaryType getType() {
        return type;
    }

    @Override
    public String toString() {
        return super.toString().replace("}",", type=" + type + '}');
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (!(otherObject instanceof MilitaryPlane)) return false;
        if (!super.equals(otherObject)) return false;
        MilitaryPlane that = (MilitaryPlane) otherObject;
        return type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), type);
    }
}
