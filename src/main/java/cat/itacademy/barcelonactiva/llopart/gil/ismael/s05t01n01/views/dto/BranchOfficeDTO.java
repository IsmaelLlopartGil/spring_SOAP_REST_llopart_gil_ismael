package cat.itacademy.barcelonactiva.llopart.gil.ismael.s05t01n01.views.dto;

import java.io.Serializable;

public class BranchOfficeDTO implements Serializable {

	private static final long serialVersionUID = 2415557501126295187L;

	private Integer pk_branch_office_id;
	private String name;
	private String country;
	private String BranchOfficeType;

	public BranchOfficeDTO(String name, String country) {
		this.name = name;
		this.country = country;
	}
	
	public BranchOfficeDTO(int pk_branch_office_id, String name, String country) {
		this.pk_branch_office_id = pk_branch_office_id;
		this.name = name;
		this.country = country;
	}
	
	public BranchOfficeDTO () {
		
	}

	public Integer getPk_branch_office_id() {
		return pk_branch_office_id;
	}

	public void setPk_branch_office_id(Integer pk_branch_office_id) {
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

	public String getBranchOfficeType() {
		return BranchOfficeType;
	}

	public void setBranchOfficeType(String branchOfficeType) {
		BranchOfficeType = branchOfficeType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
