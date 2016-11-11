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

/**
 *
 * @author Sonia
 */
public class LancamentosCaixaDAO 
{
    
    private Connection conn;
    private PreparedStatement ps;
    private Statement st;
    private ResultSet rs;
    
    public void add(LancamentosCaixa lc)
    {
            try 
                {
                    
			conn = new Conexao().conectar();
			ps = conn.prepareStatement( "INSERT INTO LANCAMENTO_CAIXA(lcData, lcValor, lcObservacao,tpmovIdTipoMovimento, pagIdFormaPagamento, cxIdCaixa) VALUES(now(), ?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
               
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
                        
                }
                catch (SQLException e)
                {
                    System.out.println("Não foi possivel salvar no banco novo Lancamentos " + e.getMessage());
                }
                finally 
                {
			if (ps != null) 
                        {
				try 
                                {
					ps.close();
				} catch (SQLException e) {
					System.out.println("Nao foi possivel fechar o Statement");
				}
			}
			if (conn != null) 
                        {
				try 
                                {
					conn.close();
                                }                                 
                                catch (SQLException e)
                                {
					System.out.println("Não foi possivel fechar a conexao");
				}
			}    
   
                }
    } 
    public List<LancamentosCaixa> buscarTodos() 
    {

                   try 
                   {

                           conn = new Conexao().conectar();
                           st = conn.createStatement();

                           rs = st.executeQuery("select m.lcIdLancamento, m.lcData, m.lcValor, m.lcObservacao, t.tpmovDescricaoMovimento, t.tpmovCredito\n" +
                                                    "\n" +
                                                    "from lancamento_caixa m\n" +
                                                    "\n" +
                                                    "inner join caixa c on c.cxIdCaixa = m.cxIdCaixa\n" +
                                                    "\n" +
                                                    "inner join tipo_movimento t on t.tpmovIdTipoMovimento = m.tpmovIdTipoMovimento\n" +
                                                    "\n" +
                                                    "where c.cxDataFechamento is null\n" +
                                                    "\n" +
                                                    "order by m.lcIdLancamento");

                           List<LancamentosCaixa> lancamentosCaixa = new ArrayList<>();

                           while(rs.next())
                           {
                               
                               TipoMovimento tm = new TipoMovimento();
                               tm.setCredito(rs.getBoolean("tpmovCredito"));
                               
                               LancamentosCaixa lc = new LancamentosCaixa();
                               lc.setIdlancamentoCaixa(rs.getInt("lcIdLancamento"));
                               lc.setObservacao(rs.getString("lcObservacao"));
                               lc.setTipoMovimento(tm);
                               lc.setValorMovimento(rs.getDouble("lcValor"));
                               lc.setDataMovimento(DataUtil.parseDate(rs.getDate("lcData")));
                               
                               lancamentosCaixa.add(lc);
                           }

                           return lancamentosCaixa;

                   }
                   catch (SQLException e)
                   {
                       System.out.println("Não foi possivel verificar no banco " + e.getMessage());
                       return null;
                   }
                   finally 
                   {
                           if (ps != null)
                           {
                                   try 
                                   {
                                           ps.close();
                                   } 
                                   catch (SQLException e)
                                   {
                                           System.out.println("Nao foi possivel fechar o Statement");
                                   }
                           }
                           if (conn != null) 
                           {
                                   try 
                                   {
                                           conn.close();
                                   }                                 
                                   catch (SQLException e)
                                   {
                                           System.out.println("Não foi possivel fechar a conexao");
                                   }
                           }
                   }
    }

}
