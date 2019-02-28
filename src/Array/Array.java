package Array;

public class Array<E> {
    private E[] data;
    private int size;//当前的元素个数

    //有参构造函数
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    //this()能在无参构造函数中调用有参构造函数
    //无参构造函数
    public Array() {
        //默认capacity为10
        this(10);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity(){
        return data.length;
    }

    public E getLast() {
        return get(size-1);
    }
    public E getFirst(){
        return data[0];
    }
    public void addLast(E e) {
        addIndex(size, e);
    }

    public void addFirst(E e) {
        addIndex(0, e);
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public void addIndex(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("can't add now");

        if (size == data.length)
            resize(2 * data.length);

        for(int i=size;i>=index;i--){
            if(i==0)
                data[i]=e;
            else
                data[i]=data[i-1];
        }
//        for (int i = size - 1; i >= index; i--)
//            data[i + 1] = data[i];

        data[index] = e;

        size++;
    }

    //应声明为private 禁止用户主动的改变数组的大小
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size=%d, capacity=%d\n", size, data.length));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
//            if (i != size - 1)
//                res.append(", ");
        }
        res.append("]");
        return res.toString();
    }

    //获取index索引位置的元素
    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed.index is illegal.");
        return data[index];
    }

    //改变index索引位置的元素
    public void set(int index, E value) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed.index is illegal");
        data[index] = value;
    }

    //equals为值比较 ==为引用比较
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e))
                return true;
        }
        return false;
    }

    //查找数组中元素e所在的索引，如果不存在元素e，则返回-1
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e))
                return i;
        }
        return -1;
    }

    //从数组中删除index位置的元素,返回被删除的元素
    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Error index");
        E temp = data[index];
        for (int i = index; i < size; i++)
            data[i] = data[i + 1];
        size--;//不要忘记改变size
        data[size] = null;//loitering objects != memory leak
        if(size==data.length/2)
            resize(data.length/2);
        return temp;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    //从数组中删除元素e
    public void remoceElement(E e) {
        int index = find(e);
        if (index != -1)
            remove(index);
    }
}
