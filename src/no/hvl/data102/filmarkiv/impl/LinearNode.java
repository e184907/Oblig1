package no.hvl.data102.filmarkiv.impl;

public class LinearNode<T> {
	public T element;
	public LinearNode<T> neste;
	
	public LinearNode(T data) {
		this.element = data;
		this.neste = null;
		
	}
	public T getElement() {
		return element;
	}
	public void setElement(T element) {
		this.element = element;
	}
	public LinearNode<T> getNeste(){
		return neste;
	}
	public void setNeste(LinearNode<T> neste) {
		this.neste = neste;
	}
}

