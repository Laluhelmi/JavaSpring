/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;

/**
 *
 * @author L
 */
public class Hallo {
    @NotEmpty(message = "nama tidak boleh kosong")
    @Size(min = 3,message = "nama tidak boleh kurang dari 3 karakter")
    private String nama;
    @NotEmpty(message = "nim tidak boleh Kosoong")
    private String nim;
    private String alamat;

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    public Hallo(){
        
    }
    public Hallo(String nama, String nim,String alamat) {
        this.nama = nama;
        this.nim = nim;
        this.alamat = alamat;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

}
