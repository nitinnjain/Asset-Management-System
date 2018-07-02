

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.assetmanagementsystem.model.entity.KeywordEntity;
import com.assetmanagementsystem.model.service.KeywordDaoService;

public class TemporaryKeywordEntity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TemporaryKeywordEntity() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		KeywordDaoService keywordService=new KeywordDaoService();
		KeywordEntity keyword1=new KeywordEntity();
		keyword1.setKeywords("i3");
		keywordService.addKeyword(keyword1);
		KeywordEntity keyword2=new KeywordEntity();
		keyword2.setKeywords("500 gb");
		keywordService.addKeyword(keyword2);
		KeywordEntity keyword3=new KeywordEntity();
		keyword3.setKeywords("4 gb");
		keywordService.addKeyword(keyword3);
		
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
