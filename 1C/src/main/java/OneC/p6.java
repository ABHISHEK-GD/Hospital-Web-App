/*1. Write a Java program to iterate through all elements in a linked list starting at the
specified position ( 2 nd ) using iterator ( hint : Iterator iteratorobj = listobj.listIterator(1))*/

package OneC;
import java.util.*;
public class p6 {
    public static void main(String[] args) {

        List<String> ls = new LinkedList<>();

        ls.add("Orange");
        ls.add("green");   // fixed typo
        ls.add("pink");
        ls.add("red");
        ls.add("Blue");

        // Start iteration from index 2
        ListIterator<String> iterator = ls.listIterator(2);

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}