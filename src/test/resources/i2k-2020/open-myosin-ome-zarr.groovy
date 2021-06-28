import bdv.util.BdvFunctions
import n5.zarr.zarr.OMEZarrS3Reader

//N5OMEZarrImageLoader.debugLogging = true;
reader = new OMEZarrS3Reader( "https://s3.embl.de", "us-west-2", "i2k-2020" );
myosin = reader.readKey( "prospr-myosin.ome.n5.zarr" );
BdvFunctions.show( myosin );