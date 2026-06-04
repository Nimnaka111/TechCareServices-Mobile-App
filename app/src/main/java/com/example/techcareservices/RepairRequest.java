package com.example.techcareservices;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class RepairRequest {
    public String device, issue, date, time, status;

    public RepairRequest() {} // Mandatory for Firebase to work

    public RepairRequest(String device, String issue, String date, String time, String status) {
        this.device = device;
        this.issue = issue;
        this.date = date;
        this.time = time;
        this.status = status;
    }

    public String getDevice() { return device; }
    public String getIssue() { return issue; }
    public String getDate() { return date; }
    public String getTime() { return time; }
    public String getStatus() { return status; }
}