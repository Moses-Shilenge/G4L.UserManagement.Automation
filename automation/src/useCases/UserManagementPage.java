package useCases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.paulhammant.ngwebdriver.NgWebDriver;

import models.Roles;
import models.User;

public class UserManagementPage {
    private WebDriver driver;
    private NgWebDriver ngDriver;

    public UserManagementPage(WebDriver driver, NgWebDriver ngDriver) {
        this.driver = driver;
        this.ngDriver = ngDriver;
    }

    public void Add(User user) {

        try {

            Thread.sleep(5 * 1000);

            // Click the add new user button
            ngDriver.waitForAngularRequestsToFinish();

            // Got to the user management view
            driver.findElement(By.xpath(
                    "/html/body/app-root/app-master-layout/app-side-nav/aside/div[2]/ul/li[2]/a"))
                    .click();

            ngDriver.waitForAngularRequestsToFinish();

            driver.findElement(By.xpath(
                    "/html/body/app-root/app-master-layout/app-content-area/main/app-usermanagement/div/div[1]/div[2]/a"))
                    .click();

            // Update user information
            // First Name
            driver.findElement(By.id("input-first-name")).clear();
            driver.findElement(By.id("input-first-name")).sendKeys(user.getName());

            // Last name
            driver.findElement(By.id("input-last-name")).clear();
            driver.findElement(By.id("input-last-name")).sendKeys(user.getSurname());

            // ID Number
            driver.findElement(By.id("input-name")).clear();
            driver.findElement(By.id("input-name")).sendKeys(user.getIdNumber());

            // Role
            Select role = new Select(driver.findElement(By.id("input-role")));
            role.selectByIndex(user.getRole());

            // Contact Information
            // Email address
            driver.findElement(By.id("input-email")).clear();
            driver.findElement(By.id("input-email")).sendKeys(user.getEmail());

            // Phone number
            driver.findElement(By.id("input-phone")).clear();
            driver.findElement(By.id("input-phone")).sendKeys(user.getPhone());

            if (user.getRole() != Roles.Admin.ordinal() && user.getRole() != Roles.SuperAdmin.ordinal()) {

                // Learnership Information
                // Stream / Career
                Select stream = new Select(driver.findElement(By.id("input-career")));
                stream.selectByIndex(user.getStream());

                // Client
                driver.findElement(By.id("input-client")).clear();
                driver.findElement(By.id("input-client")).sendKeys(user.getClient());

                // Learnership Start Date
                WebElement calendar = driver.findElement(By.id("input-learnershipStartDate"));
                calendar.sendKeys(user.getLearnershipStartDate());
            }

            // Clicking on the Add user button
            driver.findElement(By.xpath(
                    "/html/body/div/div[2]/div/mdb-modal-container/div/div/app-enrol/div/div/div[2]/form/div[4]/div[2]/a"))
                    .click();

            ngDriver.waitForAngularRequestsToFinish();
            Thread.sleep(5 * 1000);

        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }

    public void Update(User user) {
    }
}
