//creating MyMinHeap class
class MyMinHeap<A extends Comparable<A>> {
    private MyList<A> list;

    public MyMinHeap(MyList<A> list) {
        this.list = list;
        buildHeap();
    }

    public void insert(A element) {
        list.add(element);
        int index = list.size() - 1;
        bubbleUp(index);
    }
//reating function that deledes minimum in list
    public A deleteMin() {
        if (list.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        A min = list.get(0);
        list.set(0, list.remove(list.size() - 1));
        bubbleDown(0);
        return min;
    }
//creating function that finds minimum in list
    public A findMin() {
        if (list.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        return list.get(0);
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    private void buildHeap() {
        for (int i = list.size() / 2 - 1; i >= 0; i--) {
            bubbleDown(i);
        }
    }

    private void bubbleUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (list.get(index).compareTo(list.get(parentIndex)) >= 0) {
                break;
            }
            swap(index, parentIndex);
            index = parentIndex;
        }
    }

    private void bubbleDown(int index) {
        int minIndex = index;
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;

        if (leftChildIndex < list.size() && list.get(leftChildIndex).compareTo(list.get(minIndex)) < 0) {
            minIndex = leftChildIndex;
        }

        if (rightChildIndex < list.size() && list.get(rightChildIndex).compareTo(list.get(minIndex)) < 0) {
            minIndex = rightChildIndex;
        }

        if (minIndex != index) {
            swap(index, minIndex);
            bubbleDown(minIndex);
        }
    }

    private void swap(int i, int j) {
        A temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}