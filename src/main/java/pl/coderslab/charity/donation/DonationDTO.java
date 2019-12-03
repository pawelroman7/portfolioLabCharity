package pl.coderslab.charity.donation;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class DonationDTO {
    private int quantity;
    private String street;
    private String city;
    private String zipCode;
    private LocalDate pickUpDate;
    private LocalTime pickUpTime;
    private String pickUpComment;
    //TODO: Add mapping for categories and institutions
}
