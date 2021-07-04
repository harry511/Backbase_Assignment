package com.backbase.utilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtils {


	/**
	 * Reads the file and retunrs the content as string
	 * @author hmarothu
	 * @param file
	 * @return file content as string 
	 * @throws TestFrameworkException 
	 * @throws Exception
	 */
	public static String readFileAsString(String filePath) throws TestFrameworkException
	{		
		try {
			return new String(Files.readAllBytes(Paths.get(filePath)));
		} catch (IOException e) {
			e.printStackTrace();
			throw new TestFrameworkException("Unable to read the file content from path "+filePath);
		}
	}
	
}
