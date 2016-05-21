package edu.agh.to.fixit.dao.concrete;

import edu.agh.to.fixit.dao.BaseDao;
import edu.agh.to.fixit.dao.contracts.RepairRepository;
import edu.agh.to.fixit.model.Item;
import edu.agh.to.fixit.model.Repair;

/**
 * Created by mkuligowski on 20.05.16.
 */
public class RepairRepositoryImpl extends BaseDao<Repair> implements RepairRepository {
    @Override
    public void createRepair(Item item) {

    }

    @Override
    public int getRepairId(String serialNumber) {
        return 0;
    }
}
