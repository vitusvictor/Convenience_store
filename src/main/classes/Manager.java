package main.classes;

import main.enums.AcademicQualification;
import main.interfaces.InterviewRequirements;

public class Manager extends Staff implements InterviewRequirements {
    public static Cashier cashier;
    private AcademicQualification academicQualification;

    public Manager(String name, String phoneNumber, String emailAddress, String houseAddress, int age, AcademicQualification academicQualification) {
        super(name, phoneNumber, emailAddress, houseAddress, age);
        this.academicQualification = academicQualification;
    }

    // determine whether to invite applicant for interview or not for the role of cashier
    @Override
    public boolean determineInterviewStatus(int ageLimit, int yearsOfExperience, AcademicQualification academicQualification, String phone, String emailAddress) {
        if (ageLimit <= 35 && yearsOfExperience >= 3 && (AcademicQualification.SSCE == academicQualification || AcademicQualification.FIRST_DEGREE == academicQualification)){
            System.out.println("You have been invited for an interview.");
            return true;
        }

        return false;
    }

    public void setCashier(Cashier cashier) {
        Manager.cashier = cashier;
    }

    public static Cashier getCashier() {
        return cashier;
    }

}
