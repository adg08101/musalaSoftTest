package core.musala.careers;

import core.musala.careers.page.CareerPage;
import org.junit.Assert;

import java.awt.*;

public class CareerStep {
    private CareerPage careerPage;

    public CareerStep() throws AWTException {
        careerPage = new CareerPage();
    }

    public void checkOpenPositions() {
        Assert.assertTrue(careerPage.clickOpenPositions());
    }

    public void choosePosition(String position) {
        Assert.assertTrue(careerPage.choosePosition(position));
    }
}
