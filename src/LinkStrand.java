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
		 * 
		 * @param source
		 *            is the source of this enzyme
		 */
	@Override
	public void initialize(String s) {
		myFirst = new Node(s);
		myLast=myFirst;
		myAppends = 0;
		mySize= s.length();
		myIndex=0;
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
		LinkStrand.Node next = new LinkStrand.Node(dna);
		myLast.next = next;
		mySize = mySize + (long) dna.length();
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
		Node myCurrent = myFirst;
		while(myCurrent !=null) {
			sB.append(myCurrent.info);
			myCurrent=myCurrent.next;
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


//	@Override
//	public int charAt(int index) {
//		int count = 0;
//		int dex = 0;
//		Node list = myFirst;
//		while (count != index) {
//			count++;
//			dex++;
//			if (dex >= list.info.length()) {
//						dex = 0;
//						list = list.next;
//			}
//		}
//		return list.info.charAt(dex);
//	}
//}
	@Override
	public char charAt(int index) {
		//efficient
		while (myLocalIndex != index) {
			myLocalIndex++;
			if (myLocalIndex >= myCurrent.info.length()) {
				myLocalIndex = 0;
				myCurrent = myCurrent.next;
			}
		}
		return myCurrent.info.charAt(myLocalIndex);
	}

}


