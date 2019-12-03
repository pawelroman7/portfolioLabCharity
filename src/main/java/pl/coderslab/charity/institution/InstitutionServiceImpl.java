package pl.coderslab.charity.institution;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class InstitutionServiceImpl implements InstitutionService{

    private final InstitutionRepository institutionRepository;

    public InstitutionServiceImpl(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    @Override
    public Set<InstitutionEntity> findAllInstitutions() {

        List<InstitutionEntity> institutionEntityList = institutionRepository.findAll();
        return new HashSet<>(institutionEntityList);
    }

    @Override
    public int getNumberOfInstitutions() {
        return findAllInstitutions().size();
    }
}
