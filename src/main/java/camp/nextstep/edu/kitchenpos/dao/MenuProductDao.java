package camp.nextstep.edu.kitchenpos.dao;

import camp.nextstep.edu.kitchenpos.model.MenuProduct;
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
public class MenuProductDao {
    private static final String TABLE_NAME = "menu_product";
    private static final String KEY_COLUMN_NAME = "seq";

    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert jdbcInsert;

    public MenuProductDao(final DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName(TABLE_NAME)
                .usingGeneratedKeyColumns(KEY_COLUMN_NAME)
        ;
    }

    public MenuProduct save(final MenuProduct entity) {
        final SqlParameterSource parameters = new BeanPropertySqlParameterSource(entity);
        final Number key = jdbcInsert.executeAndReturnKey(parameters);
        return select(key.longValue());
    }

    public Optional<MenuProduct> findById(final Long id) {
        try {
            return Optional.of(select(id));
        } catch (final EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    public List<MenuProduct> findAll() {
        final String sql = "SELECT seq, menu_id, product_id, quantity FROM menu_product";
        return jdbcTemplate.query(sql, (resultSet, rowNumber) -> toEntity(resultSet));
    }

    private MenuProduct select(final Long id) {
        final String sql = "SELECT seq, menu_id, product_id, quantity FROM menu_product WHERE seq = ?";
        return jdbcTemplate.queryForObject(sql, (resultSet, rowNumber) -> toEntity(resultSet), id);
    }

    private MenuProduct toEntity(final ResultSet resultSet) throws SQLException {
        final MenuProduct entity = new MenuProduct();
        entity.setSeq(resultSet.getLong(KEY_COLUMN_NAME));
        entity.setMenuId(resultSet.getLong("menu_id"));
        entity.setProductId(resultSet.getLong("product_id"));
        entity.setQuantity(resultSet.getLong("quantity"));
        return entity;
    }
}
