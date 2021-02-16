package company.fetchRewards;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class findFakeGoldBar {

    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://ec2-54-208-152-154.compute-1.amazonaws.com/");

        WebElement left1 = driver.findElement(By.id("left_0"));
        left1.sendKeys("0");
        driver.findElement(By.id("left_1")).sendKeys("1");
        driver.findElement(By.id("left_2")).sendKeys("2");

        WebElement right1 = driver.findElement(By.id("right_0"));
        right1.sendKeys("3");
        driver.findElement(By.id("right_1")).sendKeys("4");
        driver.findElement(By.id("right_2")).sendKeys("5");

        WebElement weigh = driver.findElement(By.id("weigh"));
        weigh.click();

        WebElement check = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/button[1]"));
        WebElement reset = driver.findElement(By.xpath("//button[text() = 'Reset']"));
        String result = check.getText();

        WebElement number8 = driver.findElement(By.id("coin_8"));
        WebElement number7 = driver.findElement(By.id("coin_7"));
        WebElement number6 = driver.findElement(By.id("coin_6"));
        WebElement number5 = driver.findElement(By.id("coin_5"));
        WebElement number4 = driver.findElement(By.id("coin_4"));
        WebElement number3 = driver.findElement(By.id("coin_3"));
        WebElement number2 = driver.findElement(By.id("coin_2"));
        WebElement number1 = driver.findElement(By.id("coin_1"));
        WebElement number0 = driver.findElement(By.id("coin_0"));

        switch (result){
            case "=":
                reset.click();
                left1.sendKeys("6");
                right1.sendKeys("7");
                weigh.click();
                result = check.getText();
                if (result.equals("=")){
                    number8.click();
                    System.out.println("Number 8 is fake!");
                }else if (result.equals("<")){
                    number6.click();
                    System.out.println("Number 6 is fake!");
                }else {
                    number7.click();
                    System.out.println("Number 7 is fake!");
                }break;
            case "<":
                reset.click();
                left1.sendKeys("0");
                right1.sendKeys("1");
                weigh.click();
                result = check.getText();
                if (result.equals("=")){
                    number2.click();
                    System.out.println("Number 2 is fake!");
                }else if (result.equals("<")){
                    number0.click();
                    System.out.println("Number 0 is fake!");
                }else {
                    number1.click();
                    System.out.println("Number 1 is fake!");
                }break;
            case ">":
                reset.click();
                left1.sendKeys("3");
                right1.sendKeys("4");
                weigh.click();
                result = check.getText();
                if (result.equals("=")){
                    number5.click();
                    System.out.println("Number 5 is fake!");
                }else if (result.equals("<")){
                    number3.click();
                    System.out.println("Number 3 is fake!");
                }else {
                    number4.click();
                    System.out.println("Number 4 is fake!");
                }break;
        }
    }
}
