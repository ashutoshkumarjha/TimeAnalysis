package in.gov.iirs.gid.akjha
import geotrellis.raster._
import geotrellis.raster.render.Png
import geotrellis.raster.render.Jpg
import geotrellis.vector.Extent
import gdal._
import scala.language.postfixOps

import geotrellis.raster.geotiff.GeoTiffRasterSource
//import java.lang._
object Main extends App  {
  val ages = Seq(42,60, 29, 64)
  println(s"The oldest person is ${ages.max}")

  val source = GeoTiffRasterSource("https://geotrellis-demo.s3.amazonaws.com/data/aspect.tif")
  // source: GeoTiffRasterSource = geotrellis.raster.geotiff.GeoTiffRasterSource@1ff59a11
  source.extent
  //val rs =GeoTiffRasterSource("http://landsat-pds.s3.amazonaws.com/L8/107/035/LC81070352015218LGN00/LC81070352015218LGN00_B3.TIF")
  //val rs=GeoTiffRasterSource("file:///Users/ashutosh/Geotrellis/geotrellis-landsat-tutorial/data/landsat/LC81070352015218LGN00_B3.TIF")
  //rs.extent
 // System.loadLibrary("gdal")



  // The tile
  val tile = ArrayTile(1 to 100 toArray, 10, 10)
  // and its spatial extent
  val extent = Extent(0, 0, 1, 1)
  // jointly form a raster
  val raster = Raster(tile, Extent(0, 0, 1, 1))
  var ext=raster.extent
  println(s"Extent is ${ext}")
}
