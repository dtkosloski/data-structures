import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;
/**
 * Write a program that checks whether a sequence of HTML tags
 * is properly nested. For each opening tag, such as <p>, there
 * must be a closing tag </p>. A tag such as <p> may have other
 * tags inside, for example <p> <ul> <li> </li> </ul> <a> </a> </p>
 * <p>
 * The inner tags must be closed before the outer ones.
 * Your program should process a file containing tags.
 * For simplicity, assume that the tags are separated by
 * spaces, and that there is no text inside the tags.
*/
public class HTMLChecker
{
    public static void main(String[] args)
    {
        String filename = "TagSample1.html";

        try (Scanner in = new Scanner(new File(filename)))
        {
            Stack<String> stack = new Stack<>();

            while (in.hasNext()) {
                String tag = in.next();
                if (isOpeningTag(tag)) {
                    stack.push(tag);
                } else if (isClosingTag(tag)) {
                    if (stack.isEmpty()) {
                        System.out.println("Error: Found a closing tag without a corresponding opening tag: " + tag);
                        return; // Stop checking if there's an error
                    }
                    String top = stack.pop();
                    if (!areMatchingTags(top, tag)) {
                        System.out.println("Error: Mismatched tags: " + top + " and " + tag);
                        return; // Stop checking if there's an error
                    }
                }
            }

            if (stack.isEmpty()) {
                System.out.println("HTML tags are properly nested.");
            } else {
                System.out.println("Error: Some tags are not properly closed.");
            }


        } catch (FileNotFoundException e)
        {
            System.out.println("Cannot open: " + filename);
        }

    }
    // Check if a string is an opening HTML tag, e.g., <p>
    private static boolean isOpeningTag(String tag) {
        return tag.startsWith("<") && !tag.startsWith("</");
    }

    // Check if a string is a closing HTML tag, e.g., </p>
    private static boolean isClosingTag(String tag) {
        return tag.startsWith("</");
    }

    // Check if two tags are matching (e.g., <p> and </p>)
    private static boolean areMatchingTags(String openingTag, String closingTag) {
        return openingTag.substring(1).equals(closingTag.substring(2));
    }
}
