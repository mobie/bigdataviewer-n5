package n5.omezarr;

import mpicbg.spim.data.SpimData;
import n5.omezarr.readers.OMEZarrReader;
import n5.omezarr.readers.OMEZarrViewer;

import java.io.IOException;
public class Main
    {

        protected static void openAndShow( String filePath ) throws IOException
        {
            SpimData spimData = OMEZarrReader.openFile( filePath );
            final OMEZarrViewer viewer = new OMEZarrViewer( spimData );
            viewer.show();
        }

        public static void main(String[] args) {
        try {
//            openAndShow("/home/katerina/Documents/data/v0.3/yx.ome.zarr");
            openAndShow("/home/katerina/Documents/data/v0.3/flat_yx.ome.zarr");

//            openAndShow("/home/katerina/Documents/data/v0.3/cyx.ome.zarr");
//            openAndShow("/home/katerina/Documents/data/v0.3/tyx.ome.zarr");
//
//            openAndShow("/home/katerina/Documents/data/v0.3/zyx.ome.zarr");
//            openAndShow("/home/katerina/Documents/data/v0.3/czyx.ome.zarr");
//            openAndShow("/home/katerina/Documents/data/v0.3/tzyx.ome.zarr");
//            openAndShow("/home/katerina/Documents/data/v0.3/tcyx.ome.zarr");
//            openAndShow("/home/katerina/Documents/data/v0.3/tczyx.ome.zarr");
//            openAndShow("/home/katerina/Documents/data/Covid19-S4-Area2/images/bdv.ome.zarr/raw.ome.zarr");
//           openAndShow("/home/katerina/Downloads/example.ome.zarr");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
