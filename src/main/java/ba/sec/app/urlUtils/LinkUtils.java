package ba.sec.app.urlUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import ba.sec.app.constants.Constants;

public class LinkUtils {
	
	
	public static List<String> splitParams(String param) {
		String[] urlParams = param.split(Constants.AND_STRING);
		List<String> paramLst = new ArrayList<>(Arrays.asList(urlParams));
		Collections.sort(paramLst);
		return paramLst;
	}

	public static String paramsInUrl(String s) {
		
		int index = s.indexOf(Constants.QUESTIONMARK);
		return  (index != -1)? s.substring(s.indexOf(Constants.QUESTIONMARK)+1) : "";		
	}

	public static int countChars(String s, char ch) {
		int count = 0;
		for (char c : s.toCharArray()) {
			if (ch == c) {
				count++;
			}
		}
		return count;
	}

	public static String checkAndChop(String url) {
		String result = url;
		if (url.indexOf(Constants.HTTP) != -1) {
			result = result.replace(Constants.HTTP,Constants.EMPTY);
		}

		if (url.indexOf(Constants.QUESTIONMARK) != -1) {
			result = result.substring(0, result.indexOf(Constants.QUESTIONMARK));
		}

		return result;
	}
	
	
	public static boolean checkLinkExist(List<String> list,int andNumber,List<String> paramLstInUrl,String url){
			
		url = url.replace(Constants.HTTP, Constants.EMPTY);
				
		if(list != null && list.contains(url)){
			return true;
		}

		boolean result = false;
		
		for (int i = 0; i < list.size(); i++) {
			String s1 = list.get(i).replace(Constants.HTTP, Constants.EMPTY);
			
			if(s1.equals(url)){
				result = true;
				break;
			}
			
			int andNumerInUrl = countChars(list.get(i), Constants.AND);

			if (andNumber == andNumerInUrl) {
				String param = paramsInUrl(s1);

				if (param != null) {
					List<String> paramLst = splitParams(param);

					if (paramLstInUrl.equals(paramLst)) {
						result = true;
						break;
					}
				}
			}
		}

		return result;
	}
	

}
