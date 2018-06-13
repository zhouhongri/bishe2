package framework.util;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;

public class PageUtil {
	
	private int pageData=1;
	private int totalPage;
	private int totalData;
	private List<Map<String,Object>> dataList;
	public void doPage(String sql,Session session,HttpServletRequest req,int currentPage){
		StringBuffer totalDataSql = new StringBuffer();
		totalDataSql.append("select count(*) AS totaldata FROM (");
		totalDataSql.append(sql);
		totalDataSql.append(") t");
		Query query = session.createSQLQuery(totalDataSql.toString());
		totalData = Integer.parseInt(query.uniqueResult().toString());
		int beginIndex = (currentPage-1)*pageData;
		StringBuffer dataListSql = new StringBuffer();
		dataListSql.append("select * FROM (");
		dataListSql.append(sql);
		dataListSql.append(") t limit "+beginIndex+","+pageData);
		query = session.createSQLQuery(dataListSql.toString());
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		dataList=query.list();
		if(totalData%pageData==0){
			totalPage=totalData/pageData;
		}else{
			totalPage=totalData/pageData+1;
		}
		req.setAttribute("pagecount", totalPage);
		req.setAttribute("list", dataList);
		req.setAttribute("currpage", currentPage);
		req.setAttribute("totalcount", totalData);
	}

}
