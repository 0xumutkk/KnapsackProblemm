# Knapsack Problem Project

This project is an implementation of two algorithms to solve the **Knapsack Problem**: a Random Algorithm and a Greedy Algorithm. The purpose of this project is to compare the performance of these algorithms in terms of total profit using multiple test datasets.

---

## Project Structure

- **`Main`**: The entry point of the program. Executes the algorithms and compares their results.
- **`KnapsackProblem`**: Represents the problem definition, including items and bag capacity.
- **`Item`**: Represents an individual item with profit and weight attributes.
- **`Solution`**: Represents a solution to the problem, including selected items, total profit, and total weight.
- **`GreedyAlgorithm`**: Implements the greedy approach to solve the knapsack problem by sorting items based on their profit-to-weight ratio.
- **`RandomAlgorithm`**: Generates feasible random solutions by randomly selecting items.
- **`Utils`**: Utility class for reading input files and handling data.

---

## Algorithms

### 1. **Greedy Algorithm**
The greedy algorithm sorts items by their profit-to-weight ratio in descending order and adds items to the knapsack until it reaches its capacity.

- **Advantages**: Simple and efficient.
- **Limitation**: May not always yield the optimal solution.

### 2. **Random Algorithm**
The random algorithm generates random feasible solutions by randomly selecting items, ensuring that the total weight does not exceed the capacity.

- **Advantages**: Provides diverse solutions.
- **Limitation**: Quality of solutions depends on randomization.

---

## Input Format

The input files should follow this format:
1. The first line contains two integers: the number of items (`n`) and the maximum capacity of the knapsack.
2. Each subsequent line represents an item with two integers: the profit and weight of the item.

**Example Input**:
```text
4 10
10 5
15 7
20 8
25 6

---
