import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomeGooglePage {

    public WebDriver driver; // �������������� �������

    public HomeGooglePage(WebDriver driver) { // ������� ����������� �������� � �������� � ���� ���-�������
        this.driver = driver;
    }

//    ��������� �������� ��������:

    private By searchField = By.xpath("//input[@name='q']");
    private By signInButton = By.xpath("//a[text()='�����']");
    private By images = By.xpath("//a[text()='��������']");
    private By settings = By.xpath("//g-header-menu[@id='ab_options']/a[contains(text(), '���������')]");
    private By searchOptions = By.xpath("//a[text()='����������� �����']");
    private By imageSize = By.xpath("//div[@id='imgsz_button']");
    private By bigImageSize = By.xpath("//div[text()='�������']");
    private By findImages = By.xpath("//input[@value='�����']");
    private By bigImageFilter = By.xpath("//div[text()='�������']");
    private By linkIviInImages = By.xpath("//span[text()='ivi.ru']");
    private By previousPageButton = By.xpath("//span[text()='����������']");
    private By googlePlayLink = By.xpath("//cite[contains(text(), 'https://play.google.com')]");
    private By page5SearchResult = By.xpath("//a[@aria-label='Page 5']");
    private By appRaitingSearch = By.xpath("//div[contains(text(), '�������')]");
    private By wikiLink = By.xpath("//cite[contains(text(), 'https://ru.wikipedia.org')]");


//    ������ �� ������ � ���-����������:

    public void click(By locator) { // ����� ����� �� ����� �� �������
        driver.findElement(locator).click();
    }

    public HomeGooglePage enterText(String testText) { // ������ ����� � ���� � ���� Enter
        driver.findElement(searchField).sendKeys(testText);
        driver.findElement(searchField).sendKeys(Keys.ENTER);
        return this;
    }

    public HomeGooglePage clickImages() { // ��������� � ��������
        click(images);
        return this;
    }

    public HomeGooglePage clickSettings() { // ��������� � ���������
        click(settings);
        return this;
    }

    public HomeGooglePage clickSearchOptions() { // ��������� � ��������� ������ ��������
        click(searchOptions);
        return this;
    }

    public HomeGooglePage clickImageSize() { // ��������� � ����� �������
        click(imageSize);
        return this;
    }

    public HomeGooglePage clickBigImageSize() { // �������� �������� �������� �������
        click(bigImageSize);
        return this;
    }

    public HomeGooglePage clickFindImages() { // ��������� ���������
        driver.findElement(findImages).click();
        return this;
    }

// ����� ����� �� �������� � �������� � ���������� �������� ������ �� �������. ��� �������� ������ � ������:

    public HomeGooglePage findImagesWithBigSize() {
        clickImages();
        clickSettings();
        clickSearchOptions();
        clickImageSize();
        clickBigImageSize();
        clickFindImages();
        return this;
    }

    public HomeGooglePage clickPage5SearchResult() { // ���� �� 5 �������� ����������� ������ ��� ����� ������� ��� �����
        driver.findElement(page5SearchResult).click();
        return this;
    }

    public HomeGooglePage clickPreviousPageButton() { // ������� �� ���������� �������� ������
        driver.findElement(previousPageButton).click();
        return this;
    }

//    ������ �� ��������� �� ������ ��������:

    public GooglePlayPage clickGooglePlayLink() {
        click(googlePlayLink);
        return new GooglePlayPage(driver);
    }

    public WikipediaPage clickWikiLink() {
        click(wikiLink);
        return new WikipediaPage(driver);
    }


//    ��������� ����� �� ���������:

    public String getTextSignIn() { // ��� ��������, ��������������� �� ������������
        return driver.findElement(signInButton).getText();
    }

    public String getTextBigImageFilter() { // ��� �������� ������������ ������� � ����������� ������
        return driver.findElement(bigImageFilter).getText();
    }

    public String getTextWithRaiting() { // ��������� ����� �� ��������, ����������� ���� � ��������
        return driver.findElement(appRaitingSearch).getText();
    }

// ����� �� ���������� ������ �� ������ ��������� ���� String. ����� ��� �������� ���������:

    public String splitTextRaitingSearch() {
        String str = getTextWithRaiting();
        String[] subStr;
        String delimeter = " "; // ����������� ���� - ������
        subStr = str.split(delimeter); // ���������� ������ str � ������� ������ split()
        String st = (subStr[1]); // ����� ������ ������� ������� (����� � ���������)
        return st;
    }


//  ���� �������� �� �������� � �������� �� ����������:

    public int getLinkIviRuSize() { // ���������� ������ �� ��. ���� ivi
        return driver.findElements(linkIviInImages).size();
    }

    public int getGooglePlayLinkSize() { // ���������� ������ �� ���������� ivi � Google Play
        return driver.findElements(googlePlayLink).size();
    }

    public int getWikiLinkSize() { // ���������� ������ �� ivi � ���������
        return driver.findElements(googlePlayLink).size();
    }


}
