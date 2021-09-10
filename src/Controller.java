import java.util.Stack;

public class Controller {
    Stack<Command> commandStack;
    Robot robot;
    Terrain terrain;

    public void advance() {
        Command command = new AdvanceCommand(robot, null);
        commandStack.push(command);
        if (1 == command.execute()) {
            commandStack.pop();
            commandStack.push(new TurnCommand(robot, null));
        }
        terrain = robot.activateSensors();
    }

    public void advanceLeft() {
        Command command = new AdvanceCommand(robot, SIDE.LEFT);
        commandStack.push(command);
        if (1 == command.execute()) {
            commandStack.pop();
            commandStack.push(new TurnCommand(robot, SIDE.LEFT));
        }
        terrain = robot.activateSensors();
    }

    public void advanceRight() {
        Command command = new AdvanceCommand(robot, SIDE.RIGHT);
        commandStack.push(command);
        if (1 == command.execute()) {
            commandStack.pop();
            commandStack.push(new TurnCommand(robot, SIDE.RIGHT));
        }
        terrain = robot.activateSensors();
    }

    public void turnLeft() {
        Command command = new TurnCommand(robot, SIDE.LEFT);
        commandStack.push(command);
        command.execute();
        terrain = robot.activateSensors();
    }

    public void turnRight() {
        Command command = new TurnCommand(robot, SIDE.RIGHT);
        commandStack.push(command);
        command.execute();
        terrain = robot.activateSensors();
    }

    public void reverse() {
        Command command = commandStack.pop();
        command.undo();
    }

}
