package algo.tree_binary;

import java.util.ArrayList;

/**
 * Класс отвечающий за хранение 1 ноды в дереве.
 */
class Node {
    long key;   // Тот элемент по которому в дереве идет сортировка
    Node l;
    Node r;
    Node parent;

    public Node(long key, Node parent) {
        this.key = key;
        this.parent = parent;
        this.l = null;
        this.r = null;
    }
}

/**
 * Двоичное дерево поиска (BST).
 * Данный алгоритм не поддерживает дерево сбалансированным!!!
 * Это значит что функции добавления и удаления могут достигать сложности O(n).
 * Асимптотика других функций O(log(n))
 */
class Tree {
    Node root;

    public Tree() {
        root = null;
    }

    public static Node fromList(ArrayList<Long> data, long l, long r) {
        if (l + 1 > r) return null;
        if (l + 1 == r) {
            return new Node(data.get((int) l), null);
        }
        int m = (int) ((l + r) / 2);
        Node t = new Node(data.get(m), null);
        t.l = fromList(data, l, m);
        t.r = fromList(data, m + 1, r);
        if (t.l != null) {
            t.l.parent = t;
        }
        if (t.r != null) {
            t.r.parent = t;
        }
        return t;
    }


    /**
     * Формирует сбалансированное дерево поиска на основе отсортированного массива.
     */
    public static Tree fromList(ArrayList<Long> data) {
        Tree tree = new Tree();
        tree.root = fromList(data, 0, data.size());
        return tree;
    }

    Node find(Node v, long key) {
        if (v == null) return null;
        if (v.key == key) return v;
        if (v.key > key) {
            return find(v.l, key);
        } else {
            return find(v.r, key);
        }
    }

    Node find(long key) {
        return find(root, key);
    }

    void add(long key) {
        if (root == null) {
            root = new Node(key, null);
            return;
        }
        add(root, key);
    }

    private void add(Node v, long key) {
        if (v == null) return;
        if (key < v.key) {
            if (v.l == null) {
                v.l = new Node(key, v);
                return;
            }
            add(v.l, key);      // Идем в левого сына
        } else {
            if (v.r == null) {
                v.r = new Node(key, v);
                return;
            }
            add(v.r, key);
        }
    }

    void delete(long key) {
        if (root == null) return;
        Node t = find(key);
        if (t == null) return;
        delete(t);
    }

    void delete(Node t) {
        if (t == null) return;
        if ((t.l == null) || (t.r == null)) {
            Node child = null;
            if (t.l != null) {
                child = t.l;
            } else {
                child = t.r;
            }
            if (t == root) {
                root = child;
                if (child != null) {
                    child.parent = null;
                }
            }
            if (t.parent.l == t) {
                t.parent.l = child;
            } else {
                t.parent.r = child;
            }
            if (child != null) {
                child.parent = t.parent;
            }
        } else {
            // Оба ребенка есть
            // Ищем следующий эл-т по порядку за вершиной
            Node nxt = t.r;
            while (nxt.l != null) {
                nxt = nxt.l;
            }
            t.key = nxt.key;
            delete(nxt);
        }
    }

    Node next(Node v) {
        if (v == null) return null;
        if (v.r != null) {
            Node nxt = v.r;
            while (nxt.l != null) {
                nxt = nxt.l;
            }
            return nxt;
        } else {
            // Поднимаемся вверх
            Node nxt = v;
            while ((nxt.parent != null) && (nxt.parent.r == nxt)) {
                nxt = nxt.parent;
            }
            return nxt.parent;
        }
    }

    void print(Node v) {
        if (v == null) return;
        print(v.l);
        System.out.println(v.key);
        print(v.r);
    }

    void print() {
        print(root);
    }

    boolean check() {
        return check(root, null, null);
    }

    boolean check(Node v, Long l, Long r) {
        if (v == null) return true;
        if ((l != null) && (v.key < l)) return false;
        if ((r != null) && (v.key > r)) return false;
        return check(v.l, l, v.key) && check(v.r, v.key, r);
    }
}

public class TreeBinary {
}
