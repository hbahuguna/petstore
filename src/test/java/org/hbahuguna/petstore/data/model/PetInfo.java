package org.hbahuguna.petstore.data.model;

import lombok.Builder;
import lombok.Getter;
import org.hbahuguna.petstore.request.PetStatus;

import java.util.List;

@Getter
@Builder
public class PetInfo {
    @Builder.Default
    private Long id = 7L;
    @Builder.Default
    private String name = "Lion 1";
    @Builder.Default
    private String status = PetStatus.AVAILABLE.getValue();
    private NameIdPair category;
    private List<String> photoUrls;
    private List<NameIdPair> tags;
}

