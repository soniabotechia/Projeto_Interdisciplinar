/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClashFlowDAO;

import ClashFlowObjeto.LancamentosCaixa;
import ClashFlowObjeto.FormaPagamento;
import ClashFlowObjeto.Produto;
import ClashFlowObjeto.TipoMovimento;
import exception.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utilitario.Conexao;
import utilitario.DataUtil;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sonia
 */
public class LancamentosCaixaDAO {

    private static final Logger logger = Logger.getLogger(LancamentosCaixaDAO.class.getName());
    private Connection conn;
    private PreparedStatement ps;
    private Statement st;
    private ResultSet rs;

    public void add(LancamentosCaixa lc) throws DAOException {
        try {
            conn = Conexao.conectar();
            this.add(lc, conn);
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "N\u00e3o foi possivel salvar no banco {0}", ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Não foi possivel fechar a conexao");
                }
            }

        }

    }

    public void add(LancamentosCaixa lc, Connection conn) throws DAOException {
        try {

            ps = conn.prepareStatement("INSERT INTO LANCAMENTO_CAIXA(lcData, lcValor, lcObservacao,tpmovIdTipoMovimento, pagIdFormaPagamento, cxIdCaixa) VALUES(now(), ?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

            ps.setDouble(1, lc.getValorMovimento());
            ps.setString(2, lc.getObservacao());
            ps.setInt(3, lc.getTipoMovimento().getIdTipoMovimento());
            ps.setInt(4, lc.getFormaPagamento().getPagIdFormaPagamento());
            ps.setInt(5, lc.getCaixa().getIdCaixa());

            ps.execute();
            rs = ps.getGeneratedKeys();

            if (rs.next()) {
                lc.setIdlancamentoCaixa(rs.getInt(1));
            }

        } catch (SQLException e) {
            logger.severe("Não foi possivel salvar no banco novo Lancamentos " + e.getMessage());
            throw new DAOException(e);
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
    //buscando todos os movimentos do caixa que esta aberto.
    public List<LancamentosCaixa> buscarTodosCaixaAberto() {

        try {

            conn = Conexao.conectar();
            st = conn.createStatement();

            rs = st.executeQuery("select * from lancamento");

            List<LancamentosCaixa> lancamentosCaixa = new ArrayList<>();

            while (rs.next()) {

                TipoMovimento tm = new TipoMovimento();
                FormaPagamento pg = new FormaPagamento();
                tm.setCredito(rs.getBoolean("tpmovCredito"));

                pg.setPagDescricaoPagamento(rs.getString("pagDescricaoPagamento"));
                
                LancamentosCaixa lc = new LancamentosCaixa();
                lc.setIdlancamentoCaixa(rs.getInt("lcIdLancamento"));
                lc.setObservacao(rs.getString("lcObservacao"));
                lc.setTipoMovimento(tm);
                lc.setValorMovimento(rs.getDouble("lcValor"));
                lc.setDataMovimento(DataUtil.parseDate(rs.getDate("lcData")));
                lc.setFormaPagamento(pg);

                lancamentosCaixa.add(lc);
            }

            return lancamentosCaixa;

        } catch (SQLException e) {
            System.out.println("Não foi possivel verificar no banco " + e.getMessage());
            return null;
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    System.out.println("Nao foi possivel fechar o Statement");
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Não foi possivel fechar a conexao");
                }
            }
        }
    }
    

}
