package org.hbahuguna.petstore.test;

import org.hbahuguna.petstore.data.model.PetInfo;
import org.hbahuguna.petstore.request.PetStatus;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hbahuguna.petstore.data.beans.ExpectedPetBeans.myPetAvailable;
import static org.hbahuguna.petstore.data.beans.ExpectedPetBeans.myPetPending;
import static org.hbahuguna.petstore.data.beans.ExpectedPetBeans.myPetSold;


public class FindByStatusTest extends PetRestAssuredtTestBase {

    @Test
    public void testFindByStatusAvailable(){
        testByStatusPositive(PetStatus.AVAILABLE, myPetAvailable());
    }

    @Test
    public void testFindByStatusPending(){
        testByStatusPositive(PetStatus.PENDING, myPetPending());
    }

    @Test
    public void testFindByStatusSold(){
        testByStatusPositive(PetStatus.SOLD, myPetSold());
    }

    @Test
    public void testFindByStatusInvalid(){
        List<PetInfo> petList = findByStatus(PetStatus.INVALID.getValue(), 200);
        assertThat(petList, is(empty()));
    }

    /*
     I think this is a bug, status=& should not return any value
     but it's returning a list of pets
     */
    @Test
    public void testFindByStatusFailingAmpersand(){
        List<PetInfo> petList = findByStatus("&", 200);
        assertThat(petList, is(empty()));
    }

    private void testByStatusPositive(PetStatus status, PetInfo pet) {
        createMyPet(pet);
        List<PetInfo> petList = findByStatus(status.getValue(), 200);
        assertThat(petList, is(not(empty())));
        boolean foundPet = false;
        for(PetInfo petInfo: petList) {
            if(petInfo != null && petInfo.getName() != null && petInfo.getName().equals(pet.getName())) {
                foundPet = true;
                break;
            }
        }
        Assert.assertTrue("did not find expected pet in output " + pet.getName(), foundPet);
    }
}
