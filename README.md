# Run:  pip install matplotlib   then   python make_chart.py
# Replace the numbers below with YOUR results (microseconds) from the console.
import matplotlib.pyplot as plt

algos = ["Selection", "Insertion", "Bubble", "Merge", "Quick"]
cases = ["Random", "Reversed", "Partially Sorted", "Fully Sorted"]
data = {  # rows = algorithms, columns = cases (same order as above)
    "Selection": [2601321, 4459458, 2712695, 2220304],
    "Insertion": [622534, 1307059, 137876, 101],
    "Bubble":    [17739714, 8845295, 7926353, 147],
    "Merge":     [20807, 6792, 9629, 5688],
    "Quick":     [8638, 3759833, 8010, 4752695],
}

fig, ax = plt.subplots(figsize=(11, 6))
width = 0.2
for i, case in enumerate(cases):
    vals = [data[a][i] for a in algos]
    ax.bar([x + i * width for x in range(len(algos))], vals, width, label=case)

ax.set_xticks([x + 1.5 * width for x in range(len(algos))])
ax.set_xticklabels(algos)
ax.set_yscale("log")          # log scale because values differ hugely
ax.set_ylabel("Time (µs, log scale)")
ax.set_title("Sorting Algorithms Benchmark (N = 100,000)")
ax.legend()
plt.tight_layout()
plt.savefig("chart.png", dpi=150)
