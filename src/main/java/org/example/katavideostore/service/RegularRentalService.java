package org.example.katavideostore.service;

import org.springframework.stereotype.Service;

/**
 * Please add your description here.
 *
 * @author Pulse Innovations Ltd
 */
@Service
public class RegularRentalService implements RentalService
{

    @Override
    public double calculateRentalCost( final int numberOfDays )
    {
        if ( numberOfDays <= 0 )
        {
            return 0;
        }
        if ( numberOfDays <= 2 )
        {
            return 2;
        }
        return 2 + ( numberOfDays - 2 ) * 1.5;
    }

    @Override
    public int calculateFrequentRentalPoints( final int numberOfDays )
    {
        if ( numberOfDays <= 0 )
        {
            return 0;
        }
        return 1;
    }
}
