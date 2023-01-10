package cat.itacademy.barcelonactiva.llopart.gil.ismael.s05t01n01.controllers.services;

import java.util.List;
import java.util.Optional;

import cat.itacademy.barcelonactiva.llopart.gil.ismael.s05t01n01.model.domain.BranchOffice;
import cat.itacademy.barcelonactiva.llopart.gil.ismael.s05t01n01.views.dto.BranchOfficeDTO;

public interface BranchOfficeMapper {
	
	public BranchOfficeDTO convertToDTO (BranchOffice branchOffice);
	
	public BranchOffice convertToEntity(BranchOfficeDTO branchOfficeDTO);

	public Optional<BranchOfficeDTO> convertToOptionalDto(Optional<BranchOffice> branchOffice);

	public List<BranchOfficeDTO> convertToListDto(Iterable<BranchOffice> branchOfficeList);
}
