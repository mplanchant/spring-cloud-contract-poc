package uk.co.logiccache.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import uk.co.logiccache.service.PetService;
import uk.co.logiccache.web.dto.Pet;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class PetsApiImpl implements PetsApi {

    private PetService petService;

    @Autowired
    public PetsApiImpl(PetService petService) {
        this.petService = petService;
    }

    @Override
    public ResponseEntity<Void> createPets(@Valid Pet pet) {
        petService.createPet(pet);
        return ResponseEntity.created(URI.create("/v1/pets")).build();
    }

    @Override
    public ResponseEntity<List<Pet>> listPets(@Valid Integer limit) {
        return ResponseEntity.ok(petService.retrieveAllPets(limit));
    }

    @Override
    public ResponseEntity<Pet> showPetById(Long petId) {
        Optional<Pet> pet = petService.retrievePet(petId);
        return pet.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}