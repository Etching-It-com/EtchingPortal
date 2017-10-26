
package com.EtchingPortal.actions;

import com.EtchingPortal.dao.JobDAOImpl;
import com.EtchingPortal.dao.ProfileDAOImpl;
import com.EtchingPortal.domain.Job;
import com.EtchingPortal.domain.Profile;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;


public class SearchAction extends ActionSupport {
    
    Profile profile;
    String seachField, flashMessage, training, experience, languages;
    List<Profile> listProfile;
    ProfileDAOImpl profileDAO;
    List<Job> listJob;
    JobDAOImpl jobDAO;
    public List<String> listTraining, listExperience, listLanguages;
    
    /**
     * 
     */
    public SearchAction() {
        listTraining = new ArrayList<>();
        listExperience = new ArrayList<>();
        listLanguages = new ArrayList<>();
        listTraining.add("");
        listTraining.add("bachelors");
        listTraining.add("Middle Degree");
        listTraining.add("Superior grade");
        listTraining.add("Graduate");
        listExperience.add("");
        listExperience.add("Without experience");
        listExperience.add("Less than one year");
        listExperience.add("1 year");
        listExperience.add("2 year");
        listExperience.add("3 years o more");
        listLanguages.add("Hindi");
        listLanguages.add("english");
        listLanguages.add("France");
        listLanguages.add("spanish");
    }
    
    public String searchProfileByText() throws Exception {
        
        profileDAO = new ProfileDAOImpl();
        setListProfile(profileDAO.searchProfileByText(getSearchField()));
        if (getListProfile().isEmpty()) {
            setFlashMessage("Have been found " + getListProfile().size() + "candidates");
            return ERROR;
        } else {
            setFlashMessage("Have been found " + getListProfile().size() + " candidates with this profile: " + getSearchField());
            return SUCCESS;
        }
    }
        public void validateSearchProfileByText() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        if (request.getMethod().equals("POST")) {
            if (getSearchField().length() == 0) {
                addFieldError("searchField", "Enter a word to search");
            }
        }
    }
    public void validateSearchJobByText() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        if (request.getMethod().equals("POST")) {
            if (getSearchField().length() == 0) {
                addFieldError("searchField", "Enter a word to search");
            }
        }
    }
    
    public String searchJobByText() throws Exception {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        if (request.getMethod().equals("POST")) {
            try {
                jobDAO = new JobDAOImpl();
                setListJob(jobDAO.searchJobByText(getSearchField()));
                setFlashMessage("Have been found " + getListJob().size() + " work with the word " + getSearchField());
                return SUCCESS;
            } catch (Exception e) {
                setFlashMessage("Opppsss, an error has occurred");
                return ERROR;
            }
        } else {
            return "get";
        }
    }
    
    public String avancedSearchJob() throws Exception {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        if (request.getMethod().equals("POST")) {
            jobDAO = new JobDAOImpl();
            setListJob(jobDAO.searchJobByAll(getSearchField(), getTraining(), getExperience(), getLanguages()));
            setFlashMessage("\n" + 
            		"Have been found" + getListJob().size() + "work with the word " + getSearchField()
                    + "training " + getTraining() + " Experience: " + getExperience());
            return SUCCESS;
        } else {
            return "get";
        }
    }
    
    public String getFlashMessage() {
        return flashMessage;
    }
    
    public void setFlashMessage(String flashMessage) {
        this.flashMessage = flashMessage;
    }
    
    public List<Profile> getListProfile() {
        return listProfile;
    }
    
    public void setListProfile(List<Profile> listProfile) {
        this.listProfile = listProfile;
    }
    
    public List<Job> getListJob() {
        return listJob;
    }
    
    public void setListJob(List<Job> listJob) {
        this.listJob = listJob;
    }
    
    public String getSearchField() {
        return seachField;
    }
    
    public void setSearchField(String searchField) {
        this.seachField = searchField;
    }
    
    public String getTraining() {
        return training;
    }
    
    public void setTraining(String training) {
        this.training = training;
    }
    
    public String getExperience() {
        return experience;
    }
    
    public void setExperience(String experience) {
        this.experience = experience;
    }
    
    public String getLanguages() {
        return languages;
    }
    
    public void setLanguages(String languages) {
        this.languages = languages;
    }
    
    public List<String> getListTraining() {
        return listTraining;
    }
    
    public void setListTraining(List<String> listTraining) {
        this.listTraining = listTraining;
    }
    
    public List<String> getListExperience() {
        return listExperience;
    }
    
    public void setListExperience(List<String> listExperience) {
        this.listExperience = listExperience;
    }
    
    public List<String> getListLanguages() {
        return listLanguages;
    }
    
    public void setListLanguages(List<String> listLanguages) {
        this.listLanguages = listLanguages;
    }
}
