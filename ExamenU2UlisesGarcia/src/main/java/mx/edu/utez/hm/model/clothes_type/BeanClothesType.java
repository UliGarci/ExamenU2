package mx.edu.utez.hm.model.clothes_type;

public class BeanClothesType {
    int id;
    String nameClotheType;

    public BeanClothesType() {
    }

    public BeanClothesType(int id, String nameClotheType) {
        this.id = id;
        this.nameClotheType = nameClotheType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameClotheType() {
        return nameClotheType;
    }

    public void setNameClotheType(String nameClotheType) {
        this.nameClotheType = nameClotheType;
    }
}
