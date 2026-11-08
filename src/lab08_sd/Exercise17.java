package lab08_sd;

import lab08_sd.Program3.Day;

public class Exercise17 {
    public static void main(String[] args) {
        Program3 program = new Program3();
        CommandProcessor processor = new CommandProcessor();

        // Thêm phim thứ nhất
        processor.execute(program.createAddCommand(
            new Movie("Movie 1", 2000, 120), Day.MONDAY));

        // Thêm phim thứ hai
        processor.execute(program.createAddCommand(
            new Movie("Movie 2", 2010, 90), Day.WEDNESDAY));

        System.out.println("SAU KHI THUC HIEN 2 LENH:");
        System.out.println(program);

        // Hoàn tác lệnh thêm phim thứ hai
        processor.undo();

        System.out.println("SAU KHI UNDO:");
        System.out.println(program);

        // Thực hiện lại lệnh vừa hoàn tác
        processor.redo();

        System.out.println("SAU KHI REDO:");
        System.out.println(program);
    }
}
