package tech.ps.service;

import java.util.List;
import tech.ps.Model.ContactForm;

public interface ContactFormService {

    ContactForm saveContactFormService(ContactForm contactForm);

    List<ContactForm> readAllContactsService();

    void deleteContactService(int id);   
}
