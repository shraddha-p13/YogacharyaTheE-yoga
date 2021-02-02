package com.app.eyogaapplication.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.app.eyogaapplication.dao.DietPlanDao;
import com.app.eyogaapplication.model.DietPlanDetails;

@Repository
public class DietPlanDaoImpl implements DietPlanDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int insertDietInformation(DietPlanDetails dietPlans) 
	{
		String sql = "INSERT INTO diet_plans(id,name,description)VALUES(?,?,?)";
		
		return jdbcTemplate.update(sql, dietPlans.getId(), dietPlans.getName(), dietPlans.getDescription());
	}

	@Override
	public Optional<DietPlanDetails> getDietDetailsById(String id) 
	{
		String sql = "SELECT id,name,description FROM diet_plans WHERE id = ?";
		Object[] params = new Object[] { id };

		DietPlanDetails dietPlan = jdbcTemplate.query(sql, new ResultSetExtractor<DietPlanDetails>() {
			@Override
			public DietPlanDetails extractData(ResultSet rs) throws SQLException, DataAccessException {

				DietPlanDetails dietPlan = null;

				while (rs.next()) {

					dietPlan = new DietPlanDetails();
					dietPlan.setId(rs.getString("id"));
					dietPlan.setName(rs.getString("name"));
					dietPlan.setDescription(rs.getString("description"));
				}

				return dietPlan;
			}
		}, params);

		return Optional.ofNullable(dietPlan);
	}

	@Override
	public int updateDietDetailsById(DietPlanDetails dietPlans) 
	{
		String query = "UPDATE diet_plans SET name =?,description = ? WHERE id = ?";
		
		return jdbcTemplate.update(query, new Object[] { dietPlans.getName(), dietPlans.getDescription(), dietPlans.getId() });
	}

	@Override
	public int deleteDietDetailsById(String id) 
	{
		String sql = "DELETE FROM diet_plans WHERE id = ?";

		Object[] params = new Object[] { id };

		return jdbcTemplate.update(sql, params);
	}

	@Override
	public Optional<List<DietPlanDetails>> getAllDietList() 
	{
		String sql = "SELECT * FROM diet_plans";
		
		List<DietPlanDetails> dietPlanList = jdbcTemplate.query(sql, new ResultSetExtractor<List<DietPlanDetails>>() {
			@Override
			public List<DietPlanDetails> extractData(ResultSet rs) throws SQLException, DataAccessException {

				List<DietPlanDetails> list = new ArrayList<DietPlanDetails>();
				DietPlanDetails dietPlan = null;
				while (rs.next()) {
					dietPlan = new DietPlanDetails();
					dietPlan.setId(rs.getString("id"));
					dietPlan.setName(rs.getString("name"));
					dietPlan.setDescription(rs.getString("description"));
					list.add(dietPlan);
				}

				return list;
			}
		});
		if (dietPlanList.isEmpty()) {
			return Optional.empty();
		}
		return Optional.ofNullable(dietPlanList);
	}

}
