import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Stack;

public class PlayGround {

    public static void main(String[] args) {
        HashMap<String, String> userRoles = new HashMap<>();

        userRoles.put("Alice", "Admin");
        userRoles.put("Bob", "User");
        userRoles.put("Charlie", "Moderator");

        String Role = userRoles.get("Bob");
        System.out.println("Bob's role is: " + Role);

        String nonExistentRole = userRoles.get("David");
        if (nonExistentRole == null) {
            System.out.println("David's role is not found.");
        }

        boolean hasCharlie = userRoles.containsKey("Charlie");
        System.out.println("Is Charlie in the userRoles map? " + hasCharlie);

        for (Entry<String, String> entry : userRoles.entrySet()) {
            System.out.println(entry.getKey() + " has role: " + entry.getValue());
        }

        HashSet<String> uniqueRoles = new HashSet<>(userRoles.values());

        System.out.println("Unique roles in the userRoles map: " + uniqueRoles);

        // Stack<String> stack = new Stack<>();
        // stack.peek();

        isBalanced(")");

    }

    public static boolean isBalanced(String input) {
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) {
            if (c == '(')
                stack.push(c);
            if (c == ')')
                stack.pop();
        }
        return stack.isEmpty();
    }
}