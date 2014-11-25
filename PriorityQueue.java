
public class PriorityQueue {
	private RotatingQueue queue;
	private RotatingQueue priority;
	// The default size of a new queue set.
	private int DEFAULT_SIZE = 10;
	// Pop counter to manage priority vs regular pops
	private int counter = 0;
	
	/*
	 * Initialize queue using default sizes.
	 */
	public PriorityQueue() {
		this.queue = new RotatingQueue( DEFAULT_SIZE );
		this.priority = new RotatingQueue( DEFAULT_SIZE/2 );
	}
	/*
	 * Initialize the queue using specified sizes.
	 */
	public PriorityQueue( int size, int prioritySize ) {
		this.queue = new RotatingQueue( size );
		this.priority = new RotatingQueue( prioritySize );
	}
	/*
	 * Expand the queue and add values
	 */
	public RotatingQueue expand( RotatingQueue x ) throws ListEmptyException, ListFullException {
		RotatingQueue y = new RotatingQueue( x.size * 2 );
		for ( int k = 0; k < x.contains; k++ ) {
			y.Push( x.Pop() );
		}
		return y;
	}
	/*
	 * Pushes an object to the back of the queue.
	 * If full throws an exception.
	 */
	public void Push( Object x ) throws ListEmptyException, ListFullException {
		try {
			queue.Push( x );
		} catch (ListFullException e) {
			queue = expand( queue );
			queue.Push( x );
		}
	}
	/*
	 * Push an object to the back of the priority list.
	 * If full throws an exception.
	 */
	public void PushPriority( Object x ) throws ListEmptyException, ListFullException {
		try {
			priority.Push( x );
		} catch (ListFullException e) {
			priority = expand( priority );
			priority.Push( x );
		}
	}
	/*
	 * Pushes an object to the very front of the priority queue.
	 * If full throws an exception.
	 */
	public void PushImmediate( Object x ) throws ListFullException {
		priority.PushPriority( x );
	}
	/*
	 * Pop from priority queue and normal queue at a 3:1 ratio, respectively.
	 * If empty returns exception.
	 */
	public Object Pop( Object x ) throws ListEmptyException {
		counter++;
		if ( counter % 3 != 0 ) {
			return priority.Pop();
		} else {
			return queue.Pop();
		}
	}
	/*
	 * Pop priority queue until empty. If empty throws exception. 
	 */
	public Object PopPriority( Object x ) throws ListEmptyException {
		return priority.Pop();
	}
	/*
	 * Print a sting representation of the queue sets
	 */
	public String toString
}
