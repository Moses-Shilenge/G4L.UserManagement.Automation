import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.paulhammant.ngwebdriver.NgWebDriver;

import models.Roles;
import models.Streams;
import models.User;
import useCases.UserManagementPage;

public class App {

    public static void main(String[] args) {

        // Assert
        String superAdmin = "super.admin@gmail.com";
        String admin = "admin@gmail.com";
        String trainer = "trainer@gmail.com";
        String trainee = "trainee@gmail.com";

        String password = "P@ssword1";

        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\User\\Desktop\\java-tut-part-1\\automation\\automation\\src\\resources\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        JavascriptExecutor jsDriver = (JavascriptExecutor) driver;
        NgWebDriver ngDriver = new NgWebDriver(jsDriver);
        ngDriver.waitForAngularRequestsToFinish();

        driver.get("https://g4l-sit.netlify.app/");

        // Maximizing the website window
        driver.manage().window().maximize();

        // Learner Login
        // Navigate to the email

        driver.findElement(By.id("inputEmail4")).clear();
        driver.findElement(By.id("inputEmail4")).sendKeys(superAdmin);

        // Navigate to the password
        driver.findElement(By.id("inputPassword4")).clear();
        driver.findElement(By.id("inputPassword4")).sendKeys(password);

        // Clicking on the sign in button
        driver.findElement(By.xpath("/html/body/app-root/app-login/div/form/button")).click();
        // }

        // Defining the user
        User user = new User("Moses", "Automation", Roles.Learner.ordinal(), "9303260944086", "moe@automation.com",
                "0821112223", Streams.Java_Full_Stack_Developer.ordinal(), "ABSA",
                "0020221001");

        // Call the class and pass the dependency for it
        UserManagementPage userManagement = new UserManagementPage(driver, ngDriver);

        // Call the method to add the new user
        userManagement.Add(user);

        userManagement.Update(user);
    }

    // Clicking the LMS button
    // driver.findElement(By.cssSelector("ul > li:nth-child(5)")).click();
    // driver.findElement(By.className("cursor-pointer")).click();
    // driver.findElement(ByAngular.model("Profile")).click();

}
