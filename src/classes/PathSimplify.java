package classes;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class PathSimplify {

    public String simplifyPath(String path) {
       if (path.length() == 1) {
           return "/";
       }

       Deque<String> paths = new LinkedList<>();

       String[] strings = path.split("/");
       for (String string : strings) {
           if (string.equals("..")) {
               if (!paths.isEmpty()) {
                   paths.pop();
               }
           } else if (string.equals(".") || string.isEmpty()) {
               continue;
           } else {
               paths.push(string);
           }
       }

       if (paths.isEmpty()) {
           return "/";
       }

       StringBuilder builder = new StringBuilder();
       while (!paths.isEmpty()) {
           builder.append("/");
           builder.append(paths.pollLast());
       }

       return builder.toString();
    }
}
