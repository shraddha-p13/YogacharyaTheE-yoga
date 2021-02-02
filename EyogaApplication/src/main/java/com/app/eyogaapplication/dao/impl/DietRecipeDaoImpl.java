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

import com.app.eyogaapplication.dao.DietRecipeDao;
import com.app.eyogaapplication.model.DietPlanDetails;
import com.app.eyogaapplication.model.DietRecipeDetails;

public class DietRecipeDaoImpl implements DietRecipeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int insertDietRecipeInformation(DietRecipeDetails dietRecipeDetails) {
		String sql = "INSERT INTO diet_recipe_details(id,name,description)VALUES(?,?,?)";
		
		return jdbcTemplate.update(sql, dietRecipeDetails.getId(), dietRecipeDetails.getName(), dietRecipeDetails.getDescription());
	}

	@Override
	public Optional<DietRecipeDetails> getDietRecipeDetailsById(String id) {
		String sql = "SELECT id,name,description FROM diet_recipe_details WHERE id = ?";
		Object[] params = new Object[] { id };

		DietRecipeDetails dietRecipe = jdbcTemplate.query(sql, new ResultSetExtractor<DietRecipeDetails>() {
			@Override
			public DietRecipeDetails extractData(ResultSet rs) throws SQLException, DataAccessException {

				DietRecipeDetails dietRecipe = null;

				while (rs.next()) {

					dietRecipe = new DietRecipeDetails();
					dietRecipe.setId(rs.getString("id"));
					dietRecipe.setName(rs.getString("name"));
					dietRecipe.setDescription(rs.getString("description"));
				}

				return dietRecipe;
			}
		}, params);

		return Optional.ofNullable(dietRecipe);

	}

	@Override
	public int updateDietRecipeDetailsById(DietRecipeDetails dietRecipeDetails) {
String query = "UPDATE diet_recipe_details SET name =?,description = ? WHERE id = ?";
		
		return jdbcTemplate.update(query, new Object[] { dietRecipeDetails.getName(), dietRecipeDetails.getDescription(), dietRecipeDetails.getId() });
	}

	@Override
	public int deleteDietRecipeDetails(String id) {
		String sql = "DELETE FROM diet_recipe_details WHERE id = ?";

		Object[] params = new Object[] { id };

		return jdbcTemplate.update(sql, params);

	}

	@Override
	public Optional<List<DietRecipeDetails>> getAllDietRecipeList() {
String sql = "SELECT * FROM diet_recipe_details";
		
		List<DietRecipeDetails> dietRecipeList = jdbcTemplate.query(sql, new ResultSetExtractor<List<DietRecipeDetails>>() {
			@Override
			public List<DietRecipeDetails> extractData(ResultSet rs) throws SQLException, DataAccessException {

				List<DietRecipeDetails> list = new ArrayList<DietRecipeDetails>();
				DietRecipeDetails dietRecipeList = null;
				while (rs.next()) {
					dietRecipeList = new DietRecipeDetails();
					dietRecipeList.setId(rs.getString("id"));
					dietRecipeList.setName(rs.getString("name"));
					dietRecipeList.setDescription(rs.getString("description"));
					list.add(dietRecipeList);
				}

				return list;
			}
		});
		if (dietRecipeList.isEmpty()) {
			return Optional.empty();
		}
		return Optional.ofNullable(dietRecipeList);

	}

}
