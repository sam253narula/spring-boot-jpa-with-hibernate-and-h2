package mc.springboot.rest.example.springbootjpawithhibernateandh2.Controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import mc.springboot.rest.example.springbootjpawithhibernateandh2.model.Student;
import mc.springboot.rest.example.springbootjpawithhibernateandh2.service.StudentService;

@RestController
@RequestMapping("/home/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@Autowired
	RestTemplate restTemplate;

	@Value("${drools.api.url}")
	private String droolUrl;

	@GetMapping(value = "/drollcall")
	public String getDiscountOnGold(@RequestParam(required = true) String type) {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		return restTemplate
				.exchange(droolUrl + type,
						HttpMethod.GET, entity, String.class)
				.getBody();
	}

	@GetMapping(value = "/getAllStudents")
	public List<Student> add() {
		List<Student> studentList = studentService.getStudentList();

		return studentList;
	}

	@PostMapping("/postStudent")
	Student newStudent(@RequestBody Student newStudent) {
		return studentService.insertStudent(newStudent);
	}

	@GetMapping("/deletetStudent/{id}")
	void newStudent(@PathVariable Long id) {
		studentService.deleteStudent(id);
	}

	@PostMapping("/updateStudent")
	Student updateStudent(@RequestBody Student newStudent) {
		return studentService.updatestudent(newStudent);
	}

	/*
	 * @Autowired private JdbcTemplate jdbcTemplate;
	 * 
	 * @RequestMapping(value = "/createTable", method = RequestMethod.GET)
	 * public void createTable() { try {
	 * jdbcTemplate.execute("CREATE TABLE CUSTOMERDATA(" +
	 * "id SERIAL, name VARCHAR(255),age VARCHAR(255))"); } catch (Exception e)
	 * { e.printStackTrace(); } }
	 * 
	 * @RequestMapping(value = "/putData", method = RequestMethod.GET) public
	 * void putData() { try { jdbcTemplate.execute(
	 * "INSERT INTO CUSTOMERDATA(id,name,age) VALUES (1,'JPMC','30')"); } catch
	 * (Exception e) { e.printStackTrace(); } }
	 * 
	 * @SuppressWarnings("unchecked")
	 * 
	 * @RequestMapping(value = "/getData", method = RequestMethod.GET) public
	 * Map<String, List<String>> getData() { try {
	 * 
	 * Map<String, List<String>> customerMap = jdbcTemplate.query(
	 * "SELECT * FROM CUSTOMERDATA", new CustomerMapExtractor());
	 * 
	 * return customerMap;
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } return null;
	 * 
	 * }
	 */

}
