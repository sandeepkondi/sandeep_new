package com.beyontec.mol.modal;

public class BatchResponseDTO {

    public BatchResponseDTO(String message) {
        this.message = message;
    }

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
