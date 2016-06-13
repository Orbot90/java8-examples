package ru.orbot90.patterns.templatemethod.newway;

import ru.orbot90.patterns.templatemethod.ApplicationDenied;

/**
 * Created by orbot on 13.06.16.
 */
public class SharashMontazh implements Company {
    @Override
    public void checkIdentity() throws ApplicationDenied {
        System.out.println("Sharash montazh checking identity");
    }

    @Override
    public void checkProfitAndLoss() throws ApplicationDenied {
        System.out.println("Sharash montazh checking income");
    }

    @Override
    public void checkHistoricalDebt() throws ApplicationDenied {
        System.out.println("Sharash montazh checking credit history");
    }
}
