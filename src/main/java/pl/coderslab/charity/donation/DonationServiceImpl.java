package pl.coderslab.charity.donation;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class DonationServiceImpl implements DonationService {
    private final DonationRepository donationRepository;

    public DonationServiceImpl(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    @Override
    public Set<DonationEntity> findAllDonations() {
        List<DonationEntity>donationEntitiesList = donationRepository.findAll();
        return new HashSet<>(donationEntitiesList);
    }

    @Override
    public int getNumberOfDonations() {
        return findAllDonations().size();
    }

    @Override
    public void saveDonation(DonationEntity donationEntity) {
        donationRepository.save(donationEntity);

    }
}
