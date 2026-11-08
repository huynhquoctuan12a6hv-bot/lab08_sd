package lab08_sd;

import lab08_sd.Program3.Day;

public class Exercise16 {

    public static void main(String[] args) {

        Program3 program = new Program3();

        // Khởi tạo CommandProcessor
        CommandProcessor processor = new CommandProcessor();

        // Thêm Movie 1 vào Monday
        processor.execute(
            program.createAddCommand(
                new Movie("Movie 1", 2000, 120),
                Day.MONDAY
            )
        );

        // Thêm Movie 2 vào Wednesday
        processor.execute(
            program.createAddCommand(
                new Movie("Movie 2", 2010, 90),
                Day.WEDNESDAY
            )
        );

        System.out.println("SAU KHI THUC HIEN CAC LENH:");
        System.out.println(program);

        // Hoàn tác lệnh gần nhất
        processor.undo();

        System.out.println("SAU KHI UNDO LAN 1:");
        System.out.println(program);

        // Hoàn tác lệnh tiếp theo
        processor.undo();

        System.out.println("SAU KHI UNDO LAN 2:");
        System.out.println(program);
    }
}
