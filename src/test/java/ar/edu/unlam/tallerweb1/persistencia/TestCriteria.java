package ar.edu.unlam.tallerweb1.persistencia;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Farmacia;

public class TestCriteria extends SpringTest {
	
	@Test
	@Transactional
	@Rollback(true)
	public void BuscarFarmaciasDiasMartes() {
		
		Farmacia f1= new Farmacia();
		Farmacia f2 = new Farmacia();
		
		f1.setDiadeturno("Lunes");
		f1.setNombre("Vilela");
		f1.setTelefono("44411234");
		
		f2.setDiadeturno("Martes");
		f2.setNombre("Dr Ahorro");
		f2.setTelefono("12345678");
		
		getSession().save(f1);
		getSession().save(f2);
		
		
	}

}
