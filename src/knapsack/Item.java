package knapsack;
public class Item {
    private int profit;
    private int weight;

    // Constructor
    public Item(int profit, int weight) {
        this.profit = profit;
        this.weight = weight;
    }

    // Getter ve Setter metodları
    public int getProfit() {
        return profit;
    }

    public int getWeight() {
        return weight;
    }

    public double getUnitPrice() {
        return (double) profit / weight;
    }
}
