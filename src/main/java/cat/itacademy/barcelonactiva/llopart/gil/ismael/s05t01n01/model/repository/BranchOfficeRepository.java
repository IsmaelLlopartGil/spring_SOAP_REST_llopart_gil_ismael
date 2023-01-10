package cat.itacademy.barcelonactiva.llopart.gil.ismael.s05t01n01.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cat.itacademy.barcelonactiva.llopart.gil.ismael.s05t01n01.model.domain.BranchOffice;

@Repository
public interface BranchOfficeRepository extends JpaRepository<BranchOffice, Integer> {}
