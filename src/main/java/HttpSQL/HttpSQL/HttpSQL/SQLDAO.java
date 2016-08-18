package HttpSQL.HttpSQL.HttpSQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class SQLDAO {
	private static SQLDAO mapper = new SQLDAO();

	private static JdbcTemplate jdbcTemplate;
	private String sql;
	// private MapSqlParameterSource parametr = new MapSqlParameterSource();

	SQLDAO() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/BOOKMANAGER?useUnicode=true&characterEncoding=utf-8");
		dataSource.setUsername("root");
		dataSource.setPassword("1515");

		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public static SQLDAO GetMapper() {
		return mapper;
	}

	public book getBookByID(int ID) {
		sql = "select * from bookmanager.books where id=?";
		RowMapper<book> rowMapper = new RowMapper<book>() {

			@Override
			public book mapRow(ResultSet rs, int rowNum) throws SQLException {
				book book = new book();
				book.setId(rs.getInt("ID"));
				book.setTitle(rs.getString("BOOK_TITLE"));
				book.setAuthor(rs.getString("BOOK_AUTHOR"));
				book.setPrice(rs.getString("BOOK_PRICE"));
				return book;
			}
		};
		return jdbcTemplate.queryForObject(sql, new Object[] { ID }, rowMapper);
	}

	public void update(book book) {
		String sql = "update bookmanager.books SET BOOK_TITLE=?,BOOK_AUTHOR=?,BOOK_PRICE=? WHERE id=?";
		jdbcTemplate.update(sql, new Object[] { book.getTitle(), book.getAuthor(), book.getPrice(), book.getId() });
	}

	public void delete(int ID) {
		String sql = "delete from `bookmanager`.`books` where ID=?";
		jdbcTemplate.update(sql, new Object[] { ID });
	}

	public void insert(String title, String author, String price) {
		String sql = "INSERT INTO `bookmanager`.`books` (`BOOK_TITLE`, `BOOK_AUTHOR`, `BOOK_PRICE`) VALUES (?, ?, ?);";
		jdbcTemplate.update(sql, new Object[] { title, author, price });
	}

	public List<book> getAll() {

		String sql = "select * from `bookmanager`.`books` order by ID DESC";
		List<?> list = jdbcTemplate.queryForList(sql);

		List<book> booklist = new ArrayList<book>();

		for (Object el : list) {
			HashMap<?, ?> map = (HashMap<?, ?>) el;
			//
			// el.toString()
			booklist.add(new book((Integer) map.get("ID"), (String) map.get("BOOK_TITLE"),
					(String) map.get("BOOK_AUTHOR"), (String) map.get("BOOK_PRICE")));
		}

		return booklist;

	}

}
