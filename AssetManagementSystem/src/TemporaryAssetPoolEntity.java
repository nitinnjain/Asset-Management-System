

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.assetmanagementsystem.model.entity.AssetPoolEntity;
import com.assetmanagementsystem.model.entity.AssetSerialNumberEntity;
import com.assetmanagementsystem.model.entity.KeywordEntity;
import com.assetmanagementsystem.model.service.AssetCategoryDaoService;
import com.assetmanagementsystem.model.service.AssetPoolDaoService;
import com.assetmanagementsystem.model.service.KeywordDaoService;

public class TemporaryAssetPoolEntity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TemporaryAssetPoolEntity() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		AssetPoolDaoService poolService = new AssetPoolDaoService();
		KeywordDaoService keywordService=new KeywordDaoService();
		
		AssetPoolEntity assetPool_1 = new AssetPoolEntity();
		assetPool_1.setAssetCategory("Laptops");
		assetPool_1.setAssetDescription("Asus Core I3 laptop with 4 gb ram and 500 gb hdd");
		assetPool_1.setAssetName("Acer aspire E 15");
		assetPool_1.setAssetQuantity(20);
		
		AssetSerialNumberEntity assetSno1=new AssetSerialNumberEntity();
		assetSno1.setAssetSerialNumber("53609610076");
		
		AssetSerialNumberEntity assetSno2=new AssetSerialNumberEntity();
		assetSno2.setAssetSerialNumber("53609610077");
		
		AssetSerialNumberEntity assetSno3=new AssetSerialNumberEntity();
		assetSno3.setAssetSerialNumber("53609610078");
		
		assetPool_1.getAssetSerialNumber().add(assetSno1);
		assetPool_1.getAssetSerialNumber().add(assetSno2);
		assetPool_1.getAssetSerialNumber().add(assetSno3);
		
		assetSno1.setAssetPool(assetPool_1);
		assetSno2.setAssetPool(assetPool_1);
		assetSno3.setAssetPool(assetPool_1);
		
		KeywordEntity keyword1=new KeywordEntity();
		keyword1.setKeywords("i3");
		
		KeywordEntity keyword2=new KeywordEntity();
		keyword2.setKeywords("500 gb");
		
		KeywordEntity keyword3=new KeywordEntity();
		keyword3.setKeywords("4 gb");
		
		assetPool_1.getKeyword().add(keyword1);
		assetPool_1.getKeyword().add(keyword2);
		assetPool_1.getKeyword().add(keyword3);
		
		poolService.addAsset(assetPool_1);
		
		keyword1.getAssets().add(assetPool_1);
		keyword2.getAssets().add(assetPool_1);
		keyword3.getAssets().add(assetPool_1);
		
////		keywordService.addKeyword(keyword1);
////		keywordService.addKeyword(keyword2);
////		keywordService.addKeyword(keyword3);
//		
		
		
		out.println("Tables Created");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
