package com.springbootdev.examples.controller;


import com.springbootdev.examples.entity.Candidate;
import com.springbootdev.examples.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/interview")
public class CandidateController {

    @Autowired
    private CandidateRepository candidateRepository;


    @PostMapping("/candidates")
    public Candidate create(@RequestBody Candidate user)
    {
        return candidateRepository.save(user);
    }


    @GetMapping("/candidates")
    public List<Candidate> findAll()
    {
        return candidateRepository.findAll();
    }


    @PutMapping("/candidates/{user_id}")
    public Candidate update(@PathVariable("user_id") Long userId, @RequestBody Candidate userObject)
    {
    	Candidate user = candidateRepository.findOne(userId);
        user.setName(userObject.getName());
        user.setEmailid(userObject.getEmailid());
        user.setSkills(userObject.getSkills());
        user.setQualification(userObject.getQualification());
        return candidateRepository.save(user);
    }



    @DeleteMapping("/candidates/{user_id}")
    public List<Candidate> delete(@PathVariable("user_id") Long userId)
    {
    	candidateRepository.delete(userId);
        return candidateRepository.findAll();
    }



    @GetMapping("/candidates/{user_id}")
    @ResponseBody
    public Candidate findByUserId(@PathVariable("user_id") Long userId)
    {
        return candidateRepository.findOne(userId);
    }
}
