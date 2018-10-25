import java.util.Iterator;


/*
 * Private inner class Node which will initialize a node object with field info 
 * and field next, which is a pointer to another node
 * @param String s which is the info included
 */
public class LinkStrand implements IDnaStrand {
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
	   private int myIndex;
	   private Node myCurrent;
	   private int myLocalIndex;
	   
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
		 * @param s is the source of this enzyme
		 */
	@Override
	public void initialize(String s) {
		myFirst = new Node(s);
		myLast = myFirst;
		myAppends = 0;
		mySize = s.length();
		myIndex = 0;
		myLocalIndex = 0;
		myCurrent = myFirst;
	}


	/**
	 * returns new IDNAStrand which has as info string s;
	 * @Param: DNA String s which is a DNA sequence
	 */
	@Override
	public IDnaStrand getInstance(String s) {
		return new LinkStrand(s);
	}

	/**
	 * @return the number of base pairs in this strand;
	 */
	@Override
	public long size() {
		return mySize;		
	}
	
	/**
	 * @return the number of times the IDNAStrand object has been appended to
	 */
	@Override
	public int getAppendCount() {
		return myAppends;
	}

	/**
	 * Append a strand of dna data to this strand. No error checking is
	 * done. This method is efficient; it uses a StringBuilder or a
	 * StringBuffer.
	 * 
	 * @param dna is the String appended to this strand
	 */
	@Override
	public IDnaStrand append(String dna) {
		Node next = new Node(dna);
		myLast = next;
		
		mySize += (long) dna.length();
		myAppends++;
		return this;
	}
	
	/**
	 * return the DNA sequence stored in the linked list as a string by 
	 * iterating over the linked list in appending the info fields to a 
	 * string builder object
	 */
	public String toString() {
		StringBuilder sB= new StringBuilder();
		Node myCurrenttoString = myFirst;
		while(myCurrenttoString !=null) {
			sB.append(myCurrenttoString.info);
			myCurrenttoString=myCurrenttoString.next;
		}
		return sB.toString();
	}
	
	/**
	 * Reverses the order of the IDNAStrand object and reverses the order
	 * of the sequences inside the Nodes of the object. The result is a 
	 * reversed LinkedList with all of the info fields reversed.
	 */
	@Override
	public IDnaStrand reverse() {
		Node myCurrentF=myFirst;
		Node myCurrentL=myLast;
		Node nn=null;
		
		StringBuilder sB =new StringBuilder(myCurrentF.info);
		sB.reverse();
		LinkStrand ls = new LinkStrand(sB.toString());
		myCurrentF=myCurrentF.next;
		
		while(myCurrentF!=null) {
			sB =new StringBuilder(myCurrentF.info);
			sB.reverse();
			ls.append(sB.toString());
			myCurrentF=myCurrentF.next;
		}
		nn=ls.myFirst;
		Node ntemp =null;
		Node rNode=null;
		ls.myFirst=ls.myLast;
		 
		while(nn != null) {
			ntemp = nn.next;
			nn.next= rNode;
			rNode=nn;
			ls.myFirst=rNode;
			nn=ntemp;
		}
		return ls;
	}

	@Override
	public char charAt(int index) {
<<<<<<< HEAD
		//efficient
		if (index <= myIndex) {
			myLocalIndex = 0; 
			myIndex = 0;
			myCurrent = myFirst;
		}
		if(myIndex == index) {
			
		}
		
		if(index > mySize) {
			throw new RuntimeException("error: index out of bounds");
		}
		while (myIndex != index) {
			myLocalIndex++;
			myIndex++;
			System.out.println(myLocalIndex);
			System.out.println(myCurrent.info.length());
			System.out.println(myIndex);
			
			if (myLocalIndex >= myCurrent.info.length()) {
				if (myCurrent.next == null) {
					throw new RuntimeException("error: myCurrent is Null");
				}
				myLocalIndex = 0;
				myCurrent = myCurrent.next;
				System.out.println("kyle");
				
=======
		
		LinkStrand dna = new LinkStrand(".....");
		Iterator<Character> iter= dna.iterator();
		while (iter.hasNext()) {
			myLocalIndex++;
			myIndex++;
			if (myCurrent.next !=null && myLocalIndex >= myCurrent.info.length()) {
				myLocalIndex = 0;
				myCurrent = myCurrent.next;
				 System.out.print(iter.next());
>>>>>>> b236a61d0eb1ca88bebaee5e6f7b32ea583e3705
			}
			
		}
		System.out.println();
		return myCurrent.info.charAt(myLocalIndex);
	}
}