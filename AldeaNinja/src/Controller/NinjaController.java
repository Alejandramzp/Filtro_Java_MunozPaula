
package Controller;

import Dao.NinjaDao;
import Model.NinjaModel;
import java.util.List;


public class NinjaController {
    
    private NinjaDao ninjaDao;

    public NinjaController() {
        this.ninjaDao = new NinjaDao();
    }
    
    public boolean addNinja(NinjaModel ninja){
        return ninjaDao.addNinja(ninja);
    }
    
    public List<NinjaModel> getAllNinja(){
        return ninjaDao.getAllNinja();
    }
    
}
