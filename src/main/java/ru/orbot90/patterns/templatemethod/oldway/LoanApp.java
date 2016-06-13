package ru.orbot90.patterns.templatemethod.oldway;

import ru.orbot90.patterns.templatemethod.ApplicationDenied;

/**
 * Created by orbot on 13.06.16.
 */
public class LoanApp {
    public static void main(String[] args) {
        System.out.println("======= New personal loan application =======");
        LoanApplication loanApplication = new PersonalLoanApplication();
        try {
            loanApplication.checkLoanApplication();
            System.out.println("===== Application approved =====");
        } catch (ApplicationDenied applicationDenied) {
            System.out.println("======== Application denied ========");
        }

        System.out.println("======= New employee loan application =========");
        LoanApplication loanApplicationEmployee = new EmployeeLoanApplication();
        try {
            loanApplicationEmployee.checkLoanApplication();
            System.out.println("===== Application approved =====");
        } catch (ApplicationDenied applicationDenied) {
            System.out.println("======== Application denied ========");
        }
    }
}
