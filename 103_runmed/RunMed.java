// JIMIN :: Ryan Lau, Melody Lew, Paul Serbanescu
// APCS pd6
// HW103 -- Erica's Friends, Hugo, and The One in the Middle
// 2022-05-18h
// time spent: 0.5 hrs

import java.util.NoSuchElementException;

// class RunMed
// uses min and maxheap to keep track of running medium of i/o stream o numeros.



public class RunMed {
    
    private ALHeapMin minHeap;
    private ALHeapMax maxHeap;

    public RunMed() {
        maxHeap = new ALHeapMax();
        minHeap = new ALHeapMin();
    }


    public void add(Integer newVal) {
        if (maxHeap.isEmpty()) {
            minHeap.add(newVal);
        } else if (newVal < maxHeap.peekMax()) {
            maxHeap.add(newVal);
        } else {
            minHeap.add(newVal);
        }
        
        while (Math.abs(minHeap.size() - maxHeap.size()) > 1) {
            //balance
            if (minHeap.size() > maxHeap.size()) {
                Integer swapVal = minHeap.removeMin();
                maxHeap.add(swapVal);
            } else if (minHeap.size() < maxHeap.size()) {
                Integer swapVal = maxHeap.removeMax();
                minHeap.add(swapVal);
            }
        } 
    }
    
    public double getMedian() throws NoSuchElementException {
        if (maxHeap.size() == 0 && minHeap.size() == 0) {
            throw new NoSuchElementException();
        }

        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peekMax() + minHeap.peekMin()) / 2.0;
        }

        if (maxHeap.size() > minHeap.size()) return (double) maxHeap.peekMax();
        return (double) minHeap.peekMin();
    }
    
}
