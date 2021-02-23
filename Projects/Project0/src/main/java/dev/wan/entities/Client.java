package dev.wan.entities;

public class Client {
    int clientId;
    String firstName;
    String lastName;
    int birthYear;
    int numberOfAccounts;
    int creditScore;


    public Client() {
    }

    public Client(int clientId, String firstName, String lastName, int birthYear, int creditScore) {
        this.clientId = clientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.numberOfAccounts = 0;
        this.creditScore = creditScore;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int getNumberOfAccounts() {
        return numberOfAccounts;
    }

    public void setNumberOfAccounts(int numberOfAccounts) {
        this.numberOfAccounts = numberOfAccounts;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthYear=" + birthYear +
                ", numberOfAccounts=" + numberOfAccounts +
                ", creditScore=" + creditScore +
                '}';
    }
}
