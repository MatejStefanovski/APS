package given;
public class DLLNode<E extends Comparable<E>> {
    protected E element;
    protected int appearance;
    protected DLLNode<E> pred, succ;
    public DLLNode(E elem, DLLNode<E> pred, DLLNode<E> succ) {
        this.element = elem;
        this.pred = pred;
        this.succ = succ;
        this.appearance = 1;
    }

    @Override
    public String toString() {
        return element.toString() +"("+appearance+")";
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public DLLNode<E> getPred() {
        return pred;
    }

    public void setPred(DLLNode<E> pred) {
        this.pred = pred;
    }

    public DLLNode<E> getSucc() {
        return succ;
    }

    public void setSucc(DLLNode<E> succ) {
        this.succ = succ;
    }
}


