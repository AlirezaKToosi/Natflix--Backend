package com.novare.natflixbackend.models.contents;


public enum EType {
    CONTENT(4), SERIES(1), MOVIES(2), DOCUMENTARIES(3);
    private final int typeId;

    EType(int typeId) {
        this.typeId = typeId;
    }

    public int getTypeId() {
        return typeId;
    }

    public static EType fromTypeId(int typeId) {
        for (EType type : EType.values()) {
            if (type.getTypeId() == typeId) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid typeId: " + typeId);
    }
}
