package ra.run;

import config.Config;
import ra.bussinessImp.Catalog;
import ra.bussinessImp.Product;

import java.util.*;

public class ProductManagement {
    public static List<Catalog> catalogs = new ArrayList<>();
    static List<Product> products = new ArrayList<>();

    public static void main(String[] args) {
        int choice;
        while (true){
            System.out.println("""
                    1. Nhập số danh mục sản phẩm và nhập thông tin các danh mục
                    2. Nhập số sản phẩm và nhập thông tin các sản phẩm
                    3. Sắp xếp sản phẩm theo giá sản phẩm tăng dần
                    4. Tìm kiếm sản phẩm theo tên danh mục sản phẩm
                    5. Thoát
                    """);
            choice = Integer.parseInt(Config.scanner().nextLine());
            switch (choice){
                case 1:
                    handleAddCatelogs();
                    break;
                case 2:
                    handleAddProducts();
                    break;
                case 3:
                    handleSortProduct();
                    break;
                case 4:
                    handleSearch();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Không hợp lệ");
                    break;
            }
        }
    }

    private static void handleSearch() {
        boolean check = false;
        catalogs.forEach(catalog ->{
            catalog.displayData();
        });
        System.out.println("Nhập tên danh mục bạn cần tìm sản phẩm:");
        System.out.println("Kết quả tìm kiếm:");
        String cataName = Config.scanner().nextLine();
        for (Product product :products) {
            if (product.getCatalog().getCatalogName().equalsIgnoreCase(cataName)) {
                product.displayData();
                check=true;
            }
        }
        if (!check){
            System.out.println("Không có sản phẩm nào thuộc danh mục có tên " + cataName);
        }
    }

    private static void handleSortProduct() {
        products.sort((p1, p2) -> (int) (p1.getExportPrice() - p2.getExportPrice()));
        System.out.println("Đã sắp xếp xong");
    }

    private static void handleAddProducts() {
        System.out.println("Nhập số lượng sản phẩm cần thêm");
        int count = Integer.parseInt(Config.scanner().nextLine());
        for (int i = 0; i < count; i++) {
            System.out.println("Thêm mới sản phẩm " + (i+1));
            Product product = new Product();
            product.inputData();
            products.add(product);
        }
    }

    private static void handleAddCatelogs() {
        System.out.println("Nhập số lượng danh mục cần thêm");
        int count = Integer.parseInt(Config.scanner().nextLine());
        for (int i = 0; i < count; i++) {
            System.out.println("Thêm mới danh mục " + (i+1));
            Catalog catalog = new Catalog();
            catalog.inputData();
            catalogs.add(catalog);
        }
    }
}
