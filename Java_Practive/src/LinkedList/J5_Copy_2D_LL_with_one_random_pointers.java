package LinkedList;

class LinkedList_2D {
	int data;
	LinkedList_2D next;
	LinkedList_2D arbitrary;

	public LinkedList_2D(int data) {
		this.data = data;
		this.next = null;
		this.arbitrary = null;
	}

	@Override
	public String toString() {
		return this.data + "";
	}

	public void printLinkedList(LinkedList_2D root) {
		while (root != null) {
			System.out.println(root.next + " <- " + root + " -> " + root.arbitrary);
			root = root.next;

		}
	}

	public LinkedList_2D copyLinkedList(LinkedList_2D root) {
		LinkedList_2D copyHead = root;

		while (copyHead != null) {
			LinkedList_2D newNode = new LinkedList_2D(copyHead.data);
			newNode.next = copyHead.next;
			copyHead.next = newNode;
			copyHead = newNode.next;
		}

		copyHead = root;
		while (copyHead != null) {
			LinkedList_2D altNode = copyHead.next;
			altNode.arbitrary = copyHead.arbitrary.next;
			copyHead = (altNode == null) ? null : altNode.next;
		}

		copyHead = root;
		LinkedList_2D copiedHead = root.next;
		while (copyHead != null) {
			LinkedList_2D altNode = copyHead.next;
			LinkedList_2D nAltNode = altNode.next == null ? null : altNode.next.next;
			LinkedList_2D nCopyHead = copyHead.next.next;
			copyHead.next = nCopyHead;
			altNode.next = nAltNode;
			copyHead = nCopyHead;
		}

		return copiedHead;
	}
}

public class J5_Copy_2D_LL_with_one_random_pointers {

	public static void main(String[] args) {
		LinkedList_2D root = new LinkedList_2D(0);
		LinkedList_2D ll1 = new LinkedList_2D(1);
		LinkedList_2D ll2 = new LinkedList_2D(2);
		LinkedList_2D ll3 = new LinkedList_2D(3);
		LinkedList_2D ll4 = new LinkedList_2D(4);
		LinkedList_2D ll5 = new LinkedList_2D(5);

		root.next = ll1;
		ll1.next = ll2;
		ll2.next = ll3;
		ll3.next = ll4;
		ll4.next = ll5;
		ll5.next = null;

		ll1.arbitrary = ll3;
		ll2.arbitrary = ll1;
		ll3.arbitrary = ll5;
		ll4.arbitrary = ll4;
		ll5.arbitrary = ll2;

		LinkedList_2D newLL = ll1.copyLinkedList(ll1);
		ll1.printLinkedList(ll1);
		System.out.println("\n\n\n");
		ll1.printLinkedList(newLL);

	}
}