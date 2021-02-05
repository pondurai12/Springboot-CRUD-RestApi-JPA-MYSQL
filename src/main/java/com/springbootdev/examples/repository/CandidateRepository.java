package com.springbootdev.examples.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootdev.examples.entity.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Long>
{

}
