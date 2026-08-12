package tech.ps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import tech.ps.Model.BookingForm;
import tech.ps.Model.ContactForm;
import tech.ps.Model.ServiceForm;
import tech.ps.service.BookingFormService;
import tech.ps.service.ContactFormService;
import tech.ps.service.ServiceFormService;

@Controller
public class Mycontroller {

    @Autowired
    private ContactFormService contactFormService;

    @Autowired
    private BookingFormService bookingFormService;
    
    private ServiceFormService serviceFormService;
    
    @Autowired
    public void setServiceFormService(ServiceFormService serviceFormService) {
		this.serviceFormService = serviceFormService;
	}
	@GetMapping({"/", "/home", "/welcome", "/index"})
    public String welcomeView(HttpServletRequest req, Model model) {
        model.addAttribute("mycurrentpage", req.getRequestURI());

        if (!model.containsAttribute("bookingForm")) {
            model.addAttribute("bookingForm", new BookingForm());
        }

        return "index";
    }
    @GetMapping("about")
    public String aboutView(HttpServletRequest req,Model m) {
    	String requestURI = req.getRequestURI();
    	m.addAttribute("mycurrentpage",requestURI);
    	return "about";
    }
    @GetMapping("cars")
    public String carView(HttpServletRequest req,Model m) {
    	String requestURI = req.getRequestURI();
    	m.addAttribute("mycurrentpage",requestURI);
    	return "cars";
    	}
    
    @GetMapping("services")
    public String servicesView(HttpServletRequest req,Model m) {
    	String requestURI = req.getRequestURI();
    	m.addAttribute("mycurrentpage",requestURI);
    	
    	List<ServiceForm>allServices = serviceFormService.readAllServices();
    	m.addAttribute("allservices",allServices);
    	
    	return "services";
    }

    @GetMapping("/contacts")
    public String contactsView(HttpServletRequest req, Model model) {
        model.addAttribute("mycurrentpage", req.getRequestURI());

        if (!model.containsAttribute("contactForm")) {
            model.addAttribute("contactForm", new ContactForm());
        }

        return "contacts";
    }
    
    @GetMapping("/login")
    public String adminLoginView(HttpServletRequest request,Model model) {
    	
    	ServletContext servletContext=request.getServletContext();
    	Object attribute = servletContext.getAttribute("logout");
    	if(attribute instanceof Boolean) {
    		model.addAttribute("logout",attribute);
    		servletContext.removeAttribute("logout");
    	}
    	return "adminlogin";
    }

    @PostMapping("/contactform")
    public String contactForm(
            @Valid @ModelAttribute("contactForm") ContactForm contactForm,
            BindingResult result,
            RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.contactForm", result);
            redirectAttributes.addFlashAttribute("contactForm", contactForm);
            return "redirect:/contacts";
        }

        contactFormService.saveContactFormService(contactForm);
        redirectAttributes.addFlashAttribute("message", "Message Sent Successfully");

        return "redirect:/contacts";
    }

    @PostMapping("/bookingform")
    public String bookingForm(
            @Valid @ModelAttribute("bookingForm") BookingForm bookingForm,
            BindingResult result,
            RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.bookingForm", result);
            redirectAttributes.addFlashAttribute("bookingForm", bookingForm);
            return "redirect:/index";
        }

        if (bookingForm.getAdult() + bookingForm.getChildren() > 4) {
            redirectAttributes.addFlashAttribute("message",
                    "The total number of adults and children cannot exceed 4");
            redirectAttributes.addFlashAttribute("bookingForm", bookingForm);
            return "redirect:/index";
        }

        BookingForm savedBookingForm = bookingFormService.saveBookingFormService(bookingForm);

        if (savedBookingForm != null) {
            redirectAttributes.addFlashAttribute("message", "Booking Submitted Successfully");
        } else {
            redirectAttributes.addFlashAttribute("message", "Something went wrong");
        }

        return "redirect:/index";
    }
}
