package org.hbahuguna.petstore.data.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Error {
    @Builder.Default
    private String message = "Pet not found";
    @Builder.Default
    private String type = "error";
    @Builder.Default
    private int code = 1;
}
