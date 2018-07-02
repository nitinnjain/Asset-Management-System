
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.assetmanagementsystem.model.entity.AssetCategoryEntity;
import com.assetmanagementsystem.model.service.AssetCategoryDaoService;

public class TemporaryAddCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AssetCategoryDaoService service = new AssetCategoryDaoService();
		
		AssetCategoryEntity category1 = new AssetCategoryEntity();
		AssetCategoryEntity category2 = new AssetCategoryEntity();
		
		category1.setCategoryName("Laptops");
		category2.setCategoryName("Softwares");
		
		service.addCategory(category1);
		service.addCategory(category2);
		response.getWriter().append("Served at: Tables created").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
