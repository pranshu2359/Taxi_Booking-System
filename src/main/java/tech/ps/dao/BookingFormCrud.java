package tech.ps.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.ps.Model.BookingForm;
import tech.ps.Model.ContactForm;

@Repository
public interface BookingFormCrud extends JpaRepository<BookingForm, Integer> {
    
	@Override
	public <S extends BookingForm> S save(S entity);
	
	@Override
    public List<BookingForm>findAll();
	
	
	@Override
	public void deleteById(Integer id);
}
