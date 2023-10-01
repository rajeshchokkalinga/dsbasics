package ds.basics.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;

public class CourseSchedule {

    Integer[] data = new Integer[4];
    public static void main(String[] args) {
        int[][] preRequiste = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
        int[][] pre1 = { { 1, 0 }, { 2, 1 }, { 3, 1 }, { 3, 2 } };
        int[][] pre2 = { { 1, 3 }, { 2, 3 }, { 0, 1 }, { 2, 1 } };
        //boolean finish = canFinish2(4, preRequiste);
       // print(4, preRequiste);
        //print(4, pre1);
        print(4, pre2);
        //System.out.println();
        // finish = canFinish(4, pre1);
        //System.out.println();
        //finish = canFinish2(4, pre2);
       // System.out.println(finish);
    }

    public static Object[] print(int numCourses, int[][] prerequisites) {
        if(numCourses ==0 || prerequisites.length ==0)
            return null;

        int[] pre = new int[4];
        Map<Integer, ArrayList<Integer>> values = new HashMap<>();
        for(int i =0;i<prerequisites.length;i++){
            if(values.containsKey(prerequisites[i][1])){
                values.get(prerequisites[i][1]).add(prerequisites[i][0]);
            }else{
                ArrayList e = new ArrayList();
                e.add(prerequisites[i][0]);
                values.put(prerequisites[i][1], e);
            }
            pre[prerequisites[i][0]]++;

        }

        LinkedHashSet<Integer> ch = new LinkedHashSet<>();
        for(int i = 0; i<numCourses ;i ++){
           if(pre[i] == 0){
               ch.add(i);
               extracted(values, ch, i);
           }
        }

        System.out.println(ch);
        return ch.toArray();
    }

    private static void extracted(Map<Integer, ArrayList<Integer>> values, HashSet<Integer> ch, int i) {
        if(values.get(i) != null){
            ch.addAll(values.get(i));
            for(int j:values.get(i)){
                extracted(values, ch, j);
            }
        }
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null) {
            throw new IllegalArgumentException("illegal prerequisites array");
        }

        int len = prerequisites.length;

        if (numCourses == 0 || len == 0) {
            return true;
        }

        //track visited courses
        int[] visit = new int[numCourses];

        // use the map to store what courses depend on a course
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        for (int[] a : prerequisites) {
            if (map.containsKey(a[1])) {
                map.get(a[1]).add(a[0]);
            } else {
                ArrayList<Integer> l = new ArrayList<Integer>();
                l.add(a[0]);
                map.put(a[1], l);
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (!canFinishDFS(map, visit, i)) return false;
        }

        return true;
    }

    private static boolean canFinishDFS(HashMap<Integer, ArrayList<Integer>> map, int[] visit, int i) {
        if (visit[i] == -1) return false;
        if (visit[i] == 1) return true;

        visit[i] = -1;
        if (map.containsKey(i)) {
            for (int j : map.get(i)) {
                System.out.println(j+", "+map.get(i) );
                if (!canFinishDFS(map, visit, j)) return false;
            }
        }

        visit[i] = 1;

        return true;
    }

    public static boolean canFinish2(int numCourses, int[][] prerequisites) {
        if(prerequisites == null){
            throw new IllegalArgumentException("illegal prerequisites array");
        }

        int len = prerequisites.length;

        if(numCourses == 0 || len == 0){
            return true;
        }

        // counter for number of prerequisites
        int[] preRequistCounter = new int[numCourses];
        for(int i=0; i<len; i++){
            preRequistCounter[prerequisites[i][0]]++;
        }

        //store courses that have no prerequisites
        LinkedList<Integer> queue = new LinkedList<Integer>();
        for(int i=0; i<numCourses; i++){
            if(preRequistCounter[i]==0){
                queue.add(i);
                System.out.print(i);
            }
        }
        // number of courses that have no prerequisites
        int numNoPre = queue.size();

        while(!queue.isEmpty()){
            int top = queue.remove();
            for(int i=0; i<len; i++){
                // if a course's prerequisite can be satisfied by a course in queue
                if(prerequisites[i][1]==top){
                    preRequistCounter[prerequisites[i][0]]--;
                    if(preRequistCounter[prerequisites[i][0]]==0){
                        numNoPre++;
                        System.out.print(prerequisites[i][0]);
                        queue.add(prerequisites[i][0]);
                    }
                }
            }
        }


        return numNoPre == numCourses;
    }
}
