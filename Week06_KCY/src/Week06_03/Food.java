package Week06_03;

public class Food {
	String name;
	boolean Vege;
	int calories;
	Type type;

	public Food(String name, boolean vegetarian, int calories, Type type) {
		this.name = name;
		this.Vege = vegetarian;
		this.calories = calories;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public boolean isVege() {
		return Vege;
	}

	public void setVege(boolean vege) {
		Vege = vege;
	}

	public int getCalories() {
		return calories;
	}

	public Type getType() {
		return type;
	}

	@Override
	public String toString() {
		return name;
	}
}
