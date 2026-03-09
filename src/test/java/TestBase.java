
import com.codeborne.selenide.Configuration;

import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    @BeforeAll
    static void setupSelenideConfig() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl= "https://demoqa.com";
        Configuration.timeout = 5000; // default 4000
    }
}