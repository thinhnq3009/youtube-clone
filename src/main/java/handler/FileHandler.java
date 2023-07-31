package handler;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

public class FileHandler {

	private static final String PARENT_FODLER = "/datas";

	public static String fileProcess(HttpServletRequest request, String partName, String foldername)
			throws IOException, ServletException {

		if (!foldername.startsWith("/")) {
			foldername = "/" + foldername;
		}

		Part part = request.getPart(partName);

		if (part != null && part.getSize() == 0) {
			throw new FileNotFoundException("Không tìm thấy file được tải lên");
		}

		String realPath = request.getServletContext().getRealPath(PARENT_FODLER + foldername);

		String fileName = Path.of(part.getSubmittedFileName()).getFileName().toString();

		if (!Files.exists(Path.of(realPath))) {
			Files.createDirectories(Path.of(realPath));
		}

		Path filePath = Path.of(realPath + "/" + fileName);
		try (InputStream inputStream = part.getInputStream()) {
			if (Files.exists(filePath)) {
				Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
			} else {
				Files.copy(inputStream, filePath);
			}
		}

		return PARENT_FODLER + foldername + "/" + fileName;
	}

	public static String fileProcess(HttpServletRequest request, String partName, String foldername, String fileName)
			throws IOException, ServletException, FileNotFoundException {

		if (!foldername.startsWith("/")) {
			foldername = "/" + foldername;
		}

		Part part = request.getPart(partName);

		if (part != null && part.getSize() == 0) {
			throw new FileNotFoundException("Không tìm thấy file được tải lên");
		}

		String uploadFileName = Path.of(part.getSubmittedFileName()).getFileName().toString();

		if (fileName.isEmpty()) {
			throw new FileNotFoundException("Không có file upload");
		}

		String realPath = request.getServletContext().getRealPath(PARENT_FODLER + foldername);

		String extension = "." + uploadFileName.substring(uploadFileName.lastIndexOf(".") + 1);

		if (!Files.exists(Path.of(realPath))) {
			Files.createDirectories(Path.of(realPath));
		}

		Path filePath = Paths.get(realPath, fileName + extension);
		if (Files.exists(filePath)) {
			Files.delete(filePath);
		}

		try (InputStream fileContent = part.getInputStream()) {
			Files.copy(fileContent, filePath, StandardCopyOption.REPLACE_EXISTING);
		}

		return PARENT_FODLER + foldername + "/" + fileName + extension;
	}

}
