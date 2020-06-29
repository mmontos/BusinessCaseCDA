package fr.humanbooster.fx.test_technique.service.impl;

import java.sql.SQLException;
import java.util.List;

import fr.humanbooster.fx.test_technique.business.Domaine;
import fr.humanbooster.fx.test_technique.dao.DomaineDao;
import fr.humanbooster.fx.test_technique.dao.impl.DomaineDaoImpl;
import fr.humanbooster.fx.test_technique.service.DomaineService;

public class DomaineServiceImpl implements DomaineService {

	private DomaineDao domaineDao = new DomaineDaoImpl();

	@Override
	public Domaine ajouterDomaine(Domaine domaine) throws SQLException {
		try {
			return domaineDao.create(domaine);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public Domaine recupererDomaine(Long id) {
		try {
			return domaineDao.findOne(id);
		} catch (SQLException e) {
		}
		return null;
	}

	@Override
	public List<Domaine> recupererDomaines() {
		try {
			return domaineDao.findAll();
		} catch (SQLException e) {
		}
		return null;

	}

	@Override
	public Domaine majDomaine(Domaine domaine) throws SQLException {
		Domaine domaineTemp = new Domaine();
		domaineTemp.setIdDomaine(domaine.getIdDomaine());
		domaineTemp.setNom(domaine.getNom());
		try {
			return domaineDao.update(domaineTemp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean supprimerDomaine(Long id) throws SQLException {
		try {
			return domaineDao.delete(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}