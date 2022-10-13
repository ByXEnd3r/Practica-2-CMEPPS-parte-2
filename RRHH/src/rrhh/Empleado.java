package rrhh;

public class Empleado {

	public enum TipoEmpleado{Vendedor, Encargado};
	
	public static float calculoNominaBruta(TipoEmpleado tipo, float ventasMes, float horasExtra) {
		float salarioBase = 0;
		if (tipo.equals(TipoEmpleado.Vendedor))
			salarioBase = 2000;
		else if (tipo.equals(TipoEmpleado.Encargado))
			salarioBase = 2500;
		if (ventasMes >= 1500)
			salarioBase += 200;
		else if (ventasMes >= 1000)
			salarioBase += 100;
		salarioBase += horasExtra * 30;
		return salarioBase;
	}
	
	public static float calculoNominaNeta(float nominaBruta) {
		float retencion = 0;
		if (nominaBruta >= 2500)
			retencion = (float)0.18;
		else if (nominaBruta >= 2100)
			retencion = (float)0.15;
		return nominaBruta*(1-retencion);
	}
	
}
