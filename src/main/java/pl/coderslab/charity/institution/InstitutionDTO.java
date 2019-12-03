package pl.coderslab.charity.institution;

import lombok.Data;

@Data
public class InstitutionDTO {

    private String name;
    private String description;

    @Override
    public String toString() {
        return "Instytucja='" + name + "' Dzialanosc='" + description + "'";
    }
}
