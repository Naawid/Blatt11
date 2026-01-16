package h1;

public class H1_main {
	public static void main(String[] args) {
		Node a = new Node(null);
		Node b = new Node(null);
		Node c = new Node(null);
		Node d = new Node(null);
		Node e = new Node(null);
		a.setNext(b);
		b.setNext(c);
		c.setNext(d);
		d.setNext(e);
		System.out.println(distance(b,a));
	}

	public static int distance(Node x, Node y) {
		if (x == y) {
			return 0;
		}
		return 1 + distance(x.getNext(),y);

	}
}
