public class TurnCommand implements Command{
    Robot robot;
    SIDE turn;

    public TurnCommand(Robot robot, SIDE turn) {
        this.robot = robot;
        this.turn = turn;
    }

    @Override
    public int execute() {
        if (turn == SIDE.LEFT) robot.turn(45);
        else if (turn == SIDE.RIGHT) robot.turn(-45);
        return 0;
    }

    @Override
    public int undo() {
        if (turn == SIDE.LEFT) robot.turn(-45);
        else if (turn == SIDE.RIGHT) robot.turn(45);
        return 0;
    }
}
