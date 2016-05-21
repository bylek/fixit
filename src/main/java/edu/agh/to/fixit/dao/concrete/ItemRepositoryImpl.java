package edu.agh.to.fixit.dao.concrete;

import edu.agh.to.fixit.dao.BaseDao;
import edu.agh.to.fixit.dao.contracts.ItemRepository;
import edu.agh.to.fixit.model.Item;
import org.springframework.stereotype.Repository;

/**
 * Created by mkuligowski on 20.05.16.
 */
@Repository
public class ItemRepositoryImpl extends BaseDao<Item> implements ItemRepository {
}
