package com.cg.leavecontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.leavemodel.Leave;
import com.cg.leaverepository.LeaveJPARepository;

@RestController
public class LeaveController {

	@Autowired
	LeaveJPARepository repository;

	@PostMapping(path = "/apply")
	public void applyLeave(@RequestBody Leave leave) {

		System.out.println("inside applyLeave() of Controller");
		repository.save(leave);
	}

	@GetMapping(path = "/status")
	public List<Leave> retrieveStatus() {
		System.out.println("inside retrieveStatus() of Controller");
		return repository.findAll();

	}

	@PutMapping(path = "/response/{empId}")
	public Leave updateDetails(@PathVariable int empId, @RequestBody Leave leave) {

		System.out.println("inside updateDetails() of Controller");

		Optional<Leave> lea = repository.findById(empId);
		repository.save(leave);
		return leave;
	}

}
