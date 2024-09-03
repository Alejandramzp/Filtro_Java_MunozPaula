
package Model;


public class MisionNinjaModel {
    private int id_ninja;
    private int id_mision;
    private String fechaInicio;
    private String fechaFin;

    public MisionNinjaModel() { }

    public MisionNinjaModel(int id_ninja, int id_mision, String fechaInicio, String fechaFin) {
        this.id_ninja = id_ninja;
        this.id_mision = id_mision;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public int getId_ninja() {
        return id_ninja;
    }

    public void setId_ninja(int id_ninja) {
        this.id_ninja = id_ninja;
    }

    public int getId_mision() {
        return id_mision;
    }

    public void setId_mision(int id_mision) {
        this.id_mision = id_mision;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }
    
}
