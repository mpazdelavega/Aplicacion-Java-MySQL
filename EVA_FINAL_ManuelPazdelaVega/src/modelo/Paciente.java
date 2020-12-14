package modelo;


public class Paciente {
    
    private String rut;
    private String nombre;
    private String genero;
    private int edad;
    private String direccion;
    private String ciudad;
    private String isapre;
    private int donante;

    public Paciente() {
    }

    public Paciente(String rut, String nombre, String genero, int edad, String direccion, String ciudad, String isapre, int donante) {
        this.rut = rut;
        this.nombre = nombre;
        this.genero = genero;
        this.edad = edad;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.isapre = isapre;
        this.donante = donante;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getIsapre() {
        return isapre;
    }

    public void setIsapre(String isapre) {
        this.isapre = isapre;
    }

    public int getDonante() {
        return donante;
    }

    public void setDonante(int donante) {
        this.donante = donante;
    }
    
    
}
