package tests;

import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import notdefault.ActionCard;

public class actionCardTests {
    ActionCard actionCard;

    @Given("an action card is generated")
    public void an_action_card_is_generated() {
        actionCard = new ActionCard();
    }

    @When("it is initialized")
    public void it_is_initialized() {
        actionCard.init();
    }

    @Then("it has to be randomly assigned an action, so that there are between {int} and {int} movements")
    public void it_has_to_be_randomly_assigned_an_action_so_that_there_are_between_and_movements(Integer int1, Integer int2) {
        int counter = 0;
	for (int i = 0; i < 900; i++) {
	    actionCard = new ActionCard();
	    if(actionCard.isMovement()) {
		counter++;
	    }
	}
	
	assertTrue(400 <= counter && counter <= 600);
    }
}
