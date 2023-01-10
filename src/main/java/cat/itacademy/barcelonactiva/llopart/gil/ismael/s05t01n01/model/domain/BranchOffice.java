package cat.itacademy.barcelonactiva.llopart.gil.ismael.s05t01n01.model.domain;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table (name = "branch_office")
public class BranchOffice implements Serializable {

	private static final long serialVersionUID = 2946779285781784380L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (unique = true, nullable = false)
	private Integer pk_branch_office_id;
	
	@NotBlank (message = "El nom és obligatori.")
	@Column (name="name")
	private String name;
	
	@NotBlank (message = "El país és obligatori.")
	@Column (name="country")
	private String country;
		
	public BranchOffice(String name, String country) {
		this.name=name;
		this.country=country;
	}
	
	public BranchOffice() {
	}

	public Integer getPk_sucursal_id() {
		return pk_branch_office_id;
	}


	public void setPk_sucursal_id(Integer pk_branch_office_id) {
		this.pk_branch_office_id = pk_branch_office_id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
