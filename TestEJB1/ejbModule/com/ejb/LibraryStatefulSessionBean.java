package com.ejb;

import java.util.Arrays;
import java.util.List;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class LibraryStatefulSessionBean
 */
@Stateless(mappedName = "xyz")
public class LibraryStatefulSessionBean implements LibraryStatefulSessionBeanRemote {

    /**
     * Default constructor. 
     */
    public LibraryStatefulSessionBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addBook(String bookName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List getBooks() {
		// TODO Auto-generated method stub
		return Arrays.asList("A","B","C");
	}
    
   

}
