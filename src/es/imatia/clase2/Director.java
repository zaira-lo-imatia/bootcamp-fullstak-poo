package es.imatia.clase2;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Director extends Empleado{

	private String departamento;
	private int personal;
	
	public Director(String nombre, int edad, LocalDate fechaIngreso, double salario, String departamento, int personal) {
		super(nombre, edad, fechaIngreso, salario);
		this.departamento= departamento;
		this.personal = personal;
	}
	
	

	@Override
	public void incentivar() {
		long diff = this.getFechaIngreso().until(LocalDate.now() , ChronoUnit.MONTHS);
		String mensaje ="no ha recibido incremento";
		if(diff>30 && this.personal> 20) {
			this.setSalario(this.getSalario() + (BONO*2));
			mensaje = "ha recibido bono por 2";
		}else if(diff>30 || this.personal> 20) {
			this.setSalario( this.getSalario() + BONO);
			mensaje = "ha recibido bono simple";
		}
		System.out.println("El incentivo del director " + mensaje +  ",nuevo salario " + this.getSalario());
		
	}



	/**
	 * @return the departamento
	 */
	public String getDepartamento() {
		return departamento;
	}

	/**
	 * @param departamento the departamento to set
	 */
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	/**
	 * @return the personal
	 */
	public int getPersonal() {
		return personal;
	}

	/**
	 * @param personal the personal to set
	 */
	public void setPersonal(int personal) {
		this.personal = personal;
	}

	

}
