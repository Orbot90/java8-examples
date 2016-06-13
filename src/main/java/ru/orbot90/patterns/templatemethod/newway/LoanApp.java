package ru.orbot90.patterns.templatemethod.newway;

import ru.orbot90.patterns.templatemethod.ApplicationDenied;

/**
 * Created by orbot on 13.06.16.
 */
public class LoanApp {

    public static void main(String[] args) {
        LoanApplication loanApplication = new CompanyLoanApplication(new SharashMontazh());
        System.out.println("====== New loan application for employee of Sharash Montazh ========");
        try {
            loanApplication.checkLoanApplication();
            System.out.println("====== Application approved ========");
        } catch (ApplicationDenied applicationDenied) {
            System.out.println("====== Application denied ======");
        }
    }
}
