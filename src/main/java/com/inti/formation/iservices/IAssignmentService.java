package com.inti.formation.iservices;

import java.util.List;

import com.inti.formation.entities.Assignment;

public interface IAssignmentService {
	
    public Assignment saveOrUpdateAssignment(Assignment Assignment);
    public void deleteAssignment (Long idAssignment);
    public Assignment getByIdAssignment(Long idAssignment);
    public List<Assignment> getAllAssignment();

}
