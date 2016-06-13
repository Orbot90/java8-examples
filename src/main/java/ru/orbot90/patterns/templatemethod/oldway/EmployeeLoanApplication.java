package ru.orbot90.patterns.templatemethod.oldway;

import ru.orbot90.patterns.templatemethod.ApplicationDenied;

/**
 * Created by orbot on 13.06.16.
 */
public class EmployeeLoanApplication extends PersonalLoanApplication {
    @Override
    protected void checkIncomeHistory() throws ApplicationDenied {
        // No need for check
    }
}
