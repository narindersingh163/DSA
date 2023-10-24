package hashing;

import java.util.LinkedList;

public class HashMapImp<K, V> {
    class Pair{
        K key;
        V value;

        Pair(K key, V value){
            this.key = key;
            this.value = value;
        }
    }
    int n;//number of nodes
    int N;//number of buckets
    LinkedList<Pair>[] buckets;

    @SuppressWarnings("unchecked")
    public HashMapImp(){
        this.N = 4;
        this.buckets = new LinkedList[N];
        for(int i = 0; i < N; i++){
            buckets[i] = new LinkedList<>();
        }
    }

    private int hashFunction(K key){
        int i = key.hashCode();
        return Math.abs(i) % N;
    }

    public void put(K key, V value){
        int bi = hashFunction(key);
        int di = searchInLL(bi, key);

        if(di == -1){
            buckets[bi].add(new Pair(key, value));
            n++;
        }else{
            buckets[bi].get(di).value = value;//updated the value
        }

        double lambda = (double) n/N;
        if(lambda > 2.0){
            rehash();
        }
    }

    @SuppressWarnings("unchecked")
    private void rehash() {
        LinkedList<Pair>[] oldBuckets = buckets;
        this.n = 0;
        this.N = N * 2;
        buckets = new LinkedList[N];

        for(int i = 0; i < N; i++){
            buckets[i] = new LinkedList<>();
        }

        for (LinkedList<Pair> ll : oldBuckets) {
            for (Pair pair : ll) {
                int bi = hashFunction(pair.key);
                put(pair.key, pair.value);
            }
        }
    }

    private int searchInLL(int bi, K key) {
        LinkedList<Pair> currLL = buckets[bi];
        int di = -1;
        for(int i = 0; i < currLL.size(); i++){
            if(currLL.get(i).key == key) {
                di = i;
            }
        }
        return di;
    }

    public V get(K key){
        int bi = hashFunction(key);
        int di = searchInLL(bi, key);
        if(di == -1)
            return null;
        else
            return buckets[bi].get(di).value;
    }

    public boolean contains(K key){
        int bi = hashFunction(key);
        int di = searchInLL(bi, key);

        return di != -1;
    }

    //remove return the old value associated with the key that is being removed
    public V remove(K key){
        int bi = hashFunction(key);
        int di = searchInLL(bi, key);

        if(di == -1){
            return null;
        }else{
            V val = buckets[bi].get(di).value;
            buckets[bi].remove(di);
            return val;
        }
    }

    public boolean isEmpty(){
        return n == 0;
    }


    public static void main(String[] args) {
        HashMapImp<String, Integer> map = new HashMapImp<>();
        map.put("a", 1);
        map.put("b", 1);
        map.put("c", 1);
        map.put("d", 1);
        map.put("e", 1);
        map.put("f", 1);
        map.put("g", 1);
        map.put("h", 1);
        map.put("i", 1);

        System.out.println(map.contains("h"));
        System.out.println(map.remove("f"));
        System.out.println(map.isEmpty());
    }
}
