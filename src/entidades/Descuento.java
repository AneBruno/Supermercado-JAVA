package entidades;

import java.sql.Date;

public class Descuento {

	private int idDcto;
	private Date fechaDctoFin, fechaDctoInicio;
	private Double porcDcto;
	
	public int getIdDcto() {
		return idDcto;
	}
	public void setIdDcto(int idDcto) {
		this.idDcto = idDcto;
	}
	public Date getFechaDctoFin() {
		return fechaDctoFin;
	}
	public void setFechaDctoFin(java.util.Date fechaDctoFin) {
		this.fechaDctoFin = (Date) fechaDctoFin;
	}
	public Date getFechaDctoInicio() {
		return fechaDctoInicio;
	}
	public void setFechaDctoInicio(java.util.Date fechaDctoInicio) {
		this.fechaDctoInicio = (Date) fechaDctoInicio;
	}
	public Double getPorcDcto() {
		return porcDcto;
	}
	public void setPorcDcto(Double porcDcto) {
		this.porcDcto = porcDcto;
	}
	
	
}
