/**
 * 
 */
package com.javaoopdata.doublylinkedlist;

/**
 * @author ccomstock
 *
 */
public class DoublyLinkedList {
	private Node head;
    private Node tail;
    private int length;
    
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }
    
    public boolean contains(int value) {
    	return indexOf(value) >= 0;
    }
    
    public int size() { return this.length; }
    public boolean isEmpty() { return this.length == 0; }
    
    public int indexOf(int value) {
    	Node current = this.head;
    	int index = 0;
    	while(current != null) {
    		if(current.value == value) return index;
    		current = current.next;
    		index++;
    	}
    	return -1;
    }
    
    public Integer get(int index) {
    	Node temp = getNodeAt(index);
    	if(temp != null) return temp.value;
    	else return null;
    }
    
    private Node getNodeAt(int index) throws IndexOutOfBoundsException {
    	if(index < 0 || index >= this.length) throw new IndexOutOfBoundsException();
    	
    	//if(this.head == null) return null;
    	//if(index == 0) return this.head;
    	//if(index == this.length-1) return this.tail;
    	
    	Node current;
    	int currIdx;
    	if(this.length - index < index) {
    		current = this.tail;
    		currIdx = this.length - 1;
    		while(currIdx > index) {
    			currIdx--;
    			current = current.previous;
    		}
    	}
    	else {
    		current = this.head;
    		currIdx = 0;
    		while(currIdx < index) {
    			currIdx++;
    			current = current.next;
    		}
    	}
		return current;
    }
    
    public void insertAt(Integer value, int index) {
    	insertNodeAt(new Node(value), index);
    }
    
    private void insertNodeAt(Node newNode, int index) throws IndexOutOfBoundsException {
    	if(newNode == null) return;
    	if(index < 0 || index > this.length) throw new IndexOutOfBoundsException();
    	
    	if(isEmpty() || index == this.length) {
    		this.pushNode(newNode);
    		return;
    	}
    	
    	if(index == 0) {
    		newNode.next = this.head;
    		this.head.previous = newNode;
    		this.head = newNode;
    		this.length++;
    		return;
    	}
    	
    	Node toPush = getNodeAt(index);
    	Node prev = toPush.previous;
    	prev.next = newNode;
    	newNode.previous = toPush.previous;
    	newNode.next = toPush;
    	toPush.previous = newNode;
    	this.length++;
    	
//    	Node current;
//    	int cursor;
//    	if(this.length - index < index) {
//    		current = this.tail;
//    		cursor = this.length;
//    		while(cursor > index) {
//    			cursor--;
//    			current = current.previous;
//    		}
//    	}
//    	else {
//    		current = this.head;
//    		cursor = 1;
//    		while(cursor < index) {
//    			cursor++;
//    			current = current.next;
//    		}
//    	}
//		Node temp = current.next;
//		newNode.previous = current;
//		newNode.next = temp;
//		current.next = newNode;
//		temp.previous = newNode;
//		this.length++;
//		return;
    }
    
    public Integer removeAt(int index) {
    	Node temp = removeNodeAt(index);
    	if(temp != null) return temp.value;
    	else return null;
    }
    
    private Node removeNodeAt(int index) throws IndexOutOfBoundsException {
    	if(index < 0 || index >= this.length) throw new IndexOutOfBoundsException();
    	
    	if(index == this.length - 1) {
    		return this.popNode();
    	}
    	
    	Node removeNode;
    	if(index == 0) {
    		removeNode = this.head;
    		this.head = this.head.next;
    		this.head.previous = null;
    		removeNode.next = null;
    		this.length--;
    		return removeNode;
    	}
    	
    	removeNode = this.getNodeAt(index);
    	Node tempPrev = removeNode.previous;
    	Node tempNext = removeNode.next;
    	tempPrev.next = tempNext;
    	tempNext.previous = tempPrev;
    	this.length--;
    	return removeNode;
    }
    
    public void push(Integer value) {
    	pushNode(new Node(value));
    }
    
    // the push method will add a new node to the end of the list
    private void pushNode(Node newNode) {
    	if(newNode == null) return;
        // if there is no head in the list, aka, an empty list, we set the newNode to be the head and tail of the list
        if(isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
            this.length++;
            return;
        }
        
        // first find the lastNode in the list
        // then, set the lastNode's next to be the newNode;
        // then, we have to set the previous of the lastNode to the lastNode that we found previously.
        // finally, set the list's tail to be the node that we have added
        Node lastNode = this.tail;
        lastNode.next = newNode;
        newNode.previous = lastNode;
        this.tail = newNode;
        this.length++;
    }
    
    public Integer pop() {
    	Node temp = popNode();
    	if(temp != null) return temp.value;
    	else return null;
    }
    
    private Node popNode() {
    	if(isEmpty()) return null;
    	Node lastNode = this.tail;
    	if(this.length == 1) {
    		this.head = null;
            this.tail = null;
            this.length--;
            return lastNode;
    	}
    	this.tail = lastNode.previous;
    	this.tail.next = null;
    	lastNode.previous = null;
        this.length--;
    	return lastNode;
    }
    
    public void printValuesForward() {
        // find the first node, aka head.
        Node current = this.head;
        
        // while the current node exists...
        while(current != null) {
            // print it's value
            System.out.println(current.value);
            // and move on to it's next node.
            current = current.next;
        }
    }
    
    public void printValuesBackward() {
    	Node current = this.tail;
    	while(current != null) {
    		System.out.println(current.value);
    		current = current.previous;
    	}
    }
}
