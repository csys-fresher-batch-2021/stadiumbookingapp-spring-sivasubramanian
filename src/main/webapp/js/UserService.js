class UserService {

	static register( mobileNo, password ) {
		let user = { "mobileNumber": mobileNo, "password": password};
		let url = "RegisterServlet?mobileNo=" + mobileNo +"&password="+ password;	
		return axios.post(url, user);
	}


	static login( mobileNo, password ) {
		let user = { "mobileNo": mobileNo, "password": password};
		let url = "LoginServlet2?mobileNo=" + mobileNo +"&password="+ password;	
		return axios.post(url, user);
	}	
	

}