/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import pojo.Hallo;

/**
 *
 * @author L
 */
public class Config {
    private JdbcTemplate template;
    private DataSource dataSource;
    public void setConfig(DataSource dataSource){
        this.dataSource = dataSource;
        template        = new JdbcTemplate(dataSource);
    }
    public List<Hallo> tampilSemua(){
        String query =  "select * from mahasiswa";
        List<Hallo> hallos = template.query(query, new MhsMapper());
        return hallos;
    }
    public void tambahData(Hallo hallo){
        String q = "insert into mahasiswa(nama,nim,alamat) values(?,?,?)";
        template.update(q, hallo.getNama(),hallo.getNim(),hallo.getAlamat());
        
    }
    public void hapus(String id){
        String q = "delete from mahasiswa where nim = ?";
        template.update(q,id);
    }
    public Hallo mahasiswa(String id){
        String query = "select * from mahasiswa where nim=?";
        Hallo h = template.queryForObject(query, new Object[]{id}, new MhsMapper());
        return h;
    }
    public void simpanUpdate(Hallo h){
        String query = "update mahasiswa set nama=?,alamat=? where nim=?";
        template.update(query, h.getNama(),h.getAlamat(),h.getNim());
    }
    
}
