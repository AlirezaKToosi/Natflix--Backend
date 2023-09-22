package com.novare.natflixbackend.utills;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.sql.rowset.serial.SerialBlob;


public class PhotoConverter {
    private static final String IMG_STORE = "/images/";

    private enum ImageExtension {
        JPEG("jpeg"),
        JPG("jpg"),
        PNG("png"),
        GIF("gif"),
        BMP("bmp"),
        SVG("svg"),
        UNKNOWN("unknown");

        private final String extension;

        ImageExtension(String extension) {
            this.extension = extension;
        }

        public String getExtension() {
            return extension;
        }
    }

    public static String toBase64(String imagePath) {
        try {
            Resource resource = new ClassPathResource("");
            String extension = getFileExtension(imagePath);
            String base64extension = "data:image/" + extension + ";base64,";

            String resourcePath = resource.getURI().getPath();
            byte[] fileContent = FileUtils.readFileToByteArray(new File(resourcePath + imagePath));
            String encodedString = Base64.getEncoder().encodeToString(fileContent);
            return base64extension + encodedString;
        } catch (Exception e) {
            return imagePath;
        }
    }

    public static String toImageFile(String encodeImage, String parentDir) {
        try {
            String[] strings = encodeImage.split(",");
            String extension = getImageExtensionFromBase64(strings[0]);

            Resource resource = new ClassPathResource("");
            String resourcePath = resource.getURI().getPath();
            byte[] decodedBytes = Base64.getDecoder().decode(strings[1]);
            String pathname = IMG_STORE + parentDir + File.separator + UUID.randomUUID().toString() + "." + extension;
            FileUtils.writeByteArrayToFile(new File(resourcePath + pathname), decodedBytes);
            return pathname;
        } catch (Exception e) {
            return "";
        }
    }

    public static Blob convertBase64ToBlob(String base64Image) throws SQLException {
        String[] strings = base64Image.split(",");
        byte[] imageBytes = Base64.getDecoder().decode(strings[1]);
        return new SerialBlob(imageBytes);
    }

    public static String blobToBytes(Blob blob) throws SQLException, IOException {
        if (blob == null) {
            return null;
        }

        try (InputStream inputStream = blob.getBinaryStream()) {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            byte[] byteArray = outputStream.toByteArray();
            return Base64.getEncoder().encodeToString(byteArray);
        }
    }

    private static String getFileExtension(String filePath) {
        return FilenameUtils.getExtension(filePath);
    }

    private static String getImageExtensionFromBase64(String base64Header) {
        for (ImageExtension imageExtension : ImageExtension.values()) {
            if (base64Header.contains(imageExtension.getExtension())) {
                return imageExtension.getExtension();
            }
        }
        return ImageExtension.UNKNOWN.getExtension();
    }
}

