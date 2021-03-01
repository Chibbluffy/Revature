package dev.wan.entities;

public class Expense {
    double amount;
    String reason;
    String status;
    int dateSubmitted;
    int dateProcessed;
    String approvedByUser;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getDateSubmitted() {
        return dateSubmitted;
    }

    public void setDateSubmitted(int dateSubmitted) {
        this.dateSubmitted = dateSubmitted;
    }

    public int getDateProcessed() {
        return dateProcessed;
    }

    public void setDateProcessed(int dateProcessed) {
        this.dateProcessed = dateProcessed;
    }

    public String getApprovedByUser() {
        return approvedByUser;
    }

    public void setApprovedByUser(String approvedByUser) {
        this.approvedByUser = approvedByUser;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "amount=" + amount +
                ", reason='" + reason + '\'' +
                ", status='" + status + '\'' +
                ", dateSubmitted=" + dateSubmitted +
                ", dateProcessed=" + dateProcessed +
                ", approvedByUser='" + approvedByUser + '\'' +
                '}';
    }
}
