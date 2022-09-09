package models;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.paulhammant.ngwebdriver.NgWebDriver;

public class User {

    private String name;
    private String surname;
    private int role;
    private String idNumber;
    private String email;
    private String phone;
    private int stream;
    private String client;
    private String learnershipStartDate;

    public User(String name, String surname, int role, String idNumber, String email, String phone,
            int stream, String client, String learnershipStartDate) {
        setName(name);
        setSurname(surname);
        setRole(role);
        setIdNumber(idNumber);
        setEmail(email);
        setPhone(phone);
        setStream(stream);
        setClient(client);
        setLearnershipStartDate(learnershipStartDate);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getStream() {
        return stream;
    }

    public void setStream(int stream) {
        this.stream = stream;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getLearnershipStartDate() {
        return learnershipStartDate;
    }

    public void setLearnershipStartDate(String learnershipStartDate) {
        this.learnershipStartDate = learnershipStartDate;
    }

}
