package mx.edu.utez.hm.model.categories;

public class BeanCategories {
    int id;
    String nameCategorie;

    public BeanCategories() {
    }

    public BeanCategories(int id, String nameCategorie) {
        this.id = id;
        this.nameCategorie = nameCategorie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameCategorie() {
        return nameCategorie;
    }

    public void setNameCategorie(String nameCategorie) {
        this.nameCategorie = nameCategorie;
    }
}
