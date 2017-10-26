
package com.EtchingPortal.dao;



import java.util.List;

import com.EtchingPortal.domain.Inscription;
import com.EtchingPortal.domain.Job;


public interface JobDAO {

    public List<Job> searchJobByText(String text);

    public List<Job> searchJobByAll(String text, String training, String experience, String languages);

    public List<Job> listJobByInscription(List<Inscription> inscription);

    public Job findById(int id);

    public List<Job> listJobByCompanyId(int id);

    public List<Job> listJob();

    public void addJob(Job job);

    public Job deleteJob(int id);

    public Job editJob(Job job);
}
