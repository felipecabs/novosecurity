package cl.usm.novosec.ingreso.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import cl.usm.novosec.ingreso.dao.Ingreso;
import cl.usm.novosec.ingreso.dao.IngresoPK;

public interface IngresoRepository extends CrudRepository<Ingreso, IngresoPK> {
	
	@Query(value = "from Ingreso t where FECHA BETWEEN :startDate AND :endDate" )
	public List<Ingreso> getAllBetweenDates(@Param("startDate")Date startDate,@Param("endDate")Date endDate);
}
