package pl.coderslab.charity;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.donation.DonationEntity;
import pl.coderslab.charity.donation.DonationService;
import pl.coderslab.charity.institution.InstitutionDTO;
import pl.coderslab.charity.institution.InstitutionEntity;
import pl.coderslab.charity.institution.InstitutionService;

import java.util.Set;
import java.util.stream.Collectors;


@Controller
public class HomeController {

    private final InstitutionService institutionService;
    private final ModelMapper modelMapper;
    private final DonationService donationService;

    public HomeController(InstitutionService institutionService, ModelMapper modelMapper, DonationService donationService) {
        this.institutionService = institutionService;
        this.modelMapper = modelMapper;
        this.donationService = donationService;
    }


    @RequestMapping("/")
    public String homeAction(Model model){
        Set<InstitutionEntity>institutionEntities = institutionService.findAllInstitutions();
        Set<InstitutionDTO>institutionDTOS = institutionEntities.stream()
                .map(institutionEntity -> modelMapper.map(institutionEntity, InstitutionDTO.class))
                .collect(Collectors.toSet());

        model.addAttribute("numberOfBags", donationService.getNumberOfDonations());
        model.addAttribute("numberOfInstitutions", institutionService.getNumberOfInstitutions());
        model.addAttribute("institutionDTOS", institutionDTOS);
        return "index";
    }
}
