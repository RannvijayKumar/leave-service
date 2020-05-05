package com.cg.leaverepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.leavemodel.Leave;

@Repository
public interface LeaveJPARepository extends JpaRepository<Leave, Integer> {

}
