//creating queue data structure

class MyQueue<A> {
    private MyList<A> list;

    public MyQueue(MyList<A> list) {
        this.list = list;
    }

    public void enqueue(A element) {
        list.add(element);
    }

    public A dequeue() {
        if (list.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return list.remove(0);
    }

    public A peek() {
        if (list.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return list.get(0);
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}