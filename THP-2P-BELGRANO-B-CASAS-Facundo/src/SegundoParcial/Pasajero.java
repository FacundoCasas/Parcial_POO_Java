package SegundoParcial;

public class Pasajero {

	private int dni;
	private int telefono;

	public Pasajero(int dni, int telefono) {
		setDni(dni);
		setTelefono(telefono);
	}

	private void setDni(int dni) {
		this.dni = dni;
	}

	private void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public int getDni() {
		return dni;
	}

	@Override
	public String toString() {
		return "Pasajero [dni=" + dni + ", telefono=" + telefono + "]";
	}


}



	

