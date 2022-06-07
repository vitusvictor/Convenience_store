package main.interfaces;

import main.enums.AcademicQualification;

public interface InterviewRequirements {
    boolean determineInterviewStatus(int ageLimit, int yearsOfExperience, AcademicQualification academicQualification, String phone, String emailAddress);

}
