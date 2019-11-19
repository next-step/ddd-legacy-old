package camp.nextstep.edu.kitchenpos.dao;

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
import java.util.List;
import java.util.Optional;

@Repository
public class OrderLineItemDao {
    private static final String TABLE_NAME = "order_line_item";
    private static final String KEY_COLUMN_NAME = "seq";

    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert jdbcInsert;

    public OrderLineItemDao(final DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName(TABLE_NAME)
                .usingGeneratedKeyColumns(KEY_COLUMN_NAME)
        ;
    }

    public OrderLineItem save(final OrderLineItem entity) {
        final SqlParameterSource parameters = new BeanPropertySqlParameterSource(entity);
        final Number key = jdbcInsert.executeAndReturnKey(parameters);
        return select(key.longValue());
    }

    public Optional<OrderLineItem> findById(final Long id) {
        try {
            return Optional.of(select(id));
        } catch (final EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    public List<OrderLineItem> findAll() {
        final String sql = "SELECT seq, orders_id, menu_id, quantity FROM order_line_item";
        return jdbcTemplate.query(sql, (resultSet, rowNumber) -> toEntity(resultSet));
    }

    private OrderLineItem select(final Long id) {
        final String sql = "SELECT seq, orders_id, menu_id, quantity FROM order_line_item WHERE seq = ?";
        return jdbcTemplate.queryForObject(sql, (resultSet, rowNumber) -> toEntity(resultSet), id);
    }

    private OrderLineItem toEntity(final ResultSet resultSet) throws SQLException {
        final OrderLineItem entity = new OrderLineItem();
        entity.setSeq(resultSet.getLong(KEY_COLUMN_NAME));
        entity.setOrdersId(resultSet.getLong("orders_id"));
        entity.setMenuId(resultSet.getLong("menu_id"));
        entity.setQuantity(resultSet.getLong("quantity"));
        return entity;
    }
}
