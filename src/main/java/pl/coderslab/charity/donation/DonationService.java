package pl.coderslab.charity.donation;

import java.util.Set;

public interface DonationService {
    Set<DonationEntity> findAllDonations();
    int getNumberOfDonations();
    void saveDonation(DonationEntity donationEntity);
}
