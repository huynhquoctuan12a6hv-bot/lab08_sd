
package lab08_sd;

import java.util.EnumMap;

public class Program3 implements Program {

	public enum Day {
		MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
	}

	private static final Show NULL_SHOW = createNullShow();

	private static Show createNullShow() {
		return new Show() {
			public String description() {
				return "";
			}

			public int runningTime() {
				return 0;
			}

			public Show copy() {
				return createNullShow();
			}

			public int hashCode() {
				return 0;
			}

			public boolean equals(Object obj) {
				return obj != null && obj.getClass() == this.getClass();
			}
		};
	}

	private final EnumMap<Day, Show> aShows = new EnumMap<>(Day.class);

	// CommandProcessor được đóng gói bên trong Program3
	private final CommandProcessor processor = new CommandProcessor();

	public Program3() {
		clearDirect();
	}

	// ==============================
	// CÁC PHƯƠNG THỨC TẠO COMMAND
	// ==============================

	// Lệnh thêm phim
	public UndoableCommand createAddCommand(Show pShow, Day pDay) {

		return new UndoableCommand() {
			public void execute() {
				addDirect(pShow, pDay);
			}

			public void undo() {
				removeDirect(pDay);
			}
		};
	}

	// Lệnh xóa phim
	public UndoableCommand createRemoveCommand(Day pDay) {

		return new UndoableCommand() {
			Show show;

			public void execute() {
				show = get(pDay);
				removeDirect(pDay);
			}

			public void undo() {
				if (show != NULL_SHOW) {
					addDirect(show, pDay);
				}
			}
		};
	}

	// Lệnh xóa toàn bộ lịch chiếu
	public UndoableCommand createClearCommand() {

		return new UndoableCommand() {
			EnumMap<Day, Show> previousShows;

			public void execute() {
				previousShows = new EnumMap<>(aShows);
				clearDirect();
			}

			public void undo() {
				aShows.putAll(previousShows);
			}
		};
	}

	// ==============================
	// CÁC PHƯƠNG THỨC CỦA EXERCISE 18
	// ==============================

	// Thêm phim thông qua CommandProcessor
	@Override
	public void add(Show pShow, Day pDay) {
		processor.execute(createAddCommand(pShow, pDay));
	}

	// Xóa phim thông qua CommandProcessor
	@Override
	public void remove(Day pDay) {
		processor.execute(createRemoveCommand(pDay));
	}

	// Xóa toàn bộ lịch chiếu thông qua CommandProcessor
	@Override
	public void clear() {
		processor.execute(createClearCommand());
	}

	// Hoàn tác lệnh gần nhất
	@Override
	public void undoLast() {
		processor.undoLast();
	}

	// ==============================
	// CÁC PHƯƠNG THỨC XỬ LÝ DỮ LIỆU
	// ==============================

	private void clearDirect() {
		for (Day day : Day.values()) {
			aShows.put(day, NULL_SHOW);
		}
	}

	private void addDirect(Show pShow, Day pDay) {
		assert pShow != null && pDay != null;
		aShows.put(pDay, pShow);
	}

	private void removeDirect(Day pDay) {
		assert pDay != null;
		aShows.put(pDay, NULL_SHOW);
	}

	private Show get(Day pDay) {
		assert pDay != null;
		return aShows.get(pDay);
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();

		for (Day day : aShows.keySet()) {
			result.append(String.format("%9s", day.name())).append(": ").append(aShows.get(day).description())
					.append("\n");
		}

		return result.toString();
	}
}
