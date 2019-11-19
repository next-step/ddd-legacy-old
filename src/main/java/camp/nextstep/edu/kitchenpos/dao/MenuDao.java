package camp.nextstep.edu.kitchenpos.dao;

import camp.nextstep.edu.kitchenpos.model.Menu;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class MenuDao {
    private static final String TABLE_NAME = "menu";
    private static final String KEY_COLUMN_NAME = "id";

    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert jdbcInsert;

    public MenuDao(final DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName(TABLE_NAME)
                .usingGeneratedKeyColumns(KEY_COLUMN_NAME)
        ;
    }

    public Menu save(final Menu menu) {
        final SqlParameterSource parameters = new BeanPropertySqlParameterSource(menu);
        final Number key = jdbcInsert.executeAndReturnKey(parameters);
        return select(key.longValue());
    }

    public Optional<Menu> findById(final Long id) {
        try {
            return Optional.of(select(id));
        } catch (final EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    public List<Menu> findAll() {
        final String sql = "SELECT id, name, price, menu_group_id FROM menu ";
        return jdbcTemplate.query(sql, (resultSet, rowNumber) -> toEntity(resultSet));
    }

    private Menu select(final Long id) {
        final String sql = "SELECT id, name, price, menu_group_id FROM menu WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, (resultSet, rowNumber) -> toEntity(resultSet), id);
    }

    private Menu toEntity(final ResultSet resultSet) throws SQLException {
        final Menu menu = new Menu();
        menu.setId(resultSet.getLong("id"));
        menu.setName(resultSet.getString("name"));
        menu.setPrice(resultSet.getBigDecimal("price"));
        resultSet.getLong("menu_group_id");
        return menu;
    }
}
