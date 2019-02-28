package Stack;

import Array.Array;

public class ArrayStack<E> implements Stack<E>{
    Array<E> array;

    public ArrayStack(int capacity){
        array=new Array<E>(capacity);
    }
    public ArrayStack(){
        array=new Array<E>();
    }
    @Override
    public int getSize(){
        return array.getSize();
    }
    public int getCapacity(){
        return array.getCapacity();
    }
    @Override
    public boolean isEmpty(){
        return array.isEmpty();
    }
    @Override
    public E peek(){
        return array.getLast();
    }
    @Override
    public void push(E e){
        array.addLast(e);
    }

    @Override
    public E pop() {
        E temp=array.getLast();
        array.removeLast();
        return temp;
    }
}
