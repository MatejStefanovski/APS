/*
Задача 3. Сума на сите патишта од корен до лист
Нека е дадено бинарно дрво кое се состои од цифрите 1-9. Да се напише функциjа
коjа што ´ке jа пресмета сумата на сите броеви кои се формираат на патот од
коренот до соодветниот лист на дрвото.
Пример:
Влез:
7
4
4 2 LEFT
4 7 RIGHT
2 1 LEFT
2 3 RIGHT
7 6 LEFT
7 9 RIGHT

Излез:
421
+423
+476
+479
----
1799

*/

import java.util.Scanner;

public class SumaPatista {
    static int rez=0;
    static String concatenate="";
    static void Presmetaj(BNode<Integer> node){
        if (node==null){
            return;
        }
        concatenate+=node.info;
        if (node.left == null && node.right == null){
            rez+=Integer.parseInt(concatenate);
        }
        else {
            Presmetaj(node.left);
            Presmetaj(node.right);
        }
        concatenate = concatenate.substring(0,concatenate.length()-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n =  sc.nextInt();
        BTree<Integer> tree = new BTree<>();
        int root = sc.nextInt();
        tree.makeRoot(root);
        for (int i=0; i<n-1; i++){
            int parent = sc.nextInt();
            int child = sc.nextInt();
            int strana = sc.next().equals("LEFT") ? 1:2;
            BNode<Integer> parentNode = tree.find(parent);
            tree.addChild(parentNode, strana, child);
        }
        Presmetaj(tree.root);
        System.out.println(rez);
    }
}
