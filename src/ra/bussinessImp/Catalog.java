package ra.bussinessImp;

import config.Config;
import ra.bussiness.IShop;

public class Catalog implements IShop {
    private static int count = 1;
    private int catalogId;
    private String catalogName;
    private int priority;
    private String descriptions = Config.scanner().nextLine();
    private Boolean catalogStatus;

    public Catalog() {
        this.catalogId = Catalog.count++;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public void setCatalogStatus(Boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public int getPriority() {
        return priority;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public Boolean getCatalogStatus() {
        return catalogStatus;
    }

    @Override
    public void inputData() {
        System.out.println("Nhập tên danh mục");
        this.catalogName = Config.scanner().nextLine();
        System.out.println("Nhập đô ưu tiên");
        this.priority = Integer.parseInt(Config.scanner().nextLine());
        System.out.println("Nhập mô tả");
        this.descriptions = Config.scanner().nextLine();
        System.out.println("""
                Trạng thái:
                1.true
                2.false
                """);
        this.catalogStatus = Integer.parseInt(Config.scanner().nextLine()) == 1;
    }

    @Override
    public void displayData() {
        System.out.println("Catalog {" +
                "catalogId= " + catalogId +
                ", catalogName= '" + catalogName + '/' + "}\n");
    }
}
