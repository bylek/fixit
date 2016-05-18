package edu.agh.to.fixit.dao.concrete;

import edu.agh.to.fixit.dao.BaseDao;
import edu.agh.to.fixit.dao.contracts.ChoiceDao;
import edu.agh.to.fixit.model.Choice;
import org.springframework.stereotype.Repository;

@Repository
public class ChoiceDaoImpl extends BaseDao<Choice> implements ChoiceDao {
    @Override
    public Choice getChoiceByName(String name) {
        return null;
    }
}
