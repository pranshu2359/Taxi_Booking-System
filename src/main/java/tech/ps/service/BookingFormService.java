package tech.ps.service;

import java.util.List;

import tech.ps.Model.BookingForm;


public interface BookingFormService {
    BookingForm saveBookingFormService(BookingForm bookingForm);
    

    List<BookingForm> readAllBookingsService();

    void deleteBookingService(int id);   
}
