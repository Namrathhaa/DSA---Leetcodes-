import java.util.Map;
import java.util.TreeMap;

class Solution {
    private int idx;

    public String countOfAtoms(String formula) {
        idx = 0;
        Map<String, Integer> counts = parse(formula);
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            sb.append(entry.getKey());
            if (entry.getValue() > 1) {
                sb.append(entry.getValue());
            }
        }
        return sb.toString();
    }

    private Map<String, Integer> parse(String formula) {
        Map<String, Integer> map = new TreeMap<>();
        int n = formula.length();

        while (idx < n && formula.charAt(idx) != ')') {
            if (formula.charAt(idx) == '(') {
                idx++;
                Map<String, Integer> inner = parse(formula);
                idx++;
                int mult = parseCount(formula);
                for (Map.Entry<String, Integer> entry : inner.entrySet()) {
                    map.put(entry.getKey(), map.getOrDefault(entry.getKey(), 0) + entry.getValue() * mult);
                }
            } else {
                String atom = parseAtom(formula);
                int count = parseCount(formula);
                map.put(atom, map.getOrDefault(atom, 0) + count);
            }
        }

        return map;
    }

    private String parseAtom(String formula) {
        int start = idx++;
        while (idx < formula.length() && Character.isLowerCase(formula.charAt(idx))) {
            idx++;
        }
        return formula.substring(start, idx);
    }

    private int parseCount(String formula) {
        if (idx >= formula.length() || !Character.isDigit(formula.charAt(idx))) {
            return 1;
        }
        int num = 0;
        while (idx < formula.length() && Character.isDigit(formula.charAt(idx))) {
            num = num * 10 + (formula.charAt(idx++) - '0');
        }
        return num;
    }
}
