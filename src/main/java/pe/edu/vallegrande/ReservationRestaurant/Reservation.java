package pe.edu.vallegrande.ReservationRestaurant;

public class Reservation {
    private String name;
    private String apellido;
    private String phone;
    private String dni;
    private int edad;
    private String sexo;
    private String date;
    private String time;

    public Reservation(String name, String apellido, String phone, String dni, int edad, String sexo, String date, String time) {
        this.name = name;
        this.apellido = apellido;
        this.phone = phone;
        this.dni = dni;
        this.edad = edad;
        this.sexo = sexo;
        this.date = date;
        this.time = time;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getApellido() {
        return apellido;
    }

    public String getPhone() {
        return phone;
    }

    public String getDni() {
        return dni;
    }

    public int getEdad() {
        return edad;
    }

    public String getSexo() {
        return sexo;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }
}
