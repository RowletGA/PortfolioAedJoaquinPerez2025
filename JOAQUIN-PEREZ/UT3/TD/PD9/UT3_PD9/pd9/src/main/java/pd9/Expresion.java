package pd9;
import java.util.Stack;

public class Expresion {
    Stack<Character> stack = new Stack<Character>();

    public boolean controlCorchetes(char[] listaDeEntrada) {
        for (int i = 0; i < listaDeEntrada.length; i++) {
            if (listaDeEntrada[i] == '}') {
                if (stack.empty()){
                    stack.clear();
                    return false;
                }
                stack.pop();
            }
            else if (listaDeEntrada[i] == '{') {
                if(i == listaDeEntrada.length - 1) {
                    stack.clear();
                    return false;
                }
                stack.push(Character.MIN_VALUE);
            }
            if (i == listaDeEntrada.length - 1) {
                if (stack.empty()) {
                    stack.clear();
                    return true;
                }
                stack.clear();
                return false;
            }
        }
        stack.clear();
        return true;
    }
    
}
