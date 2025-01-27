package org.example.katavideostore.model;

/**
 * Please add your description here.
 *
 * @author Pulse Innovations Ltd
 */
public class RentalDue
{
    private double due;
    private String chargeStatement;
    private int frequentRentalPoints;

    public void setDue( final double Due )
    {
        this.due = Due;
    }

    public void setChargeStatement( final String chargeStatement )
    {
        this.chargeStatement = chargeStatement;
    }

    public void setFrequentRentalPoints( final int frequentRentalPoints )
    {
        this.frequentRentalPoints = frequentRentalPoints;
    }

    public double getDue()
    {
        return due;
    }

    public String getChargeStatement()
    {
        return chargeStatement;
    }

    public int getFrequentRentalPoints()
    {
        return frequentRentalPoints;
    }
}
