// JIMIN :: Ryan Lau, Melody Lew, Paul Serbanescu
// APCS
// LAB08 -- America's Next Top Data Scientist
// 2022-04-05
// time spent: 2.5hrs + class time

public class Cereal {
	private String name;
	private String type;
	private int calories;
	private int protein;
	private int fat;
	private int sodium;
	private double fiber;
	private double carbohydrates;
	private int sugar;
	private int potassium;
	private int vitamins;
	private int shelf;
	private double weight;
	private double cups;
	private double rating;

	public Cereal(String name, String type, int calories, int protein, int fat, int sodium, double fiber, double carbohydrates, int sugar, int potassium, int vitamins, int shelf, double weight, double cups, double rating) {
		this.name = name;
		this.type = type;
		this.calories = calories;
		this.protein = protein;
		this.fat = fat;
		this.sodium = sodium;
		this.fiber = fiber;
		this.carbohydrates = carbohydrates;
		this.sugar = sugar;
		this.potassium = potassium;
		this.vitamins = vitamins;
		this.shelf = shelf;
		this.weight = weight;
		this.cups = cups;
		this.rating = rating;
		}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public int getCalories() {
		return calories;
	}

	public int getProtein() {
		return protein;
	}

	public int getFat() {
		return fat;
	}

	public int getSodium() {
		return sodium;
	}

	public double getFiber() {
		return fiber;
	}

	public double getCarbohydrates() {
		return carbohydrates;
	}

	public int getSugar() {
		return sugar;
	}

	public int getPotassium() {
		return potassium;
	}

	public int getVitamins() {
		return vitamins;
	}

	public int getShelf() {
		return shelf;
	}

	public double getWeight() {
		return weight;
	}

	public double getCups() {
		return cups;
	}

	public double getRating() {
		return rating;
	}

	public String toString() {
		String ret = "";
		ret += "name: " + name + "\n";
		ret += "type: " + type + "\n";
		ret += "calories: " + calories + "\n";
		ret += "protein: " + protein + "\n";
		ret += "fat: " + fat + "\n";
		ret += "sodium: " + sodium + "\n";
		ret += "fiber: " + fiber + "\n";
		ret += "carbohydrates: " + carbohydrates + "\n";
		ret += "sugar: " + sugar + "\n";
		ret += "potassium: " + potassium + "\n";
		ret += "vitamins: " + vitamins + "\n";
		ret += "shelf: " + shelf + "\n";
		ret += "weight: " + weight + "\n";
		ret += "cups: " + cups + "\n";
		ret += "rating: " + rating + "\n";
		return ret;
	}

	public static void main(String[] args) {
		Cereal raisinBran = new Cereal("Raisin Bran","C",120,3,1,210,5,14,12,240,25,2,1.33,0.75,39.259197);
		Cereal frostedFlakes = new Cereal("Frosted Flakes","C",110,1,0,200,1,14,11,25,25,1,1,0.75,31.435973);

		System.out.println(raisinBran);
		System.out.println(frostedFlakes);
	}

}