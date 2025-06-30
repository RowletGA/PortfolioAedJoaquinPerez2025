package Modelos;

public class BinaryTree {
    public TreeNode root;

    public BinaryTree() {
        this.root = null;
    }

    public BinaryTree(TreeNode root) {
        this.root = root;
    }

    public void sustituirYEvaluar(TreeNode nodo, int obtenerValorVariable) {
        if (nodo == null) {
            return;
        }

        if (nodo.value.equals("+")) {
            nodo.value = Integer.toString(Integer.parseInt(nodo.left.value) + Integer.parseInt(nodo.right.value));
            nodo.left = null;
            nodo.right = null;
        } else if (nodo.value.equals("-")) {
            nodo.value = Integer.toString(Integer.parseInt(nodo.left.value) - Integer.parseInt(nodo.right.value));
            nodo.left = null;
            nodo.right = null;
        } else if (nodo.value.equals("*")) {
            nodo.value = Integer.toString(Integer.parseInt(nodo.left.value) * Integer.parseInt(nodo.right.value));
            nodo.left = null;
            nodo.right = null;
        } else if (nodo.value.equals("/")) {
            nodo.value = Integer.toString(Integer.parseInt(nodo.left.value) / Integer.parseInt(nodo.right.value));
            nodo.left = null;
            nodo.right = null;
        } else if (nodo.value.equals("variable")) {
            nodo.value = Integer.toString(obtenerValorVariable);
        }
    }
    public void insert(TreeNode nodo) {
        if (root == null) {
            root = nodo;
        } else {
            insert(root, nodo);
        }
    }
    
    private void insert(TreeNode actual, TreeNode nodo) {
        if (actual.left == null) {
            actual.left = nodo;
        } else if (actual.right == null) {
            actual.right = nodo;
        } else {
            // Si ambos hijos ya están ocupados, intenta insertar en el hijo izquierdo
            insert(actual.left, nodo);
        }
    }
    
 public void insert(String value) {
        TreeNode nodo = new TreeNode(value);
        insert(nodo);
    }
    public void print(TreeNode nodo) {
        if (nodo == null) {
            return;
        }
        System.out.println(nodo.value);
        print(nodo.left);
        print(nodo.right);
    }
    public void print() {
        print(root);
    }

    
}
