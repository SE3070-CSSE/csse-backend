package csse.logs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/logs")
public class LogHttpController {
	
	private final LogService service;
	
	@Autowired
	public LogHttpController(LogService service) {
		this.service=service;
	}
	
	@PostMapping("/create")
    public ResponseEntity createlog(@RequestBody Log log) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(log));
    }

	@GetMapping("/list")
	public List<Log> all(){
		return service.All();
	}
	
}
