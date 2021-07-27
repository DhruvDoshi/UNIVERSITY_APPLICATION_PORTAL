package com.dal.universityPortal.model;

public class Dashboard {

    private int userId;
    private int successful_Application;
    private int in_progress_Application;
    private int rejected_Application;
    private int total_Payment;

    public Dashboard(){}

    public Dashboard(int userId, int successful_Application, int in_progress_Application, int rejected_Application, int total_Payment) {
        this.userId = userId;
        this.successful_Application = successful_Application;
        this.in_progress_Application = in_progress_Application;
        this.rejected_Application =rejected_Application;
        this.total_Payment = total_Payment;
    }

    public int getUserId() {
        return userId;
    }

    public int getSuccessful_Application() {
        return successful_Application;
    }

    public int getIn_progress_Application() {
        return in_progress_Application;
    }

    public int getRejected_Application() {
        return rejected_Application;
    }

    public int getTotal_Payment() {
        return total_Payment;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setSuccessful_Application(int successful_Application) {
        this.successful_Application = successful_Application;
    }

    public void setIn_progress_Application(int in_progress_Application) {
        this.in_progress_Application = in_progress_Application;
    }

    public void setRejected_Application(int rejected_Application) {
        this.rejected_Application = rejected_Application;
    }

    public void setTotal_Payment(int total_Payment) {
        this.total_Payment = total_Payment;
    }
}
