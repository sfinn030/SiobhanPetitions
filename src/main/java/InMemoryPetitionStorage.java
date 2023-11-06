import org.example.Petition;
import org.example.PetitionStorage;

import java.util.*;

public class InMemoryPetitionStorage implements PetitionStorage {

    private final Map<Long, Petition> petitions = new HashMap<>();
    @Override
    public Petition save(final Petition petition) {
        boolean isPetitionIDEmpty =petition.getId()==null;
        if (isPetitionIDEmpty){
            Long id = petitions.size()+1L;
       petition.setId(id);
        }
        petitions.put(petition.getId(), petition);
        return petition;
    }

    @Override
    public Optional<Petition> get(Long id) {
        return Optional.ofNullable(petitions.get(id));
    }

    @Override
    public List<Petition> getAll() {
        ArrayList<Petition> returnValue =new ArrayList<Petition>(petitions.values());
        return returnValue;
    }

    @Override
    public void delete(Long id) {
petitions.remove(id);
    }

    @Override
    public void deleteAll() {
petitions.clear();
    }
}
