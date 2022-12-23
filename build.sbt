ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"
//ThisBuild / scalaVersion := "3.2.12" //Inspired to upgrade.currently stuck at 2.13.10

val geotrellisVersion="3.6.3"
val scalaTestVersion="3.2.12"
val apacheSparkVersion="3.2.1"
val sparkVersion="3.2.2"

lazy val root = (project in file("."))
  .settings(
    name := "TimeAnalysis",
      licenses := Seq ("Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0.html")),
      resolvers ++= Seq("repo.osgeo.org" at "https://repo.osgeo.org/repository/release/"),
      organization := "in.gov.iirs.gid",

//javaOptions += "-Djava.library.path=/usr/local/lib"
//libraryDependencies += pomOnly()
libraryDependencies ++= Seq(
  //  "org.locationtech.geotrellis" %% "geotrellis-s3" % geotrellisVersion,
  //  "org.locationtech.geotrellis" %% "geotrellis-gdal" % geotrellisVersion,
  //  "org.locationtech.geotrellis" %% "geotrellis-spark_2.13" % geotrellisVersion,
  "joda-time" % "joda-time" % "2.12.2",
  "org.joda" % "joda-convert" % "2.2.1",
  "org.gdal" % "gdal" % "3.5.0",
  "org.apache.spark" %% "spark-core" % sparkVersion % "provided",
  "org.apache.spark" %% "spark-sql" % sparkVersion % "provided",
  "org.apache.spark" %% "spark-mllib" % sparkVersion % "provided",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.9.5",
  "org.locationtech.geotrellis" %% "geotrellis-gdal" % geotrellisVersion,
  "org.locationtech.geotrellis" %% "geotrellis-raster" % geotrellisVersion,
  "org.locationtech.geotrellis" %% "geotrellis-spark" % geotrellisVersion,
  "org.locationtech.geotrellis" %% "geotrellis-spark" % geotrellisVersion,
  "org.locationtech.geotrellis" %% "geotrellis-gdal" % geotrellisVersion,
  "org.locationtech.geotrellis" %% "geotrellis-geotools" % geotrellisVersion,
  "org.locationtech.geotrellis" %% "geotrellis-spark-pipeline" % geotrellisVersion,
  "org.locationtech.geotrellis" %% "geotrellis-store" % geotrellisVersion,
  "org.locationtech.geotrellis" %% "geotrellis-layer" % geotrellisVersion,
  "org.locationtech.geotrellis" %% "geotrellis-vector" % geotrellisVersion,
  "org.locationtech.geotrellis" %% "geotrellis-shapefile" % geotrellisVersion,
  "org.locationtech.geotrellis" %% "geotrellis-util" % geotrellisVersion,
  "org.locationtech.geotrellis" %% "geotrellis-proj4" % geotrellisVersion,
  "org.locationtech.geotrellis" %% "geotrellis-spark" % geotrellisVersion,
  "org.locationtech.geotrellis" %% "geotrellis-raster" % geotrellisVersion,
  "org.locationtech.geotrellis" %% "geotrellis-s3-spark" % geotrellisVersion, // now we can use the Amazon S3 store!
  "org.scalatest" %% "scalatest" % scalaTestVersion % "test"
  )
)