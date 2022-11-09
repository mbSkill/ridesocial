package com.bostic.ridesocial.azure;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import com.azure.storage.common.StorageSharedKeyCredential;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Timestamp;
import java.util.Random;

@Service
public class AzureImageService {
    String accountName = System.getenv("AZURE_STORAGE_ACCOUNT");
    String accountKey = System.getenv("AZURE_STORAGE_ACCESS_KEY");
    String bucket = "images";

    StorageSharedKeyCredential credential = new StorageSharedKeyCredential(accountName, accountKey);
    String endpoint = System.getenv("blobEndpoint");
    BlobServiceClient serviceClient = new BlobServiceClientBuilder()
            .endpoint(endpoint)
            .credential(credential)
            .buildClient();
    BlobContainerClient containerClient = serviceClient.getBlobContainerClient(bucket);

    public String SaveImage(MultipartFile multipartFile, String username) throws IOException {
        BlobClient blobClient= containerClient.getBlobClient(
                username+"/"
                + String.valueOf(multipartFile.hashCode()*Math.random())
                        .substring(2)
                +"."
                + StringUtils.getFilenameExtension(
                        multipartFile.getOriginalFilename()));
        blobClient.upload(multipartFile.getInputStream(),multipartFile.getSize(),false);
        return blobClient.getBlobUrl();
    }
}
