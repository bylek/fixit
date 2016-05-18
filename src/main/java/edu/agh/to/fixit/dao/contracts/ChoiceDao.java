package edu.agh.to.fixit.dao.contracts;

import edu.agh.to.fixit.dao.CrudDao;
import edu.agh.to.fixit.model.Choice;

public interface ChoiceDao extends CrudDao<Choice>{

    Choice getChoiceByName(String name);

}
