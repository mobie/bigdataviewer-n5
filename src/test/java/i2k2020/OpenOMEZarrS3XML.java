package i2k2020;

import bdv.util.BdvFunctions;
import mpicbg.spim.data.SpimData;
import mpicbg.spim.data.SpimDataException;
import mpicbg.spim.data.XmlIoSpimData;

public class OpenOMEZarrS3XML
{
	public static void main( String[] args ) throws SpimDataException
	{
		// Note: this requires the native blosc library
		// Tischi: for me on my Mac it worked copying libblosc.dylib from Fiji into /src/main/resources
		SpimData spimData = new XmlIoSpimData().load( "src/test/resources/prospr-myosin-n5.zarr.xml" );
		BdvFunctions.show( spimData );
	}
}
