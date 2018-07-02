
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.assetmanagementsystem.model.entity.KeywordEntity;
import com.assetmanagementsystem.model.service.KeywordDaoService;

public class TemporaryAddKeyword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		KeywordDaoService keywordService=new KeywordDaoService();
		
		KeywordEntity keyword1=new KeywordEntity();
		keyword1.setKeywords("i3");
		
		KeywordEntity keyword2=new KeywordEntity();
		keyword2.setKeywords("500 gb");
		
		KeywordEntity keyword3=new KeywordEntity();
		keyword3.setKeywords("4 gb");
		
		keywordService.addKeyword(keyword1);
		keywordService.addKeyword(keyword2);
		keywordService.addKeyword(keyword3);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
