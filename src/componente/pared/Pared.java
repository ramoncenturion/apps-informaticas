package componente.pared;

import componente.Componente;

public class Pared implements Componente {

	private TipoLadrilloPared tipoLadrillo;
	private TipoRevestimientoExtPared tipoRevestimientoExt;
	private TipoRevestimientoIntPared tipoRevestimientoInt;
	
	public Pared(int tipoLadrillo, int tipoRevInt, int tipoRevExt){
		this.setTipoLadrillo(TipoLadrilloPared.values()[tipoLadrillo-1]);
		this.setTipoRevestimientoInt(TipoRevestimientoIntPared.values()[tipoRevInt-1]);
		this.setTipoRevestimientoExt(TipoRevestimientoExtPared.values()[tipoRevExt-1]);
	}
	
	@Override
	public String getDescripcion() {
		return "Pared: ladrillo " + this.tipoLadrillo.getDescripcion() + 
			   "\nrevestimiento interior: " + this.tipoRevestimientoInt.getDescripcion() + 
			   "\nrevestimiento exterior: " + this.tipoRevestimientoExt.getDescripcion();
	}

	@Override
	public int getValor() {
		return (this.tipoLadrillo.getValor()+this.tipoRevestimientoInt.getValor()+this.tipoRevestimientoExt.getValor())/3;
	}

	public TipoLadrilloPared getTipoLadrillo() {
		return tipoLadrillo;
	}

	public void setTipoLadrillo(TipoLadrilloPared tipoLadrillo) {
		this.tipoLadrillo = tipoLadrillo;
	}

	public TipoRevestimientoExtPared getTipoRevestimientoExt() {
		return tipoRevestimientoExt;
	}

	public TipoRevestimientoIntPared getTipoRevestimientoInt() {
		return tipoRevestimientoInt;
	}

	public void setTipoRevestimientoExt(TipoRevestimientoExtPared tipoRevestimientoExt) {
		this.tipoRevestimientoExt = tipoRevestimientoExt;
	}

	public void setTipoRevestimientoInt(TipoRevestimientoIntPared tipoRevestimientoInt) {
		this.tipoRevestimientoInt = tipoRevestimientoInt;
	}
}
