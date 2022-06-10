package core.musala.careers;

import core.musala.careers.page.CareerPage;
import org.junit.Assert;

public class CareerStep {
    private CareerPage careerPage;

    public CareerStep() {
        careerPage = new CareerPage();
    }

    public void checkOpenPositions() {
        Assert.assertTrue(careerPage.clickOpenPositions());
    }

    public void choosePosition(String position) {
        Assert.assertTrue(careerPage.choosePosition(position));
    }
}
