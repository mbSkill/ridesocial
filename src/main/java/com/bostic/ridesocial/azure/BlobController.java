package com.bostic.ridesocial.azure;

import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import com.azure.storage.common.StorageSharedKeyCredential;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

@RestController
@RequestMapping("/blob")
public class BlobController {
    @Value("azure-blob://rideblobstorage143/frank.jpg")
    private Resource blobFile;

    String accountName = System.getenv("AZURE_STORAGE_ACCOUNT");
    String accountKey = System.getenv("AZURE_STORAGE_ACCESS_KEY");

    StorageSharedKeyCredential credential = new StorageSharedKeyCredential(accountName, accountKey);
    String endpoint = System.getenv("blobEndpoint");
    BlobServiceClient serviceClient = new BlobServiceClientBuilder()
            .endpoint(endpoint)
            .credential(credential)
            .buildClient();


    @GetMapping("/readBlobFile")
    public String readBlobFile() throws IOException {
        return StreamUtils.copyToString(
                this.blobFile.getInputStream(),
                Charset.defaultCharset());
    }

    @PostMapping("/writeBlobFile")
    public String writeBlobFile(@RequestBody String data) throws IOException {
        try (OutputStream os = ((WritableResource) this.blobFile).getOutputStream()) {
            os.write(data.getBytes());
        }

        return "file was updated";
    }
}
