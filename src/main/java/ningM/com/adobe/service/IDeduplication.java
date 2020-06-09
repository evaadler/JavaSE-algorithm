package ningM.com.adobe.service;

/**
 * Dededuplication interface
 * 
 * @author ningm
 *
 */
public interface IDeduplication {
	
	/**
	 * remove the duplicate records
	 * 
	 * @param filePath
	 * 				json file path
	 */
	public void deDuplicate(String filePath);

	public void deDuplicate2(String filePath);
	
}
