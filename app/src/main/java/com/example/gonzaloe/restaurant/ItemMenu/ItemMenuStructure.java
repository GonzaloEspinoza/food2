package com.example.gonzaloe.restaurant.ItemMenu;

import android.graphics.Bitmap;


public class ItemMenuStructure {

   private String url;
   private String estado;
   private String street;
   private String descripcion;
   private String precio;
   private String ciudad;


    private boolean deleteui;
    private String id;
   private Bitmap img;

//urlimg,estado,precio,vecindario
    //int
    public ItemMenuStructure(String urlimg, String ciudad, String estado, String precio){
        this.url=urlimg;
        this.ciudad=ciudad;
        this.estado=estado;
        this.street=street;
        this.descripcion = descripcion;
        this.precio= precio;
        this.ciudad = ciudad;
    }


    public void setEstado(String estado){
        this.estado= estado;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setUrl(String url){
        this.url= url;

    }

    public void setStreet(String calle){
        this.street = calle;
    }

    public void setDescripcion(String des){
        this.descripcion =des;
    }

    public void setPrecio(String precio){
        this.precio=precio;
    }

    public void setCiudad (String ciudad){
        this.ciudad=ciudad;
    }


    public String getUrlimg(){
        return this.url;
    }

    public String getStreet() {
        return this.street;
    }

    public String getDescripcion(){
        return this.descripcion;
    }

    public String getPrecio() {
        return this.precio;
    }

    public String getCiudad(){
        return this.ciudad;
    }


    public void setImg(Bitmap img) {
        this.img = img;
    }

    public Bitmap getImg(){
        return this.img;
    }
}
