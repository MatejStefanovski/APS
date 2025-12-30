import java.util.*;

interface Stack<E> {

    // Elementi na stekot se objekti od proizvolen tip.

    // Metodi za pristap:

    public boolean isEmpty ();
    // Vrakja true ako i samo ako stekot e prazen.

    public E peek ();
    // Go vrakja elementot na vrvot od stekot.

    // Metodi za transformacija:

    public void clear ();
    // Go prazni stekot.

    public void push (E x);
    // Go dodava x na vrvot na stekot.

    public E pop ();
    // Go otstranuva i vrakja elementot shto e na vrvot na stekot.
}

class ArrayStack<E> implements Stack<E> {
    private E[] elems;
    private int depth;

    @SuppressWarnings("unchecked")
    public ArrayStack (int maxDepth) {
        // Konstrukcija na nov, prazen stek.
        elems = (E[]) new Object[maxDepth];
        depth = 0;
    }


    public boolean isEmpty () {
        // Vrakja true ako i samo ako stekot e prazen.
        return (depth == 0);
    }


    public E peek () {
        // Go vrakja elementot na vrvot od stekot.
        if (depth == 0)
            throw new NoSuchElementException();
        return elems[depth-1];
    }


    public void clear () {
        // Go prazni stekot.
        for (int i = 0; i < depth; i++)  elems[i] = null;
        depth = 0;
    }


    public void push (E x) {
        // Go dodava x na vrvot na stekot.
        elems[depth++] = x;
    }


    public E pop () {
        // Go otstranuva i vrakja elementot shto e na vrvot na stekot.
        if (depth == 0)
            throw new NoSuchElementException();
        E topmost = elems[--depth];
        elems[depth] = null;
        return topmost;
    }
}

class BNode<E> {

    public E info;
    public BNode<E> left;
    public BNode<E> right;

    static int LEFT = 1;
    static int RIGHT = 2;

    public BNode<E> parent;
    public BNode(E info, BNode<E> parent) {
        this.parent = parent;
        this.info = info;
        left = null;
        right = null;
    }
    public BNode(E info) {
        this.parent = null;
        this.info = info;
        left = null;
        right = null;
    }

    public BNode(E info, BNode<E> left, BNode<E> right) {
        this.info = info;
        this.left = left;
        this.right = right;
    }

}

class BTree<E> {

    public BNode<E> root;

    public BTree() {
        root = null;
    }

    public BTree(E info) {
        root = new BNode<E>(info);
    }

    public void makeRoot(E elem) {
        root = new BNode<E>(elem);
    }

    public BNode<E> addChild(BNode<E> node, int where, E elem) {

        BNode<E> tmp = new BNode<E>(elem, node);

        if (where == BNode.LEFT) {
            if (node.left != null)  // veke postoi element
                return null;
            node.left = tmp;
        } else {
            if (node.right != null) // veke postoi element
                return null;
            node.right = tmp;
        }

        return tmp;
    }

    public void inorder() {
        System.out.print("INORDER: ");
        inorderR(root);
        System.out.println();
    }

    public void inorderR(BNode<E> n) {
        if (n != null) {
            inorderR(n.left);
            System.out.print(n.info.toString()+" ");
            inorderR(n.right);
        }
    }

    public void preorder() {
        System.out.print("PREORDER: ");
        preorderR(root);
        System.out.println();
    }

    public void preorderR(BNode<E> n) {
        if (n != null) {
            System.out.print(n.info.toString()+" ");
            preorderR(n.left);
            preorderR(n.right);
        }
    }

    public void postorder() {
        System.out.print("POSTORDER: ");
        postorderR(root);
        System.out.println();
    }

    public void postorderR(BNode<E> n) {
        if (n != null) {
            postorderR(n.left);
            postorderR(n.right);
            System.out.print(n.info.toString()+" ");
        }
    }

    public void inorderNonRecursive() {
        ArrayStack<BNode<E>> s = new ArrayStack<BNode<E>>(100);
        BNode<E> p = root;
        System.out.print("INORDER (nonrecursive): ");

        while (true) {
            // pridvizuvanje do kraj vo leva nasoka pri sto site koreni
            // na potstebla se dodavaat vo magacin za podocnezna obrabotka
            while (p != null) {
                s.push(p);
                p = p.left;
            }

            // ako magacinot e prazen znaci deka stebloto e celosno izminato
            if (s.isEmpty())
                break;

            p = s.peek();
            // pecatenje (obrabotka) na jazelot na vrvot od magacinot
            System.out.print(p.info.toString()+" ");
            // brisenje na obraboteniot jazel od magacinot
            s.pop();
            // pridvizuvanje vo desno od obraboteniot jazel i povtoruvanje na
            // postapkata za desnoto potsteblo na jazelot
            p = p.right;

        }
        System.out.println();

    }

