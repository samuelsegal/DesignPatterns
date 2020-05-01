/**
 * 
 */
package com.sms.sandbox.files;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import lombok.extern.slf4j.Slf4j;

/**
 * @author samuelsegal
 *
 */
@Slf4j
public class FilterDirectoryExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Path bindPath = Paths.get("/Users");
			try(DirectoryStream<Path> stream = Files.newDirectoryStream(bindPath)){
				for(Path entry : stream) {
					log.info("Docker Secret :: {}", entry);
				}
			}
			
		} catch (Exception e) {
			String msg = "An error occurred reading docker secrets";
			log.error("{} :: {}", msg, e);
			throw new RuntimeException(e.getMessage());
		}
	}

}
