package Array;

public class Array {
    private int[] data;
    private int size;//当前的元素个数

    //有参构造函数
    public Array(int capacity){
        data=new int[capacity];
        size=0;
    }
    //无参构造函数
    public Array(){
        //默认capacity为10
        data=new int[10];
        size=0;
    }
    public int getSize(){
        return size;
    }
    public int getLast(){
        return data[size];
    }
    public void addLast(int e){
        addIndex(size,e);
    }
    public void addFirst(int e){
        addIndex(0,e);
    }
    public boolean isEmpty(){
        return (size==0);
    }
    public void addIndex(int index,int e){
        if(size==data.length)
            throw new IllegalArgumentException("can't add now,Array is full");
        if(index<0 || index>size)
            throw new IllegalArgumentException("can't add now");

        for(int i=size;i>=index;i--){
            data[i+1]=data[i];
        }
        data[index]=e;
        size++;
    }
    @Override
    public String toString(){
        StringBuilder res=new StringBuilder();
        res.append(String.format("Array: size=%d, capacity=%d\n",size,data.length));
        res.append("[");
        for(int i=0;i<size;i++){
            res.append(data[i]);
            if(i!=size-1)
                res.append(", ");
        }
        res.append("]");
        return res.toString();
    }

    //获取index索引位置的元素
    public int get(int index){
        if(index<0 || index>=size)
            throw new IllegalArgumentException("Get failed.index is illegal.");
        return data[index];
    }
    //改变index索引位置的元素
    public void set(int index,int value){
        if(index<0 || index >=size)
            throw  new IllegalArgumentException("Set failed.index is illegal");
        data[index]=value;
    }

    public boolean contains(int e){
        for(int i=0;i<size;i++){
            if(data[i]==e)
                return true;
        }
        return false;
    }
    //查找数组中元素e所在的索引，如果不存在元素e，则返回-1
    public int find(int e){
        for(int i=0;i<size;i++){
            if(data[i]==e)
                return i;
        }
        return -1;
    }

    //从数组中删除index位置的元素,返回被删除的元素
    public int remove(int index){
        if(index<0 || index>=size)
            throw new IllegalArgumentException("Error index");
        int temp=data[index];
        for(int i=index;i<size;i++)
            data[i]=data[i+1];
        size--;//不要忘记改变size
        return temp;
    }
    public int removeFirst(){
        return remove(0);
    }
    public int removeLast(){
        return remove(size-1);
    }
    //从数组中删除元素e
    public void remoceElement(int e){
        int index=find(e);
        if(index!=-1)
            remove(index);
    }
}
