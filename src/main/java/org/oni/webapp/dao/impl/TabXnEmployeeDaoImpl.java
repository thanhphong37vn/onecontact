package org.oni.webapp.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.oni.webapp.dao.TabXnEmployeeDao;
import org.oni.webapp.dao.base.impl.GenericDaoImpl;
import org.oni.webapp.dao.entity.TabXnEmployee;
import org.oni.webapp.dao.entity.TabXnEmployeeKey;
import org.oni.webapp.utils.PaginationBean;
import org.springframework.stereotype.Repository;

import com.tianque.oa2.OfficeDataSource;
import com.tianque.oa2.setting.Module;
import com.tianque.oa2.setting.ModuleSetting;
import com.tianque.oa2.usermanage.User;

/**
 * This is the implementation class of the TabXnEmployeeDao.
 * 
 * @author Admin
 *
 */
@Repository
public class TabXnEmployeeDaoImpl extends
		GenericDaoImpl<TabXnEmployee, TabXnEmployeeKey> implements
		TabXnEmployeeDao {

	// Câu lệnh lấy thông tin cấu hình service theo tham số tên module
	private static final String LOAD_MODULE = "SELECT T.ID    MODULE_ID, M.COMPANY_ID  COMPANY_ID, T.DESCRIPTION MODULE_DESCRIPTION,  T.MODULE_NAME MODULE_NAME, T.READONLY    MODULE_READONLY, P.ID          PARAM_ID, P.DESCRIPTION PARAM_DESCRIPTION, P.PARAM_NAME  PARAM_NAME, P.READONLY    PARAM_READONLY, P.PARAM_TYPE  PARAM_TYPE, M.TYPE_ID     PARAM_TYPE_ID, M.VALUE       PARAM_VALUE FROM CONF_MODULE T, CONF_PARAM P, CONF_PUBLIC_VALUE M  WHERE T.ID = P.MODULE_ID  AND T.MODULE_NAME = 'webservice'  AND M.PARAM_ID = P.ID AND T.READONLY != 1 AND M.STATUS <> -1 ORDER BY PARAM_NAME,M.ID";

	public TabXnEmployeeDaoImpl() {
		super(TabXnEmployee.class, TabXnEmployeeKey.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TabXnEmployee> searchByKey(String key) {
		Criteria criteria = createCriteria().add(
				Restrictions.like("employeeId", "%" + key + "%"));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TabXnEmployee> searchByCompanyKey(String key) {
		Criteria criteria = createCriteria().add(
				Restrictions.like("companyId", "%" + key + "%"));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TabXnEmployee> searchByEmployeeName(String employeeName) {
		Criteria criteria = createCriteria().add(
				Restrictions.like("employeeByname", "%" + employeeName + "%"));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TabXnEmployee> searchByEmployeeMobile(String employeePhone) {
		Criteria criteria = createCriteria().add(
				Restrictions.like("mobilePhone", "%" + employeePhone + "%"));
		return criteria.list();
	}

	@Override
	public List<TabXnEmployee> getListEmployee(PaginationBean paginationBean,
			Integer cate) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * This method using to chech data user
	 * 
	 * @param companyMobile
	 * @param ext
	 * @param pwd
	 * @return
	 */
	@Override
	public User getUser(String companyMobile, String ext, String pwd) {
		User user = null;
		Session session = getCurrentSession();
		Connection con = session.connection();
		StringBuilder q = new StringBuilder();
		ResultSet rs = null;
		Statement stm = null;
		if (companyMobile != null && ext != null && pwd != null) {
			q.append("SELECT E.*,C.*, X.* FROM VAS.TAB_XN_EMPLOYEE_H E ");
			q.append(" INNER JOIN VAS.TAB_XN_COMPANY_H C");
			q.append(" ON C.COMPANY_ID        = E.COMPANY_ID ");
			q.append(" INNER JOIN VAS.TAB_XN_EMP_EXT_H X ON X.EMPLOYEE_ID       = E.EMPLOYEE_ID");
			q.append(" WHERE C.COMPANY_MOBILE = '").append(companyMobile)
					.append("'");
			q.append(" AND E.EMPLOYEE_NO      = '").append(ext).append("'");
			q.append(" AND E.EMPLOYEE_PWD     = '").append(pwd).append("'");
			q.append(" AND E.EMPLOYEE_STATUS <> 3 ");

			try {
				stm = con.createStatement();
				System.out.println(q.toString());
				rs = stm.executeQuery(q.toString());
				if (rs.next()) {
					System.out.println("Co du lieu...!");
					user = new User();
					user.setVasUserId(Integer.parseInt(rs
							.getBigDecimal("EMPLOYEE_ID") + ""));
					user.setId(Integer.parseInt(rs.getBigDecimal("EMPLOYEE_ID")
							+ ""));
					user.setTruename(rs.getString("EMPLOYEE_NAME"));
					user.setMobile(rs.getString("MOBILE_PHONE") + "");
					user.setEmployee_no(rs.getBigDecimal("EMPLOYEE_NO") + "");
					user.setCompanyid(Integer.parseInt(rs
							.getBigDecimal("COMPANY_ID") + ""));
					user.setCompanyName(rs.getString("COMPANY_NAME"));
					user.setCompany_mobile(rs.getString("COMPANY_MOBILE") + "");
					user.setSex(rs.getBigDecimal("EMPLOYEE_SEX") + "");
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				OfficeDataSource.closeResultSet(rs);
				OfficeDataSource.closeStatement(stm);
				OfficeDataSource.closeConnection(con);

				// session.close();
			}
		}
		return user;
	}

	/**
	 * This method using get configuration infomation
	 * 
	 * @return Module : Config to call service
	 */
	@Override
	public Module getModule() {
		Module module = null;
		Session session = getCurrentSession();
		Connection con = session.connection();
		Statement stm = null;
		ResultSet rs = null;

		try {
			stm = con.createStatement();
			rs = stm.executeQuery(LOAD_MODULE);
			module = new Module();
			while (rs.next()) {
				if (rs.getString("PARAM_NAME").equals("evas-port"))
					module.seteServerPort(rs.getString("PARAM_VALUE"));
				if (rs.getString("PARAM_NAME").equals("evas-ip"))
					module.seteServerIp(rs.getString("PARAM_VALUE"));
				if (rs.getString("PARAM_NAME").equals("evas-cross-port"))
					module.setServerCrossPort(rs.getString("PARAM_VALUE"));
				if (rs.getString("PARAM_NAME").equals("vas-ip"))
					module.setSocketIp(rs.getString("PARAM_VALUE"));
				if (rs.getString("PARAM_NAME").equals("vas-port"))
					module.setSocketPort(rs.getString("PARAM_VALUE"));
			}

		} catch (Exception e) {
		} finally {
			OfficeDataSource.closeResultSet(rs);
			OfficeDataSource.closeStatement(stm);
			OfficeDataSource.closeConnection(con);
			// session.close();
		}
		return module;
	}
}