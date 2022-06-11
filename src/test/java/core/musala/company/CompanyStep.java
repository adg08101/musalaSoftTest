package core.musala.company;

import core.musala.company.page.CompanyPage;
import org.junit.Assert;

import java.awt.*;

public class CompanyStep {
    private CompanyPage companyPage;

    public CompanyStep() throws AWTException {
        companyPage = new CompanyPage();
    }

    public void verifyPage() {
        Assert.assertTrue(companyPage.verifyPage());
    }

    public void checkForSection(String section) {
        Assert.assertNotNull(companyPage.verifySection(section));
    }

    public void clickFacebookLink() {
        Assert.assertTrue(companyPage.clickFacebook());
    }
}