    int insideNodesR(BNode<E> node) {
        if (node == null)
            return 0;

        if ((node.left == null)&&(node.right == null))
            return 0;

        return insideNodesR(node.left) + insideNodesR(node.right) + 1;
    }

    int listoviR(BNode<E> node) {
        if (node == null)
            return 0;

        if ((node.left == null)&&(node.right == null))
            return 1;  // ova e list, nema deca

        //ako ne e list, ke vleze vo sledno:
        return insideNodesR(node.left) + insideNodesR(node.right);
    }

    int dlabocinaR(BNode<E> node) {
        if (node == null)
            return 0;

        if ((node.left == null)&&(node.right == null))
            return 1;  // ova e list, nema deca

        //ako ne e list, ke presmeta max dlabocina od levo i desno
        return Math.max(dlabocinaR(node.left) ,
                dlabocinaR(node.right))+1;
    }


    public int insideNodes() {
        return listoviR(root);
    }

    int leavesR(BNode<E> node) {
        if (node != null) {
            if ((node.left == null)&&(node.right == null))
                return 1;
            else
                return (leavesR(node.left) + leavesR(node.right));
        } else {
            return 0;
        }
    }

    public int leaves() {
        return leavesR(root);
    }

    int depthR(BNode<E> node) {
        if (node == null)
            return 0;
        if ((node.left == null)&&(node.right == null))
            return 0;
        return (1 + Math.max(depthR(node.left), depthR(node.right)));
    }

    public int depth() {
        return depthR(root);
    }

    void mirrorR(BNode<E> node) {
        BNode<E> tmp;

        if (node == null)
            return;

        // simetricno preslikuvanje na levoto i desnoto potsteblo
        mirrorR(node.left);
        mirrorR(node.right);

        // smena na ulogite na pokazuvacite na momentalniot jazel
        tmp = node.left;
        node.left = node.right;
        node.right = tmp;

    }

    private BNode<E> findR(BNode<E> node, E what){

        if (node==null){  //ako ne postoi jazol, vrati null
            return null;
        }

        // ako si go nasol toa sto go baras, vrati go jazolot
        if(node.info.equals(what)){
            return node;
        }

        //baraj levo
        BNode<E> found=findR(node.left, what);
        if(found!=null){  //ako si go nasol levo
            return found; //vrati go
        }

        //baraj desno
        found=findR(node.right, what);
        if(found!=null) { //ako si go nasol desno
            return found; //vrati go

        }
        return null; //go nema kaj nas i kaj nasite deca, vrati null

    }

    public void preorderIterative(){
        //inorder:  koren, levo, desno

        BNode<E> current=root;

        ArrayStack<BNode<E>> stack= new ArrayStack<BNode<E>>(100);

        stack.push(current);
        while (!stack.isEmpty()){


            current=stack.pop();
            System.out.println(current.info.toString());//printaj go momentalniot
            //prvo desno
            if(current.right!=null){
                stack.push(current.right);
            }
            //pa levo, zatoa sto sledniot stack pop ke go izvadi prvo posledniot
            if(current.left!=null){
                stack.push(current.left);
            }
        }



    }

    public BNode<E> find(E what){
        return findR(root,what);

    }




    public void mirror() {
        mirrorR(root);
    }


}

public class NeparnaDlabocina {
    static int maxSuma = 0;
    static int soberi(BNode<Integer> node, int d){
        if (node == null){
            return 0;
        }
        int sum = 0;
        if (d%2==1){
            sum += node.info;
        }
        sum += soberi(node.left, d+1);
        sum += soberi(node.right, d+1);
        return sum;
    }
    static void funkcija(BNode<Integer> node, int d) {
        if (node == null) {
            return;
        }
        maxSuma = Math.max(maxSuma, soberi(node, d));
        funkcija(node.left, d+1);
        funkcija(node.right, d+1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BTree<Integer> tree = new BTree<>();
        int n = sc.nextInt();
        int root = sc.nextInt();
        tree.makeRoot(root);
        for (int i = 0; i < n-1; i++) {
            int parent = sc.nextInt();
            int child = sc.nextInt();
            int strana = sc.next().equals("LEFT") ? 1:2;
            BNode<Integer> node = tree.find(parent);
            tree.addChild(node, strana, child);
        }
        funkcija(tree.root, 0);
        System.out.println(maxSuma);
    }
}
