package lab08_sd;

import java.util.Stack;

public class CommandProcessor {
    private Stack<UndoableCommand> undoStack = new Stack<>();
    private Stack<UndoableCommand> redoStack = new Stack<>();

    // Thực hiện lệnh mới
    public void execute(UndoableCommand command) {
        command.execute();
        undoStack.push(command);
        redoStack.clear();
    }

    // Hoàn tác cho Exercise 16 và 17
    public void undo() {
        undoLast();
    }

    // Hoàn tác lệnh gần nhất cho Exercise 18
    public void undoLast() {
        if (!undoStack.isEmpty()) {
            UndoableCommand command = undoStack.pop();
            command.undo();
            redoStack.push(command);
        }
    }

    // Thực hiện lại lệnh cho Exercise 17
    public void redo() {
        if (!redoStack.isEmpty()) {
            UndoableCommand command = redoStack.pop();
            command.execute();
            undoStack.push(command);
        }
    }
}