package es.imatia.clase2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio2 {

	public static void main(String[] args) {
		//Empleado e = new Empleado("empleado", 35, LocalDate.of(2020, 5, 1), 25000);
		Empleado d = new Director("director", 41, LocalDate.of(2020, 2, 3), 40000, "TIC", 25);
		Empleado d2 = new Director("director2", 41, LocalDate.of(2020, 2, 3), 40000, "TIC", 15);
		Empleado d3 = new Director("director3", 41, LocalDate.of(2022, 4, 3), 40000, "TIC", 25);
		Empleado d4 = new Director("director", 41, LocalDate.of(2022, 2, 3), 40000, "TIC", 15);
		Empleado o = new Operario("operario", 35, LocalDate.of(2019, 6, 5), 26000, 3);
		Empleado o2 = new Operario("operario2", 31, LocalDate.of(2019, 6, 5), 26000, 2);
		Empleado o3 = new Operario("operario3", 27, LocalDate.of(2022, 6, 5), 26000, 3);
		Operario o4 = new Operario("operario2", 25, LocalDate.of(2019, 6, 5), 26000, 1);
		Director e = new Director("director-empleado", 35, LocalDate.of(2020, 2, 3), 45000, "TIC", 30);
//		e.incentivar();
//		d.incentivar();
//		d2.incentivar();
//		d3.incentivar();
//		d4.incentivar();
//		o.incentivar();
//		((Operario) o2).actualizarNivel();
//		o2.incentivar();
//		o3.incentivar();
//		o4.incentivar();
		
		List<Empleado> listaempleados = new ArrayList<>();
		listaempleados.add(e);
		listaempleados.add(o4);
		listaempleados.add(d4);
		for (Empleado empleado : listaempleados) {
			empleado.incentivar();
		}

	}

}
