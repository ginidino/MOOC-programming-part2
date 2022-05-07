package TEST;

public class Slot<T> {
	private T key;

    public void setValue(T key) {
        this.key = key;
    }

    public T getValue() {
        return key;
    }
}
