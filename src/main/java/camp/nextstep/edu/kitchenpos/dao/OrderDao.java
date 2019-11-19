package camp.nextstep.edu.kitchenpos.dao;

import camp.nextstep.edu.kitchenpos.model.Order;
import camp.nextstep.edu.kitchenpos.model.OrderLineItem;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class OrderDao {
    private static final String TABLE_NAME = "orders";
    private static final String KEY_COLUMN_NAME = "id";

    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert jdbcInsert;

    public OrderDao(final DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName(TABLE_NAME)
                .usingGeneratedKeyColumns(KEY_COLUMN_NAME)
        ;
    }

    public Order save(final OrderLineItem entity) {
        final SqlParameterSource parameters = new BeanPropertySqlParameterSource(entity);
        final Number key = jdbcInsert.executeAndReturnKey(parameters);
        return select(key.longValue());
    }

    public Optional<Order> findById(final Long id) {
        try {
            return Optional.of(select(id));
        } catch (final EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    public List<Order> findAll() {
        final String sql = "SELECT id, order_table_id, order_status, ordered_time FROM orders";
        return jdbcTemplate.query(sql, (resultSet, rowNumber) -> toEntity(resultSet));
    }

    private Order select(final Long id) {
        final String sql = "SELECT id, order_table_id, order_status, ordered_time FROM orders WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, (resultSet, rowNumber) -> toEntity(resultSet), id);
    }

    private Order toEntity(final ResultSet resultSet) throws SQLException {
        final Order entity = new Order();
        entity.setId(resultSet.getLong(KEY_COLUMN_NAME));
        entity.setOrderTableId(resultSet.getLong("order_table_id"));
        entity.setOrderStatus(resultSet.getString("order_status"));
        entity.setOrderedTime(resultSet.getObject("ordered_time", LocalDateTime.class));
        return entity;
    }
}
