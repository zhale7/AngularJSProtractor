import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestScripts {
    WebDriver driver;
    WebDriverWait wait;
    String driverPath = "C:\\Users\\Jala\\Downloads\\geckodriver-v0.33.0-win64/geckodriver.exe";
    String baseUrl = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login";

    @BeforeTest
    public void setUp() {
        System.out.println("Setup Process...");
        // System.setProperty("webdriver.gecko.driver", driverPath);
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @Test(priority = 1)
    public void checkLogin() {
        WebElement customerLoginBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[ng-click='customer()']")));
        customerLoginBtn.click();
        WebElement dropdownElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#userSelect")));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText("Albus Dumbledore");
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
        loginBtn.click();
    }

    @Test(priority = 2)
    public void checkDepositMoney() {
        WebElement customerLoginBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[ng-click='customer()']")));
        customerLoginBtn.click();
        WebElement dropdownElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#userSelect")));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText("Albus Dumbledore");
        WebElement loginBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body>div>div>div.ng-scope>div>form>button")));
        loginBtn.click();
        WebElement depositBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div > div > div.ng-scope > div > div:nth-child(5) > button:nth-child(2)")));
        depositBtn.click();
        WebElement amountInputDeposit = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body > div > div > div.ng-scope > div > div.container-fluid.mainBox.ng-scope > div > form > div > input")));
        amountInputDeposit.sendKeys("100");
        WebElement depositBtn2 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div > div > div.ng-scope > div > div.container-fluid.mainBox.ng-scope > div > form > button")));
        depositBtn2.click();
        String successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".error.ng-binding"))).getText();
        Assert.assertEquals(successMessage, "Deposit Successful", "Unsuccessful deposit");
    }

    @Test(priority = 3)
    public void checkWithdrawMoney() {
        WebElement customerLoginBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[ng-click='customer()']")));
        customerLoginBtn.click();
        WebElement dropdownElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#userSelect")));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText("Albus Dumbledore");
        WebElement loginBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body>div>div>div.ng-scope>div>form>button")));
        loginBtn.click();
        WebElement withdrawalBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn.btn-lg.tab[ng-class='btnClass3']")));
        withdrawalBtn.click();
        WebElement amountInputWithdraw = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body > div > div > div.ng-scope > div > div.container-fluid.mainBox.ng-scope > div > form > div > input")));
        amountInputWithdraw.sendKeys("50");
        WebElement withdrawalBtn2 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div > div > div.ng-scope > div > div.container-fluid.mainBox.ng-scope > div > form > button")));
        withdrawalBtn2.click();
        String successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".error.ng-binding"))).getText();
        Assert.assertEquals(successMessage, "Transaction Failed. You can not withdraw amount more than the balance.", "Unsuccessful transaction");
    }

    @Test(priority = 4)
    public void checkButtonText() {
        WebElement customerLoginBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[ng-click='customer()']")));
        customerLoginBtn.click();
        WebElement dropdownElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#userSelect")));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText("Albus Dumbledore");
        WebElement loginBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body>div>div>div.ng-scope>div>form>button")));
        loginBtn.click();
        WebElement withdrawBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".btn.btn-lg.tab[ng-class='btnClass3']")));
        String buttonText = withdrawBtn.getText();
        Assert.assertEquals(buttonText, "Withdrawal", "Button text is written wrongly");
    }

    @Test(priority = 5)
    public void checkDifferentAccountNumbers() {
        WebElement customerLoginBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[ng-click='customer()']")));
        customerLoginBtn.click();
        WebElement dropdownElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#userSelect")));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText("Albus Dumbledore");
        WebElement loginBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body>div>div>div.ng-scope>div>form>button")));
        loginBtn.click();
        WebElement dropdownElementAccounts = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#accountSelect")));
        Select dropdownAccounts = new Select(dropdownElementAccounts);
        dropdownAccounts.selectByVisibleText("1011");
        WebElement currencyText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div > div > div.ng-scope > div > div:nth-child(3) > strong:nth-child(3)")));
        Assert.assertTrue(currencyText.isDisplayed());
    }

    @Test(priority = 6)
    public void checkLogout() {
        WebElement customerLoginBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[ng-click='customer()']")));
        customerLoginBtn.click();
        WebElement dropdownElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#userSelect")));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText("Albus Dumbledore");
        WebElement loginBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body>div>div>div.ng-scope>div>form>button")));
        loginBtn.click();
        WebElement logoutBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div > div > div.box.mainhdr > button.btn.logout")));
        logoutBtn.click();
        String actualPageUrl = driver.getCurrentUrl();
        String expectedPageUrl = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/customer";
        Assert.assertEquals(actualPageUrl, expectedPageUrl, "Unsuccessful logout");
    }

    @Test(priority = 7)
    public void checkAccessAfterLogout() {
        WebElement customerLoginBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[ng-click='customer()']")));
        customerLoginBtn.click();
        WebElement dropdownElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#userSelect")));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText("Albus Dumbledore");
        WebElement loginBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body>div>div>div.ng-scope>div>form>button")));
        loginBtn.click();
        WebElement logoutBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div > div > div.box.mainhdr > button.btn.logout")));
        logoutBtn.click();
        driver.navigate().back();
        driver.navigate().forward();
    }

    @Test(priority = 8)
    public void checkAddCustomer() {
        WebElement bankManagerLoginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div > div > div.ng-scope > div > div.borderM.box.padT20 > div:nth-child(3) > button")));
        bankManagerLoginBtn.click();
        WebElement addCustomerBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div > div > div.ng-scope > div > div.center > button:nth-child(1)")));
        addCustomerBtn.click();
        WebElement firstNameInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body > div > div > div.ng-scope > div > div.ng-scope > div > div > form > div:nth-child(1) > input")));
        firstNameInput.sendKeys("Leila");
        WebElement lastNameInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body > div > div > div.ng-scope > div > div.ng-scope > div > div > form > div:nth-child(2) > input")));
        lastNameInput.sendKeys("Aliyeva");
        WebElement postCodeInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body > div > div > div.ng-scope > div > div.ng-scope > div > div > form > div:nth-child(3) > input")));
        postCodeInput.sendKeys("250");
        WebElement addCustomerBtn2 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div > div > div.ng-scope > div > div.ng-scope > div > div > form > button")));
        addCustomerBtn2.click();
        driver.switchTo().alert().accept();
    }

    @Test(priority = 9)
    public void checkOpenAccount() {
        WebElement bankManagerLoginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div > div > div.ng-scope > div > div.borderM.box.padT20 > div:nth-child(3) > button")));
        bankManagerLoginBtn.click();
        WebElement openAccountBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn.btn-lg.tab[ng-class='btnClass2']")));
        openAccountBtn.click();
        WebElement dropdownAccounts = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#userSelect")));
        Select dropdown = new Select(dropdownAccounts);
        dropdown.selectByVisibleText("Albus Dumbledore");
        WebElement dropdownCurrency = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#currency")));
        Select dropdown2 = new Select(dropdownCurrency);
        dropdown2.selectByVisibleText("Rupee");
        WebElement processBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
        processBtn.click();
        driver.switchTo().alert().accept();
    }

    @Test(priority = 10)
    public void checkSearchCustomer() {
        WebElement bankManagerLoginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div > div > div.ng-scope > div > div.borderM.box.padT20 > div:nth-child(3) > button")));
        bankManagerLoginBtn.click();
        WebElement customersBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div > div > div.ng-scope > div > div.center > button:nth-child(3)")));
        customersBtn.click();
        WebElement searchCustomerInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[placeholder='Search Customer']")));
        searchCustomerInput.sendKeys("Albus");
    }

    @Test(priority = 11)
    public void checkDeleteCustomer() {
        WebElement bankManagerLoginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div > div > div.ng-scope > div > div.borderM.box.padT20 > div:nth-child(3) > button")));
        bankManagerLoginBtn.click();
        WebElement customersBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div > div > div.ng-scope > div > div.center > button:nth-child(3)")));
        customersBtn.click();
        WebElement deleteBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("tbody tr:nth-child(1) td:nth-child(5) button:nth-child(1)")));
        deleteBtn.click();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
