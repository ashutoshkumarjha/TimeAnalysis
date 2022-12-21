ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.8"

lazy val root = (project in file("."))
  .settings(
    name := "TimeAnalysis"
  )
val geotrellisVersion="3.6.2"
val scalaTestVersion="3.2.12"
val apacheSparkVersion="3.2.1"
//javaOptions += "-Djava.library.path=/usr/local/lib"
//libraryDependencies += pomOnly()
libraryDependencies ++= Seq(
  //  "org.locationtech.geotrellis" %% "geotrellis-s3" % geotrellisVersion,
  //  "org.locationtech.geotrellis" %% "geotrellis-gdal" % geotrellisVersion,
  //  "org.locationtech.geotrellis" %% "geotrellis-spark_2.13" % geotrellisVersion,
  "org.gdal" % "gdal" % "3.5.0",
  "org.apache.spark" %% "spark-core" % "3.2.1",
  "org.locationtech.geotrellis" %% "geotrellis-gdal" % geotrellisVersion,
  "org.locationtech.geotrellis" %% "geotrellis-raster" % geotrellisVersion,
  "org.locationtech.geotrellis" %% "geotrellis-spark" % geotrellisVersion,
  "org.scalatest" %% "scalatest" % scalaTestVersion % "test"
)
