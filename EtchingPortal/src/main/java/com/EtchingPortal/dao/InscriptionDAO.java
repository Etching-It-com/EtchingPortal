
package com.EtchingPortal.dao;

import java.util.List;

import com.EtchingPortal.domain.Inscription;


public interface InscriptionDAO {
    public Inscription findById(int id);
    public boolean updateInscriptionStatus(Inscription inscription);
    public void addInscription(Inscription inscription);
    public List<Inscription> listInscriptionByCandidateId(int id);
    public List<Inscription> listInscriptionByJobId (int id);
    public boolean findByCandidateIdAndJobId(int candidateId, int jobId);
}
