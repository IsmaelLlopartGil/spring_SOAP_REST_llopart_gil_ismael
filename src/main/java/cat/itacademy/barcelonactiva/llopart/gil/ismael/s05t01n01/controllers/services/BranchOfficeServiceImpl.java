package cat.itacademy.barcelonactiva.llopart.gil.ismael.s05t01n01.controllers.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.llopart.gil.ismael.s05t01n01.model.repository.BranchOfficeRepository;
import cat.itacademy.barcelonactiva.llopart.gil.ismael.s05t01n01.views.dto.BranchOfficeDTO;

@Service
public class BranchOfficeServiceImpl implements BranchOfficeService {

	@Autowired
	BranchOfficeRepository branchOfficeRepository;
	
	@Autowired
	BranchOfficeMapper branchOfficeMapper;

	public void save(BranchOfficeDTO branchOfficeDTO) {
		 branchOfficeRepository.save(branchOfficeMapper.convertToEntity(branchOfficeDTO));
	}

	public Optional<BranchOfficeDTO> findById(int id) {
		return branchOfficeMapper.convertToOptionalDto(branchOfficeRepository.findById(id));
	}

	public void deleteById(int id) {
		branchOfficeRepository.deleteById(id);
	}

	public List<BranchOfficeDTO> findAll() {
		return branchOfficeMapper.convertToListDto (branchOfficeRepository.findAll());
	}
}
