/**
 * 
 */
package com.javaoopdata.doublylinkedlist;

/**
 * @author ccomstock
 *
 */
public class DLLTest {
	
	private static int testVal = 50;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("\n***testing push/pop with dll1***");
		DoublyLinkedList dll1 = new DoublyLinkedList();
        dll1.pop();
//        displayDll(dll1);
        dll1.push(10);
//        displayDll(dll1);
        dll1.pop();
//        displayDll(dll1);
        dll1.push(10);
        dll1.push(20);
//        displayDll(dll1);
        dll1.pop();
//        displayDll(dll1);
        dll1.push(20);
        dll1.push(30);
//        displayDll(dll1);
        dll1.pop();
        displayDll(dll1);
        testContains(dll1);
        System.out.println("The last value in the list is " + dll1.get(dll1.size()-1));

		System.out.println("\n***testing insertAt/removeAt with dll2***");
        DoublyLinkedList dll2 = new DoublyLinkedList();
//        displayDll(dll2);
        dll2.insertAt(99, 0);	//insert at 0 when empty
//        displayDll(dll2);
        dll2.removeAt(0);		//remove at 0 when only 1
//        displayDll(dll2);
        dll2.push(11);
//        displayDll(dll2);
        dll2.insertAt(100, 0);	//insert at 0 when only 1
//        displayDll(dll2);
        dll2.pop();
//        displayDll(dll2);
        dll2.insertAt(10, 1);	//insert at 1 when only 1
//        displayDll(dll2);
        dll2.insertAt(22, 2);	//insert at end when multiple
//        displayDll(dll2);
        dll2.removeAt(0);		//remove at 0 when multiple
//        displayDll(dll2);
        dll2.insertAt(0, 0);	//insert at 0 when multiple
//        displayDll(dll2);
        dll2.removeAt(2);		//remove at end when multiple
//        displayDll(dll2);
        dll2.push(50);
        dll2.push(30);
        dll2.push(40);
        dll2.push(20);
        dll2.push(60);
        displayDll(dll2);
        dll2.removeAt(2);		//remove at first half of middle
//        displayDll(dll2);
        dll2.insertAt(50, 5);	//insert at last half of middle
//        displayDll(dll2);
        dll2.removeAt(4);		//remove at last half of middle
//        displayDll(dll2);
        dll2.insertAt(20, 2);	//insert at first half of middle
        displayDll(dll2);
        testContains(dll2);
	}
	
	public static void displayDll(DoublyLinkedList dll) {
    	System.out.println();
        dll.printValuesForward();
        System.out.println("length == " + dll.size());
	}
	
	public static void testContains(DoublyLinkedList dll) {
		if(dll.contains(testVal)) {
        	System.out.printf("\nthe list contains the value %d at index %d\n", testVal, dll.indexOf(testVal));
		}
        else
        	System.out.println("\nthe list doesn't contain the value " + testVal);
	}

}
