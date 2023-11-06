package org.example;

import java.util.List;
import java.util.Optional;

public interface PetitionStorage {
    public Petition save(Petition petition);
    public Optional<Petition> get(Long id);

    public List<Petition> getAll();
    public void delete(Long id);

    public void deleteAll();
}
