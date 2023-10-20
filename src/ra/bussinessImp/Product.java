package ra.bussinessImp;

import config.Config;
import ra.bussiness.IShop;
import ra.run.ProductManagement;

public class Product implements IShop {
    private int productId;
    private static int count = 1;
    private String productName;
    private String title;
    private String descriptions;
    private Catalog catalog;
    private float importPrice;
    private float exportPrice;
    private Boolean productStatus;

    public Product() {
        this.productId = Product.count++;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public Boolean getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Boolean productStatus) {
        this.productStatus = productStatus;
    }

    @Override
    public void inputData() {
        System.out.println("Nhập tên sản phẩm");
        this.productName = Config.scanner().nextLine();
        System.out.println("Nhập tiêu đề");
        this.title = Config.scanner().nextLine();
        System.out.println("Nhập mô tả");
        this.descriptions = Config.scanner().nextLine();
        System.out.println("Chọn danh mục:");
        System.out.println("Danh sách danh mục hiện tại:");
        ProductManagement.catalogs.forEach(cata ->{
            cata.displayData();
        });
        System.out.print("Nhập id danh mục:");
        int choice = Integer.parseInt(Config.scanner().nextLine());
        boolean check = false;
        for (Catalog cata:ProductManagement.catalogs) {
            if (cata.getCatalogId() == choice) {
                this.catalog = cata;
                check = true;
                break;
            }
        }
        if (!check){
            System.out.println("Danh mục không tồn tại!");
            System.out.println("Tạo mới danh mục: ");
            Catalog cata = new Catalog();
            cata.inputData();
            this.catalog = cata;
        }
        System.out.println("Nhập giá nhập");
        this.importPrice = Float.parseFloat(Config.scanner().nextLine());
        this.exportPrice = this.importPrice * this.RATE;
        System.out.println("Giá bán đã được tính toán = " + Config.formatter.format(this.exportPrice));
        System.out.println("""
                Trạng thái:
                1.true
                2.false
                """);
        this.productStatus = Integer.parseInt(Config.scanner().nextLine()) == 1;
    }


    @Override
    public void displayData() {
        System.out.printf("productId: %d\n productName: %s\n catelog: %s\n exportPrice: %s\n status: %s\n", this.productId, this.productName,this.catalog.getCatalogName(), Config.formatter.format(this.exportPrice),this.productStatus );
    }
}
