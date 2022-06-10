package core.musala.company;

import core.musala.company.page.CompanyPage;
import org.junit.Assert;

public class CompanyStep {
    private CompanyPage companyPage;

    public CompanyStep() {
        companyPage = new CompanyPage();
    }

    public void verifyPage() {
        Assert.assertTrue(companyPage.verifyPage());
    }
}
