
class Knoten {
		// ATTRIBUTES
		int value;
    Knoten next;

		// CONSTRUCTOR
    Knoten(int i) {
        this.value = i;
    }
}

class VerketteteListe {
		// ATTRIBUTES
    Knoten head;

    public void insert(int i) {
			// Insert node at beginning of list
      Knoten node = new Knoten(i);
      node.next = head;
      head = node;
    }

		public void insert(int i, Knoten k) {
			// Insert new node with value i after node k
			Knoten node = new Knoten(i);
			node.next = k.next;
			k.next = node;
		}

    public void traverse() {
			// Traverse the list & print each node
      Knoten node = head;
      while (node != null) {
          System.out.println(node.value);
          node = node.next;
      }
    }

		public Knoten nodeForValue(int i) {
			// Return the first node with the value i, else null.
			Knoten node = head;
			while (node != null) {
				if (node.value == i) {
					return node;
				}
				node = node.next;
			}
			return null;
		}

		// MAIN
		//
		public static void main(String [] x) {

				VerketteteListe list = new VerketteteListe();
				for (int i = 10; i > 0; i--) {
					list.insert(i);
				}
				Knoten node = list.nodeForValue(5);
				list.insert(20, node);
				list.traverse();


				// list.insert(20);

		}
}
