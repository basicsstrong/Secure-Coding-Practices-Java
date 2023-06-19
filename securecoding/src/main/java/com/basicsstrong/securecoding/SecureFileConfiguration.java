package com.basicsstrong.securecoding;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.nio.file.attribute.UserPrincipal;

public class SecureFileConfiguration {

	public static String readSensitiveFile(String filePath, String username) throws IOException, IllegalAccessException {
		if(FileConfiguration.hasPermission(filePath, username)) {
		try {
			return Files.readString(Path.of(filePath));
		} catch (IOException e) {
			return "Error reading the file.";
		}
		}else {
			throw new IllegalAccessException("Illegal access to sensitive file");
		}
	}

    public static void main(String[] args) throws IllegalAccessException, IOException {
        String username = "<username>";
        System.out.println(readSensitiveFile("<filepath>", username));
    }
}


class FileConfiguration{
	
	public static boolean hasPermission(String path, String username) throws IOException {
		
		Path filePath = Path.of(path);
		FileOwnerAttributeView instance = Files.getFileAttributeView(filePath, FileOwnerAttributeView.class);
		UserPrincipal owner = instance.getOwner();
		return owner.getName().equals(username);
	}
}



