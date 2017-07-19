import java.util.HashMap;
import java.util.Map;

public class Atoi {

    public static int atoi(final String a) {
        Map<Character, Integer> m = new HashMap<Character, Integer>();
        m.put('0', 0);
        m.put('1', 1);
        m.put('2', 2);
        m.put('3', 3);
        m.put('4', 4);
        m.put('5', 5);
        m.put('6', 6);
        m.put('7', 7);
        m.put('8', 8);
        m.put('9', 9);

        int output = 0;
        boolean initial = true;
        boolean negative = false;
        boolean max = false;
        for (char c : a.toCharArray()) {
            if (c == ' ') {
                if (!initial) {
                    break;
                }
            } else {
                initial = false;
                if (c == '-' && output == 0) {
                    negative = true;
                } else if (c == '+' && output == 0) {
                    continue;
                } else if (m.get(c) != null) {
                    if (output == 0) {
                        output = m.get(c);
                    } else {
                        if ((Integer.MAX_VALUE - m.get(c)) / 10 < output) {
                            max = true;
                            break;
                        }
                        output = output * 10 + m.get(c);
                    }
                } else {
                    break;
                }
            }
        }
        if (max) {
            output = Integer.MAX_VALUE;
        }
        if (negative) {
            if (max) {
                output = Integer.MIN_VALUE;
            } else {
                output = output * -1;
            }
        }
        return output;
    }

    public static void main(String[] args) {
        String a = "-88297 248252140B12 37239U4622733246I218 9 1303 44 A83793H3G2 1674443R591 4368 7 97";
        System.out.print(atoi(a) + "\n");

        String b = "- 5 88C340185Q 71 8079 834617385 2898422X5297Z6900";
        System.out.print(atoi(b) + "\n");

        String c = "-6435D56183011M11 648G1 903778065 762 75316456373673B5 334 19885 90668 8 98K X277 9846";
        System.out.print(atoi(c) + "\n");

        String d = "5121478262 8070067M75 X199R 547 8C0A11 93I630 4P4071 029W433619 M3 5 14703818 776366059B9O43393";
        System.out.print(atoi(d) + "\n");
    }

}