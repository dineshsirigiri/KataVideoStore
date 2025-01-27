package org.example.katavideostore.service;

import org.springframework.stereotype.Service;

/**
 * Please add your description here.
 *
 * @author Pulse Innovations Ltd
 */
@Service
public class ChildrenMoviesRentalService implements RentalService
{
    @Override
    public double calculateRentalCost( final int numberOfDays )
    {
        if ( numberOfDays <= 0 )
        {
            return 0;
        }
        if ( numberOfDays <= 3 )
        {
            return 1.5;
        }
        return 1.5 + ( numberOfDays - 3 ) * 1.5;
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
