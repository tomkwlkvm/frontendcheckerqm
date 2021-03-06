package crisscrosscrass.Tests;

import com.jfoenix.controls.JFXCheckBox;
import crisscrosscrass.Tasks.ChangeCheckBox;
import crisscrosscrass.Tasks.Report;
import crisscrosscrass.Tasks.ScreenshotViaWebDriver;
import javafx.application.Platform;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class BecomeAPartnerPageTest {
    final static org.apache.log4j.Logger logger = Logger.getLogger(BecomeAPartnerPageTest.class);

    public void checkingRegisterButton(ChromeDriver webDriver, Report report, JavascriptExecutor js, JFXCheckBox RegisterButton, Text statusInfo, TextField inputBecomeAPartnerPageURL, Properties Homepage){
        final String infoMessage = "Checking Register Button";
        ChangeCheckBox.adjustStyle(false,"progress",RegisterButton);
        Platform.runLater(() -> {
            statusInfo.setText(""+infoMessage+"...");
        });
        try {
            ArrayList<String> tabs = new ArrayList<>(webDriver.getWindowHandles());
            webDriver.switchTo().window(tabs.get(0));
            try {
                webDriver.navigate().to(inputBecomeAPartnerPageURL.getText().trim());
                WebDriverWait wait = new WebDriverWait(webDriver, 10);
                try{
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Homepage.getProperty("partnerpage.shops.register.button"))));
                    webDriver.findElementByXPath(Homepage.getProperty("partnerpage.shops.register.button")).click();
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Homepage.getProperty("partnerpage.shops.becomePartner.close"))));
                    ChangeCheckBox.adjustStyle(true,"complete",RegisterButton);
                    report.writeToFile(infoMessage, "Functioning Pop Up appears!");
                }catch (Exception gridPageIssue){
                    ChangeCheckBox.adjustStyle(true,"nope",RegisterButton);
                    webDriver.navigate().to(inputBecomeAPartnerPageURL.getText().trim());
                    report.writeToFile(infoMessage, "Couldn't detect \"Register\" Button");
                    gridPageIssue.printStackTrace();
                }
            }catch (Exception noRequestedSiteFound){
                ChangeCheckBox.adjustStyle(true,"nope",RegisterButton);
                webDriver.navigate().to(inputBecomeAPartnerPageURL.getText().trim());
                report.writeToFile(infoMessage, "Couldn't navigate to requested Site!");
                noRequestedSiteFound.printStackTrace();
            }
        }catch (Exception noBrowserWorking){
            ChangeCheckBox.adjustStyle(true,"nope",RegisterButton);
            webDriver.navigate().to(inputBecomeAPartnerPageURL.getText().trim());
            report.writeToFile(infoMessage, "unable to check! Browser not responding");
            noBrowserWorking.printStackTrace();
        }

        report.writeToFile("=================================", "");

    }
    public void checkingBecomePartnerButton(ChromeDriver webDriver, Report report, JavascriptExecutor js, JFXCheckBox RegisterButton, Text statusInfo, TextField inputBecomeAPartnerPageURL, Properties Homepage){
        final String infoMessage = "Checking Become Partner Button";
        ChangeCheckBox.adjustStyle(false,"progress",RegisterButton);
        Platform.runLater(() -> {
            statusInfo.setText(""+infoMessage+"...");
        });
        try {
            ArrayList<String> tabs = new ArrayList<>(webDriver.getWindowHandles());
            webDriver.switchTo().window(tabs.get(0));
            try {
                webDriver.navigate().to(inputBecomeAPartnerPageURL.getText().trim());
                WebDriverWait wait = new WebDriverWait(webDriver, 10);
                try{
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Homepage.getProperty("partnerpage.shops.register.banner.button"))));
                    webDriver.findElementByXPath(Homepage.getProperty("partnerpage.shops.register.banner.button")).click();
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Homepage.getProperty("partnerpage.shops.becomePartner.close"))));
                    ChangeCheckBox.adjustStyle(true,"complete",RegisterButton);
                    report.writeToFile(infoMessage, "Functioning Pop Up appears!");
                }catch (Exception gridPageIssue){
                    ChangeCheckBox.adjustStyle(true,"nope",RegisterButton);
                    webDriver.navigate().to(inputBecomeAPartnerPageURL.getText().trim());
                    report.writeToFile(infoMessage, "Couldn't detect \"Register\" Button");
                    gridPageIssue.printStackTrace();
                }
            }catch (Exception noRequestedSiteFound){
                ChangeCheckBox.adjustStyle(true,"nope",RegisterButton);
                webDriver.navigate().to(inputBecomeAPartnerPageURL.getText().trim());
                report.writeToFile(infoMessage, "Couldn't navigate to requested Site!");
                noRequestedSiteFound.printStackTrace();
            }
        }catch (Exception noBrowserWorking){
            ChangeCheckBox.adjustStyle(true,"nope",RegisterButton);
            webDriver.navigate().to(inputBecomeAPartnerPageURL.getText().trim());
            report.writeToFile(infoMessage, "unable to check! Browser not responding");
            noBrowserWorking.printStackTrace();
        }

        report.writeToFile("=================================", "");

    }
    public void checkingGoToTopButton(ChromeDriver webDriver, Report report, JavascriptExecutor js, JFXCheckBox GoToTopButton, Text statusInfo, TextField inputBecomeAPartnerPageURL, Properties Homepage){
        final String infoMessage = "Checking Go to Top Button";
        ChangeCheckBox.adjustStyle(false,"progress",GoToTopButton);
        Platform.runLater(() -> {
            statusInfo.setText(""+infoMessage+"...");
        });
        try {
            ArrayList<String> tabs = new ArrayList<>(webDriver.getWindowHandles());
            webDriver.switchTo().window(tabs.get(0));
            try {
                webDriver.navigate().to(inputBecomeAPartnerPageURL.getText().trim());
                WebDriverWait wait = new WebDriverWait(webDriver, 10);
                try{
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Homepage.getProperty("page.main.footer.box"))));
                    Point hoverItem = webDriver.findElement(By.xpath(Homepage.getProperty("page.main.footer.box"))).getLocation();
                    ((JavascriptExecutor)webDriver).executeScript("return window.title;");
                    ((JavascriptExecutor)webDriver).executeScript("window.scrollBy(0,"+(hoverItem.getY())+");");
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Homepage.getProperty("page.main.totopbutton"))));
                    webDriver.findElementByXPath(Homepage.getProperty("page.main.totopbutton")).click();
                    for (int i = 0; i < 1; i++) {
                        Thread.sleep(300);
                        js.executeScript("window.scrollBy(0,100)");
                    }
                    for (int i = 0; i < 1; i++) {
                        Thread.sleep(300);
                        js.executeScript("window.scrollBy(0,-100)");
                    }
                    try {
                        WebElement h3Element = webDriver.findElementByXPath(Homepage.getProperty("partnerpage.info.h3"));
                        h3Element.click();
                        boolean isInViewPort = (boolean)((JavascriptExecutor)webDriver).executeScript(
                                "var elem = arguments[0],                 " +
                                        "  box = elem.getBoundingClientRect(),    " +
                                        "  cx = box.left + box.width / 2,         " +
                                        "  cy = box.top + box.height / 2,         " +
                                        "  e = document.elementFromPoint(cx, cy); " +
                                        "for (; e; e = e.parentElement) {         " +
                                        "  if (e === elem)                        " +
                                        "    return true;                         " +
                                        "}                                        " +
                                        "return false;                            "
                                , h3Element);
                        if (isInViewPort){
                            ChangeCheckBox.adjustStyle(true,"complete",GoToTopButton);
                            report.writeToFile("Go to Top- Help: ", "Initial banner (H3) is on user's view");
                        }else {
                            ChangeCheckBox.adjustStyle(true,"nope",GoToTopButton);
                            report.writeToFile("Go to Top- Help: ", "Initial banner (H3) is NOT on user's view");
                        }
                        webDriver.findElementByXPath(Homepage.getProperty("partnerpage.info.h3")).click();
                        ChangeCheckBox.adjustStyle(true,"complete",GoToTopButton);
                        report.writeToFile(infoMessage, "Successful, Initial banner (H3) is on user's view");
                    }catch (Exception noH3InViewPort){
                        ChangeCheckBox.adjustStyle(true,"nope",GoToTopButton);
                        report.writeToFile(infoMessage, "Not successful, Initial banner (H3) is NOT on user's view");
                        noH3InViewPort.printStackTrace();
                    }
                }catch (Exception gridPageIssue){
                    ChangeCheckBox.adjustStyle(true,"nope",GoToTopButton);
                    webDriver.navigate().to(inputBecomeAPartnerPageURL.getText().trim());
                    report.writeToFile(infoMessage, "Couldn't detect \"Register\" Button");
                    gridPageIssue.printStackTrace();
                }
            }catch (Exception noRequestedSiteFound){
                ChangeCheckBox.adjustStyle(true,"nope",GoToTopButton);
                webDriver.navigate().to(inputBecomeAPartnerPageURL.getText().trim());
                report.writeToFile(infoMessage, "Couldn't navigate to requested Site!");
                noRequestedSiteFound.printStackTrace();
            }
        }catch (Exception noBrowserWorking){
            ChangeCheckBox.adjustStyle(true,"nope",GoToTopButton);
            webDriver.navigate().to(inputBecomeAPartnerPageURL.getText().trim());
            report.writeToFile(infoMessage, "unable to check! Browser not responding");
            noBrowserWorking.printStackTrace();
        }

        report.writeToFile("=================================", "");

    }
    public void checkingCountryFlags(ChromeDriver webDriver, Report report, JavascriptExecutor js, JFXCheckBox CountryFlags, Text statusInfo, TextField inputBecomeAPartnerPageURL, Properties Homepage){
        final String infoMessage = "Checking Country Flags";
        ChangeCheckBox.adjustStyle(false,"progress",CountryFlags);
        Platform.runLater(() -> {
            statusInfo.setText(""+infoMessage+"...");
        });
        try {
            ArrayList<String> tabs = new ArrayList<>(webDriver.getWindowHandles());
            webDriver.switchTo().window(tabs.get(0));
            try {
                webDriver.navigate().to(inputBecomeAPartnerPageURL.getText().trim());
                WebDriverWait wait = new WebDriverWait(webDriver, 10);
                try{
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Homepage.getProperty("partnerpage.info.countryFlags"))));
                    Point hoverItem = webDriver.findElement(By.xpath(Homepage.getProperty("partnerpage.info.countryFlags"))).getLocation();
                    ((JavascriptExecutor)webDriver).executeScript("return window.title;");
                    ((JavascriptExecutor)webDriver).executeScript("window.scrollBy(0,"+(hoverItem.getY())+");");
                    List<WebElement> AllCountryFlags = webDriver.findElementsByXPath(Homepage.getProperty("partnerpage.info.countryFlags"));
                    List<WebElement> AllCountryNames = webDriver.findElementsByXPath(Homepage.getProperty("partnerpage.info.countryNames"));
                    ArrayList allCollectedLinks = new ArrayList();
                    ArrayList allCollectedNames = new ArrayList();
                    for (WebElement CountryFlagURL : AllCountryFlags){
                        allCollectedLinks.add(CountryFlagURL.getAttribute("href").trim().toLowerCase());
                    }
                    for (WebElement CountryNames : AllCountryNames){
                        allCollectedNames.add(CountryNames.getText().trim());
                    }
                    for (int i = 0 ; i < allCollectedLinks.size() ; i++){
                        ((JavascriptExecutor)webDriver).executeScript("window.open()");
                        tabs = new ArrayList<>(webDriver.getWindowHandles());
                        webDriver.switchTo().window(tabs.get(1)); //switches to new tab
                        webDriver.get(allCollectedLinks.get(i).toString());
                        if (webDriver.getCurrentUrl().trim().toLowerCase().equals(allCollectedLinks.get(i).toString())){
                            report.writeToFile("Country Flag Link from "+allCollectedNames.get(i).toString()+" is redirected to a functioning page  ",webDriver.getCurrentUrl().toLowerCase().trim());
                        }else {
                            report.writeToFile("Country Flag Link from "+allCollectedNames.get(i).toString()+" is redirected to a NOT functioning page  ",webDriver.getCurrentUrl().toLowerCase().trim());
                        }

                        webDriver.switchTo().window(tabs.get(1)).close();
                        webDriver.switchTo().window(tabs.get(0));
                    }
                    report.writeToFile("");
                    ChangeCheckBox.adjustStyle(true,"complete",CountryFlags);
                    webDriver.navigate().to(inputBecomeAPartnerPageURL.getText().trim());
                    report.writeToFile(infoMessage, "Complete");

                }catch (Exception gridPageIssue){
                    ChangeCheckBox.adjustStyle(true,"nope",CountryFlags);
                    webDriver.navigate().to(inputBecomeAPartnerPageURL.getText().trim());
                    report.writeToFile(infoMessage, "Couldn't detect \"Country Flags\"");
                    boolean isSuccessful = ScreenshotViaWebDriver.printScreen(webDriver, "CountryFlags.png");
                    if (isSuccessful){
                        report.writeToFile(infoMessage+" Screenshot: ", "Screenshot successful!");
                    }else {
                        report.writeToFile(infoMessage+" Screenshot: ", "Screenshot not successful!");
                    }
                    gridPageIssue.printStackTrace();
                }
            }catch (Exception noRequestedSiteFound){
                ChangeCheckBox.adjustStyle(true,"nope",CountryFlags);
                webDriver.navigate().to(inputBecomeAPartnerPageURL.getText().trim());
                report.writeToFile(infoMessage, "Couldn't navigate to requested Site!");
                noRequestedSiteFound.printStackTrace();
            }
        }catch (Exception noBrowserWorking){
            ChangeCheckBox.adjustStyle(true,"nope",CountryFlags);
            webDriver.navigate().to(inputBecomeAPartnerPageURL.getText().trim());
            report.writeToFile(infoMessage, "unable to check! Browser not responding");
            noBrowserWorking.printStackTrace();
        }

        report.writeToFile("=================================", "");

    }
    public void checkingLoginPartnerdashboard(ChromeDriver webDriver, Report report, JavascriptExecutor js, JFXCheckBox LoginPartnerdashboard, Text statusInfo, TextField inputBecomeAPartnerPageURL, Properties Homepage){
        final String infoMessage = "Checking Login Partnerdashboard";
        ChangeCheckBox.adjustStyle(false,"progress",LoginPartnerdashboard);
        Platform.runLater(() -> {
            statusInfo.setText(""+infoMessage+"...");
        });
        try {
            ArrayList<String> tabs = new ArrayList<>(webDriver.getWindowHandles());
            webDriver.switchTo().window(tabs.get(0));
            try {
                webDriver.navigate().to(inputBecomeAPartnerPageURL.getText().trim());
                WebDriverWait wait = new WebDriverWait(webDriver, 10);
                try{
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Homepage.getProperty("partnerpage.info.login.button"))));
                    Point hoverItem = webDriver.findElement(By.xpath(Homepage.getProperty("partnerpage.info.login.button"))).getLocation();
                    ((JavascriptExecutor)webDriver).executeScript("return window.title;");
                    ((JavascriptExecutor)webDriver).executeScript("window.scrollBy(0,"+(hoverItem.getY())+");");

                    webDriver.findElementByXPath(Homepage.getProperty("partnerpage.info.login.button")).click();
                    if (webDriver.getCurrentUrl().contains("login")){
                        report.writeToFile(infoMessage, "User is redirected to a Login page ");
                    }else {
                        report.writeToFile(infoMessage, "User is redirected to a functioning page but not with Login ");
                    }

                    try {
                        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Homepage.getProperty("partnerpage.dashboard.forgot.button"))));
                        webDriver.findElementByXPath(Homepage.getProperty("partnerpage.dashboard.forgot.button")).click();
                        if (webDriver.getCurrentUrl().contains("reset-password")){
                            report.writeToFile(infoMessage, "User is redirected to a reset-password page ");
                            ChangeCheckBox.adjustStyle(true,"complete",LoginPartnerdashboard);
                        }else {
                            report.writeToFile(infoMessage, "User is redirected to a functioning page but not with Reset Password ");
                            ChangeCheckBox.adjustStyle(true,"nope",LoginPartnerdashboard);
                        }
                        report.writeToFile(infoMessage, "Complete");
                    }catch (Exception noForgotPassword){
                        ChangeCheckBox.adjustStyle(true,"nope",LoginPartnerdashboard);
                        webDriver.navigate().to(inputBecomeAPartnerPageURL.getText().trim());
                        report.writeToFile(infoMessage, "Couldn't detect \"Forget Password\" Button");
                    }
                }catch (Exception gridPageIssue){
                    ChangeCheckBox.adjustStyle(true,"nope",LoginPartnerdashboard);
                    webDriver.navigate().to(inputBecomeAPartnerPageURL.getText().trim());
                    report.writeToFile(infoMessage, "Couldn't detect \"Login Button\"");
                    gridPageIssue.printStackTrace();
                }
            }catch (Exception noRequestedSiteFound){
                ChangeCheckBox.adjustStyle(true,"nope",LoginPartnerdashboard);
                webDriver.navigate().to(inputBecomeAPartnerPageURL.getText().trim());
                report.writeToFile(infoMessage, "Couldn't navigate to requested Site!");
                noRequestedSiteFound.printStackTrace();
            }
        }catch (Exception noBrowserWorking){
            ChangeCheckBox.adjustStyle(true,"nope",LoginPartnerdashboard);
            webDriver.navigate().to(inputBecomeAPartnerPageURL.getText().trim());
            report.writeToFile(infoMessage, "unable to check! Browser not responding");
            noBrowserWorking.printStackTrace();
        }

        report.writeToFile("=================================", "");

    }

    public void checkingTabHelpSection(ChromeDriver webDriver, Report report, JavascriptExecutor js, JFXCheckBox HelpRegisterTab, Text statusInfo, TextField inputBecomeAPartnerPageURL, Properties Homepage){
        final String infoMessage = "Checking Tab Help Section";
        ChangeCheckBox.adjustStyle(false,"progress",HelpRegisterTab);
        Platform.runLater(() -> {
            statusInfo.setText(""+infoMessage+"...");
        });
        try {
            ArrayList<String> tabs = new ArrayList<>(webDriver.getWindowHandles());
            webDriver.switchTo().window(tabs.get(0));
            try {
                webDriver.navigate().to(inputBecomeAPartnerPageURL.getText().trim());
                WebDriverWait wait = new WebDriverWait(webDriver, 10);
                try{
                    //click on Help Tab
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Homepage.getProperty("partnerpage.tab.help"))));
                    webDriver.findElementByXPath(Homepage.getProperty("partnerpage.tab.help")).click();
                    //check if correct page
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Homepage.getProperty("partnerpage.tab.help.content"))));
                    if (webDriver.findElementByXPath(Homepage.getProperty("partnerpage.tab.help.content")).isDisplayed()){
                        report.writeToFile("Help Tab: ", "Help Introduction is displayed");
                    }else{
                        report.writeToFile("Help Tab: ", "Help Introduction is NOT displayed");
                    }
                    try {
                        //check if register button
                        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Homepage.getProperty("partnerpage.shops.register.button"))));
                        //click on register button
                        webDriver.findElementByXPath(Homepage.getProperty("partnerpage.shops.register.button")).click();
                        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Homepage.getProperty("partnerpage.shops.becomePartner.close"))));
                        if (webDriver.findElementByXPath(Homepage.getProperty("partnerpage.shops.becomePartner.close")).isDisplayed()){
                            webDriver.findElementByXPath(Homepage.getProperty("partnerpage.shops.becomePartner.close")).click();
                            report.writeToFile("Register- Help: ", "Functioning Pop Up appears");
                        }else{
                            report.writeToFile("Register- Help: ", "Functioning Pop Up does NOT appear !");
                        }
                        try {
                            //check if become Partner button
                            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Homepage.getProperty("partnerpage.tab.help.becomePartner.button"))));
                            //click on become partner button
                            webDriver.findElementByXPath(Homepage.getProperty("partnerpage.tab.help.becomePartner.button")).click();
                            if (webDriver.findElementByXPath(Homepage.getProperty("partnerpage.shops.becomePartner.close")).isDisplayed()){
                                webDriver.findElementByXPath(Homepage.getProperty("partnerpage.shops.becomePartner.close")).click();
                                report.writeToFile("Become Partner Button- Help: ", "Functioning Pop Up appears");
                            }else{
                                report.writeToFile("Become Partner Button- Help: ", "Functioning Pop Up does NOT appear !");
                            }
                            try {
                                //scroll down to bottom
                                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Homepage.getProperty("page.main.footer.box"))));
                                Point hoverItem = webDriver.findElement(By.xpath(Homepage.getProperty("page.main.footer.box"))).getLocation();
                                ((JavascriptExecutor)webDriver).executeScript("return window.title;");
                                ((JavascriptExecutor)webDriver).executeScript("window.scrollBy(0,"+(hoverItem.getY())+");");
                                //click on GoToTop
                                wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Homepage.getProperty("page.main.totopbutton"))));
                                webDriver.findElementByXPath(Homepage.getProperty("page.main.totopbutton")).click();
                                //check if H3 is in viewport
                                WebElement h3Element = webDriver.findElementByXPath(Homepage.getProperty("partnerpage.help.h3"));
                                h3Element.click();
                                boolean isInViewPort = (boolean)((JavascriptExecutor)webDriver).executeScript(
                                        "var elem = arguments[0],                 " +
                                                "  box = elem.getBoundingClientRect(),    " +
                                                "  cx = box.left + box.width / 2,         " +
                                                "  cy = box.top + box.height / 2,         " +
                                                "  e = document.elementFromPoint(cx, cy); " +
                                                "for (; e; e = e.parentElement) {         " +
                                                "  if (e === elem)                        " +
                                                "    return true;                         " +
                                                "}                                        " +
                                                "return false;                            "
                                        , h3Element);
                                if (isInViewPort){
                                    ChangeCheckBox.adjustStyle(true,"complete",HelpRegisterTab);
                                    report.writeToFile("Go to Top- Help: ", "Initial banner (H3) is on user's view");
                                }else {
                                    ChangeCheckBox.adjustStyle(true,"nope",HelpRegisterTab);
                                    report.writeToFile("Go to Top- Help: ", "Initial banner (H3) is NOT on user's view");
                                }
                                report.writeToFile("");
                                report.writeToFile(infoMessage, "Complete!");
                            }catch (Exception noGoToTopButton){
                                ChangeCheckBox.adjustStyle(true,"nope",HelpRegisterTab);
                                webDriver.navigate().to(inputBecomeAPartnerPageURL.getText().trim());
                                report.writeToFile("Go to Top- Help", "Couldn't detect \"Go To Top\" Button");
                                noGoToTopButton.printStackTrace();
                            }
                        }catch (Exception noBecomePartnerButton){
                            ChangeCheckBox.adjustStyle(true,"nope",HelpRegisterTab);
                            webDriver.navigate().to(inputBecomeAPartnerPageURL.getText().trim());
                            report.writeToFile("Become Partner Button- Help", "Couldn't detect \"Become Partner\" Button");
                            noBecomePartnerButton.printStackTrace();
                        }
                    }catch (Exception noRegisterButton){
                        ChangeCheckBox.adjustStyle(true,"nope",HelpRegisterTab);
                        webDriver.navigate().to(inputBecomeAPartnerPageURL.getText().trim());
                        report.writeToFile("Register- Help", "Couldn't detect \"Register\" Button");
                        noRegisterButton.printStackTrace();
                    }
                }catch (Exception gridPageIssue){
                    ChangeCheckBox.adjustStyle(true,"nope",HelpRegisterTab);
                    webDriver.navigate().to(inputBecomeAPartnerPageURL.getText().trim());
                    report.writeToFile("Help Tab", "Couldn't detect Tab \"Help\"");
                    gridPageIssue.printStackTrace();
                }
            }catch (Exception noRequestedSiteFound){
                ChangeCheckBox.adjustStyle(true,"nope",HelpRegisterTab);
                webDriver.navigate().to(inputBecomeAPartnerPageURL.getText().trim());
                report.writeToFile(infoMessage, "Couldn't navigate to requested Site!");
                noRequestedSiteFound.printStackTrace();
            }
        }catch (Exception noBrowserWorking){
            ChangeCheckBox.adjustStyle(true,"nope",HelpRegisterTab);
            webDriver.navigate().to(inputBecomeAPartnerPageURL.getText().trim());
            report.writeToFile(infoMessage, "unable to check! Browser not responding");
            noBrowserWorking.printStackTrace();
        }
        report.writeToFile("=================================", "");
    }

    public void checkingDownloadOnHelp(ChromeDriver webDriver, Report report, JavascriptExecutor js, JFXCheckBox DownloadPDFHelp, Text statusInfo, TextField inputBecomeAPartnerPageURL, Properties Homepage){
        final String infoMessage = "Checking Tab Partner Section";
        ChangeCheckBox.adjustStyle(false,"progress",DownloadPDFHelp);
        Platform.runLater(() -> {
            statusInfo.setText(""+infoMessage+"...");
        });
        try {
            ArrayList<String> tabs = new ArrayList<>(webDriver.getWindowHandles());
            webDriver.switchTo().window(tabs.get(0));
            try {
                webDriver.navigate().to(inputBecomeAPartnerPageURL.getText().trim());
                WebDriverWait wait = new WebDriverWait(webDriver, 10);
                try{
                    //click on Help Tab
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Homepage.getProperty("partnerpage.tab.help"))));
                    webDriver.findElementByXPath(Homepage.getProperty("partnerpage.tab.help")).click();
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Homepage.getProperty("partnerpage.tab.help.content"))));
                    //scroll down to Download
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Homepage.getProperty("partnerpage.help.download.button"))));
                    Point hoverItem = webDriver.findElement(By.xpath(Homepage.getProperty("partnerpage.help.download.button"))).getLocation();
                    ((JavascriptExecutor)webDriver).executeScript("return window.title;");
                    ((JavascriptExecutor)webDriver).executeScript("window.scrollBy(0,"+(hoverItem.getY())+");");
                    //click download
                    webDriver.findElementByXPath(Homepage.getProperty("partnerpage.help.download.button")).click();
                    for (int i = 0; i < 5; i++) {
                        Thread.sleep(100);
                        js.executeScript("window.scrollBy(0,100)");
                    }
                    tabs = new ArrayList<>(webDriver.getWindowHandles());
                    webDriver.switchTo().window(tabs.get(1));
                    if(webDriver.getCurrentUrl().contains("pdf")){
                        report.writeToFile(infoMessage, "Functioning PDF appears");
                        ChangeCheckBox.adjustStyle(true,"complete",DownloadPDFHelp);
                    }else {
                        report.writeToFile(infoMessage, "No functioning PDF appears");
                        ChangeCheckBox.adjustStyle(true,"nope",DownloadPDFHelp);
                    }
                    webDriver.switchTo().window(tabs.get(1)).close();
                    webDriver.switchTo().window(tabs.get(0));
                }catch (Exception gridPageIssue){
                    ChangeCheckBox.adjustStyle(true,"nope",DownloadPDFHelp);
                    webDriver.navigate().to(inputBecomeAPartnerPageURL.getText().trim());
                    report.writeToFile(infoMessage, "Couldn't detect \"Download Help\" Button");
                    gridPageIssue.printStackTrace();
                }
            }catch (Exception noRequestedSiteFound){
                ChangeCheckBox.adjustStyle(true,"nope",DownloadPDFHelp);
                webDriver.navigate().to(inputBecomeAPartnerPageURL.getText().trim());
                report.writeToFile(infoMessage, "Couldn't navigate to requested Site!");
                noRequestedSiteFound.printStackTrace();
            }
        }catch (Exception noBrowserWorking){
            ChangeCheckBox.adjustStyle(true,"nope",DownloadPDFHelp);
            webDriver.navigate().to(inputBecomeAPartnerPageURL.getText().trim());
            report.writeToFile(infoMessage, "unable to check! Browser not responding");
            noBrowserWorking.printStackTrace();
        }
        report.writeToFile("=================================", "");
    }
    public void checkingTabPartnerSection(ChromeDriver webDriver, Report report, JavascriptExecutor js, JFXCheckBox PartnerTabSection, Text statusInfo, TextField inputBecomeAPartnerPageURL, Properties Homepage){
        final String infoMessage = "Checking Tab Partner Section";
        ChangeCheckBox.adjustStyle(false,"progress",PartnerTabSection);
        Platform.runLater(() -> {
            statusInfo.setText(""+infoMessage+"...");
        });
        try {
            ArrayList<String> tabs = new ArrayList<>(webDriver.getWindowHandles());
            webDriver.switchTo().window(tabs.get(0));
            try {
                webDriver.navigate().to(inputBecomeAPartnerPageURL.getText().trim());
                WebDriverWait wait = new WebDriverWait(webDriver, 10);
                try{
                    //click on Partner Tab
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Homepage.getProperty("partnerpage.tab.partner"))));
                    webDriver.findElementByXPath(Homepage.getProperty("partnerpage.tab.partner")).click();
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Homepage.getProperty("partnerpage.tab.partner.content"))));
                    if (webDriver.findElementByXPath(Homepage.getProperty("partnerpage.tab.partner.content")).isDisplayed()){
                        report.writeToFile("Partner Tab: ", "Partner Introduction is displayed");
                    }else{
                        report.writeToFile("Partner Tab: ", "Partner Introduction is NOT displayed");
                    }
                    try {
                        //check if register button
                        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Homepage.getProperty("partnerpage.shops.register.button"))));
                        //click on register button
                        webDriver.findElementByXPath(Homepage.getProperty("partnerpage.shops.register.button")).click();
                        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Homepage.getProperty("partnerpage.shops.becomePartner.close"))));
                        if (webDriver.findElementByXPath(Homepage.getProperty("partnerpage.shops.becomePartner.close")).isDisplayed()){
                            webDriver.findElementByXPath(Homepage.getProperty("partnerpage.shops.becomePartner.close")).click();
                            report.writeToFile("Register- Help: ", "Functioning Pop Up appears");
                        }else{
                            report.writeToFile("Register- Help: ", "Functioning Pop Up does NOT appear !");
                        }
                        try {
                            //check if become Partner button
                            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Homepage.getProperty("partnerpage.tab.partner.becomePartner.button"))));
                            //click on become partner button
                            webDriver.findElementByXPath(Homepage.getProperty("partnerpage.tab.partner.becomePartner.button")).click();
                            if (webDriver.findElementByXPath(Homepage.getProperty("partnerpage.shops.becomePartner.close")).isDisplayed()){
                                webDriver.findElementByXPath(Homepage.getProperty("partnerpage.shops.becomePartner.close")).click();
                                report.writeToFile("Become Partner Button- Help: ", "Functioning Pop Up appears");
                            }else{
                                report.writeToFile("Become Partner Button- Help: ", "Functioning Pop Up does NOT appear !");
                            }
                            try {
                                //scroll down to bottom
                                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Homepage.getProperty("page.main.footer.box"))));
                                Point hoverItem = webDriver.findElement(By.xpath(Homepage.getProperty("page.main.footer.box"))).getLocation();
                                ((JavascriptExecutor)webDriver).executeScript("return window.title;");
                                ((JavascriptExecutor)webDriver).executeScript("window.scrollBy(0,"+(hoverItem.getY())+");");
                                //click on GoToTop
                                wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Homepage.getProperty("page.main.totopbutton"))));
                                webDriver.findElementByXPath(Homepage.getProperty("page.main.totopbutton")).click();
                                //check if H3 is in viewport
                                WebElement h3Element = webDriver.findElementByXPath(Homepage.getProperty("partnerpage.partner.h3"));
                                for (int i = 0; i < 5; i++) {
                                    Thread.sleep(100);
                                    js.executeScript("window.scrollBy(0,100)");
                                }
                                for (int i = 0; i < 5; i++) {
                                    Thread.sleep(100);
                                    js.executeScript("window.scrollBy(0,-100)");
                                }
                                boolean isInViewPort = (boolean)((JavascriptExecutor)webDriver).executeScript(
                                        "var elem = arguments[0],                 " +
                                                "  box = elem.getBoundingClientRect(),    " +
                                                "  cx = box.left + box.width / 2,         " +
                                                "  cy = box.top + box.height / 2,         " +
                                                "  e = document.elementFromPoint(cx, cy); " +
                                                "for (; e; e = e.parentElement) {         " +
                                                "  if (e === elem)                        " +
                                                "    return true;                         " +
                                                "}                                        " +
                                                "return false;                            "
                                        , h3Element);
                                if (isInViewPort){
                                    ChangeCheckBox.adjustStyle(true,"complete",PartnerTabSection);
                                    report.writeToFile("Go to Top- Help: ", "Initial banner (H3) is on user's view");
                                }else {
                                    ChangeCheckBox.adjustStyle(true,"nope",PartnerTabSection);
                                    report.writeToFile("Go to Top- Help: ", "Initial banner (H3) is NOT on user's view");
                                }
                                report.writeToFile("");
                                report.writeToFile(infoMessage, "Complete!");
                            }catch (Exception noGoToTopButton){
                                ChangeCheckBox.adjustStyle(true,"nope",PartnerTabSection);
                                webDriver.navigate().to(inputBecomeAPartnerPageURL.getText().trim());
                                report.writeToFile("Go to Top- Help", "Couldn't detect \"Go To Top\" Button");
                                noGoToTopButton.printStackTrace();
                            }
                        }catch (Exception noBecomePartnerButton){
                            ChangeCheckBox.adjustStyle(true,"nope",PartnerTabSection);
                            webDriver.navigate().to(inputBecomeAPartnerPageURL.getText().trim());
                            report.writeToFile("Become Partner Button- Help", "Couldn't detect \"Become Partner\" Button");
                            noBecomePartnerButton.printStackTrace();
                        }
                    }catch (Exception noRegisterButton){
                        ChangeCheckBox.adjustStyle(true,"nope",PartnerTabSection);
                        webDriver.navigate().to(inputBecomeAPartnerPageURL.getText().trim());
                        report.writeToFile("Register- Help", "Couldn't detect \"Register\" Button");
                        noRegisterButton.printStackTrace();
                    }
                }catch (Exception gridPageIssue){
                    ChangeCheckBox.adjustStyle(true,"nope",PartnerTabSection);
                    webDriver.navigate().to(inputBecomeAPartnerPageURL.getText().trim());
                    report.writeToFile(infoMessage, "Couldn't detect Tab \"Partner\"");
                    gridPageIssue.printStackTrace();
                }
            }catch (Exception noRequestedSiteFound){
                ChangeCheckBox.adjustStyle(true,"nope",PartnerTabSection);
                webDriver.navigate().to(inputBecomeAPartnerPageURL.getText().trim());
                report.writeToFile(infoMessage, "Couldn't navigate to requested Site!");
                noRequestedSiteFound.printStackTrace();
            }
        }catch (Exception noBrowserWorking){
            ChangeCheckBox.adjustStyle(true,"nope",PartnerTabSection);
            webDriver.navigate().to(inputBecomeAPartnerPageURL.getText().trim());
            report.writeToFile(infoMessage, "unable to check! Browser not responding");
            noBrowserWorking.printStackTrace();
        }

        report.writeToFile("=================================", "");

    }
    public void checkingFeedProviders(ChromeDriver webDriver, Report report, JavascriptExecutor js, JFXCheckBox FeedProviders, Text statusInfo, TextField inputBecomeAPartnerPageURL, Properties Homepage){
        final String infoMessage = "Checking Feed Providers";
        ChangeCheckBox.adjustStyle(false,"progress",FeedProviders);
        Platform.runLater(() -> {
            statusInfo.setText(""+infoMessage+"...");
        });
        try {
            ArrayList<String> tabs = new ArrayList<>(webDriver.getWindowHandles());
            webDriver.switchTo().window(tabs.get(0));
            try {
                webDriver.navigate().to(inputBecomeAPartnerPageURL.getText().trim());
                WebDriverWait wait = new WebDriverWait(webDriver, 10);
                try{
                    //click on Partner Tab
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Homepage.getProperty("partnerpage.tab.partner"))));
                    webDriver.findElementByXPath(Homepage.getProperty("partnerpage.tab.partner")).click();
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Homepage.getProperty("partnerpage.tab.partner.content"))));

                    //get all Links for Feed Provider
                    List<WebElement> AllFeedProviderElements = webDriver.findElementsByXPath(Homepage.getProperty("partnerpage.tab.partner.feedproviders"));
                    ArrayList allCollectedProviderURLs = new ArrayList();
                    for (WebElement FeedProvider : AllFeedProviderElements){
                        allCollectedProviderURLs.add(FeedProvider.getAttribute("href").toLowerCase().trim());
                    }
                    report.writeToFile("Feed Provider Links:");
                    for (int i = 0 ; i < allCollectedProviderURLs.size() ; i++){
                        ((JavascriptExecutor)webDriver).executeScript("window.open()");
                        tabs = new ArrayList<>(webDriver.getWindowHandles());
                        webDriver.switchTo().window(tabs.get(1)); //switches to new tab
                        webDriver.get(allCollectedProviderURLs.get(i).toString());
                        if (webDriver.getCurrentUrl().toLowerCase().trim().equals(allCollectedProviderURLs.get(i).toString())){
                            report.writeToFile("Link for "+allCollectedProviderURLs.get(i).toString()+" is redirected to a correct page  ",webDriver.getCurrentUrl().toLowerCase().trim());
                        }else {
                            report.writeToFile("Link for "+allCollectedProviderURLs.get(i).toString()+" is redirected to a different page  ",webDriver.getCurrentUrl().toLowerCase().trim());
                        }
                        webDriver.switchTo().window(tabs.get(1)).close();
                        webDriver.switchTo().window(tabs.get(0));
                    }
                    report.writeToFile("");
                    report.writeToFile(infoMessage, "Complete");
                    ChangeCheckBox.adjustStyle(true,"complete",FeedProviders);
                }catch (Exception gridPageIssue){
                    ChangeCheckBox.adjustStyle(true,"nope",FeedProviders);
                    webDriver.navigate().to(inputBecomeAPartnerPageURL.getText().trim());
                    report.writeToFile(infoMessage, "Couldn't detect \"Feed Providers\"");
                    gridPageIssue.printStackTrace();
                }
            }catch (Exception noRequestedSiteFound){
                ChangeCheckBox.adjustStyle(true,"nope",FeedProviders);
                webDriver.navigate().to(inputBecomeAPartnerPageURL.getText().trim());
                report.writeToFile(infoMessage, "Couldn't navigate to requested Site!");
                noRequestedSiteFound.printStackTrace();
            }
        }catch (Exception noBrowserWorking){
            ChangeCheckBox.adjustStyle(true,"nope",FeedProviders);
            webDriver.navigate().to(inputBecomeAPartnerPageURL.getText().trim());
            report.writeToFile(infoMessage, "unable to check! Browser not responding");
            noBrowserWorking.printStackTrace();
        }

        report.writeToFile("=================================", "");

    }
}
