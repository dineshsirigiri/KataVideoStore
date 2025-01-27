package org.example.katavideostore.service;

/**
 * Please add your description here.
 *
 * @author Pulse Innovations Ltd
 */
public interface RentalService
{
    double calculateRentalCost(int numberOfDays);

    int calculateFrequentRentalPoints( int numberOfDays );
}
