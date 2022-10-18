package org.hbahuguna.petstore.data.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class NameIdPair {
    private String name;
    private Long id;
}
