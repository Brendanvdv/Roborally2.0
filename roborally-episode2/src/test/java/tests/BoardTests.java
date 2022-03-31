package tests;
import static org.junit.Assert.assertArrayEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import notdefault.Board;


public class BoardTests {
	
	private int width;
	private int length;
	Board b;
	
	@Given("length and width {int}")
	public void length_and_width(Integer int1) {
	    this.width = int1;
	    this.length = int1;
	}
	@When("square board is generated")
	public void square_board_is_generated() {
	    b = new Board(width, length);
	}
	
	@Then("make board with size {int}")
	public void make_board_with_size_x(Integer int1) {
	    assertArrayEquals(b.getSize(), new int[] {int1, int1});
	}

	@Given("length {int} and width {int}")
	public void length_and_width(Integer int1, Integer int2) {
	    this.width = int1;
	    this.length = int2;
	}
	@When("rectangular board is generated")
	public void rectangular_board_is_generated() {
		b = new Board(width, length);
	}
	
	@Then("make board with size {int} x {int}")
	public void make_board_with_size_x(Integer int1, Integer int2) {
		assertArrayEquals(b.getSize(), new int[] {int1,int2});
	}

}
