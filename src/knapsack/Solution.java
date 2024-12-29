package knapsack;
import java.util.List;

public class Solution {
    private List<Item> selectedItems;
    private int totalProfit;
    private int totalWeight;

    // Constructor
    public Solution(List<Item> selectedItems, int totalProfit, int totalWeight) {
        this.selectedItems = selectedItems;
        this.totalProfit = totalProfit;
        this.totalWeight = totalWeight;
    }

    // Getter metodları
    public List<Item> getSelectedItems() {
        return selectedItems;
    }

    public int getTotalProfit() {
        return totalProfit;
    }

    public int getTotalWeight() {
        return totalWeight;
    }

    // Çözümün geçerli olup olmadığının kontrolü
    public boolean isFeasible(int maxWeight) {
        return totalWeight <= maxWeight;
    }
}

