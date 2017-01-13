package topTenAlgorithm;

public class SortedLinkedListToBinaryTree {
	public static void main(String[] args) {
		LinkedList n = new LinkedList();
		for (int i = 7; i > 0; i--) {
			n.push(i);
		}
		n.nodeCount(n.head);
	}
}

class LinkedList {

	static LNode head;

	class LNode {
		int data;
		LNode prev, next;

		LNode(int n) {
			data = n;
			prev = next = null;
		}
	}

	class TNode {
		int data;
		TNode root, left, right;

		TNode(int n) {
			data = n;
			left = right = null;
		}

	}

	int nodeCount(LNode n) {
		int count = 0;
		LNode temp = head;
		while (temp != null) {
			System.out.println("data = " + temp.data);
			temp = temp.next;
			count++;
		}
		return count;
	}

	void push(int data) {
		LNode newNode = new LNode(data);
		newNode.next = head;
		if (head != null)
			head.prev = newNode;
		head = newNode;
	}

	void printList(LNode n) {
		LNode tmp = n;
		while (tmp != null) {
			System.out.print(tmp.data + " ");
			tmp = tmp.next;
		}
		System.out.println();
	}

	TNode LLtoBT(int n) {
		LNode tmp = null;
		TNode L, R;
		TNode root = null;
		if (n <= 0) {
			return null;
		}
		L = LLtoBT(n / 2);
		root = new TNode(head.data);
		head = head.next;
		root.right = LLtoBT(n - (n / 2) - 1);
		return root;
	}
}