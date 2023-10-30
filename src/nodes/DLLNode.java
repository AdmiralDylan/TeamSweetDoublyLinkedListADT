package nodes;

public class DLLNode<E> {

	  private E data;
	  private DLLNode<E> next;
	  private DLLNode<E> prev;
	  
	  public DLLNode(E data) {
	    this.data = data;
	    next = null;
	    prev = null;
	  }
	 
	  public void setData(E data) {
	    this.data = data;
	  }

	  public E getData() {
	    return data;
	  }
	 
	  public void setNext(DLLNode<E> reference) {
	    this.next = reference;
	  }

	  public DLLNode<E> getNext() {
	    return next;
	  }

	  public void setPrev(DLLNode<E> reference) {
	    this.prev = reference;
	  }

	  public DLLNode<E> getPrev() {
	    return prev;
	  }
}
