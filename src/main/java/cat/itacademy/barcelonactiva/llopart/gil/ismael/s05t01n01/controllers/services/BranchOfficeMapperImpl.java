package cat.itacademy.barcelonactiva.llopart.gil.ismael.s05t01n01.controllers.services;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import cat.itacademy.barcelonactiva.llopart.gil.ismael.s05t01n01.model.domain.BranchOffice;
import cat.itacademy.barcelonactiva.llopart.gil.ismael.s05t01n01.views.dto.BranchOfficeDTO;

@Component("mapper")
public class BranchOfficeMapperImpl implements BranchOfficeMapper {

	List<String> countries;
	
	public BranchOfficeMapperImpl() {
		
		countries = new ArrayList<>();
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader("UE_Countries.txt"))) {
		    String line = bufferedReader.readLine();
		    String[] values = line.split(",");
		    
		    for (String string : values) {
		    	countries.add(string.trim().toLowerCase());
			}
		    
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	@Override
	public BranchOfficeDTO convertToDTO(BranchOffice branchOffice) {
		BranchOfficeDTO branchOfficeDTO = new BranchOfficeDTO();
		branchOfficeDTO.setPk_branch_office_id(branchOffice.getPk_sucursal_id());
		branchOfficeDTO.setName(branchOffice.getName());
		branchOfficeDTO.setCountry(branchOffice.getCountry());
		
		if (countries.contains(branchOffice.getCountry().toLowerCase())) {
			branchOfficeDTO.setBranchOfficeType("UE");
		} else {
			branchOfficeDTO.setBranchOfficeType("Fora UE");
		}
		
		return branchOfficeDTO;
	}

	@Override
	public BranchOffice convertToEntity(BranchOfficeDTO branchOfficeDTO) {
		BranchOffice branchOffice = new BranchOffice();
		branchOffice.setPk_sucursal_id(branchOfficeDTO.getPk_branch_office_id());
		branchOffice.setName(branchOfficeDTO.getName());
		branchOffice.setCountry(branchOfficeDTO.getCountry());
		return branchOffice;
	}

	@Override
	public Optional<BranchOfficeDTO> convertToOptionalDto(Optional<BranchOffice> branchOffice) {
				
		if (branchOffice.isPresent()) {
			return Optional.of(convertToDTO(branchOffice.get()));
		} else {
			return Optional.empty();
		}
	}

	@Override
	public List<BranchOfficeDTO> convertToListDto(Iterable<BranchOffice> branchOfficeList) {
		List<BranchOfficeDTO> branchOfficeDtoList = new ArrayList<>();
		
		for (BranchOffice branchOffice : branchOfficeList) {
			branchOfficeDtoList.add(convertToDTO(branchOffice));
		}
		
		return branchOfficeDtoList;
	}
}
