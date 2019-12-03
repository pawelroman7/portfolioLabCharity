package pl.coderslab.charity.donation;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.category.CategoryDTO;
import pl.coderslab.charity.category.CategoryService;
import pl.coderslab.charity.institution.InstitutionDTO;
import pl.coderslab.charity.institution.InstitutionService;

import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class DonationController {
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;
    private final InstitutionService institutionService;

    public DonationController(CategoryService categoryService, ModelMapper modelMapper, InstitutionService institutionService) {
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
        this.institutionService = institutionService;
    }

    @GetMapping("/form")
    public String prepareDonation(Model model){
        Set<CategoryDTO> categoryDTOS = categoryService
                .findAllCategories()
                .stream()
                .map(categoryEntity -> modelMapper.map(categoryEntity, CategoryDTO.class))
                .collect(Collectors.toSet());
        Set<InstitutionDTO>institutionDTOS = institutionService
                .findAllInstitutions()
                .stream()
                .map(institutionEntity -> modelMapper.map(institutionEntity, InstitutionDTO.class))
                .collect(Collectors.toSet());
        model.addAttribute("institutions", institutionDTOS);
        model.addAttribute("categories", categoryDTOS);
        model.addAttribute("newDonation", new DonationEntity());
        return "form";
    }

    @PostMapping
    public String saveDonation(){
        return "form-confirmation";
    }
}
