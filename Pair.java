/**
 * TODO: ทำให้คลาสนี้เป็น Generic <K, V> ที่สามารถเก็บอ็อบเจกต์ได้ 2 ชนิด
 */
public class Pair<K,V> {
    // TODO: สร้างฟิลด์ private final สำหรับ key และ value
    private final K key; //แทน string
    private final V value; //แทน int
    
    // TODO: สร้าง Constructor ที่รับ key และ value
     public Pair(K key, V value){
        this.key = key; //รับค่าจาก key
        this.value = value; //รับค่าจาก value
    }

    // TODO: สร้าง Getters สำหรับ key และ value
    public K getkey(){return key;} //รับค่าจาก K และส่งกลับเป็น key
    public V getvalue(){return value;} //รับค่าจาก V และส่งค่ากลับเป็น value 

}