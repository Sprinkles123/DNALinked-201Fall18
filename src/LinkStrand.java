
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

		public LinkStrand(){
			this("");
		}

		public LinkStrand(String s) {
			initialize(s);
		}

	@Override
	public void initialize(String s) {
		myFirst = new Node(s);
		myLast=myFirst;
		myAppends = 0;
		mySize=0;
	}

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
		return null;
	}


	@Override
	public char charAt(int index) {
		return 0;
	}

}
