package LearningBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class First {
    static void main() {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://alphabetaops.com/");
        driver.quit();
    }
}
