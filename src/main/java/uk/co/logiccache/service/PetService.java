package uk.co.logiccache.service;

import uk.co.logiccache.web.dto.Pet;

import java.util.List;
import java.util.Optional;

public interface PetService {
    void createPet(Pet pet);

    Optional<Pet> retrievePet(long petId);

    List<Pet> retrieveAllPets(int limit);
}