package co.jiye.prjdb.book.service;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookVO {
	private String bookId;
	private String bookName;
	private String bookWriter;
	private String bookCom;
	private int bookPrice;
}
