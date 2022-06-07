package main.classes;

import main.enums.AcademicQualification;
import main.interfaces.InterviewRequirements;

public class StoreOwner extends Staff implements InterviewRequirements {
    private static Manager manager;

    public StoreOwner(String name, String phoneNumber, String emailAddress, String houseAddress, int age) {
        super(name, phoneNumber, emailAddress, houseAddress, age);
    }


    // determine whether to invite applicant for interview or not for the role of manager
    @Override
    public boolean determineInterviewStatus(int ageLimit, int yearsOfExperience, AcademicQualification academicQualification, String phone, String emailAddress) {
        if (ageLimit >= 27 && yearsOfExperience >= 5 && (AcademicQualification.MASTERS == academicQualification || AcademicQualification.FIRST_DEGREE == academicQualification)){
            System.out.println("You have been invited for an interview.");
            return true;
        }

        return false;
    }

    public void setManager(Manager manager) {
        StoreOwner.manager = manager;
    }

    public static Manager getManager() {
        return manager;
    }
}
