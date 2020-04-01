package GoFish;

public class SingleLinkedList {
	private Node head = null;

	public SingleLinkedList() {

	}

	public SingleLinkedList(Node head) {
		this.head = head;
	}

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public void Add(Object data) {
		Node newNode = new Node(data);

		if (head == null) {
			head = newNode;
		} else {
			Node temp = head;

			while (temp.getLink() != null) {
				temp = temp.getLink();
			}

			temp.setLink(newNode);
		}
	}

	public boolean Delete(Object input) {
		if (head == null) {
			return false;
		} else if (head.getData().equals(input) == true) {
			head = head.getLink();
			return true;
		} else {
			Node prev = head;
			Node temp = prev.getLink();

			while (temp != null) {
				if (temp.getData().equals(input) == true) {
					prev.setLink(temp.getLink());
					return true;
				}

				prev = temp;
				temp = temp.getLink();

			}
			return false;
		}

	}

	public void Display() {
		if (head == null) {
			// System.out.println("Linked list is empty!");
		} else {
			Node temp = head;

			while (temp != null) {
				System.out.print(temp.getData() + " ");
				temp = temp.getLink();
			}
		}
	}

	public int Size() {
		int size = 0;
		if (head == null) {
			// System.out.println("Linked list is empty!");
		} else {
			Node temp = head;

			while (temp != null) {
				size++;
				temp = temp.getLink();
			}
		}
		return size;
	}

	public boolean Search(Object data) {
		if (head == null) {
			return false;
		} else {
			Node temp = head;

			boolean retVal = false;
			while (temp != null) {
				if ((int) temp.getData() == (int) data) {
					retVal = true;
					break;
				}

				temp = temp.getLink();
			}

			return retVal;
		}
	}
}
