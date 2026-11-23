class Solution {
    private int idx;
    public boolean parseBoolExpr(String expression) {
        idx = 0;
        return parse(expression);
    }
    private boolean parse(String expr) {
        char ch = expr.charAt(idx++);
        if(ch == 't') {
            return true;
        }
        if(ch == 'f') {
            return false;
        }
        if(ch == '!') {
            idx++;
            boolean res = !parse(expr);
            idx++;
            return res;
        }
        boolean isAnd = (ch == '&');
        boolean res = isAnd;
        idx++;
        while(true) {
            boolean sub = parse(expr);
            if(isAnd) {
                res &= sub;
            } else {
                res |= sub;
            }
            if(expr.charAt(idx) == ')') {
                idx++;
                break;
            }
            idx++;
        }
        return res;
    }
}
