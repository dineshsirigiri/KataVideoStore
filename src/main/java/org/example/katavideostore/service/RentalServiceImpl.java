package org.example.katavideostore.service;

import java.util.Locale;

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
public class RentalServiceImpl
{
    private final RegularRentalService regularRentalService;
    private final NewMoviesRentalService newMoviesRentalService;
    private final ChildrenMoviesRentalService childrenMoviesRentalService;

    @Autowired
    public RentalServiceImpl( final RegularRentalService regularRentalService,
        final NewMoviesRentalService newMoviesRentalService,
        final ChildrenMoviesRentalService childrenMoviesRentalService )
    {
        this.regularRentalService = regularRentalService;
        this.newMoviesRentalService = newMoviesRentalService;
        this.childrenMoviesRentalService = childrenMoviesRentalService;
    }

    public RentalDue calculateRentalDue( final Rental rental )
    {
        var rentalDue = new RentalDue();
        var rentalService = getRentalService( rental.getType() );
        rentalDue.setDue( rentalService.calculateRentalCost( rental.getNumberOfDays() ) );
        rentalDue.setFrequentRentalPoints( rentalService.calculateFrequentRentalPoints( rental.getNumberOfDays() ) );
        rentalDue.setChargeStatement( rental.getMovie() + " " + rentalDue.getDue() );

        return rentalDue;
    }

    private RentalService getRentalService( final String type )
    {
        switch ( type.toLowerCase( Locale.ROOT ) )
        {
            case "regular" ->
            {
                return regularRentalService;
            }
            case "new" ->
            {
                return newMoviesRentalService;
            }
            case "children" ->
            {
                return childrenMoviesRentalService;
            }
            default -> throw new IllegalArgumentException( "Invalid type: " + type );
        }
    }
}
