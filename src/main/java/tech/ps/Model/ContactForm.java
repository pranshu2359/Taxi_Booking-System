package tech.ps.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="contactForm")
public class ContactForm {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Name can not be empty")
    @Size(min = 2, max = 30, message = "Name must be between 2 and 30 characters")
    @Column(length=30)
    private String name;

    @NotEmpty(message = "Email can not be empty")
    @Email(message = "Invalid email format")
    @Size(min = 5, max = 50, message = "Email must be between 5 and 50 characters")
    @Column(length=50)
    private String email;
    
	@NotNull(message = "phone no  can't be empty") 
	@Min(value = 1000000000, message = "Phone number can't be empty")
	@Max(value = 9999999999L, message = "Phone number must be between 10 and 15 digits") 
	@Column(length=10)
	private Long phone;
    @NotEmpty(message = "Message can not be empty")
    @Size(min = 5, max = 500, message = "Message must be between 5 and 500 characters")
    @Column(length=500)
    private String message;

    
    public ContactForm() {
    }

   
    public ContactForm(int id, String name, String email, Long phone, String message) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.message = message;
    }

   
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Long getPhone() { return phone; }
    public void setPhone(Long phone) { this.phone = phone; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    @Override
    public String toString() {
        return "ContactForm [id=" + id + ", name=" + name + ", email=" + email +
               ", phone=" + phone + ", message=" + message + "]";
    }
}
