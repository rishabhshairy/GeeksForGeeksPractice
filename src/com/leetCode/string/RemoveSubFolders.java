package com.leetCode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveSubFolders {

    public static void main(String[] args) {
        String[] folder = {"/a", "/a/b", "/c/d", "/c/d/e", "/c/f"};
        new RemoveSubFolders().removeSubfolders(folder);
    }

    /**
     * Approach here is
     *
     * Sort the folder array
     * then take the first folder as base
     * ass "/" to it and check if subsequent folder starts with last folder in resultant array
     * @param folder
     * @return
     */
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);

        List<String> result = new ArrayList<>();
        result.add(folder[0]);

        for (int i = 1; i < folder.length; i++) {
            String lastFolder = result.get(result.size() - 1) + "/";

//            System.out.println("lastFolder= " + lastFolder);
//            System.out.println("currFolder= " + folder[i]);

            if (!folder[i].startsWith(lastFolder)) {
                result.add(folder[i]);
            }
        }

//        System.out.print(result);

        return result;
    }
}
