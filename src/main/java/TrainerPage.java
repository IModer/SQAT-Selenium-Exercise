import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

class TrainerPage extends PageBase {

    public TrainerPage(int i, WebDriver driver) {
        super(driver);
        navigate("https://liftzone.hu/?o=edzok&eid=" + i);
    }
    
    // Trainer name
    public WebElement getTrainerName() {
        return this.waitAndReturnElement(By.xpath("//h1[contains(@class, 'trainer-name')]"));
    }
    
    // Trainer bio
    public WebElement getTrainerBio() {
        return this.waitAndReturnElement(By.xpath("//div[contains(@class, 'trainer-bio')]"));
    }
    
    // Trainer schedule
    public WebElement getTrainerSchedule() {
        return this.waitAndReturnElement(By.xpath("//div[contains(@class, 'trainer-schedule')]"));
    }
    
    // Book a session button
    public WebElement getBookSessionButton() {
        return this.waitAndReturnElement(By.xpath("//button[contains(@class, 'book-session')]"));
    }
    
    // Contact trainer button
    public WebElement getContactTrainerButton() {
        return this.waitAndReturnElement(By.xpath("//button[contains(@class, 'contact-trainer')]"));
    }

    public WebElement getTrainerNameField() {
        return this.waitAndReturnElement(By.xpath("//input[contains(@name,'mentes_nev')]"));
    }

    // Feedback TextArea
    public WebElement getTrainerFeedbackTextArea() {
        return this.waitAndReturnElement(By.xpath("//textarea[contains(@id,'komment')]"));
    }

    // Feedback Send Button for text area
    public WebElement getTrainerFeedbackSendButton() {
        return this.waitAndReturnElement(By.xpath("//button[contains(@id,'elkuld')]"));
    }

    // Get the ith Star
    public WebElement getTrainerStarRating(int i) {
        return this.waitAndReturnElement(By.xpath("(//form[contains(@id,'rating')]//div[contains(@class,'stars')])//span[" + i + "]"));
    }

    // Get the Star Submit button
    public WebElement getTrainerRatingSubmitButton(int i) {
        return this.waitAndReturnElement(By.xpath("//form[contains(@id,'rating')]//button"));
    }

}
