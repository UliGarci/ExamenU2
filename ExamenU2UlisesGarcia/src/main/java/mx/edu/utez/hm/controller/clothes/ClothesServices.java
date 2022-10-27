package mx.edu.utez.hm.controller.clothes;

import mx.edu.utez.hm.model.clothes.BeanClothes;
import mx.edu.utez.hm.model.clothes.DaoClothes;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Path("/api/clothes")
public class ClothesServices {

    @GET
    @Path("/")
    @Produces(value = {"application/json"})
    public List<BeanClothes> getAll(){
        return new DaoClothes().finAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<BeanClothes> getClothe(@PathParam("id") int id){
        List<BeanClothes> clothe = new ArrayList<>();
        try{
            clothe = new DaoClothes().consultarClothe(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return clothe;
    }

    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public BeanClothes saveClothe(@WebParam BeanClothes clothe){
        BeanClothes clotheAdd = new BeanClothes();
        return clotheAdd;
    }

    @DELETE
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean eliminarClothe(@PathParam("id") int id){
        boolean clotheDelete = new DaoClothes().eliminarClothe(id);
        return  clotheDelete;
    }

    @PUT
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public BeanClothes updateClothe(@WebParam BeanClothes clothe, @PathParam("id") int id){
        BeanClothes beanClothes = new DaoClothes().actualizarClothe(
          clothe.getNameClothe(),
          clothe.getPrice(),
                clothe.getSize(),
                clothe.getBrand(),
                clothe.getStock(),
                clothe.getClotheType(),
                clothe.getCreateAt(),
                clothe.getStatus(),
                clothe.getCategory_id().getId(),
                clothe.getClotheType_id().getId());
        return beanClothes;
    }

}
