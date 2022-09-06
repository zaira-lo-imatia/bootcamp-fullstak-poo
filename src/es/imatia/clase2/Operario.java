package es.imatia.clase2;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Operario extends Empleado{
	private int nivel;

	public Operario(String nombre, int edad, LocalDate fechaIngreso, double salario, int nivel) {
		super(nombre, edad, fechaIngreso, salario);
		this.nivel = nivel;
	}

	
	@Override
	public void incentivar() {
		String mensaje ="no ha recibido incremento";
		if(this.getEdad()>30 && this.getNivel()> 2) {
			this.setSalario(this.getSalario() + (BONO*2));
			mensaje = "ha recibido bono por 2";
		}else if(this.getEdad()>30 || this.getNivel()> 2) {
			this.setSalario( this.getSalario() + BONO);
			mensaje = "ha recibido bono simple";
		}
		System.out.println("El incentivo del operario " + mensaje + ", nuevo salario " + this.getSalario());
	}


	/**
	 * @return the nivel
	 */
	public int getNivel() {
		return nivel;
	}

	/**
	 * @param nivel the nivel to set
	 */
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
	
	public void actualizarNivel() {
		long diff = this.getFechaIngreso().until(LocalDate.now() , ChronoUnit.YEARS);
		if(diff > 2 && this.getNivel()<5) {
			this.setNivel(this.getNivel()+1);
		}
	}
	
	

}
