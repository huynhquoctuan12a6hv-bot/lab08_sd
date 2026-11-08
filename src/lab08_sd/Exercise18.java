package lab08_sd;

public class Exercise18 {
    public static void main(String[] args) {
        Program3 program = new Program3();

        // Thêm hai bộ phim
        program.add(
            new Movie("Movie 1", 2000, 120),
            Program3.Day.MONDAY
        );

        program.add(
            new Movie("Movie 2", 2010, 90),
            Program3.Day.WEDNESDAY
        );

        System.out.println("SAU KHI THEM PHIM:");
        System.out.println(program);

        // Hoàn tác lệnh thêm Movie 2
        program.undoLast();

        System.out.println("SAU KHI UNDO:");
        System.out.println(program);

        // Hoàn tác lệnh thêm Movie 1
        program.undoLast();

        System.out.println("SAU KHI UNDO LAN 2:");
        System.out.println(program);
    }
}