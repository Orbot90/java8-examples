package ru.orbot90.exampleapps;

import ru.orbot90.pojos.Address;
import ru.orbot90.pojos.Building;
import ru.orbot90.pojos.Company;
import ru.orbot90.pojos.Employee;
import ru.orbot90.pojos.Street;

import java.util.Objects;
import java.util.Optional;

public class OptionalApp {

    public static void main(String[] args) {

    }

    private static boolean companyExample() {
        return Optional.ofNullable(getCompany())
                .map(Company::getEmployees)
                .filter(list -> !list.isEmpty())
                .map(list -> list.get(0))
                .map(Employee::getAddress)
                .map(Address::getStreet)
                .map(Street::getBuilding)
                .map(Building::getNumber)
                .map(Objects::nonNull)
                .orElse(false);
    }

    private static Company getCompany() {
        return new Company();
    }
}