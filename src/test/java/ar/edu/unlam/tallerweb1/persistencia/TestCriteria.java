package ar.edu.unlam.tallerweb1.persistencia;

import java.util.List;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.assertThat;
import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Barrio;
import ar.edu.unlam.tallerweb1.modelo.Direccion;
import ar.edu.unlam.tallerweb1.modelo.Farmacia;

public class TestCriteria extends SpringTest {
	
	@Test
	@Transactional
	@Rollback(true)
	public void BuscarFarmaciasDiasMartes() {
		
		Farmacia f1= new Farmacia();
		Farmacia f2 = new Farmacia();
		Farmacia f3 = new Farmacia();
		
		f1.setDiadeturno("Lunes");
		f1.setNombre("Vilela");
		f1.setTelefono("44411234");
		getSession().save(f1);
		
		f2.setDiadeturno("Martes");
		f2.setNombre("Dr Ahorro");
		f2.setTelefono("12345678");
		getSession().save(f2);
		
		f3.setDiadeturno("Martes");
		f3.setNombre("Dr pirulo");
		f3.setTelefono("12345678345");
		getSession().save(f3);
		
		
		List<Farmacia> farmacia;
		
		farmacia = getSession().createCriteria(Farmacia.class)
				  .add(Restrictions.eq("diadeturno","Martes")).list();
		
		assertThat(farmacia).hasSize(2);
		
		
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void BuscarFarmaciasDeUnaCalle() {
		
		Farmacia f1= new Farmacia();
		Farmacia f2= new Farmacia();
		
		Direccion dir1 = new Direccion();
		Direccion dir2 = new Direccion();
		//Barrio barrio = new Barrio();
		
		dir1.setCalle("San juan");
		dir1.setNumero("3596");
		getSession().save(dir1);
		
		f1.setDireccion(dir1);
		getSession().save(f1);
		
		dir2.setCalle("San pedro");
		dir2.setNumero("2336");
		getSession().save(dir2);
		
		f2.setDireccion(dir2);
		getSession().save(f2);
		
		List<Direccion> direccion;
		
		direccion = getSession().createCriteria(Direccion.class)
				  .add(Restrictions.eq("calle","San Juan")).list();
		
		assertThat(direccion).hasSize(1);
	}

	@Test
	@Transactional
	@Rollback(true)
	public void BuscarFarmaciasDeUnBarrio(){
		
		Direccion dir1 = new Direccion();
		Barrio b1 = new Barrio();
		Farmacia f2 = new Farmacia();
		
		b1.setNombre("Marina");
		getSession().save(b1);
		
		dir1.setBarrio(b1);
		getSession().save(dir1);
		
		f2.setDireccion(dir1);
		getSession().save(f2);
		
		List<Farmacia> farm;
		
		farm = getSession().createCriteria(Farmacia.class)
				  .createAlias("Barrio", "b1")
				  .add(Restrictions.eq("b1.nombre", "Marina")).list();
		
		assertThat(farm).hasSize(1);
	}

}
