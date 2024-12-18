package com.leetCode.string.medium;

/**
 * LC 2337 -- Move Pieces to Obtain a String
 */
public class MovePieces {

    public static void main(String[] args) {
        String start = "_L__R__R_", target = "L______RR";
        MovePieces obj = new MovePieces();
        System.out.println(obj.canChange(start, target));
    }

    /**
     * Iterate on both the string
     * i --> start
     * j --> target
     * Skip if _ is found
     * do check to ensure position of L and R are in order
     *
     * @param start
     * @param target
     * @return
     */
    public boolean canChange(String start, String target) {
        int i = 0, j = 0, n = start.length();

        while (i < n || j < n) {
            // skip if _

            while (i < n && start.charAt(i) == '_') {
                i++;
            }
            while (j < n && target.charAt(j) == '_') {
                j++;
            }

            // if whole string is empty
            if (i == n || j == n)
                break;

            // to check order of character
            if (start.charAt(i) != target.charAt(j)) {
                return false;
            }

            // eg s='L_' and t='_L'
            if (start.charAt(i) == 'L' && i < j) {
                return false;
            }

            // eg:: s='_R' t='R_'
            if (start.charAt(i) == 'R' && i > j) {
                return false;
            }
            i++;
            j++;
        }

        return i == n && j == n;
    }
}
