package com.EtchingPortal.dao;

import java.util.List;

import com.EtchingPortal.domain.Candidate;


public interface CandidateDAO {
    public Candidate findById(int id);
    public List <Candidate> listCandidate();
    public boolean addCandidate(Candidate candidate);
    public Candidate deleteCandidate(int id);
    public Candidate editCandidate(Candidate candidate); 
    public boolean existCandidateByUserName(String string);
}
