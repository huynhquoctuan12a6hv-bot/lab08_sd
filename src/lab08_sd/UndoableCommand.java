package lab08_sd;

public interface UndoableCommand extends Command {
    void undo(); //hoàn thao tác lệnh
}