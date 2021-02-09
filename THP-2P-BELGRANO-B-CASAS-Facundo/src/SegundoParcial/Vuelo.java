package SegundoParcial;

import java.util.ArrayList;

public class Vuelo {

	private String nroVuelo;
	private int cantidadTotalAsientos;
	private ArrayList<Asiento> asientos;
	private ArrayList<Asiento> asientosReservados;
	private double montoTotalRecaudado;

	public Vuelo(String nroVuelo, int cantidadTotalAsientos) {
		setNroVuelo(nroVuelo);
		setCantidadTotalAsientos(cantidadTotalAsientos);
		setMontoTotalRecaudado(0);
		asientos = new ArrayList<Asiento>();
		asientosReservados = new ArrayList<Asiento>();
	}

	public void mostrarMontoRecaudadoDeClase(Clase clase) {
		double montoAcumulado = obtenerAcumuladoPorClase(clase);
		if (montoAcumulado > 0) {
			System.out.println("El monto acumulado hasta el momento en la clase " + clase + " es: $" + montoAcumulado);
		}else if (montoAcumulado == 0 && asientosReservados.size() > 0 ) {
			System.out.println("No hay asientos reservados para clase " + clase);
		}else {
			System.out.println("No hay asientos reservados en ninguna clase");
		}
	}

	private double obtenerAcumuladoPorClase(Clase clase) {
		double montoAcumulado = 0;
		for (Asiento asiento : asientosReservados) {
			if (asiento.getClase() == clase) {
				montoAcumulado = montoAcumulado + asiento.getPrecio();
			}
		}	
		return montoAcumulado;
	}

	public String anularReserva(int dni) {
		Asiento asientoBuscado = buscarAsientoReservado(dni);
		String mensaje = "No existe una reserva con ese DNI";
		if (asientoBuscado != null) {
			mensaje ="Se ha anulado la reserva con éxito";
			asientosReservados.remove(asientoBuscado);
		}
		return mensaje;
	}

	public void listarAsientosReservados() {
		System.out.println("Cantidad de asientos reservados hasta el momento:" + asientosReservados.size());
		for (Asiento asiento : asientosReservados) {
			System.out.println(asiento.toString());
		}
	}

	public ResultadoReservaBoletos reservarAsiento(int dni,int telefono,Clase clase) {
		ResultadoReservaBoletos resultado = ResultadoReservaBoletos.RESERVA_CONFIRMADA;
		Asiento asientoPasajero = buscarAsientoReservado(dni);
		if (cantidadTotalAsientos <= asientosReservados.size()) {
			resultado = ResultadoReservaBoletos.ERROR_AVION_COMPLETO;
		}else if (asientoPasajero != null) {
			resultado = ResultadoReservaBoletos.ERROR_YA_TIENE_UN_PASAJE;
		}else if (resultado == ResultadoReservaBoletos.RESERVA_CONFIRMADA) {
			Asiento asientoNuevo = new Asiento(new Pasajero(dni,telefono),clase);
			setMontoTotalRecaudado(asientoNuevo.getPrecio());
			asientosReservados.add(asientoNuevo);

		}
		return resultado;
	}

	private Asiento buscarAsientoReservado(int dni) {
		Asiento asientoBuscado = null;
		int i = 0;
		Asiento asiento;
		while (i < asientosReservados.size() && asientoBuscado == null) {
			asiento = asientosReservados.get(i);
			if (asiento.buscarDniPasajero() == dni) {
				asientoBuscado = asiento;
			}else {
				i++;
			}
		}
		return asientoBuscado;
	}

	private void setNroVuelo(String nroVuelo) {
		this.nroVuelo = nroVuelo;
	}
	private void setCantidadTotalAsientos(int cantidadTotalAsientos) {
		this.cantidadTotalAsientos = cantidadTotalAsientos;
	}
	private void setMontoTotalRecaudado(double montoTotalRecaudado) {
		this.montoTotalRecaudado = montoTotalRecaudado + this.montoTotalRecaudado;
	}

	@Override
	public String toString() {
		return "Vuelo [nroVuelo=" + nroVuelo + ", cantidadTotalAsientos=" + cantidadTotalAsientos + ", asientos=" + asientos
				+ ", asientosReservados=" + asientosReservados + ", montoTotalRecaudado=" + montoTotalRecaudado + "]";
	}
}
