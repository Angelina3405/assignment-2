//creating stack datastructure

class MyStack<A> {
    private MyList<A> list;

    public MyStack(MyList<A> list) {
        this.list = list;
    }

    public void push(A element) {
        list.add(element);
    }
//creating pop function
    public A pop() {
        if (list.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return list.remove(list.size() - 1);
    }
//creating peek function
    
public A peek() {
        if (list.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return list.get(list.size() - 1);
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}