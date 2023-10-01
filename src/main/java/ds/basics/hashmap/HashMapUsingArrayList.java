package ds.basics.hashmap;

import java.util.ArrayList;
import java.util.List;

public class HashMapUsingArrayList {

    class Container<K extends Object, V extends Object>{
        K key;
        V value;
        public  Container(K key, V value){
            this.key=key;
            this.value=value;
        }
    }

    private List<Container> recordList;

    public HashMapUsingArrayList(){

        this.recordList=new ArrayList<>();
    }

    public void put(Object k, Object v){
        Container c=new Container(k, v);
        //check for the same key before adding
        for(int i=0; i<recordList.size(); i++){
            Container c1=recordList.get(i);
            if(c1.key.equals(k)){
                //remove the existing object
                recordList.remove(i);
                break;
            }
        }
        recordList.add(c);
    }

    public Object get(Object k){
        for(int i=0; i<this.recordList.size(); i++){
            Container con = recordList.get(i);
            //System.out.println("k.toString():"+k.toString()+"con.key.toString()"+con.key.toString());
            if (k.toString()==con.key.toString()) {
                return con.value;
            }

        }
        return null;
    }

    public static void main(String[] args) {
        HashMapUsingArrayList hm = new HashMapUsingArrayList();
        hm.put("1", "1");
        hm.put("2", "2");
        hm.put("3", "3");
        System.out.println(hm.get("3"));
        hm.put("3", "4");

        System.out.println(hm.get("1"));
        System.out.println(hm.get("3"));
        System.out.println(hm.get("8"));
    }

}
