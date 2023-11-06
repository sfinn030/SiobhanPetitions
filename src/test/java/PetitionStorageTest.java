import org.example.Petition;
import org.example.PetitionStorage;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class PetitionStorageTest {
    private PetitionStorage petitionStorage = new InMemoryPetitionStorage();

    private final Petition GAZA_CEASEFIRE = createNewPetition("GAZA");
    private final Petition UKRAINE_CEASEFIRE = createNewPetition("Ukraine");


    private Petition createNewPetition(String name) {
        Petition petition = new Petition();
        petition.setName(name);
        return petition;
    }

    @Test
    public void getNonExistingPetition_petitionNotPresent(){
        Optional<Petition> returnedPetition = petitionStorage.get(1L);
        assertThat(returnedPetition.isPresent()).isEqualTo(false);

    }
    @Test
    public void saveonePetition_returnsThePetition(){
        Petition returnedPetition = petitionStorage.save(GAZA_CEASEFIRE);
        assertThat(returnedPetition.getName()).isEqualTo("GAZA");
        assertThat(returnedPetition.getId()).isEqualTo(1L);

    }
    @Test
    public void savetwoPetition_returnsThePetition(){
        petitionStorage.save(GAZA_CEASEFIRE);
        Petition returnedPetition = petitionStorage.save(UKRAINE_CEASEFIRE);
        assertThat(returnedPetition.getName()).isEqualTo("Ukraine");
        assertThat(returnedPetition.getId()).isEqualTo(2L);

    }
    @Test
    public void noPetitions_getall_returnsemptyList(){
        List<Petition> returnedPetitions= petitionStorage.getAll();

        assertThat(returnedPetitions.size()).isEqualTo(0);

    }
    @Test
    public void onePetition_getall_returnsthePetition(){
        petitionStorage.save(GAZA_CEASEFIRE);
        List<Petition> returnedPetitions= petitionStorage.getAll();

        assertThat(returnedPetitions.size()).isEqualTo(1);
        assertThat(returnedPetitions.iterator().next().getName()).isEqualTo("GAZA");
        assertThat(returnedPetitions.iterator().next().getId()).isEqualTo(1L);
    }
    @Test
    public void twoPetition_getall_returnstwoPetitions(){
        petitionStorage.save(GAZA_CEASEFIRE);
        petitionStorage.save(UKRAINE_CEASEFIRE);

        List<Petition> returnedPetitions= petitionStorage.getAll();

        assertThat(returnedPetitions.size()).isEqualTo(2);

    }
    @Test
    public void twoPetitions_deleteFirst_returnstheSecond(){
        petitionStorage.save(GAZA_CEASEFIRE);
        petitionStorage.save(UKRAINE_CEASEFIRE);
        petitionStorage.delete(1L);

        List<Petition> returnedPetitions= petitionStorage.getAll();

        assertThat(returnedPetitions.size()).isEqualTo(1);
        assertThat(returnedPetitions.iterator().next().getId()).isEqualTo(2L);

    }
    @Test
    public void twoPetitions_deleteALL_returnsEmptyList(){
        petitionStorage.save(GAZA_CEASEFIRE);
        petitionStorage.save(UKRAINE_CEASEFIRE);
        petitionStorage.deleteAll();

        List<Petition> returnedPetitions= petitionStorage.getAll();

        assertThat(returnedPetitions.size()).isEqualTo(0);
      //  assertThat(returnedPetitions.iterator().next().getId()).isEqualTo(2L);

    }

}