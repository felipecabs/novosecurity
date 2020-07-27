package cl.usm.novosec.ingreso.signature;

import java.util.ArrayList;
import java.util.List;

import cl.usm.novosec.ingreso.model.Ingreso;

public class ListarIngresosReq {
	List<Ingreso> ingresos;
	
	public ListarIngresosReq() {
		ingresos = new ArrayList<Ingreso>();
	}
	
	public List<Ingreso> getIngresos() {
		return ingresos;
	}
	
	public void setIngresos(List<Ingreso> ingresos) {
		this.ingresos = ingresos;
	}
	
}
