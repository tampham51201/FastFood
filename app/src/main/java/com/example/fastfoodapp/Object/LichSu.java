package com.example.fastfoodapp.Object;

public class LichSu {

    private String ten;
    private String thoiGian;
    private int Anh;
    private String Mota;
    private String gia;
    private String calories;
    private Double sao;
    private String Tong;
    private String ingredient;
    private String size;
    private int anhMot;
    private int anhHai;
    private int anhBa;
    private int anhBon;


    public LichSu(String ten, String thoiGian, int anh, String mota, String gia, String calories, Double sao, String tong, String ingredient, String size, int anhMot, int anhHai, int anhBa, int anhBon) {
        this.ten = ten;
        this.thoiGian = thoiGian;
        Anh = anh;
        Mota = mota;
        this.gia = gia;
        this.calories = calories;
        this.sao = sao;
        Tong = tong;
        this.ingredient = ingredient;
        this.size = size;
        this.anhMot = anhMot;
        this.anhHai = anhHai;
        this.anhBa = anhBa;
        this.anhBon = anhBon;

    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public int getAnh() {
        return Anh;
    }

    public void setAnh(int anh) {
        Anh = anh;
    }

    public String getMota() {
        return Mota;
    }

    public void setMota(String mota) {
        Mota = mota;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

    public Double getSao() {
        return sao;
    }

    public void setSao(Double sao) {
        this.sao = sao;
    }

    public String getTong() {
        return Tong;
    }

    public void setTong(String tong) {
        Tong = tong;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getAnhMot() {
        return anhMot;
    }

    public void setAnhMot(int anhMot) {
        this.anhMot = anhMot;
    }

    public int getAnhHai() {
        return anhHai;
    }

    public void setAnhHai(int anhHai) {
        this.anhHai = anhHai;
    }

    public int getAnhBa() {
        return anhBa;
    }

    public void setAnhBa(int anhBa) {
        this.anhBa = anhBa;
    }

    public int getAnhBon() {
        return anhBon;
    }

    public void setAnhBon(int anhBon) {
        this.anhBon = anhBon;
    }


}