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
		
		Farmacia farmacia1, farmacia2, farmacia3;
		Direccion direccion1, direccion2, direccion3;
		
		
		farmacia1 = new Farmacia();
		farmacia2 = new Farmacia();
		farmacia3 = new Farmacia();
		
		direccion1 = new Direccion();
		direccion2 = new Direccion();
		direccion3 = new Direccion();
		
		direccion1.setCalle("Jujuy");
		direccion2.setCalle("San juan");
		direccion3.setCalle("Arieta");
		
		
		farmacia1.setDireccion(direccion1);
		farmacia2.setDireccion(direccion2);
		farmacia3.setDireccion(direccion3);
		
		getSession().save(direccion1);
		getSession().save(direccion2);
		getSession().save(direccion3);
		getSession().save(farmacia1);
		getSession().save(farmacia2);
		getSession().save(farmacia3);
		
		
		List<Direccion> direccion;
		
		direccion = getSession().createCriteria(Farmacia.class)
				   .createAlias("direccion", "dir")
				  .add(Restrictions.eq("dir.calle","San juan")).list();
		
		assertThat(direccion).hasSize(1);
	}

	@Test
	@Transactional
	@Rollback(true)
	public void BuscarFarmaciasDeUnBarrio(){
		
		Farmacia farmacia1, farmacia2, farmacia3;
		Direccion direccion1, direccion2, direccion3;
		Barrio barrio1, barrio2, barrio3;
		
		farmacia1 = new Farmacia();
		farmacia2 = new Farmacia();
		farmacia3 = new Farmacia();
		
		direccion1 = new Direccion();
		direccion2 = new Direccion();
		direccion3 = new Direccion();
		
		barrio1 = new Barrio();
		barrio2 = new Barrio();
		barrio3 = new Barrio();
		
		barrio1.setNombre("Caseros");
		barrio2.setNombre("San Justo");
		barrio3.setNombre("Ramos Mejia");
		
		direccion1.setBarrio(barrio1);
		direccion2.setBarrio(barrio2);
		direccion3.setBarrio(barrio3);
		
		farmacia1.setDireccion(direccion1);
		farmacia2.setDireccion(direccion2);
		farmacia3.setDireccion(direccion3);
		
		getSession().save(barrio1);
		getSession().save(barrio2);
		getSession().save(barrio3);
		getSession().save(direccion1);
		getSession().save(direccion2);
		getSession().save(direccion3);
		getSession().save(farmacia1);
		getSession().save(farmacia2);
		getSession().save(farmacia3);
		
		
		List<Farmacia> farmaciaBarrio;
		
		farmaciaBarrio = getSession().createCriteria(Farmacia.class)
				  .createAlias("direccion", "dir")
				  .createAlias("dir.barrio", "ba")
				  .add(Restrictions.eq("ba.nombre", "Caseros")).list();
		
		assertThat(farmaciaBarrio).hasSize(1);
	}

}
