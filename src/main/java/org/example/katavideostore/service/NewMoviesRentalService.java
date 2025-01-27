package org.example.katavideostore.service;

import org.springframework.stereotype.Service;

/**
 * Please add your description here.
 *
 * @author Pulse Innovations Ltd
 */
@Service
public class NewMoviesRentalService implements RentalService
{
    @Override
    public double calculateRentalCost( final int numberOfDays )
    {
        if (numberOfDays <= 0) return 0;
        return numberOfDays * 3;
    }

    @Override
    public int calculateFrequentRentalPoints( final int numberOfDays )
    {
        if (numberOfDays <= 0) return 0;
        if (numberOfDays == 1) return 1;
        return 2;
    }
}
