package ds.basics.hashmap;

import java.util.ArrayList;

class Mapping<K,V>{
    class MappingNode<K,V>{
        K key;
        V value;
        MappingNode<K,V> next;
        public MappingNode(K key, V value){
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    ArrayList<MappingNode<K,V>> buckets;

    int size;

    int numBuckets;

    final double DEFAULT_LOAD_FACTOR = 0.75;

    public Mapping(){
        numBuckets = 5;
        buckets = new ArrayList<>();
        for(int i=0;i<numBuckets;i++){
            buckets.add(null);
        }
    }
}
