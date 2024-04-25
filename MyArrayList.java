//creating MyList interface

interface MyList<A>{
    void add(A element);
    void add(int index, A element);
    A get(int index);
    A remove(int index);
    int size();
}
//creating MyArrayList class

class MyArrayList<A> implements MyList<A>{
    private Object[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayList(){
        this.elements= new Object[DEFAULT_CAPACITY];
        this.size=0;
    }

    @Override
    public void add(int index, A element){
        if (index<0||index>size){
            throw new Exception("Index: "+index+", Size: "+size);
        }
        if (size== elements.lenghth){
            increaseCapacity();
        }
        System.arraycopy(elements, index, elements, index+1,size-index);
        elements[index]=element;
        size++;
    }


    @Override
    public A get(int index) throws Exception{
        if (index<0|| index>=size){
            throw new Exception();
        }
        return (A) elements[index];
    }

    @Override
    public A remove(int index) throws Exception{
        if (index<0|| index>=size){
            throw new Exception();
        }
        A removedElement = (A) elements[index];
        System.arraycopy(elements, index+1, elements, index, size-index-1);
        elements[--size]=null;
        return removedElement;
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public boolean isEmpty(){
        return size==0;
    }


    private void increaseCapacity(){
        int newCapacity = elements.length *2;
        Object[] newElements = new Object[newCapacity];
        System.arraycopy(elements, 0, newElements, 0, size);
        elements= newElements;
    }
}