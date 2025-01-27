package org.example.katavideostore.service;

import java.util.List;

import org.example.katavideostore.model.Rental;
import org.example.katavideostore.model.RentalDue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Please add your description here.
 *
 * @author Pulse Innovations Ltd
 */
@Service
public class CustomerService
{
    private final RentalServiceImpl rentalService;
    private final List<Rental> rentals;

    @Autowired
    public CustomerService( RentalServiceImpl rentalService, List<Rental> rentals )
    {
        this.rentalService = rentalService;
        this.rentals = rentals;
    }

    public RentalDue[] generateRentals()
    {
        var rentalDues = new RentalDue[ rentals.size() ];
        for ( int i = 0; i < rentals.size(); i++ )
        {
            rentalDues[ i ] = rentalService.calculateRentalDue( rentals.get( i ) );
        }

        return rentalDues;
    }
}
