/**
 * 
 */
class Book{
	bookList(bookId, callback){
		fetch('ajaxbooklist.do?nid='+ bookId)
		.then((resolv) => resolv.json())
		.then(result => callback(result))
		.catch(err => console.log(err));
	}
}