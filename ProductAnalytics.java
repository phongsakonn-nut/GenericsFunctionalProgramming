import java.util.List;
import java.util.stream.Collectors;

public class ProductAnalytics {
    private List<Product> productCatalog;

    public ProductAnalytics(List<Product> productCatalog) {
        this.productCatalog = productCatalog;
    }

    // TODO: Refactor เมธอดทั้งหมดด้านล่างนี้ให้ใช้ Stream API
    // เช่น productCatalog.stream()
    /**
     * ค้นหาสินค้าทั้งหมดในหมวดหมู่ที่กำหนด
     */
    public List<Product> findProductsByCategory(String category) {
        return productCatalog.stream() //สร้าง stream
        .filter(p->p.category().equalsIgnoreCase(category)) //กรองหมวดหมู่
        .collect(Collectors.toList()); //เก็บเป็น list
    }

    /**
     * คืนค่า "ชื่อ" ของสินค้าทั้งหมดที่มีราคาต่ำกว่าที่กำหนด
     */
    public List<String> getProductNamesWithPriceLessThan(double maxPrice) {
        return productCatalog.stream()
        .filter(p->p.price()<maxPrice) //กรองราคาที่ต่ำกว่า
        .map(p->p.name()) //แปลงเป็นชื่อ
        .collect(Collectors.toList()); //เก็บเป็น list
    }

    /**
     * คำนวณมูลค่ารวมของสต็อกสินค้าในหมวดหมู่ที่กำหนด
     */
    public double calculateTotalStockValueForCategory(String category) { //เหตุผลที่ใช่ double
       return productCatalog.stream()
       .filter(p->p.category().equalsIgnoreCase(category)) //กรองหมวดหมู่
       .mapToDouble(p->p.price()*p.stock()).sum(); //คำนวณมูลค่ารวม ราคา*สต็อก ใช่ double เพราะเป็นตัวเลข
    }

    /**
     * ตรวจสอบว่ามีสินค้าที่หมดสต็อก (stock = 0) หรือไม่
     */
    public boolean hasProductOutOfStock() {
        return productCatalog.stream()
        .anyMatch(p->p.stock()==0); // ตรวจสอบว่าเท่ากับ 0 หรือเปล่า anyMatch คือ 
        /* อีกวิธี
        public boolean hasProductOutOfStock() {
        return productCatalog.stream()
        .filter(p->p.stock()==0) กรองว่า = 0 หรือเปล่า
        .count()>0; มีมากกว่า 0 หรือเปล่า
         */
    }
}
