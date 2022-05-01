package appModel;

// Responsibility: Produce cards and card specific variables

// Not open for extension yet

public class ActionCard {
	private String title;
	private CardType type;
	private int magnitude;
	private boolean movement = false;

	ActionCard() {
		init();
		cardModifiers();
	}

	public ActionCard(CardType cardType) {
		type = cardType;
		cardModifiers();
	}

// Consider independent class for Card Factory

	private void init() {
		double val = Math.random();

		if (val < 0.225) {
			setCardType(CardType.Move1);
			setTitle("Move 1");
		} else if (val < 0.425) {
			type = CardType.Move2;
			setTitle("Move 2");
		} else if (val < 0.55) {
			type = CardType.Move3;
			setTitle("Move 3");
		} else if (val < 0.75) {
			type = CardType.TurnL;
			setTitle("Turn Left");
		} else if (val < 0.95) {
			type = CardType.TurnR;
			setTitle("Turn Right");
		} else {
			type = CardType.UTurn;
			setTitle("U-Turn");
		}
	}

// Consider different class for movement specific cards

	public void cardModifiers() {
		if (type.equals(CardType.Move1)) {
			movement = true;
			magnitude = 1;
		} else if (type.equals(CardType.Move2)) {
			movement = true;
			magnitude = 2;
		} else if (type.equals(CardType.Move3)) {
			movement = true;
			magnitude = 3;
		}
	}

	public CardType getCardType() {
		return type;
	}

	public void setCardType(CardType type) {
		this.type = type;
	}

	public boolean isMovement() {
		return movement;
	}

	public int getMagnitude() {
		return magnitude;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
