/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClashFlowDAO;

import ClashFlowObjeto.Venda;
import exception.DAOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilitario.Conexao;

/**
 *
 * @author Sonia
 */
public class VendaDAO {

    private static final Logger logger = Logger.getLogger(VendaDAO.class.getName());
    private Connection conn;
    private PreparedStatement ps;
    private Statement st;
    private ResultSet rs;

    public void add(Venda venda, Connection conn) throws DAOException {
        try {

            ps = conn.prepareStatement("INSERT INTO VENDAS (vdTotalVenda, lcIdLancamentoCaixa, vdData) VALUES(?, ?, now())", Statement.RETURN_GENERATED_KEYS);

            ps.setDouble(1, venda.getTotalVenda());
            ps.setInt(2, venda.getLancamento().getIdlancamentoCaixa());

            ps.execute();

            rs = ps.getGeneratedKeys();

            if (rs.next()) {
                venda.setIdVenda(rs.getInt(1));
            }

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "N\u00e3o foi possivel salvar no banco {0}", e.getMessage());
            throw new DAOException("Não foi possivel salvar no banco");
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    System.out.println("Nao foi possivel fechar o Statement");
                }
            }
        }

    }
}
