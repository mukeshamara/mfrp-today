package com.model;

public class User {

	Long userid;
	String password;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Long userid, String password) {
		super();
		this.userid = userid;
		this.password = password;
	}
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
/*
 <form class="example" action="action_page.php">
  <input type="text" placeholder="Search.." name="search">
  <button type="submit"><i class="fa fa-search"></i></button>
</form>


<input type="text" name="category" placeholder="Search the book as per category">
		<button type="submit" name="save" class="btn btn-primary">Search</button>
  */	
 
	
}
