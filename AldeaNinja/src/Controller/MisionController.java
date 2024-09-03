
package Controller;

import Dao.MisionDao;
import Model.MisionModel;
import java.util.List;


public class MisionController {
    
    private MisionDao misionDao;

    public MisionController() {
        this.misionDao = new MisionDao();
    }
    
    public boolean addMision(MisionModel mision){
        return misionDao.addMision(mision);
    }
    
    public List<MisionModel> getAllMision(){
        return misionDao.getAllMision();
    }
    
}
