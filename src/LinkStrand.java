
public class LinkStrand implements IDnaStrand {
	
	/*
	 * Private inner class Node which will initialize a node object with field info 
	 * and field next, which is a pointer to another node
	 * @param String s which is the info included
	 */
	 private class Node {
	       String info;
	       Node next;
	       public Node(String s) {
	          info = s;
	          next = null;
	       }
	   }
	   private Node myFirst,myLast;
	   private long mySize;
	   private int myAppends;
	   
		/*
		 * Default Link Strand constructor. initializes a string object as an empty
		 * string
		 */

		public LinkStrand(){
			this("");
		}
		
		/*
		 * LinkStrand constructor. Calls initialize on String s to create a LinkStrand 
		 * with the same value as the source 
		 */


		public LinkStrand(String s) {
			initialize(s);
		}
	
		/**
		 * Initialize this strand so that it represents the value of source. No
		 * error checking is performed.
		 * 
		 * @param source
		 *            is the source of this enzyme
		 */

	@Override
	public void initialize(String s) {
		myFirst = new Node(s);
		myLast=myFirst;
		myAppends = 0;
		mySize=0;
	}

	/**
	 * returns new linkedList
	 */
	
	@Override
	public IDnaStrand getInstance(String s) {
		return new LinkStrand(s);
	}

	@Override
	public long size() {
		return size();
		
	}
	
	@Override
	public int getAppendCount() {
		return myAppends;
	}

	@Override
	public IDnaStrand append(String dna) {
		myLast=myLast.next;
		mySize=mySize + (long) dna.length();
		myAppends++;
		return this;
	}
	
	public String toString() {
		StringBuilder sB= new StringBuilder();
		Node myCurrent = myFirst;
		while(myCurrent !=null) {
			sB.append(myCurrent.info);
			myCurrent=myCurrent.next;}
		return sB.toString();
		
	}
	
	@Override
	public IDnaStrand reverse() {
		Node firstNode = this.myFirst;
		Node lastNode = this.myLast; 
		
		Node list = firstNode;
		Node head = firstNode;
		
		String DNA = head.info;
		StringBuilder copy = new StringBuilder(DNA);
		copy.reverse();
		StringStrand reverseDNA = new StringStrand(copy.toString());
		head.info = reverseDNA;
		break;
			
			
		String DNA = head.info;
		String reverseDNA;
		for(int i = DNA.length() -1; i >= 0; i --) {
			reverseDNA += reverseDNA.charAt(i);
				
		}
		
			

//		System.out.println(head);
		
		
		return head;
	}


	@Override
	public char charAt(int index) {
		return 0;
	}

}
