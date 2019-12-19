package com.example.ferinadwifitri.emenu.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Transaksi {
    @SerializedName("id_transaksi")
    @Expose
    private Integer idTransaksi;
    @SerializedName("meja_id")
    @Expose
    private Integer mejaId;
    @SerializedName("tanggal")
    @Expose
    private String tanggal;
    @SerializedName("status_bayar_id")
    @Expose
    private String statusBayarId;
    @SerializedName("member_id")
    @Expose
    private Integer memberId;
    @SerializedName("total_harga")
    @Expose
    private Integer totalHarga;
    @SerializedName("pembayaran_id")
    @Expose
    private String pembayaranId;

    public Transaksi(Integer idTransaksi, Integer mejaId, String tanggal, String statusBayarId, Integer memberId, Integer totalHarga, String pembayaranId) {
        this.idTransaksi = idTransaksi;
        this.mejaId = mejaId;
        this.tanggal = tanggal;
        this.statusBayarId = statusBayarId;
        this.memberId = memberId;
        this.totalHarga = totalHarga;
        this.pembayaranId = pembayaranId;
    }

    public Integer getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(Integer idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public Integer getMejaId() {
        return mejaId;
    }

    public void setMejaId(Integer mejaId) {
        this.mejaId = mejaId;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getStatusBayarId() {
        return statusBayarId;
    }

    public void setStatusBayarId(String statusBayarId) {
        this.statusBayarId = statusBayarId;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(Integer totalHarga) {
        this.totalHarga = totalHarga;
    }

    public String getPembayaranId() {
        return pembayaranId;
    }

    public void setPembayaranId(String pembayaranId) {
        this.pembayaranId = pembayaranId;
    }
}
