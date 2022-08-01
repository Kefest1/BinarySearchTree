public class MyData<T> {
    final int key;
    T data;

    MyData<T> left;
    MyData<T> right;

    public MyData(T data, int key) {
        this.data = data;
        this.key = key;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
