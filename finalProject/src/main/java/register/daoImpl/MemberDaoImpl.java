package register.daoImpl;

import java.sql.Connection;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import product.model.productBean;
import register.dao.MemberDao;
import register.model.MemberBean;

@Repository
public class MemberDaoImpl implements MemberDao {
	@Autowired
	SessionFactory factory;

	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	public MemberDaoImpl() {
//		this.factory = HibernateUtils.getSessionFactory();
	}

	@Override
	public void setConnection(Connection conn) {
//		this.conn = conn;
	}

	@Override
	public boolean checkAccount(String mAccount) {
		boolean exist = false;
		String sql = "FROM MemberBean m WHERE m.mAccount=:mid";
		Session session = factory.getCurrentSession();
		try {
			MemberBean mb = (MemberBean) session.createQuery(sql).setParameter("mid", mAccount).uniqueResult();
			if (mb != null) {
				exist = true;
			}
		} catch (NoResultException ex) {
			exist = false;
		} catch (NonUniqueResultException ex) {
			exist = true;
		}
		return exist;
	}

	@Override
	public int registerMember(MemberBean mb) {
		int n = 0;
		Session session = factory.getCurrentSession();
		session.save(mb);
		n++;

		return n;
	}

	@Override
	public MemberBean queryMember(String mAccount) {
		MemberBean mb = null;
		Session session = factory.getCurrentSession();
		String sql = "FROM MemberBean m WHERE m.mAccount=:mid";
		try {
			mb = (MemberBean) session.createQuery(sql).setParameter("mid", mAccount).uniqueResult();
		} catch (NonUniqueResultException ex) {
			mb = null;
		}
		return mb;
	}

	@Override
	public MemberBean checkPassword(String mAccount, String mPassword) {
		MemberBean mb = null;
		Session session = factory.getCurrentSession();
		String sql = "FROM MemberBean m WHERE m.mAccount=:mid and m.mPassword=:pswd";
		try {
			mb = (MemberBean) session.createQuery(sql).setParameter("mid", mAccount).setParameter("pswd", mPassword)
					.uniqueResult();
		} catch (NoResultException ex) {
			mb = null;
		}

		return mb;
	}
	@Override
	public MemberBean getMemberBymId(int mId) {
		MemberBean mb = null;
		Session session = factory.getCurrentSession();
		String sql = "FROM MemberBean mb WHERE mb.mId=:mid";
		mb = (MemberBean) session.createQuery(sql).setParameter("mid", mId).uniqueResult();
		return mb;
	}
	
	@Override
	public void updateMember(MemberBean mb) {
		
		String hql = "UPDATE MemberBean mb SET mb.mAccount =:mAccount , mb.mPassword =:mPassword WHERE mId =:mId";
		Session session = factory.getCurrentSession();
//		session.saveOrUpdate(mb);
		
		session.saveOrUpdate(mb);
		
	}

}
