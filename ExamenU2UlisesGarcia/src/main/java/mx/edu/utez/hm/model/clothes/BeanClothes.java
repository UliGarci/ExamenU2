package mx.edu.utez.hm.model.clothes;

import mx.edu.utez.hm.model.categories.BeanCategories;
import mx.edu.utez.hm.model.clothes_type.BeanClothesType;

public class BeanClothes {
    int id;
    String nameClothe;
    double price;
    String size;
    String brand;
    int stock;
    String clotheType;
    String createAt;
    int status;
    BeanCategories category_id;
    BeanClothesType clotheType_id;

    public BeanClothes() {
    }

    public BeanClothes(int id, String nameClothe, double price, String size, String brand, int stock, String clotheType, String createAt, int status, BeanCategories category_id, BeanClothesType clotheType_id) {
        this.id = id;
        this.nameClothe = nameClothe;
        this.price = price;
        this.size = size;
        this.brand = brand;
        this.stock = stock;
        this.clotheType = clotheType;
        this.createAt = createAt;
        this.status = status;
        this.category_id = category_id;
        this.clotheType_id = clotheType_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameClothe() {
        return nameClothe;
    }

    public void setNameClothe(String nameClothe) {
        this.nameClothe = nameClothe;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getClotheType() {
        return clotheType;
    }

    public void setClotheType(String clotheType) {
        this.clotheType = clotheType;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public BeanCategories getCategory_id() {
        return category_id;
    }

    public void setCategory_id(BeanCategories category_id) {
        this.category_id = category_id;
    }

    public BeanClothesType getClotheType_id() {
        return clotheType_id;
    }

    public void setClotheType_id(BeanClothesType clotheType_id) {
        this.clotheType_id = clotheType_id;
    }
}
