package pl.coderslab.charity.institution;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class InstitutionsConverter implements Converter <String, InstitutionEntity> {
    private final InstitutionService institutionService;

    public InstitutionsConverter(InstitutionService institutionService) {
        this.institutionService = institutionService;
    }

    @Override
    public InstitutionEntity convert(String s) {
        String[]data = s.split(",");
        return institutionService.findById(Long.parseLong(data[0]));
    }
}
