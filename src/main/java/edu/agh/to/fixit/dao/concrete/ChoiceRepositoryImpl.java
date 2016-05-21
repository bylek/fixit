package edu.agh.to.fixit.dao.concrete;

import edu.agh.to.fixit.dao.BaseDao;
import edu.agh.to.fixit.dao.contracts.ChoiceRepository;
import edu.agh.to.fixit.model.Choice;
import org.springframework.stereotype.Repository;

@Repository
public class ChoiceRepositoryImpl extends BaseDao<Choice> implements ChoiceRepository {
    @Override
    public Choice getChoiceByName(String name) {
        return null;
    }

    @Override
    public void reportChoice(Choice choice) {

    }
}
