import java.util.*;
import java.lang.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;;

public class Hw01 {

    public static Node root;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Character> choice = new ArrayList<Character>();
        ArrayList<Integer> value = new ArrayList<Integer>();
        int i = 0;
        int key = 0;

        System.out.println(args[0] + ".txt contains:");

        File file = new File(args[0] + ".txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                String[] parts = line.split(" ");
                choice.add(Character.toLowerCase(parts[0].charAt(0)));
                if (choice.get(i) == 'p' || choice.get(i) == 'q')
                    value.add(0);
                else
                    value.add(Integer.parseInt(parts[1]));

                i++;
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int j = 0; j < choice.size(); j++) {
            switch (choice.get(j)) {
            case 'i':
                // insert
                key = value.get(j);
                instertNode(key);

                break;

            case 'p':
                inOrderTraverseTree(root);
                System.out.println("");
                break;

            case 'd':
                // delete
                key = value.get(j);
                Node trash = deleteNode(root, key);
                break;

            case 's':
                // delete
                key = value.get(j);
                searchNode(key);
                break;

            case 'q':
                // quit
                break;

            }// end switch

        } // end for

        int count = 0;
        count = childrenCount(root.leftChild, count);
        System.out.println("left children:          " + count);
        int deph = 1;
        deph = getDeph(root.leftChild, deph);
        System.out.println("left depth:             " + deph);
        count = 0;
        count = childrenCount(root.rightChild, count);
        System.out.println("right children:         " + count);
        deph = 1;
        deph = getDeph(root.rightChild, deph);
        System.out.println("right depth:            " + deph);
        complexityIndicator();

    }// end main

    public static int getDeph(Node current, int deph) {
        if (current == null)
            return 0;
        int left = getDeph(current.leftChild, deph);
        int right = getDeph(current.rightChild, deph);
        return Math.max(left, right) + 1;
    }

    public static int childrenCount(Node current, int count) {

        if (root == null) {
            return 0;
        }

        if (current != null) {

            // Traverse the left node

            count = childrenCount(current.leftChild, count);

            // Visit the currently focused on node

            count++;

            // Traverse the right node

            count = childrenCount(current.rightChild, count);

        }

        return count;
    }// end children count

    public static void complexityIndicator() {
        System.err.println("ma666439;2.5;5");
    }// end comprexity indicator

    public static void searchNode(int key) {

        if (root == null) {
            System.out.println(key + ": NOT found");
            return;
        }

        Node current = root;

        boolean found = false;

        while (found == false) {

            // left side
            if (key < current.key) {
                if (current.leftChild == null) {
                    System.out.println(key + ": NOT found");
                    return;
                } // end if
                current = current.leftChild;
            } else if (key > current.key) {// right side
                if (current.rightChild == null) {
                    System.out.println(key + ": NOT found");
                    return;
                } // end if
                current = current.rightChild;
            } // end else if

            if (key == current.key) {
                // do nothing
                found = true;
            } // end if

        } // end while

    }// end search node

    public static void inOrderTraverseTree(Node focusNode) {

        if (focusNode != null) {

            // Traverse the left node

            inOrderTraverseTree(focusNode.leftChild);

            // Visit the currently focused on node
            System.out.print(" " + focusNode.key);

            // Traverse the right node

            inOrderTraverseTree(focusNode.rightChild);

        }

    }

    // Get minimum element in binary search tree
    public static Node minimumElement(Node current) {
        if (current.leftChild == null)
            return root;
        else {
            return minimumElement(current.leftChild);
        }
    }

    public static Node deleteNode(Node current, int key) {
        if (current == null) {
            System.out.println(key + ": NOT found");
            return null;
        }
        if (current.key > key) {
            current.leftChild = deleteNode(current.leftChild, key);
        } else if (current.key < key) {
            current.rightChild = deleteNode(current.rightChild, key);

        } else {
            // if have both children
            if (current.leftChild != null && current.rightChild != null) {
                Node temp = root;
                // Finding minimum element from right
                Node minNodeForRight = minimumElement(temp.rightChild);
                // Replacing current node with minimum node from right subtree
                current.key = minNodeForRight.key;
                // Deleting minimum node from right now
                current.rightChild = deleteNode(current.rightChild, minNodeForRight.key);

            }
            // if nodeToBeDeleted has only left child
            else if (current.leftChild != null) {
                current = current.leftChild;
            }
            // if nodeToBeDeleted has only right child
            else if (current.rightChild != null) {
                current = current.rightChild;
            }
            // if nodeToBeDeleted do not have child (Leaf node)
            else
                current = null;
        }
        return current;
    }

    public static void instertNode(int key) {

        // create node
        Node newNode = new Node(key);
        // if no root becomes root
        if (root == null) {
            root = newNode;
        } else {
            // seet root as start and traverse

            Node focusNode = root;
            Node parent;

            while (true) {
                parent = focusNode;

                // check side

                if (key < focusNode.key) {
                    // go left
                    focusNode = focusNode.leftChild;

                    if (focusNode == null) {

                        parent.leftChild = newNode;
                        return;

                    } // end if
                } else {// this works if key is > or ==
                    // go right
                    focusNode = focusNode.rightChild;

                    if (focusNode == null) {

                        parent.rightChild = newNode;
                        return;
                    } // end if
                } // end if else
            } // end while
        } // end if else
    }// end insertNode

}// end class

class Node {

    int key;

    Node leftChild;
    Node rightChild;

    Node(int key) {

        this.key = key;

    }// end node

}// end Node