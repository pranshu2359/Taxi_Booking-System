package tech.ps.Model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="bookingform")
public class BookingForm {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotEmpty(message="name cant be empty")
    @NotBlank(message="name cant be blank")
    @Size(min=2,max=30,message="invalid name length")
    @Pattern(regexp = "^[A-Za-z]+$",message="name must contain only alphabet")
    @Column(length=30)
    private String name;

    @NotEmpty(message="source cant be empty")
    @NotBlank(message="source cant be blank")
    @Size(min=2,max=100,message="invalid source length")
    @Column(length=100)
    private String source;

    @NotEmpty(message="email cant be empty")
    @NotBlank(message="email cant be blank")
    @Size(min=5,max=50,message="invalid email length")
    @Column(length=50)
    private String email;

    @NotEmpty(message="destination cant be empty")
    @NotBlank(message="destination cant be blank")
    @Size(min=2,max=100,message="invalid destination length")
    @Column(length=100)
    private String destination;

    @NotNull(message="time cant be empty")
    private LocalTime time;

    @NotNull(message="date cant be empty")
    private LocalDate date;

    @NotEmpty(message="comfort cant be empty")
    @Size(min=2,max=30,message="invalid comfort length")
    @Column(length=20)
    private String comfort;

    @Min(value=1,message="adult can be at least 1 ")
    @Max(value=4,message="adult can be at most 4 ")
    private int adult;

    @Max(value=3,message="children can be at most 3")
    private int children;

    @NotEmpty(message="message cant be empty")
    @NotBlank(message="message cant be blank")
    @Size(min=2,max=2000,message="invalid message length")
    @Column(length=2000)
    private String message;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getComfort() {
		return comfort;
	}

	public void setComfort(String comfort) {
		this.comfort = comfort;
	}

	public int getAdult() {
		return adult;
	}

	public void setAdult(int adult) {
		this.adult = adult;
	}

	public int getChildren() {
		return children;
	}

	public void setChildren(int children) {
		this.children = children;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

    
  
}
