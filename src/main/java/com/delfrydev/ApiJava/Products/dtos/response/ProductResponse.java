package com.delfrydev.ApiJava.Products.dtos.response;

public class ProductResponse {
    private Long idProduct;
    private String nombre;
    private Double precio;

    public ProductResponse(Long idProduct, String nombre, Double precio) {
        this.idProduct = idProduct;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
