package core.musala.parser;

import core.musala.parser.positions.Positions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Parser {
    public static void Parse(WebElement element) {
        String location = element.findElement(By.xpath(".//p[@class='card-jobsHot__location']")).getText();
        String position = element.findElement(By.xpath(".//h2[@class='card-jobsHot__title']")).getText();
        String moreInfo = element.getAttribute("href");

        Positions.addPosition(location, position, moreInfo);
    }
}
