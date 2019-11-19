package camp.nextstep.edu.kitchenpos.dao;

import camp.nextstep.edu.kitchenpos.model.OrderTable;
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
public class OrderTableDao {
    private static final String TABLE_NAME = "order_table";
    private static final String KEY_COLUMN_NAME = "id";

    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert jdbcInsert;

    public OrderTableDao(final DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName(TABLE_NAME)
                .usingGeneratedKeyColumns(KEY_COLUMN_NAME)
        ;
    }

    public OrderTable save(final OrderTable entity) {
        final SqlParameterSource parameters = new BeanPropertySqlParameterSource(entity);
        final Number key = jdbcInsert.executeAndReturnKey(parameters);
        return select(key.longValue());
    }

    public Optional<OrderTable> findById(final Long id) {
        try {
            return Optional.of(select(id));
        } catch (final EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    public List<OrderTable> findAll() {
        final String sql = "SELECT id, table_group_id, number_of_guests, empty FROM order_table";
        return jdbcTemplate.query(sql, (resultSet, rowNumber) -> toEntity(resultSet));
    }

    private OrderTable select(final Long id) {
        final String sql = "SELECT id, table_group_id, number_of_guests, empty FROM order_table WHERE seq = ?";
        return jdbcTemplate.queryForObject(sql, (resultSet, rowNumber) -> toEntity(resultSet), id);
    }

    private OrderTable toEntity(final ResultSet resultSet) throws SQLException {
        final OrderTable entity = new OrderTable();
        entity.setId(resultSet.getLong(KEY_COLUMN_NAME));
        entity.setTableGroupId(resultSet.getLong("table_group_id"));
        entity.setNumberOfGuests(resultSet.getInt("number_of_guests"));
        entity.setEmpty(resultSet.getBoolean("empty"));
        return entity;
    }
}
