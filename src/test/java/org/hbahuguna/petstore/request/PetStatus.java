package org.hbahuguna.petstore.request;

public enum PetStatus {
    AVAILABLE("available"),
    PENDING("pending"),
    SOLD("sold"),
    INVALID("invalid");
    private String status;

    PetStatus(String status){
        this.status = status;
    }

    public String getValue(){
        return status;
    }
}
