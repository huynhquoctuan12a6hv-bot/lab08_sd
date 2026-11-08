package lab08_sd;

public interface Program {
    void add(Show show, Program3.Day day);

    void remove(Program3.Day day);

    void clear();

    void undoLast();
}
