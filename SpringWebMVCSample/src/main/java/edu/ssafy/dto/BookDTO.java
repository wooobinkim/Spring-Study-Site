package edu.ssafy.dto;

public class BookDTO {
	private String ISBN;
	private String Author;
	private String Title;
	private String Price;
	private String Descr;
	private String Picture;
	
	public BookDTO() {
		super();
	}

	public BookDTO(String iSBN, String author, String title, String price, String descr, String picture) {
		super();
		ISBN = iSBN;
		Author = author;
		Title = title;
		Price = price;
		Descr = descr;
		Picture = picture;
	}
	
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getPrice() {
		return Price;
	}
	public void setPrice(String price) {
		Price = price;
	}
	public String getDescr() {
		return Descr;
	}
	public void setDescr(String descr) {
		Descr = descr;
	}
	public String getPicture() {
		return Picture;
	}
	public void setPicture(String picture) {
		Picture = picture;
	}
	@Override
	public String toString() {
		return "BookDTO [ISBN=" + ISBN + ", Author=" + Author + ", Title=" + Title + ", Price=" + Price + ", Descr="
				+ Descr + ", Picture=" + Picture + "]";
	}
	
	
	

}
