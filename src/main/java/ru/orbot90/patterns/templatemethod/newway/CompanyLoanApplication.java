package ru.orbot90.patterns.templatemethod.newway;

/**
 * Created by orbot on 13.06.16.
 */
public class CompanyLoanApplication extends LoanApplication {
    public CompanyLoanApplication(Company company) {
        super(company::checkIdentity,
                company::checkHistoricalDebt,
                company::checkProfitAndLoss);
    }
}
