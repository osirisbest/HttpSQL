package HttpSQL.HttpSQL.HttpSQL;

public class book {

	private int id;
	private String title;
	private String author;
	private String price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public book(String title, String author, String price) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
	}

	public book(int i, String title, String author, String price) {
		super();
		this.id = i;
		this.title = title;
		this.author = author;
		this.price = price;
	}

	public book() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "book [title=" + title + ", author=" + author + ", price=" + price + "]";
	}

}
