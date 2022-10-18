package org.hbahuguna.petstore.data.beans;

import org.hbahuguna.petstore.data.model.NameIdPair;
import org.hbahuguna.petstore.data.model.PetInfo;
import org.hbahuguna.petstore.request.PetStatus;

import java.util.ArrayList;
import java.util.Arrays;

public class ExpectedPetBeans {

    public static PetInfo myPetAvailable() {
        ArrayList<String> photoUrls = new ArrayList<>(Arrays.asList("photoUrl99"));
        ArrayList<NameIdPair> tags = new ArrayList<>(Arrays.asList(
                NameIdPair.builder().id(0L).name("tag99").build()));
        return PetInfo.builder()
                .name("myUniquePetAvailable" + Math.random() * 99999)
                .id(10000L)
                .status(PetStatus.AVAILABLE.getValue())
                .category(NameIdPair.builder().id(9999999L).name("myCategory").build())
                .photoUrls(photoUrls)
                .tags(tags)
                .build();
    }

    public static PetInfo myPetPending() {
        ArrayList<String> photoUrls = new ArrayList<>(Arrays.asList("photoUrl99"));
        ArrayList<NameIdPair> tags = new ArrayList<>(Arrays.asList(
                NameIdPair.builder().id(0L).name("tag99").build()));
        return PetInfo.builder()
                .name("myUniquePetPending" + Math.random() * 99999)
                .id(10000L)
                .status(PetStatus.PENDING.getValue())
                .category(NameIdPair.builder().id(9999999L).name("myCategory").build())
                .photoUrls(photoUrls)
                .tags(tags)
                .build();
    }

    public static PetInfo myPetSold() {
        ArrayList<String> photoUrls = new ArrayList<>(Arrays.asList("photoUrl99"));
        ArrayList<NameIdPair> tags = new ArrayList<>(Arrays.asList(
                NameIdPair.builder().id(0L).name("tag99").build()));
        return PetInfo.builder()
                .name("myUniquePetSold" + Math.random() * 99999)
                .id(10000L)
                .status(PetStatus.SOLD.getValue())
                .category(NameIdPair.builder().id(9999999L).name("myCategory").build())
                .photoUrls(photoUrls)
                .tags(tags)
                .build();
    }

    public static PetInfo dog3() {
        ArrayList<String> photoUrls = new ArrayList<>(Arrays.asList("url1", "url2"));
        ArrayList<NameIdPair> tags = new ArrayList<>(Arrays.asList(
                NameIdPair.builder().id(1L).name("tag3").build(),
                NameIdPair.builder().id(2L).name("tag4").build()));
        return PetInfo.builder()
                .name("Dog 3")
                .id(6L)
                .status(PetStatus.PENDING.getValue())
                .category(NameIdPair.builder().id(1L).name("Dogs").build())
                .photoUrls(photoUrls)
                .tags(tags)
                .build();
    }


}
