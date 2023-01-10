package cat.itacademy.barcelonactiva.llopart.gil.ismael.s05t01n01.controllers.services;

import java.util.List;
import java.util.Optional;

import cat.itacademy.barcelonactiva.llopart.gil.ismael.s05t01n01.views.dto.BranchOfficeDTO;

public interface BranchOfficeService {
	
	public void save(BranchOfficeDTO branchOfficeDTO);

	public Optional<BranchOfficeDTO> findById(int id);

	public void deleteById(int id);

	public List<BranchOfficeDTO> findAll();
}
