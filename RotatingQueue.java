public class RotatingQueue {
	private int[] list;
	private int top;
	private int bottom;
	private int size;
	private int contains;
	
	public RotatingQueue(int size) {
		list = new int[size];
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
	
	public void Push(int x) throws ListFullException {
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
	
	public void PushPriority(int x) throws ListFullException {
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
	
	public int Pop() throws ListEmptyException {
		if (isEmpty()) {
			ListEmptyException q = new ListEmptyException();
			throw q;
		}
		int ret = list[top];
		list[top] = 0;
		top++;
		contains--;
		if (top == size)
			top = 0;
		return ret;
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
