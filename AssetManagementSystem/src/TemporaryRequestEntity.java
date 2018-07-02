

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.assetmanagementsystem.model.entity.RequestEntity;
import com.assetmanagementsystem.model.service.RequestDaoService;
import com.assetmanagementsystem.utility.Utility;

public class TemporaryRequestEntity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TemporaryRequestEntity() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestEntity requestEntity=new RequestEntity();
		RequestDaoService requestService=new RequestDaoService();
		requestEntity.setEmployeeId(15);
		requestEntity.setManagerId(10);
		requestEntity.setAssetId(1);
		requestEntity.setRequestStatus(Utility.PENDING);
		requestEntity.setRequestType(Utility.ASSET_REQUEST);
		requestEntity.setUserNotes("Need this laptop as my old laptop is very slow and does not fulfill my requirement.");
		requestService.raiseRequest(requestEntity);
		response.getWriter().append("Tables Created ");	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
