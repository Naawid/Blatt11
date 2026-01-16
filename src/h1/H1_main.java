package h1;

public class H1_main {
	public static void main(String[] args) {
		
	}

	public static int distance(Node x, Node y) {	
		if (x == y) {
			return 0;
		}
		return 1 + distance(x.getNext(),y);

	}
}
