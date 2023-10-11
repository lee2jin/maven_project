/**
 * 
 */
//책 목록 보여주기
class Book{
	bookList(bookId, callback){
		fetch('ajaxbooklist.do?nid='+ bookId)
		.then((resolv) => resolv.json())
		.then(result => callback(result))
		.catch(err => console.log(err));
	}

//도서 등록
bookAdd(book = {bookId:'p3333', bookName:'book1', bookWriter:'writer1', 
	bookCom:'test1', bookPrice:30000 }, callback){
		fetch('ajaxbookinsert.do',{
			method : "POST",
			headers:{
				'Content-Type': 'application/x-www-form-urlencoded',
			},
			body: 'bookId=' + book.bookId 
			+ '&bookName=' + book.bookName
			+ '&bookWriter=' + book.bookWriter
			+ '&bookCom=' + book.bookCom
			+ '&bookPrice=' + book.bookPrice
		})
		.then(resolve => resolve.json())
		.then(result => callback(result))
		.catch(console.log)
	}

bookDelete(bookId, callback){
	fetch('ajaxbookdelete.do?bid='+ bookId)
		.then((resolv) => resolv.json())
		.then(result => callback(result))
		.catch(err => console.log(err));
		
		
}
	
}//end of BookClass