/*
 * Project: 
 * 	Cockpit Valuation Server
 *
 * Author:  
 *	Christian Zirpins
 *
 * Last Change: 
 *	by:   $$Author: $$
 *	date: $$Date:   $$
 *
 * Copyright (c):
 * 	2011 Karlsruhe Institute of Technology (KIT)
 * 
 * License:
 * 	Licensed under the Apache License, Version 2.0 (the "License"); you
 * 	may not use this file except in compliance with the License. You may
 * 	obtain a copy of the License at
 * 
 * 	http://www.apache.org/licenses/LICENSE-2.0
 * 
 * 	Unless required by applicable law or agreed to in writing, software
 * 	distributed under the License is distributed on an "AS IS" BASIS,
 * 	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * 	implied. See the License for the specific language governing
 * 	permissions and limitations under the License.
 */

package edu.kit.cockpit.valuationserver.sfmpersistency;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Some file helper functionality
 * 
 */
public class FileUtil {

	public static String deleteExtensionFromFilename(String fileName) {
		return fileName.substring(0, fileName.lastIndexOf('.'));
	}

	private static Log log = LogFactory.getLog(FileUtil.class);

	/**
	 * checks file for reading
	 * 
	 * @param modelFile
	 * @param modelFileName
	 */
	public static void checkFileForReading(File file) throws IOException {
		if (!file.exists()) {
			String error = "File '" + file.getPath() + "' does not exist";
			log.error(error);
			throw new IOException(error);
		}
	}

	/**
	 * checks file for writing
	 * 
	 * @param modelFile
	 * @param modelFileName
	 */
	public static void checkFileForWriting(File file) throws IOException {
		checkFileForReading(file);
		if (!file.canWrite()) {
			String error = "File '" + file.getAbsolutePath()
					+ "' is write protected";
			log.error(error);
			throw new IOException(error);
		}
	}

	/**
	 * @param file
	 * @return string representation of File
	 * @throws IOException
	 */
	public static String readFile(File file) throws IOException {
		FileInputStream stream = new FileInputStream(file);
		try {
			FileChannel fc = stream.getChannel();
			MappedByteBuffer bb = fc.map(FileChannel.MapMode.READ_ONLY, 0,
					fc.size());
			/* Instead of using default, pass in a decoder. */
			return Charset.defaultCharset().decode(bb).toString();
		} finally {
			stream.close();
		}
	}

}
