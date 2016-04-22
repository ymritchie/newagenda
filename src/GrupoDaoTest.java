import br.com.agenda.persistencia.*;
import br.com.agenda.nucleo.*;

public class GrupoDaoTest {
	public static void main(String[] args) {
	
		GrupoMySqlDao dao = new GrupoMySqlDao();
		
		Grupo g = new Grupo("Familia");
		dao.save(g);
		
		Grupo k = dao.findById(1);
		
		dao.delete(k);
		
		for (Grupo g1 : dao.listGrupos()){
			System.out.println(g1.toString());
		}
	}
}
