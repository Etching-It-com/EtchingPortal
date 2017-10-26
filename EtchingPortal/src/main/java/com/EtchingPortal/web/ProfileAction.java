package com.EtchingPortal.web;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;

import com.EtchingPortal.dao.ProfileDAOImpl;
import com.EtchingPortal.domain.Profile;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

public class ProfileAction extends ActionSupport implements ModelDriven<Profile> {

    private static final long serialVersionUID = 1L;
    String flashMessage;
    String name, surName, curriculum, category, location, experience, training, languages;
    int candidateId;
    public List<String> listCategory, listLocation, listTraining, listExperience, listLanguages;
    private List<Profile> listProfile;
    ProfileDAOImpl profileDAO;
    Profile profile;

    public boolean authProfile(int id) {
        Map session = ActionContext.getContext().getSession();
        try {
            profileDAO = new ProfileDAOImpl();
            profile = profileDAO.viewProfile(id);
            return session.get("id").equals(profile.getCandidateId()) && session.get("role").equals("candidate");
        } catch (Exception e) {
            return false;
        }
    }

    public String view() throws Exception {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        try {
            profileDAO = new ProfileDAOImpl();
            profile = profileDAO.viewProfile(Integer.parseInt(request.getParameter("id")));
            return SUCCESS;
        } catch (NumberFormatException e) {
            setFlashMessage("Opppsss, some error has occurred");
            return ERROR;
        }
    }

    public String edit() throws Exception {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        try {
            if (authProfile(Integer.parseInt(request.getParameter("id")))) {
                if (request.getMethod().equals("POST")) {
                    profileDAO = new ProfileDAOImpl();
                    profile = profileDAO.viewProfile(Integer.parseInt(request.getParameter("id")));
                    profile.setName(getName());
                    profile.setSurName(getSurName());
                    profile.setCurriculum(getCurriculum());
                    profile.setCategory(getCategory());
                    profile.setLocation(getLocation());
                    profile.setExperience(getExperience());
                    profile.setTraining(getTraining());
                    profile.setLanguages(getLanguages());
                    profile.setModified(new Date());
                    profile = profileDAO.editProfile(profile);
                    setFlashMessage("Ok, the profile has been edited");
                    return "post";
                } else {
                    listCategory = new ArrayList<>();
                    listLocation = new ArrayList<>();
                    listTraining = new ArrayList<>();
                    listExperience = new ArrayList<>();
                    listLanguages = new ArrayList<>();

                    listLocation.add("Alabama"); 
                    listLocation.add("Alaska");
                    listLocation.add("Arizona"); 
                    listLocation.add("Arkansas");
                    listLocation.add("California"); 
                    listLocation.add("Colorado"); 
                    listLocation.add("Connecticut"); 
                    listLocation.add("Delaware"); 
                    listLocation.add("Florida"); 
                    listLocation.add("Georgia"); 
                    listLocation.add("Hawaii"); 
                    listLocation.add("Idaho"); 
                    listLocation.add("Illinois Indiana"); 
                    listLocation.add("Iowa"); 
                    listLocation.add("Kansas"); 
                    listLocation.add("Kentucky"); 
                    listLocation.add("Louisiana"); 
                    listLocation.add("Maine"); 
                    listLocation.add("Maryland"); 
                    listLocation.add("Massachusetts"); 
                    listLocation.add("Michigan"); 
                    listLocation.add("Minnesota"); 
                    listLocation.add("Mississippi"); 
                    listLocation.add("Missouri"); 
                    listLocation.add("Montana Nebraska"); 
                    listLocation.add("Nevada"); 
                    listLocation.add("New Hampshire"); 
                    listLocation.add("New Jersey"); 
                    listLocation.add("New Mexico"); 
                    listLocation.add("New York"); 
                    listLocation.add("North Carolina"); 
                    listLocation.add("North Dakota"); 
                    listLocation.add("Ohio"); 
                    listLocation.add("Oklahoma"); 
                    listLocation.add("Oregon"); 
                    listLocation.add("Pennsylvania Rhode Island"); 
                    listLocation.add("South Carolina"); 
                    listLocation.add("South Dakota"); 
                    listLocation.add("Tennessee"); 
                    listLocation.add("Texas"); 
                    listLocation.add("Utah"); 
                    listLocation.add("Vermont"); 
                    listLocation.add("Virginia"); 
                    listLocation.add("Washington"); 
                    listLocation.add("West Virginia"); 
                    listLocation.add("Wisconsin"); 
                    listLocation.add("Wyoming");

                    listCategory.add("All");
                    listCategory.add("Public Administration");
                    listCategory.add("Business Administration");
                    listCategory.add("Customer Service");
                    listCategory.add("Quality, production and R & D");
                    listCategory.add("Sales and sales");
                    listCategory.add("Purchasing, Logistics and Warehousing");
                    listCategory.add("Design and graphic arts");
                    listCategory.add("Education and training");
                    listCategory.add("Finance and Banking");
                    listCategory.add("IT and Telecoms");
                    listCategory.add("Engineers and technicians");
                    listCategory.add("Real estate and construction");
                    listCategory.add("Legal");
                    listCategory.add("Marketing and communication");
                    listCategory.add("Professionals, arts and crafts");
                    listCategory.add("Human Resources");
                    listCategory.add("Health and health");
                    listCategory.add("Tourism and restoration");
                    listCategory.add("Retail Sales");
                    listCategory.add("Others");

                    listTraining.add("no studies");
                    listTraining.add("that");
                    listTraining.add("Bachelors");
                    listTraining.add("Grade Medium");
                    listTraining.add("superior grade");
                    listTraining.add("Diploma");
                    listTraining.add("Graduate");

                    listExperience.add("without experience");
                    listExperience.add("Less than one year");
                    listExperience.add("1 year");
                    listExperience.add("2 year");
                    listExperience.add("3 years or more");

                    listLanguages.add("hindi");
                    listLanguages.add("english");
                    listLanguages.add("France");
                    listLanguages.add("German");

                    profileDAO = new ProfileDAOImpl();
                    profile = profileDAO.viewProfile(Integer.parseInt(request.getParameter("id")));
                    return "get";
                }
            } else {
                setFlashMessage("You do not have access to this content");
                return ERROR;
            }
        } catch (NumberFormatException ex) {
            setFlashMessage("You do not have access to this content");
            return ERROR;
        }
    }

    public String getFlashMessage() {
        return flashMessage;
    }

    public void setFlashMessage(String flashMessage) {
        this.flashMessage = flashMessage;
    }

    public int getCandidateId() {
        return this.candidateId;
    }

    public void setCandidateId(int candidateId) {
        this.candidateId = candidateId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;

    }

    public String getSurName() {
        return this.surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getCurriculum() {
        return this.curriculum;
    }

    public void setCurriculum(String curriculum) {
        this.curriculum = curriculum;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTraining() {
        return this.training;
    }

    public void setTraining(String training) {
        this.training = training;
    }

    public String getExperience() {
        return this.experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getLanguages() {
        return this.languages;
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

    @Override
    public Profile getModel() {
        return profile;
    }
}
