
import com.assetmanagementsystem.model.entity.*;
import com.assetmanagementsystem.model.service.*;
import java.io.IOException;
import java.io.PrintWriter;
import com.assetmanagementsystem.utility.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class TemporaryAddEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TemporaryAddEmployee() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EmployeeEntity e=new EmployeeEntity();
		EmployeeAddressEntity address = new EmployeeAddressEntity();
		EmployeeDaoService service = new EmployeeDaoService();
		
		address.setFlatHouseFloorBuilding("flat 521, 2nd floor, T5 SNU");
		address.setColonyStreetLocality("dadri");
		address.setLandmark("SNU CAMPUS");
		address.setCity("Gautam buddh nagar");
		address.setPincode(201314);
		address.setState("Uttar Pradesh");
		address.setCountry("India");

		e.setEmployeeName("Aditya Tripathi");
		e.setManagerId(1);
		e.setProjectId(1);
		e.setEmployeeDepartment(Utility.ADMIN);
		e.setEmployeeSalary(50000);
		e.setEmployeePhoneNumber(8266034989L);
		e.setEmployeePostingCity("Delhi");
		e.setEmployeeUsername("nitin.j");
		e.setEmployeePassword(service.passAES("bankai"));
		e.setAddress(address);
		if(service.addEmployee(e)) {
			System.out.println("ho gaya...");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
