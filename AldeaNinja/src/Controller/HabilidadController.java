
package Controller;

import Dao.HabilidadDao;
import Model.HabilidadModel;

public class HabilidadController {
    private HabilidadDao habilidadDao;

    public HabilidadController() {
        this.habilidadDao = new HabilidadDao();
    }
    
    public boolean addHabilidad(HabilidadModel habi){
        return habilidadDao.addHabilidad(habi);
    }
    
    public boolean isNinjaExists(int id) {
        return habilidadDao.isNinjaExists(id);
    }
    
}

