package uk.co.logiccache.service;

import org.springframework.stereotype.Service;
import uk.co.logiccache.web.dto.Pet;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PetServiceImpl implements PetService {

    private final List<Pet> pets = new ArrayList<>();

    public static final Pet FIDO = new Pet().id(1L).name("Fido").tag("dog").age(3);
    public static final Pet TIDDLES = new Pet().id(2L).name("Tiddles").tag("cat").age(6);

    @PostConstruct
    void setUp() {
        pets.add(FIDO);
        pets.add(TIDDLES);
    }

    @Override
    public void createPet(Pet pet) {
        pets.add(pet);
    }

    @Override
    public Optional<Pet> retrievePet(long petId) {
        return pets.stream().filter(pet -> pet.getId() == petId).findFirst();
    }

    @Override
    public List<Pet> retrieveAllPets(int limit) {
        return pets.stream().limit(limit).collect(Collectors.toList());
    }
}
