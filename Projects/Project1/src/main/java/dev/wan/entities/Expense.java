package dev.wan.entities;


import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "Expense")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="expense_id")
    int expenseId;

    @Column(name="amount")
    double amount;

    @Column(name="reason")
    String reason;

    @Column(name="employee_id")
    @JoinColumn(name="employee_id")
    int employeeId;

    @Column(name="expense_status")
    String expenseStatus;

    @Column(name="submitted_date")
    int submittedDate;

    @Column(name="processed_date")
    int processedDate;

    @Column(name="processed_reason")
    String processedReason;

    @Column(name="processed_manager_id")
    @JoinColumn(name="processed_manager_id")
    Integer processedManagerId;

    public Expense() {
    }

    public Expense(int expenseId, double amount, String reason, int employeeId, String expenseStatus, int submittedDate, int processedDate, String processedReason, Integer processedManagerId) {
        this.expenseId = expenseId;
        this.amount = amount;
        this.reason = reason;
        this.employeeId = employeeId;
        this.expenseStatus = expenseStatus;
        this.submittedDate = submittedDate;
        this.processedDate = processedDate;
        this.processedReason = processedReason;
        this.processedManagerId = processedManagerId;
    }

    public int getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(int expenseId) {
        this.expenseId = expenseId;
    }

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

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getExpenseStatus() {
        return expenseStatus;
    }

    public void setStatus(String status) {
        this.expenseStatus = status;
    }

    public int getSubmittedDate() {
        return submittedDate;
    }

    public void setSubmittedDate(int submittedDate) {
        this.submittedDate = submittedDate;
    }

    public int getProcessedDate() {
        return processedDate;
    }

    public void setProcessedDate(int processedDate) {
        this.processedDate = processedDate;
    }

    public String getProcessedReason() {
        return processedReason;
    }

    public void setProcessedReason(String processedReason) {
        this.processedReason = processedReason;
    }

    public Integer getProcessedManagerId() {
        return processedManagerId;
    }

    public void setProcessedManagerId(Integer processedManagerId) {
        this.processedManagerId = processedManagerId;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "expenseId=" + expenseId +
                ", amount=" + amount +
                ", reason='" + reason + '\'' +
                ", employeeId=" + employeeId +
                ", status='" + expenseStatus + '\'' +
                ", submittedDate=" + submittedDate +
                ", processedDate=" + processedDate +
                ", processedReason='" + processedReason + '\'' +
                ", processedManagerId=" + processedManagerId +
                '}';
    }
}
