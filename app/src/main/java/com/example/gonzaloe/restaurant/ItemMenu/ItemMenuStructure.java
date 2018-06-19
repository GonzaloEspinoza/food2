package com.example.gonzaloe.restaurant.ItemMenu;

import android.graphics.Bitmap;
import android.service.autofill.FillEventHistory;


public class ItemMenuStructure {


    private String url;
    private String id;
   private String ciudad;
   private String estado;
   private String cuartos;
   private String baños;
   private String superficie;
   private String antiguedad;
   private String street;
   private String descripcion;
   private String precio;
   private double latitud;
   private double longitud;
   private String neighborhood;
   private String contacto;

   private boolean deleteui;
   private Bitmap img;

//urlimg,estado,precio,vecindario
    //int
    public ItemMenuStructure(String urlimg, String idhome, String ciudad, String estado, String cuartos,
                             String bañ, String superf, String antig,String calle, String descrip, String prec,
                             double lat, double longit, String neigh, String contac ){
        this.url=urlimg;
        this.id=idhome;
        this.ciudad=ciudad;
        this.estado=estado;
        this.cuartos=cuartos;
        this.baños=bañ;
        this.superficie=superf;
        this.antiguedad=antig;
        this.street=calle;
        this.descripcion=descrip;
        this.precio=prec;
        this.latitud=lat;
        this.longitud=longit;
        this.neighborhood=neigh;
        this.contacto=contac;
    }



    public void setUrl(String url){
        this.url= url;
    }
    public void setId(String id){
        this.id=id;
    }

    public void setCiudad (String ciudad){
        this.ciudad=ciudad;
    }

    public void setEstado(String estado){
        this.estado= estado;
    }

    public void setCuartos(String cuartos){
        this.cuartos=cuartos;
    }

    public void setBaños(String baños) {
        this.baños=baños;
    }

    public void setSuperficie(String superficie){
        this.superficie=superficie;
    }

    public void setAntiguedad(String antiguedad) {
        this.antiguedad=antiguedad;
    }

    public void setStreet(String street){
        this.street = street;
    }

    public void setDescripcion(String des){
        this.descripcion =des;
    }

    public void setPrecio(String precio){
        this.precio=precio;
    }


    public void setLatitud(double latitud){
        this.latitud=latitud;
    }

    public void setLongitud(double longitud){
        this.longitud=longitud;
    }

    public void setNeighborhood(String neighborhood){
        this.neighborhood=neighborhood;
    }
    public void setContacto(String contacto){
        this.contacto=contacto;

    }




    public String getUrlimg(){
        return this.url;
    }

    public String getId() {
        return this.id;
    }
    public String getCiudad(){
        return this.ciudad;
    }

    public String getEstado(){
        return this.estado;
    }
    public String getCuartos(){
        return this.cuartos;
    }

    public String getStreet() {
        return this.street;
    }

    public String getDescripcion(){
        return this.descripcion;
    }

    public String getPrecio() {
        return  this.precio;
    }

    public String getBaños(){
        return  this.baños;
    }

    public String getSuperficie(){
        return this.superficie;
    }


    public String getAntiguedad(){
        return this.antiguedad;
    }

    public double getLatitud(){
        return  this.latitud;
    }
    public double getLongitud(){
        return this.longitud;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getContacto(){
        return this.contacto;
    }


    public void setImg(Bitmap img) {
        this.img = img;
    }

    public Bitmap getImg(){
        return this.img;
    }
}
