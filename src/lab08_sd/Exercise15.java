package lab08_sd;

import lab08_sd.Program3.Day;

public class Exercise15 {

    public static void main(String[] args) {

        Program3 program = new Program3();

        System.out.println("TRANG THAI BAN DAU:");
        System.out.println(program);

        // 1. Thêm Movie 1 vào Monday
        UndoableCommand command =
                program.createAddCommand(
                    new Movie("Movie 1", 2000, 120),
                    Day.MONDAY
                );

        command.execute();
        System.out.println("SAU KHI THEM MOVIE 1:");
        System.out.println(program);

        // 2. Hoàn tác thêm Movie 1
        command.undo();
        System.out.println("SAU KHI UNDO:");
        System.out.println(program);

        // 3. Thêm lại Movie 1
        command.execute();
        System.out.println("SAU KHI THEM LAI MOVIE 1:");
        System.out.println(program);

        // 4. Thêm Movie 2 vào Wednesday
        command = program.createAddCommand(
                new Movie("Movie 2", 2010, 90),
                Day.WEDNESDAY
        );

        command.execute();
        System.out.println("SAU KHI THEM MOVIE 2:");
        System.out.println(program);

        // 5. Xóa phim ở Monday
        command = program.createRemoveCommand(Day.MONDAY);

        command.execute();
        System.out.println("SAU KHI XOA MOVIE 1:");
        System.out.println(program);

        // 6. Hoàn tác xóa phim
        command.undo();
        System.out.println("SAU KHI KHOI PHUC MOVIE 1:");
        System.out.println(program);

        // 7. Xóa toàn bộ lịch chiếu
        command = program.createClearCommand();

        command.execute();
        System.out.println("SAU KHI CLEAR:");
        System.out.println(program);

        // 8. Hoàn tác Clear
        command.undo();
        System.out.println("SAU KHI UNDO CLEAR:");
        System.out.println(program);
    }
}
