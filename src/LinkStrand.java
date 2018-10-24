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
		int myIndex=0;
		int myLocalIndex;
		Node myCurrent;
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

		return ls;}


	@Override
	public char charAt(int index) {
		//inefficent
			int count = 0;
			        int dex = 0;
			        Node list = myFirst;
			        while (count != index) {
			            count++;
			            dex++;
			            if (dex >= list.info.length()) {
			                dex = 0;
			                list = list.next;
			            }
			        }
			           return list.info.charAt(dex);
			        }

	}

}
