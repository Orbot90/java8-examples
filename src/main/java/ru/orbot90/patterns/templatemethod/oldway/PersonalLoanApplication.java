package ru.orbot90.patterns.templatemethod.oldway;

import ru.orbot90.patterns.templatemethod.ApplicationDenied;

/**
 * Created by orbot on 13.06.16.
 */
public class PersonalLoanApplication extends LoanApplication {
    @Override
    protected void checkIdentity() throws ApplicationDenied {
        System.out.println("Checking identity");
    }

    @Override
    protected void checkIncomeHistory() throws ApplicationDenied {
        System.out.println("Checking income history");
    }

    @Override
    protected void checkCreditHistory() throws ApplicationDenied {
        System.out.println("Checking credit history");
    }

    @Override
    protected void reportFindings() {
        System.out.println("Reporting");
    }
}
