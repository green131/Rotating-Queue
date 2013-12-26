public class RotatingQueue {
	private Object[] list;
	private int top;
	private int bottom;
	private int size;
	private int contains;
	
	public RotatingQueue(int size) {
		list = new Object[size];
		top = 0;
		bottom = 0;
		this.size = size;
	}
	
	public boolean isEmpty() {
		if (contains == 0)
			return true;
		return false;
	}
	
	public boolean isFull() {
		if (contains == size) {
			return true;
		}
		return false;
	}
	
	public void clear() {
		while (!(isEmpty())) {
			try {
				Pop();
			} catch (ListEmptyException e) {
				break;
			}
		}
	}
	
	public void Push(Object x) throws ListFullException {
		if (isFull()) {
			ListFullException q = new ListFullException();
			throw q;
		}
		list[bottom] = x;
		bottom++;
		contains++;
		if (bottom == size)
			bottom = 0;
	}
	
	public void PushPriority(Object x) throws ListFullException {
		if (isFull()) {
			ListFullException q = new ListFullException();
			throw q;
		}
		top--;
		if (top < 0) {
			top = size-1;
		}
		list[top] = x;
		contains++;
	}
	
	public Object Pop() throws ListEmptyException {
		if (isEmpty()) {
			ListEmptyException q = new ListEmptyException();
			throw q;
		}
		Object ret = list[top];
		list[top] = null;
		top++;
		contains--;
		if (top == size)
			top = 0;
		return ret;
	}
	
	public Object GetNext() throws ListEmptyException {
		if (isEmpty()) {
			ListEmptyException q = new ListEmptyException();
			throw q;
		}
		return list[top];
	}
	
	public String toString() {
		String str = "[";
		for (int x = 0; x < list.length; x++) {
			str += list[x];
			if (x < list.length - 1)
				str += ",";
		}
		str += "]";
		return str;
	}

}
