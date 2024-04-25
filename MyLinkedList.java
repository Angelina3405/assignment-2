//creating fMyLinkedList class
class MyLinkedList<A> implements MyList<A>{
    //reating private class MyNode

private class MyNode{
    A element;
    MyNode next;
    MyNode prev;
    MyNode(A element){
        this.element = element;
    }
}

    private MyNode head;
    private MyNode tail;
    private int size;

    @Override
    public void add(A element){
        add(size, element);
    }

    @Override
    public void add(int index, A element){
        if (index<0|| index>=size){
            throw new IndexOutOfBoundsException();
        }
        MyNode newNode = new MyNode(element);
        if (size == 0){
            head = tail = newNode;
        }
        else if (index == 0){
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        else if (index == size){
            tail.next= newNode;
            newNode.prev=tail;
            tail=newNode;
        }
        else{
            MyNode current = getNode(index);
            newNode.prev = current.prev;
            newNode.next=current;
            current.prev.next=newNode;
            current.prev=newNode;
        }
        size++;
    }

    @Override
    public A get(int index){
        return getNode(index).element;
    }

    @Override
    public boolean isEmpty(){
        return size==0;
    }

    @Override
    public A remove (int index){
        MyNode removedNode =  getNode(index);
        if(size == 1){
            head = tail = null;
        }
        else if (index == 0){
            head = head.next;
            head.prev = null;}
        else if (index == size -1){
            tail= tail.prev;
            tail.next = null;
        }
        else {
            removedNode.prev.next= removedNode.next;
            removedNode.next.prev=removedNode.prev;
        }
        size--;
        return removedNode.element;
        
    }
    @Override
    public int size(){
        return size;
    }

    private MyNode getNode(int index){
        if (index<0|| index>=size){
            throw new IndexOutOfBoundsException();
        }
        MyNode current = head;
        for (int i =0; i<index; i++){
            current = current.next;
        }
        return current;
    }

}