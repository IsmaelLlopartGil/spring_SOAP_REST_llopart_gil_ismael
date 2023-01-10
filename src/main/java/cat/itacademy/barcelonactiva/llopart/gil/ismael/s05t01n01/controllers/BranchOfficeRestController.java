package cat.itacademy.barcelonactiva.llopart.gil.ismael.s05t01n01.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cat.itacademy.barcelonactiva.llopart.gil.ismael.s05t01n01.controllers.services.BranchOfficeService;
import cat.itacademy.barcelonactiva.llopart.gil.ismael.s05t01n01.views.dto.BranchOfficeDTO;
import jakarta.validation.Valid;

@RestController
@RequestMapping ("/v1/sucursal")
public class BranchOfficeRestController {

	@Autowired
	BranchOfficeService branchOfficeService;
	
	@PostMapping ("/")
	public ResponseEntity<BranchOfficeDTO> add (@Valid @RequestBody BranchOfficeDTO branchOfficeDTO) {	
		branchOfficeService.save(branchOfficeDTO);	
		return ResponseEntity.ok(branchOfficeDTO);
	}
	
	@PutMapping ("/")
	public ResponseEntity<BranchOfficeDTO> update (@Valid @RequestBody BranchOfficeDTO branchOfficeDTO){		
		Optional<BranchOfficeDTO> branchOffice = branchOfficeService.findById(branchOfficeDTO.getPk_branch_office_id());

		if (branchOffice.isPresent()) {
			branchOfficeService.save(branchOfficeDTO);
			return ResponseEntity.ok(branchOfficeDTO);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping ("/{id}")
	public ResponseEntity<BranchOfficeDTO> delete (@PathVariable int id){
		Optional<BranchOfficeDTO> branchOffice = branchOfficeService.findById(id);
		
		if (branchOffice.isPresent()) {
			branchOfficeService.deleteById(id);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping ("/{id}")
	public ResponseEntity<BranchOfficeDTO> getOne(@PathVariable int id) {
		Optional<BranchOfficeDTO> branchOffice = branchOfficeService.findById(id);
		
		if (branchOffice.isPresent()) {
			return ResponseEntity.ok(branchOffice.get());
		} else {
			return ResponseEntity.notFound().build();
		}		
	}
	
	@GetMapping ("/")
	public ResponseEntity<List<BranchOfficeDTO> > getAll() {		
		return ResponseEntity.ok(branchOfficeService.findAll());
	}
}
