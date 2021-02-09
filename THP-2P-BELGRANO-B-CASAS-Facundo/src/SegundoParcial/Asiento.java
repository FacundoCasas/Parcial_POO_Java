package SegundoParcial;

public class Asiento {
	private final double TURISTA = 50000;
	private final double BUSINESS = 100000;
	private final double PRIMERA = 150000;
	private Pasajero pasajero;
	private Clase clase;
	private double precio;

	public Asiento(Pasajero pasajero, Clase clase) {
		setPasajero(pasajero);
		setClase(clase);
		setPrecioSegunClase(clase);
	}

	public int buscarDniPasajero() {
		return pasajero.getDni();
	}

	private void setPrecioSegunClase(Clase clase) {
		if (clase == Clase.TURISTA) {
			this.precio = TURISTA;
		}else if (clase == Clase.BUSINESS) {
			this.precio = BUSINESS;
		}else if (clase == Clase.PRIMERA) {
			this.precio = PRIMERA;
		}
	}
	
	private void setPasajero(Pasajero pasajero) {
		this.pasajero = pasajero;
	}

	private void setClase(Clase clase) {
		this.clase = clase;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public Clase getClase() {
		return this.clase;
	}
	public double getPrecio() {
		return precio;
	}

	@Override
	public String toString() {
		return "Boleto [pasajero=" + pasajero.toString() + ", clase=" + clase + ", precio=" + precio + "]";
	}
}
