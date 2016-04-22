import br.com.agenda.persistencia.*;
import br.com.agenda.nucleo.*;

public class ContatoDaoTest {
	
	 public static void main(String[] args) {
	
		 ContatoMySqlDao dao = new ContatoMySqlDao();
		 //GrupoMySqlDao gp = new GrupoMySqlDao();
		 
		 //Grupo a = new Grupo("Familia");
		 //gp.save(a);
		 
		 Contato con = new Contato(null, "Milder Mora Ritchie");
		 con.setEndereco(new Endereco(null, "maravi - Cane"));
		 con.setGrupo(new Grupo("Familia"));
		 
		 dao.save(con);
	
		 //	Contato c = dao.findById(53);
		 //	System.out.println(c);
		 //dao.delete(c);
	
		 for (Contato c: dao.listContatos()){
			 System.out.println(c.toString());
		 }
	
	 }
}
