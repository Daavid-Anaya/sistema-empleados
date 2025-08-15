package model.dao;

import java.util.List;

import controller.Coordinador;
import model.vo.VoArea;

public class DaoArea {
    @SuppressWarnings("unused")
    private Coordinador coordinador;

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    public VoArea buscarArea(VoArea a) {
        return null;
    }

    public boolean insertarArea(VoArea a) {
        return false;
    }

    public boolean actualizarArea(VoArea a) {
        return false;
    }

    public boolean eliminarArea(VoArea a) {
        return false;
    }

	public List<VoArea> cargaListaAreas() {
		return null;
	}
}
