package edu.agh.to.fixit.dao.contracts;

import edu.agh.to.fixit.dao.CrudDao;
import edu.agh.to.fixit.model.Item;
import edu.agh.to.fixit.model.Repair;

/**
 * Created by mkuligowski on 20.05.16.
 */
public interface RepairRepository extends CrudDao<Repair> {
    void createRepair(Item item);
    int getRepairId(String serialNumber);
}
