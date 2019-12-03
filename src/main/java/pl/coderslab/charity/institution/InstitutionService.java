package pl.coderslab.charity.institution;

import java.util.Set;

public interface InstitutionService {

    Set<InstitutionEntity>findAllInstitutions();
    int getNumberOfInstitutions();
}
