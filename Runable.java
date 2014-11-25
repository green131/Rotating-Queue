
public class Runable {

	public static void main(String[] args) throws ListFullException, ListEmptyException {
		RotatingQueue q = new RotatingQueue( 2 );
		q.Push( 'a' );
		q.Push( 'b' );
		q.Pop();
		System.out.println( q.toString() );
		q.Push( 'c' );
		System.out.println( q.Pop() );
		System.out.println( q.toString() );
	}

}
