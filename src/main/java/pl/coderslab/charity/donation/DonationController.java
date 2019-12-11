package pl.coderslab.charity.donation;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.category.CategoryDTO;
import pl.coderslab.charity.category.CategoryEntity;
import pl.coderslab.charity.category.CategoryService;
import pl.coderslab.charity.institution.InstitutionDTO;
import pl.coderslab.charity.institution.InstitutionEntity;
import pl.coderslab.charity.institution.InstitutionService;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@Transactional
public class DonationController {

    private final CategoryService categoryService;
    private final ModelMapper modelMapper;
    private final InstitutionService institutionService;
    private final DonationService donationService;

    public DonationController(CategoryService categoryService, ModelMapper modelMapper, InstitutionService institutionService, DonationService donationService) {
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
        this.institutionService = institutionService;
        this.donationService = donationService;
    }

    @GetMapping("/form_step1")
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
        /*model.addAttribute("categories", categoryDTOS);*/
        DonationEntity newDonation = new DonationEntity();
        model.addAttribute("newDonation", newDonation);
        return "form_step1";
    }
    @PostMapping("/form_step1")
    public String saveFirstStep(@ModelAttribute DonationEntity donationEntity, BindingResult result, Model model){
        donationEntity.setCategories(donationEntity.getCategories());
        model.addAttribute("donationSecondStep", donationEntity);
        return "form_step2";
    }
    @GetMapping("/form_step2")
    public String prepareSecondStep(@ModelAttribute (name = "donationSecondStep") DonationEntity donationEntity, BindingResult result, Model model){
        model.addAttribute("donationThirdStep", donationEntity);
        return "form_step3";
    }
    @PostMapping("/form_step2")
    public String saveSecondStep(@ModelAttribute(name = "donationSecondStep") DonationEntity donationEntity, BindingResult result, Model model){
        model.addAttribute("donationThirdStep", donationEntity);
        return "form_step3";
    }
    @GetMapping("/form_step3")
    public String prepareThirdStep(@ModelAttribute DonationEntity donationEntity, BindingResult result, Model model){
        model.addAttribute("newDonation", donationEntity);
        return "form_step3";
    }
    @PostMapping("/form_step3")
    public String saveThirdStep(@ModelAttribute(name = "donationThirdStep") DonationEntity donationEntity, BindingResult result, Model model){
        model.addAttribute("donationFourthStep", donationEntity);
        return "form_step4";
    }
    @PostMapping("/form_step4")
    public String saveFourthStep(@ModelAttribute(name = "donationFourthStep") DonationEntity donationEntity, BindingResult result, Model model){
        model.addAttribute("donationFinal", donationEntity);
        return "form-confirmation";
    }

    @PostMapping("/saveDonation")
    public String saveDonation(@ModelAttribute(name = "donationFinal") DonationEntity donationEntity, BindingResult result){
        System.out.println(donationEntity);
        donationService.saveDonation(donationEntity);
        return "index";
    }

    @ModelAttribute("categories")
    public Set<CategoryEntity>donationCategories(){
        return categoryService.findAllCategories();
    }

    @ModelAttribute("institutions")
    public Set<InstitutionEntity>institutions(){
        return institutionService.findAllInstitutions();
    }
}
