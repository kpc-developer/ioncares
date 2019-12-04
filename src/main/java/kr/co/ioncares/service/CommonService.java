package kr.co.ioncares.service;

import com.fasterxml.jackson.core.type.TypeReference;

public interface CommonService {

	/**
	 * 오브젝트를 JSON 문자열로 변환
	* <pre>
	* 1. 메소드명 : toJSON
	* 2. 작성일 : 2017. 9. 19. 오전 2:08:44
	* 3. 작성자 : saphie
	* 4. 설명 :
	* </pre>
	* @param data
	* @return
	 */
	public String toJSON(final Object data);

	
	/**
	 * JSON 문자열을 오브젝트로 변환
	* <pre>
	* 1. 메소드명 : fromJSON
	* 2. 작성일 : 2017. 9. 19. 오전 2:08:50
	* 3. 작성자 : saphie
	* 4. 설명 :
	* </pre>
	* @param jsonText
	* @param type
	* @return
	 */
	public <T> T fromJSON(final String jsonText, Class<T> type);

}
