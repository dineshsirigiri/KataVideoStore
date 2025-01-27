package org.example.katavideostore.model;

/**
 * Please add your description here.
 *
 * @author Pulse Innovations Ltd
 */
public class Rental
{
    private String movie;
    private String type;
    private int numberOfDays;

    public Rental( final String movie, final String type, final int numberOfDays ) {
        this.movie = movie;
        this.type = type;
        this.numberOfDays = numberOfDays;
    }

    public String getMovie()
    {
        return movie;
    }

    public String getType()
    {
        return type;
    }

    public int getNumberOfDays()
    {
        return numberOfDays;
    }
}
