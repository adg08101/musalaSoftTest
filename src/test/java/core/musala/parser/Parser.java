package core.musala.parser;

import core.musala.parser.positions.Positions;
import org.openqa.selenium.WebElement;

public class Parser {
    private Positions position;

    public Parser(WebElement element) {
        System.out.println("----------------");
        System.out.println(element.getAttribute("innerHTML"));
        System.out.println("----------------");
    }
}
