import java.util.Random;

public class TreeTest {
    private static int NUMBER_CAP = 50;

    // main method
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<Integer>();
        Random rand = new Random();

        // fill tree with random numbers
        for (int i: rand.ints(20, 0, NUMBER_CAP).toArray()) {
            tree.insertNode(i);
        };
        
        // print tree
        System.out.println("Created tree:");
        tree.inorderTraversal();
        System.out.printf("\n\n");

        // pick a random number to check
        int check = rand.nextInt(NUMBER_CAP);
        System.out.printf("Checking for %d...\n", check);


        if (tree.contains(check) != null) {
            System.out.printf("Tree contains %d\n", check);
        } else {
            System.out.printf("Tree does not contain %d\n", check);
        }
    }
}
