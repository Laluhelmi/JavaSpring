/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import pojo.Hallo;

/**
 *
 * @author L
 */
public class MhsMapper implements RowMapper<Hallo>{

    @Override
    public Hallo mapRow(ResultSet rs, int i) throws SQLException {
        Hallo h = new Hallo();
        h.setNama(rs.getString("nama"));
        h.setNim(rs.getString("nim"));
        h.setAlamat(rs.getString("alamat"));
        return h;
    }
    
}
