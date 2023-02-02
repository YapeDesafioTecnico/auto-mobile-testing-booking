package starter.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.ui.PricesView;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class DoBooking implements Task {

    String price;
    public DoBooking() {
    }

    public static Performable ofTheRoom() {
        return new DoBooking();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(PricesView.labelPrice,isVisible()).forNoMoreThan(10).seconds());
        price= Text.of(PricesView.labelPrice).answeredBy(actor);
        actor.remember("price",price);
        actor.attemptsTo(WaitUntil.the(PricesView.btnSelectOption,isVisible()).forNoMoreThan(10).seconds());
        actor.attemptsTo(Click.on(PricesView.btnSelectOption));

    }
}
