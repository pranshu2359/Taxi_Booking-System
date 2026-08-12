package tech.ps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.ps.Model.BookingForm;
import tech.ps.dao.BookingFormCrud;

@Service
public class BookingFormServiceImpl implements BookingFormService {

    @Autowired
    private BookingFormCrud bookingFormCrud;

    @Override
    public BookingForm saveBookingFormService(BookingForm bookingForm) {
        return bookingFormCrud.save(bookingForm);
    }

	@Override
	public List<BookingForm> readAllBookingsService() {
		// TODO Auto-generated method stub
		return bookingFormCrud.findAll();
	}

	@Override
	public void deleteBookingService(int id) {
		bookingFormCrud.deleteById(id);
		
	}
}
