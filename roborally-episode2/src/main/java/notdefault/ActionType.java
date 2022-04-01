package notdefault;

public enum ActionType {
    
    Move_1,
    Move_2,
    Move_3,
    TurnLeft,
    TurnRight,
    UTurn;

    private String actionString;
    
    public void setActionType(ActionType actionType) {
	if(actionType.equals(ActionType.Move_1)) {
	    actionString = "Move 1";
	} else if(actionType.equals(ActionType.Move_2)) {
	    actionString = "Move 2";
	} else if(actionType.equals(ActionType.Move_3)) {
	    actionString = "Move 3";
	} else if(actionType.equals(ActionType.TurnLeft)) {
	    actionString = "Turn Right";
	} else if(actionType.equals(ActionType.TurnRight)) {
	    actionString = "Turn Left";
	} else if(actionType.equals(ActionType.UTurn)) {
	    actionString = "U-Turn";
	}
    }
    
    public String getActionType() {
	return actionString;
    }
}
