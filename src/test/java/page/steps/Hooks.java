package page.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Hooks {
    public static WebDriver driver;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    @After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {
            try {
                String screenshotName = scenario.getName()
                        .replaceAll("[^a-zA-Z0-9]", "_");

                System.out.println("Failed Scenario: " + screenshotName);

                TakesScreenshot ts = (TakesScreenshot) driver;

                // 1. Save to file
                File source = ts.getScreenshotAs(OutputType.FILE);

                String destinationPath = System.getProperty("user.dir")
                        + "/Screenshots/" + screenshotName + ".png";

                Files.createDirectories(Paths.get(System.getProperty("user.dir") + "/Screenshots"));

                Files.copy(source.toPath(), Paths.get(destinationPath));

                // 2. Attach to report
                byte[] screenshotBytes = ts.getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshotBytes, "image/png", screenshotName);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (driver != null) {
            driver.quit();
        }
    }
}