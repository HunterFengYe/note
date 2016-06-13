package utils;

import javax.servlet.http.HttpServletRequest;

public class ParamUtils {
  public static Integer paramInt(HttpServletRequest request,String paramName){
	  String param=request.getParameter(paramName);
	  try{
		int i=Integer.parseInt(param);
		return i;
	  }catch(NumberFormatException e){}
	  return null;
  }
}