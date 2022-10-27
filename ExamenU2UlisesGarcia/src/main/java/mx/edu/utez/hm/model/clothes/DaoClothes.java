package mx.edu.utez.hm.model.clothes;

import mx.edu.utez.hm.model.categories.BeanCategories;
import mx.edu.utez.hm.model.clothes_type.BeanClothesType;
import mx.edu.utez.hm.utils.MySQLConection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoClothes{
    Connection con;
    PreparedStatement pstm;
    ResultSet rs;

    public List<BeanClothes> finAll(){
        List<BeanClothes> listaRopa = new ArrayList<>();
        BeanClothes beanClothes = null;
        BeanClothesType beanClothesType=null;
        BeanCategories beanCategories=null;
        try{
            con = MySQLConection.getConnection();
            pstm = con.prepareStatement("SELECT * FROM clothes cth INNER JOIN categories cat ON cat.id = cth.category_id INNER JOIN ;");
            rs = pstm.executeQuery();
            while(rs.next()){
                beanClothes = new BeanClothes();
                beanCategories = new BeanCategories();
                beanClothesType = new BeanClothesType();
                beanClothes.setId(rs.getInt("id"));
                beanClothes.setNameClothe(rs.getString("name"));
                beanClothes.setPrice(rs.getDouble("price"));
                beanClothes.setSize(rs.getString("size"));
                beanClothes.setBrand(rs.getString("brand"));
                beanClothes.setStock(rs.getInt("stock"));
                beanClothes.setClotheType(rs.getString("cloth_type"));
                beanClothes.setCreateAt(rs.getString("created_at"));
                beanClothes.setStatus(rs.getInt("satus"));
                beanClothesType.setId(rs.getInt("id"));
                beanClothes.setClotheType_id(beanClothesType);
                beanCategories.setId(rs.getInt("id"));
                beanClothes.setCategory_id(beanCategories);
                listaRopa.add(beanClothes);
            }
        }catch(SQLException e){
            Logger.getLogger(DaoClothes.class.getName()).log(Level.SEVERE,"Error -> "+e.getMessage());
        }finally {
            try{
                if(con!=null){
                    con.close();
                }
                if(pstm!=null){
                    pstm.close();
                }
                if(rs!=null){
                    rs.close();
                }
            }catch(SQLException e){
                System.out.println("Error en el cierre de conexiones -> "+e.getMessage());
            }
        }
        return listaRopa;
    }

    public List<BeanClothes> consultarClothe(int id){
        List<BeanClothes> clothe = new ArrayList<>();
        try{
            con = MySQLConection.getConnection();
            pstm = con.prepareStatement("SELECT cth.*,cat.name, ctp.name FROM clothes cth INNER JOIN categories cat ON cat.id=cth.id INNER JOIN clothe_types ctp ON ctp.id=cth.id where cth.id=?");
            rs = pstm.executeQuery();
            while(rs.next()){
                BeanClothes beanClothes = new BeanClothes();
                BeanCategories beanCategories = new BeanCategories();
                BeanClothesType beanClothesType = new BeanClothesType();
                beanClothes.setId(rs.getInt("id"));
                beanClothes.setNameClothe(rs.getString("name"));
                beanClothes.setPrice(rs.getDouble("price"));
                beanClothes.setBrand(rs.getString("brand"));
                beanClothes.setStock(rs.getInt("stock"));
                beanClothes.setClotheType(rs.getString("cloth_type"));
                beanClothes.setCreateAt(rs.getString("created_at"));
                beanClothes.setStatus(rs.getInt("status"));
                beanCategories.setId(rs.getInt("id"));
                beanClothes.setCategory_id(beanCategories);
                beanClothesType.setId(rs.getInt("id"));
                beanClothes.setClotheType_id(beanClothesType);
                clothe.add(beanClothes);
            }
        }catch (SQLException e){
            System.out.println("Error en el metodo << consultarClothe() >> "+e.getMessage());
        }finally {
            try{
                if(con!=null){
                    con.close();
                }
                if(pstm!=null){
                    pstm.close();
                }
                if(rs!=null){
                    rs.close();
                }
            }catch(SQLException e){
                System.out.println("Error en el cierre de conexiones -> "+e.getMessage());
            }
        }
        return clothe;
    }

    public BeanClothes insertarClothe(int id, String name, double price, String size,String brand, int stock, String clothe_type, String created_at, int status, int category_id, int clothe_type_id){
        BeanClothes clothe = new BeanClothes();
        try {
            con = MySQLConection.getConnection();
            pstm = con.prepareStatement("INSERT INTO clothes (id,name,price,size,brand,stock,cloth_type,create_at,status,category_id,clothe_type_id) VALUES (?,?,?,?,?,?,?,?,?,?,?)");
            pstm.setInt(1,id);
            pstm.setString(2,name);
            pstm.setDouble(3,price);
            pstm.setString(4,size);
            pstm.setString(5,brand);
            pstm.setInt(6,stock);
            pstm.setString(7,clothe_type);
            pstm.setString(8,created_at);
            pstm.setInt(9,status);
            pstm.setInt(10,category_id);
            pstm.setInt(11,clothe_type_id);
            int result = pstm.executeUpdate();
            if (result==1){
                clothe.setId(id);
                clothe.setNameClothe(name);
                clothe.setPrice(price);
                clothe.setSize(size);
                clothe.setBrand(brand);
                clothe.setStock(stock);
                clothe.setClotheType(clothe_type);
                clothe.setCreateAt(created_at);
                clothe.setStatus(status);
                //clothe.setCategory_id(category_id);
                //clothe.setClotheType_id(clothe_type_id);
            }else{
                clothe=null;
            }
        }catch(SQLException e){
            System.out.println("Error en el metodo << insertarClothe() >> "+e.getMessage());
        }finally {
            try{
                if(con!=null){
                    con.close();
                }
                if(pstm!=null){
                    pstm.close();
                }
                if(rs!=null){
                    rs.close();
                }
            }catch(SQLException e){
                System.out.println("Error en el cierre de conexiones -> "+e.getMessage());
            }
        }
        return clothe;
    }

    public boolean eliminarClothe(int id){
        boolean flag = false;
        try{
            con = MySQLConection.getConnection();
            pstm = con.prepareStatement("DELETE FROM clothes WHERE id=?");
            pstm.setInt(1,id);
            int result = pstm.executeUpdate();
            if(result==1){
                flag=true;
            }else{
                flag = false;
            }
        }catch(SQLException e){
            System.out.println("Error en el metodo << eliminarClothe() >> "+e.getMessage());
        }finally {
            try{
                if(con!=null){
                    con.close();
                }
                if(pstm!=null){
                    pstm.close();
                }
            }catch(SQLException e){
                System.out.println("Error en el cierre de conexiones -> "+e.getMessage());
            }
        }
        return flag;
    }

    public BeanClothes actualizarClothe(String name, double price, String size,String brand, int stock, String clothe_type, String created_at, int status, int category_id, int clothe_type_id){
    BeanClothes clothe = new BeanClothes();
    try {
        con = MySQLConection.getConnection();
        pstm = con.prepareStatement("UPDATE clothes SET name=?,price=?,size=?,brand=?,stock=?,clothe_type=?,created_at=?,status=?,category_id=?,clothe_type_id=?");
        pstm.setString(1,name);
        pstm.setDouble(2,price);
        pstm.setString(3,size);
        pstm.setString(4,brand);
        pstm.setInt(5,stock);
        pstm.setString(6,clothe_type);
        pstm.setString(7,created_at);
        pstm.setInt(8,status);
        pstm.setInt(9,category_id);
        pstm.setInt(10,clothe_type_id);
    }catch(SQLException e){
        System.out.println("Error en el metodo  << actualizarClothe() >> "+e.getMessage());
    }
        return clothe;
    }


}
