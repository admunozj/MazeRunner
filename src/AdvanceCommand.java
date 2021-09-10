public class AdvanceCommand implements Command {
    Robot robot;
    SIDE turn;

    public AdvanceCommand(Robot robot, SIDE turn) {
        this.robot = robot;
        this.turn = turn;
    }

    @Override
    public int execute() {
        if (turn == SIDE.LEFT)
            robot.turn(45);
        else if(turn == SIDE.RIGHT)
            robot.turn(-45);
        return robot.advance();
    }

    @Override
    public int undo() {
        robot.retreat();
        if (turn == SIDE.LEFT) robot.turn(-45);
        else if (turn == SIDE.RIGHT) robot.turn(45);
        return 0;
    }
}
