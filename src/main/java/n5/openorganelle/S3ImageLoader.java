package n5.openorganelle;

public interface S3ImageLoader {

    String getServiceEndpoint();

    String getSigningRegion();

    String getBucketName();

    String getKey();
}
