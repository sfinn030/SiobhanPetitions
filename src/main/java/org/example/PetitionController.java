package org.example;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class PetitionController {
    private PetitionStorage petitionStorage= new InMemoryPetitionStorage();
    private  Petition GAZA_CEASEFIRE = createNewPetition("GAZA");

    Petition UKRAINE_CEASEFIRE = createNewPetition("Ukraine");
    private final Petition Ant_Hunting = createNewPetition("Hunting");
    Petition returnedPetition = petitionStorage.save(GAZA_CEASEFIRE);
    Petition returnedPetition2= petitionStorage.save(UKRAINE_CEASEFIRE);
    Petition returnedPetition3= petitionStorage.save(Ant_Hunting);
    @GetMapping("/petition")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        //  model.addAttribute("name", name);
        model.addAttribute("petitions", petitionStorage.getAll());
        //   return "greeting";
        return "petitionList";
    }
    @GetMapping("/{id}")
    public String getSingle(@PathVariable long id, Model model){
        Optional<Petition> returnPetition = petitionStorage.get(id);
        if (returnPetition.isPresent()){
            model.addAttribute("petition", returnPetition.get());
            return "signpetition";}
        else {
            return "addPetition";
        }
    }

    @GetMapping("/addPetition")
    public String greetingSubmit(@ModelAttribute Petition petition, Model model) {
        model.addAttribute("petition",petition );
        //    petitionStorage.save(petition);
        ;
        return "addpetition";
    }

    @PostMapping(value ="/savepetition")
    //public String petitionSubmit(@ModelAttribute Petition petition, Model model) {
    public String petitionSubmit(@ModelAttribute  Petition petition, Model model) {
        petitionStorage.save(petition);
        model.addAttribute("petitions", petitionStorage.getAll());
        //   return "greeting";
        return "petitionList";
    }
    @PostMapping(value ="/sign")
    //public String petitionSubmit(@ModelAttribute Petition petition, Model model) {
    public String petitionSign(@ModelAttribute  Petition petition, Model model) {
        petitionStorage.save(petition);
        model.addAttribute("petitions", petitionStorage.getAll());
        //   return "greeting";
        return "petitionList";
    }


    private Petition createNewPetition(String name) {
        Petition petition = new Petition();
        petition.setImage("");
        petition.content ="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus gravida tortor eget neque malesuada, ut consequat tortor pellentesque. Phasellus varius hendrerit lorem sit amet volutpat. Etiam vehicula fringilla eros, nec dapibus quam cursus id. Fusce posuere purus molestie, condimentum augue finibus, tempor eros. Ut lobortis odio nulla, et mollis neque condimentum at. Nullam rhoncus ultricies ligula ac maximus. Curabitur volutpat, dui non dictum tristique, eros risus interdum ipsum, quis convallis odio elit at enim. Nunc massa odio, volutpat a lectus aliquam, convallis tincidunt dui. Vivamus eget posuere nunc. Nullam at molestie diam. Sed vulputate blandit vestibulum. Pellentesque vitae tristique velit. Aenean porta commodo sem. Proin tortor risus, dapibus eget dolor eu, venenatis congue nisl.";
        petition.setName(name);
        return petition;
    }
}
