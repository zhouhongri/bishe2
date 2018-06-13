package framework.interceptors;


import java.util.List;

import javax.persistence.Entity;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.gym.code.model.User;


@Entity
public class MyInterceptor implements HandlerInterceptor{

	
	private List<String> allowUri;
	
	
	public List<String> getAllowUri() {
		return allowUri;
	}

	public void setAllowUri(List<String> allowUri) {
		this.allowUri = allowUri;
	}

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}

	
	/**
     * 拦截器最终调用的方法
     * 
     * @param HttpServletRequest
     * @param HttpServletResponse
     * @param Object
     * @return boolean
     * @throws Exception
     */
    @Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object obj) throws Exception {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String uri = request.getRequestURI();
		if (user != null)
        {
		    return true;
        }
		//判断当前请求路径，是否包含白名单中路径字符串，如果包含则放行
		for(String uriStr : allowUri){
			if(uri.contains(uriStr)){
				return true;
			}
		}
			response.sendRedirect(request.getContextPath()+"/common/login/login");
			return false;
		}

}
