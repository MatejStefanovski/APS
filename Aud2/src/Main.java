class SLLNode<E> {
    protected E element;
    protected SLLNode<E> succ;

    public SLLNode(E elem, SLLNode<E> succ) {
        this.element = elem;
        this.succ = succ;
    }

    @Override
    public String toString() {
        return element.toString();
    }
}

class SLL<E> {
    private SLLNode<E> first;

    public SLL() {
        first = null;
    }

    public void insertLast(E elem) {
        if (first == null) {
            first = new SLLNode<>(elem, null);
        } else {
            SLLNode<E> tmp = first;
            while (tmp.succ != null)
                tmp = tmp.succ;
            tmp.succ = new SLLNode<>(elem, null);
        }
    }

    public void mirror() {
        SLLNode<E> prev = null;
        SLLNode<E> current = first;
        SLLNode<E> next = null;

        while (current != null) {
            next = current.succ;  // store next
            current.succ = prev;  // reverse the link
            prev = current;       // move prev one step
            current = next;       // move current one step
        }

        first = prev; // new head is the old tail
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        SLLNode<E> tmp = first;
        while (tmp != null) {
            sb.append(tmp.element);
            if (tmp.succ != null) sb.append(" -> ");
            tmp = tmp.succ;
        }
        return sb.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        SLL<String> lista = new SLL<>();
        lista.insertLast("ovaa");
        lista.insertLast("lista");
        lista.insertLast("kje");
        lista.insertLast("bide");
        lista.insertLast("prevrtena");

        System.out.println("Listata pred da bide prevrtena: " + lista.toString());
        lista.mirror();
        System.out.println("Listata otkako e prevrtena: " + lista.toString());
    }
}
