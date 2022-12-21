import geotrellis.raster._
//val rs =RasterSource("https://landsat-pds.s3.amazonaws.com/L8/107/035/LC81070352015218LGN00/LC81070352015218LGN00_B3.TIF")
val rs=RasterSource("gtiff+file:///Users/ashutosh/Geotrellis/geotrellis-landsat-tutorial/data/landsat/LC81070352015218LGN00_B3.TIF")
rs.extent