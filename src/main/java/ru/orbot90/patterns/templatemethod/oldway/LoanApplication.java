package ru.orbot90.patterns.templatemethod.oldway;

import ru.orbot90.patterns.templatemethod.ApplicationDenied;

/**
 * Created by orbot on 13.06.16.
 */
public abstract class LoanApplication {

    public void checkLoanApplication() throws ApplicationDenied {
        checkIdentity();
        checkCreditHistory();
        checkIncomeHistory();
        reportFindings();
    }

    protected abstract void checkIdentity() throws ApplicationDenied;
    protected abstract void checkIncomeHistory() throws ApplicationDenied;
    protected abstract void checkCreditHistory() throws ApplicationDenied;
    protected abstract void reportFindings();
}
