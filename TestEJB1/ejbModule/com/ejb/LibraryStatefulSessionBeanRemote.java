package com.ejb;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface LibraryStatefulSessionBeanRemote {
	void addBook(String bookName);
	 List getBooks();

}
