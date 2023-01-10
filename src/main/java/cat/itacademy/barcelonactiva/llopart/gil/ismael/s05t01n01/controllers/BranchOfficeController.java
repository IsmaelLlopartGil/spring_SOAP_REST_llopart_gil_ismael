package cat.itacademy.barcelonactiva.llopart.gil.ismael.s05t01n01.controllers;

import java.util.Optional;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import cat.itacademy.barcelonactiva.llopart.gil.ismael.s05t01n01.controllers.services.BranchOfficeService;
import cat.itacademy.barcelonactiva.llopart.gil.ismael.s05t01n01.views.dto.BranchOfficeDTO;

@Controller
@RequestMapping({ "/", "/sucursals" })
public class BranchOfficeController {

	@Autowired
	BranchOfficeService branchOfficeService;

	@PostConstruct
	public void init() {
		branchOfficeService.save(new BranchOfficeDTO(1, "Sucursal 1", "greece"));
		branchOfficeService.save(new BranchOfficeDTO(2, "Sucursal 2", "united kingdom"));
		branchOfficeService.save(new BranchOfficeDTO(3, "Sucursal 3", "peru"));
	}

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("sucursals", branchOfficeService.findAll());
		return "sucursals";
	}

	@GetMapping("/nova")
	public String addFormulary(Model model) {
		BranchOfficeDTO branchOfficeDTO = new BranchOfficeDTO();
		model.addAttribute("sucursal", branchOfficeDTO);
		return "crear_sucursal";
	}

	@PostMapping("/add")
	public String add(@ModelAttribute("sucursal") BranchOfficeDTO branchOfficeDTO) {
		branchOfficeService.save(branchOfficeDTO);
		return "redirect:/sucursals/";
	}

	@GetMapping("/update/{id}")
	public String updateFormulary(@PathVariable int id, Model model) {
		model.addAttribute("sucursal", branchOfficeService.findById(id).get());
		return "modificar_sucursal";
	}

	@PostMapping("/update/{id}")
	public String update(@PathVariable int id, @ModelAttribute("sucursal") BranchOfficeDTO branchOfficeDTO) {
		branchOfficeDTO.setPk_branch_office_id(id);
		branchOfficeService.save(branchOfficeDTO);
		return "redirect:/sucursals/";
	}

	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		Optional<BranchOfficeDTO> branchOffice = branchOfficeService.findById(id);

		if (branchOffice.isPresent()) {
			branchOfficeService.deleteById(id);
		}
		return "redirect:/sucursals/";
	}
}
