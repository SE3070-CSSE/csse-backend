package csse.logs;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogService {
	
	private final LogDAO repo;
	
	@Autowired
	public LogService(LogDAO repo) {
		this.repo=repo;
	}

	Log create(Log l) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		String d=dateFormat.format(date);
		
		l.setLoggedDate(date);
		return repo.save(l);
	}
	
	List<Log> All(){
		return repo.findAll();
	}
		
}
