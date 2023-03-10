package Utils

import com.google.cloud.storage.{BlobId, BlobInfo, StorageOptions}

import java.io._
import java.nio.channels.Channels

/**
  * Utility  functions for accessing the google cloud bucket
  */
object FileUtils {
    val storage = StorageOptions.getDefaultInstance().getService()

    /**
      * Returns an input stream of the provided path
      *
      * @param stringPath file path
      * @return file input stream 
      */
    def getInputStream(stringPath: String): InputStream = {
        val isGS = stringPath.size > 5 && stringPath.indexOf("gs://") == 0
        if(isGS)
            new ByteArrayInputStream(storage.readAllBytes(getBlobIdFromPath(stringPath)))
        else
            new FileInputStream(new File(stringPath))
    }

    /**
      * Returns an output stream of the provided path
      *
      * @param stringPath file path
      * @return file output stream 
      */
    def getOutputStream(stringPath: String): OutputStream = {
        val isGS = stringPath.size > 5 && stringPath.indexOf("gs://") == 0
        if(isGS) {
            val blobId = getBlobIdFromPath(stringPath)
            val blobInfo = BlobInfo.newBuilder(blobId).build()
            val blob = storage.create(blobInfo)
            Channels.newOutputStream(blob.writer())
        } else {
            val file = new File(stringPath)
            file.createNewFile()
            new FileOutputStream(file, false)
        }
    }

    /**
      * Get a blob from a given path
      *
      * @param stringPath file path
      * @return blobId
      */
    private def getBlobIdFromPath(stringPath: String) : BlobId = {
        val bucket: String = stringPath.split("/")(2)
        val file = stringPath.split(s"gs://$bucket/")(1)
        BlobId.of(bucket, file)
    }
}