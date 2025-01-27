package org.example.katavideostore;

import java.util.List;

import org.example.katavideostore.model.Rental;
import org.example.katavideostore.model.RentalDue;
import org.example.katavideostore.service.ChildrenMoviesRentalService;
import org.example.katavideostore.service.CustomerService;
import org.example.katavideostore.service.NewMoviesRentalService;
import org.example.katavideostore.service.RegularRentalService;
import org.example.katavideostore.service.RentalServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith( SpringExtension.class )
class KataVideoStoreApplicationTests
{

    @Test
    void contextLoads()
    {
    }

    private CustomerService customerService;
    private RentalServiceImpl rentalServiceImpl;

    @BeforeEach
    void setup()
    {
        RegularRentalService regularRentalService = new RegularRentalService();
        NewMoviesRentalService newMoviesRentalService = new NewMoviesRentalService();
        ChildrenMoviesRentalService childrenMoviesRentalService = new ChildrenMoviesRentalService();
        rentalServiceImpl =
            new RentalServiceImpl( regularRentalService, newMoviesRentalService, childrenMoviesRentalService );
    }

    @Test
    void shouldReturnRentalsForRegularMovies()
    {
        var rental1 = new Rental( "Die Hard", "Regular", 2 );
        var rental2 = new Rental( "Jurassic Park", "Regular", 3 );

        customerService = new CustomerService( rentalServiceImpl, List.of( rental1, rental2 ) );
        var rentalDues = customerService.generateRentals();
        assertEquals( 5.5, getTotalDue( rentalDues ) );
        assertEquals( 2, getFrequentRentalPoints( rentalDues ) );
    }

    @Test
    void shouldReturnRentalsForNewReleases()
    {
        var rental1 = new Rental( "MI", "New", 1 );
        var rental2 = new Rental( "Dune 2", "New", 2 );

        customerService = new CustomerService( rentalServiceImpl, List.of( rental1, rental2 ) );
        var rentalDues = customerService.generateRentals();
        assertEquals( 9, getTotalDue( rentalDues ) );
        assertEquals( 3, getFrequentRentalPoints( rentalDues ) );
    }

    @Test
    void shouldReturnRentalsForChildrenMovies()
    {
        var rental1 = new Rental( "Home Alone", "Children", 2 );
        var rental2 = new Rental( "Inside Out", "Children", 4 );

        customerService = new CustomerService( rentalServiceImpl, List.of( rental1, rental2 ) );
        var rentalDues = customerService.generateRentals();
        assertEquals( 4.5, getTotalDue( rentalDues ) );
        assertEquals( 2, getFrequentRentalPoints( rentalDues ) );
    }

    private double getTotalDue( final RentalDue[] rentalDues )
    {
        double totalDue = 0;
        for ( RentalDue rentalDue : rentalDues )
        {
            totalDue += rentalDue.getDue();
        }
        return totalDue;
    }

    private int getFrequentRentalPoints( final RentalDue[] rentalDues )
    {
        int frequentRentalPoints = 0;
        for ( RentalDue rentalDue : rentalDues )
        {
            frequentRentalPoints += rentalDue.getFrequentRentalPoints();
        }
        return frequentRentalPoints;
    }
}
