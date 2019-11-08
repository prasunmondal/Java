package LinkedList;

class SingleLinkNode {
	int data;
	SingleLinkNode next;
}

class LinkedList {

	SingleLinkNode head;

	public LinkedList() {
		this.head = null;
	}

	public void add_node(int data) {
		SingleLinkNode temp = new SingleLinkNode();
		temp.data = data;
		temp.next = null;

		if (this.head != null) {
			SingleLinkNode node = head;
			while (node.next != null) {
				node = node.next;
			}
			node.next = temp;
		}

		if (this.head == null) {
			this.head = temp;
		}
	}

	public void reverseLL() {
		SingleLinkNode current = this.head;
		SingleLinkNode prev = null, next = null;

		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;

	}
	
	public void reverseLL_Recursively() {
		head=reverseLL_Recurse(this.head);
	}
	
	private SingleLinkNode reverseLL_Recurse(SingleLinkNode head) {
		if(head==null || head.next==null) {
			return head;
		}
		
		SingleLinkNode node = reverseLL_Recurse(head.next);
		
		head.next.next = head;
		head.next = null;
		
		return node;
	}

	public void print_LL() {
		SingleLinkNode node = head;
		while (node.next != null) {
			System.out.print(node.data + ", ");
			node = node.next;
		}
		System.out.print(node.data);
	}
}

public class LL_Reverse_a_LL {
	public static void main(String[] args) {
		System.out.println("Hi");
		LinkedList ll = new LinkedList();
		ll.add_node(5);
		ll.add_node(8);
		ll.add_node(10);
		ll.add_node(15);
		ll.print_LL();
		System.out.println();
		ll.reverseLL();
		ll.print_LL();
		System.out.println();
		ll.reverseLL_Recursively();
		ll.print_LL();
	}
}