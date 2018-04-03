package deletemessages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("deleteService")
@Transactional(rollbackFor=Exception.class)
public class DeleteServiceImpl implements DeleteService{

	@Autowired
	DeleteDao deleteDao;

	@Override
	public void create(Delete delete) {
		deleteDao.create(delete);
	}

	@Override
	public void update(Delete delete) {
	    deleteDao.update(delete);
	}

	@Override
	public void delete(Delete delete) {
		deleteDao.delete(delete);
	}
	
	
}
