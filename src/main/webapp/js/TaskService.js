class TaskService {
	
	static getAllTasks( ) {
		
		let url = "GetAllTasksServlet";	
		return axios.get(url);
	}
	
    getTask( id) {
		
		let url = "GetTaskServlet/" + id;	
		return axios.get(url);
	}

}