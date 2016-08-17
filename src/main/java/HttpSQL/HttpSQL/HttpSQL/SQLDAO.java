package HttpSQL.HttpSQL.HttpSQL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class SQLDAO {
	private static SQLDAO mapper = new SQLDAO();

	private static JdbcTemplate jdbcTemplate;
	private MapSqlParameterSource parametr = new MapSqlParameterSource();

	SQLDAO() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/BOOKMANAGER");
		dataSource.setUsername("root");
		dataSource.setPassword("1515");

		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public static SQLDAO GetMapper() {
		return mapper;
	}

	public void test() {
		String sql = "INSERT INTO `bookmanager`.`books` (`BOOK_TITLE`, `BOOK_AUTHOR`, `BOOK_PRICE`) VALUES ('test', 'autor', '34');";
		jdbcTemplate.execute(sql);
	}

	public void insert(String title, String author, String price) {
		String sql = "INSERT INTO `bookmanager`.`books` (`BOOK_TITLE`, `BOOK_AUTHOR`, `BOOK_PRICE`) VALUES (?, ?, ?);";
		jdbcTemplate.update(sql, new Object[] { title, author, price });
	}

	public List<book> getAll() {

		String sql = "select * from `bookmanager`.`books` order by ID DESC";
		List list = jdbcTemplate.queryForList(sql);

		List<book> booklist = new ArrayList<book>();

		for (Object el : list) {
			HashMap map = (HashMap) el;
			//
			// el.toString()
			booklist.add(new book((Integer) map.get("ID"), (String) map.get("BOOK_TITLE"),
					(String) map.get("BOOK_AUTHOR"), (String) map.get("BOOK_PRICE")));
		}

		return booklist;

	}

}
