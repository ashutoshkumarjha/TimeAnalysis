import geotrellis.proj4._
import geotrellis.raster._
import geotrellis.raster.io.geotiff._
import geotrellis.raster.io.geotiff.reader.{GeoTiffReader, _}

import java.io.File

object ReadFiles {
  val directories = List("data")
  //constants to differentiate which bands to use
  val R_BAND = 0
  val G_BAND = 1
  val NIR_BAND = 2

  // Path to our landsat band geotiffs.
  def bandPath(directory: String) = s"../biggis-landuse/radar_data/${directory}"

  def main(args: Array[String]): Unit = {
    directories.map(directory => generateMultibandGeoTiffFile(directory))
  }

//  def generateMultibandGeoTiffFile(directory: String) = {
//    val tiffFiles = new java.io.File(bandPath(directory)).listFiles.map(_.toString)
//
//    val singleBandGeoTiffArray = tiffFiles.foldLeft(Array[SinglebandGeoTiff]())((acc, el: String) => {
//      acc :+ SinglebandGeoTiff(el)
//    })
//
//    val tileArray = ArrayMultibandTile(singleBandGeoTiffArray.map(_.tile))
//    println(s"Writing out $directory multispectral tif")
//    MultibandGeoTiff(tileArray, singleBandGeoTiffArray(0).extent, singleBandGeoTiffArray(0).crs).write(s"data/$directory.tif")
//
//  }
    def generateMultibandGeoTiffFile(directory: String) = {
    val tiffs =
      new File(bandPath(directory))
        .listFiles
        .map(_.toString)
        // streaming = true won't force all bytes to load into memory
        // only tiff metadata is fetched here
        .map(GeoTiffReader.readSingleband(_,streaming = true))

    val (extent, crs) = {
      val tiff = tiffs.head
      tiff.extent -> tiff.crs
    }

    // TIFF segments bytes fetch will start only during the write
    MultibandGeoTiff(
      MultibandTile(tiffs.map(_.tile)),
      extent, crs
    ).write(s"data/$directory.tif")
  }
}
