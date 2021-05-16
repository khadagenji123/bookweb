package models;

public class Book {
	private int bookId;
	private int categoryId;
	private String categoryName;
	private String bookName;
	private String publishingCompany;
	private String author;
	private float originalPrice;
	private float saleOff;
	private float currentPrice;
	private String shortDescription;
	private String detailDescription;
	private int amount;
	private String image;
	private float total;
	
	public  Book() {
		
	}
	
	public Book(int bookId) {
		super();
		this.bookId = bookId;
	}

	public Book(String bookName) {
		this.bookName = bookName;
	}
	
	public Book(int categoryId, String bookName, String publishingCompany, String author, float originalPrice,
			float saleOff, float currentPrice, String shortDescription, String detailDescription, int amount,
			String image) {
		this.categoryId = categoryId;
		this.bookName = bookName;
		this.publishingCompany = publishingCompany;
		this.author = author;
		this.originalPrice = originalPrice;
		this.saleOff = saleOff;
		this.currentPrice = currentPrice;
		this.shortDescription = shortDescription;
		this.detailDescription = detailDescription;
		this.amount = amount;
		this.image = image;
	}

	public Book(int bookId, int categoryId, String bookName, String publishingCompany, String author,
			float originalPrice, float saleOff, float currentPrice, String shortDescription, String detailDescription,
			int amount, String image) {
		this.bookId = bookId;
		this.categoryId = categoryId;
		this.bookName = bookName;
		this.publishingCompany = publishingCompany;
		this.author = author;
		this.originalPrice = originalPrice;
		this.saleOff = saleOff;
		this.currentPrice = currentPrice;
		this.shortDescription = shortDescription;
		this.detailDescription = detailDescription;
		this.amount = amount;
		this.image = image;
	}

	public Book(int bookId, String bookName, float originalPrice, float saleOff, float currentPrice, int amount,
			String image, float total) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.originalPrice = originalPrice;
		this.saleOff = saleOff;
		this.currentPrice = currentPrice;
		this.amount = amount;
		this.image = image;
		this.total = total;
	}

	public Book(int bookId, int categoryId, String bookName, String publishingCompany, String author,
			float originalPrice, float saleOff, float currentPrice, String shortDescription, int amount,
			String image) {
		this.bookId = bookId;
		this.categoryId = categoryId;
		this.bookName = bookName;
		this.publishingCompany = publishingCompany;
		this.author = author;
		this.originalPrice = originalPrice;
		this.saleOff = saleOff;
		this.currentPrice = currentPrice;
		this.shortDescription  = shortDescription;
		this.amount = amount;
		this.image = image;
	}
	
	

	public Book(int bookId, String categoryName, String bookName, String publishingCompany, String author,
			float originalPrice, float saleOff, float currentPrice, String detailDescription, int amount,
			String image) {
		super();
		this.bookId = bookId;
		this.categoryName = categoryName;
		this.bookName = bookName;
		this.publishingCompany = publishingCompany;
		this.author = author;
		this.originalPrice = originalPrice;
		this.saleOff = saleOff;
		this.currentPrice = currentPrice;
		this.detailDescription = detailDescription;
		this.amount = amount;
		this.image = image;
	}
	public String getCategoryName() {
		return categoryName;
	}


	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public float getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(float currentPrice) {
		this.currentPrice = currentPrice;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getPublishingCompany() {
		return publishingCompany;
	}
	public void setPublishingCompany(String publishingCompany) {
		this.publishingCompany = publishingCompany;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public float getOriginalPrice() {
		return originalPrice;
	}
	public void setOriginalPrice(float originalPrice) {
		this.originalPrice = originalPrice;
	}
	public float getSaleOff() {
		return saleOff;
	}
	public void setSaleOff(float saleOff) {
		this.saleOff = saleOff;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public String getDetailDescription() {
		return detailDescription;
	}
	public void setDetailDescription(String detailDescription) {
		this.detailDescription = detailDescription;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", categoryId=" + categoryId + ", categoryName=" + categoryName
				+ ", bookName=" + bookName + ", publishingCompany=" + publishingCompany + ", author=" + author
				+ ", originalPrice=" + originalPrice + ", saleOff=" + saleOff + ", currentPrice=" + currentPrice
				+ ", shortDescription=" + shortDescription + ", detailDescription=" + detailDescription + ", amount="
				+ amount + ", image=" + image + "]";
	}
	
	
	
	
}
