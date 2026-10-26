# Sorting-Algorithms-Benchmark

## Student Information
- **Name:** Jamal Abdulnasser Shalabi (جمال عبدالناصر شلابي)
- **University ID:** 3169116
- **Section:** [YOUR SECTION]

## Description
A Java program that measures the running time (in microseconds) of five sorting algorithms
(Selection, Insertion, Bubble, Merge, Quick) on four input cases, with **N = 100,000** elements.
Timing uses `System.nanoTime()` divided by 1000; only the sorting itself is timed
(each algorithm works on an independent copy of the original array).

Source file: [`SortingBenchmark.java`](SortingBenchmark.java)

## Results (µs)

| Algorithm      | Random | Reversed | Partially Sorted (~80%) | Fully Sorted |
|----------------|-------:|---------:|------------------------:|-------------:|
| Selection Sort | 2,601,321 | 4,459,458 | 2,712,695 | 2,220,304 |
| Insertion Sort | 622,534 | 1,307,059 | 137,876 | 101 |
| Bubble Sort    | 17,739,714 | 8,845,295 | 7,926,353 | 147 |
| Merge Sort     | 20,807 | 6,792 | 9,629 | 5,688 |
| Quick Sort     | 8,638 | 3,759,833 | 8,010 | 4,752,695 |

## Chart
![Chart](chart.png)

(Logarithmic Y axis, because the values range from ~100 µs to ~17,000,000 µs.)

## Analysis and Discussion

### 1. O(N²) vs O(N log N)
Selection, Insertion and Bubble Sort take roughly N² = 10¹⁰ basic steps for N = 100,000,
while Merge and Quick Sort take about N·log₂N ≈ 1.7·10⁶ steps. In the random case this
means Merge/Quick Sort finish in milliseconds, while Bubble Sort needs many seconds:
a difference of hundreds to thousands of times. Bubble Sort is the slowest because it
performs the most swaps.

### 2. Best algorithm for sorted and partially sorted data
**Insertion Sort** is the best. On fully sorted data each element is compared only once
with its left neighbour, so it runs in O(N) (about 100 µs). On ~80% sorted data every
element is only a short distance from its place, so the number of shifts is small
and it is much faster than on random data. Bubble Sort is also fast on fully sorted data
only because of the early-exit flag (`swapped`), but it is slow on partially sorted data.
Selection Sort does not benefit at all: it always scans the whole remaining array to find the minimum.

### 3. Quick Sort on reversed / fully sorted data and the pivot
This implementation uses the **last element as the pivot**. On sorted or reversed data the
pivot is always the largest or smallest element, so each partition splits the array into
N-1 elements and 0 elements. The recursion depth becomes N and the total work grows to
O(N²), which is why Quick Sort jumps from ~8,000 µs to millions of µs.
Choosing a random pivot or the median of three (first, middle, last) avoids this worst case.
