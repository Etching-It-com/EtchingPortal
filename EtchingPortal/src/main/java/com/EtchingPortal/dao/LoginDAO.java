

package com.EtchingPortal.dao;

import com.EtchingPortal.domain.Candidate;
import com.EtchingPortal.domain.Company;

public interface LoginDAO {
    public Candidate findCandidate(String userName, String passWord);
    public Company findCompany(String cif, String passWord);
    public void updateLastLogin(Candidate candidate, Company company);
}
